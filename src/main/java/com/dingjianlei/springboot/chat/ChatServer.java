package com.dingjianlei.springboot.chat;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.dingjianlei.springboot.config.SpringContextHolder;
import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.dto.ChatMessage;
import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.service.ChatUserService;
import com.dingjianlei.springboot.service.ChatUserServiceImpl;
import com.google.gson.Gson;

/***
 * 即时通讯服务的服务模块<br/>
 * 
 * @author 丁建磊
 *
 */
@Component
@ServerEndpoint("/chatServer")
public class ChatServer {
	private static Log logger = LogFactory.getLog(ChatServer.class);
	/** AtomicInteger：线程安全的整数对象 */
	private static AtomicInteger onlineCount = new AtomicInteger(0);// 线程安全整数对象
	private static long MAX_BIG_LONG = 1024 * 4 * 1024;
	/** roomId与一个集合的哈希。集合中存储当前房间的所有用户 */
	private static ConcurrentHashMap<String, CopyOnWriteArraySet<String>> roomToChatUserHashMap = new ConcurrentHashMap<String, CopyOnWriteArraySet<String>>();
	/** 用户与chatServer实例的哈希。 */
	private static ConcurrentHashMap<String, ChatServer> chatUserToChatServer = new ConcurrentHashMap<String, ChatServer>();
	/** token验证 **/
	private String token;
	/** 房间号 **/
	private String roomId;
	/** chatUser 主键Id**/
	private String chatUserId;
	/**chatUserd对象**/
     private ChatUser chatUser;
	/**
	 * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，
	 * 可以使用Map来存放，其中Key可以为用户标识·1
	 */
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getChatUserId() {
		return chatUserId;
	}

	public void setChatUserId(String chatUserId) {
		this.chatUserId = chatUserId;
	}

	/** 与某个客户端的连接会话，需要通过它来给客户端发送数据 */
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;

	}

	/**
	 * 连接建立成功调用的方法<br>
	 * 1、解析连接字符串，获得用户名、房间名<br>
	 * 2、取得发起人的聊天账号<br>
	 * 3、将当前会话websocket加入到hashmap，以uuid为键<br>
	 *
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(Session session) {
		session.setMaxTextMessageBufferSize((int) MAX_BIG_LONG);
		addOnlineCount(); // 在线数加1--必须先加1---错误的时候会减1
		this.session = session;
		if (!parseQueryString(session)) // 如果未能取得用户id和type，退出
			return;
		// 验证账号，防止伪造
		this.chatUser = loginChatServer(chatUserId);
		if (this.chatUser == null) {
             closeSession(session);
             return;
		}
		addChatUserToHashMap(roomId, chatUserId);
		try {
			// 发一个应答标记，表示已经成功登陆，没有构造
			sendMessage("SUCCESS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constant.ONLINECOUNT = onlineCount.toString();
	}

	// 通过用户id登录chatServer服务器，如果null则证明伪造身份 closeSession
	private ChatUser loginChatServer(String chatUserId) {
		ChatUserService chatUserService = SpringContextHolder.getBean(ChatUserServiceImpl.class);
		return chatUserService.findChatUserById(chatUserId);
	}

	/**
	 * 一个房间对应的一个chatuser列表 发消息时候进行遍历操作
	 * 
	 * @param chatUserId
	 * @param chatUserId
	 * @return
	 */
	private boolean addChatUserToHashMap(String roomId, String chatUserId) {
		try {
			CopyOnWriteArraySet<String> chatUserIdSet = null;
			if (roomToChatUserHashMap.containsKey(roomId)) {
				chatUserIdSet = roomToChatUserHashMap.get(roomId);
			} else {
				chatUserIdSet = new CopyOnWriteArraySet<String>();
			}
			chatUserIdSet.add(chatUserId);
			roomToChatUserHashMap.put(chatUserId, chatUserIdSet);
			chatUserToChatServer.put(chatUserId, this);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 从哈希中移除已经断开的连接
	 * 
	 * @param chatUserId
	 * @param terminalUuid
	 * @return
	 */
	private boolean removeChatUserFromRoomHashMap(String roomId, String chatUserId) {
		try {
			CopyOnWriteArraySet<String> chatUserIdSet = null;
			if (roomToChatUserHashMap.containsKey(roomId)) {// 如果存在
				chatUserIdSet = roomToChatUserHashMap.get(chatUserId);// 取得chatUserId的集合
			} else {
				return true;
			}
			chatUserIdSet.remove(chatUserId);// 从集合中移除
			if (chatUserIdSet.size() == 0) {// 如果已经没有连接终端
				roomToChatUserHashMap.remove(roomId);// 则清除
			} else {
				roomToChatUserHashMap.put(roomId, chatUserIdSet);// 更新哈希
			}
			ChatServer chatServer = chatUserToChatServer.get(chatUserId);
			// 释放资源，清空chatServer
			chatServer = null;
			chatUserToChatServer.remove(chatUserId);// 将chatServer的实例从哈希中移除。
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 解析查询字符串，取得用户id，type，uuid，indentid 失败则关闭连接
	 * 
	 * @param session
	 * @return 成功返回true，失败返回false
	 */
	private boolean parseQueryString(Session session) {
		// 以下取得queryString，并从中解析到用户id和类型
		String queryString = session.getQueryString();// 取得查询字符串
		if (StringUtils.isBlank(queryString)) {// 如果没有传递参数，则关闭此连接
			closeSession(session);// 关闭会话
			return false;
		}
		String chatUserIdStart = "CHATUSERID="; // 查询字符串的每一节，以&隔开，传递用户id的部分以userID开头，必须有
		String roomIdStart = "ROOMID="; // 用户类型的开头字符串，必须有
		try {
			String[] queryStringArray = queryString.split("&");// 查询字符串用&连接
			if (queryStringArray.length == 0) // 如果没有查询字符串，则返回false，调用者会据此关闭连接
				return false;
			for (int i = 0; i < queryStringArray.length; i++) {// ‘对查询字符串进行检查，如果有uid等参数，则取出病赋值
				if (queryStringArray[i].toUpperCase().startsWith(chatUserIdStart)) {// 用户id
					this.setChatUserId(queryStringArray[i].split("=")[1]);
				}
				if (queryStringArray[i].toUpperCase().startsWith(roomIdStart)) {// 类型
					this.setRoomId(queryStringArray[i].split("=")[1]);
				}
			}
		} catch (Exception e) {// 解析查询字符串发生错误--传递的查询字符串错误
			closeSession(session);// 关闭连接
			return false;
		}
		return true;
	}

	/**
	 * 关闭websocket连接。
	 * 
	 * @param session
	 *            要关闭的会话
	 */
	private void closeSession(Session session) {
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(Session session) {
		try {
			removeChatUserFromRoomHashMap(this.roomId, this.chatUserId);
			subOnlineCount(); // 在线数减1
		} catch (Exception e) {
			
		}
	}

	/**
	 * 收到客户端消息后调用的方法。 客户端发送消息的方法是，发送到服务器，消息中指明要传送给那个用户，消息的类型。<br/>
	 * 此处只管发送，至于发送的模式（紧急通知，普通通知，订单消息，聊天信息），这里并进行解析处理，由客户端自行处理。<br/>
	 * 
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		if (StringUtils.isBlank(message)) // 收到的是空串
			return;
		if (StringUtils.equals(Constant.SUCCESS_RESPONSE, message)) {
			return;
		}
		Gson gson = null;
		try {// 解析json串
			gson = new Gson();
			ChatMessage chatMessage = gson.fromJson(message, ChatMessage.class);
			// 解析json出错
			if (chatMessage == null)
				return;
			//不用做NPE判断，因为chatUser如果为空 则推出closeSession 所以不可能为空
			chatMessage.setChatName(this.chatUser.getUsername());			
			sendMessageToEveryoneInRoom(chatMessage);
		} catch (Exception e) {// 发生错误即退出
			e.printStackTrace();
		}
	}

	private boolean sendMessageToEveryoneInRoom(ChatMessage chatMessage) {
		CopyOnWriteArraySet<String> chatUserIdSet;
		chatUserIdSet = roomToChatUserHashMap.get(this.roomId);// 取得此连接用户的所有连接终端
		Iterator<String> it = chatUserIdSet.iterator();
		String chatUserIt = "";
		ChatServer chatServer = null;
		while (it.hasNext()) {
			chatUserIt = it.next();
			chatServer = chatUserToChatServer.get(chatUserIt);// 取得连接终端
			if (chatServer == null) {
				chatUserToChatServer.remove(chatUserIt);
			} else {
				Gson gson = new Gson();
				String singleMsgJson = gson.toJson(chatMessage);
				gson = null;
				try {
					chatServer.sendMessage(singleMsgJson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 向指定用户发送消息
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	public boolean sendMessage(String message) throws IOException {

		try {
			if (!this.session.isOpen()) {
				logger.error("seesion closed");
				return false;
			}
			synchronized (session) {
				this.session.getBasicRemote().sendText(message);
			}
			return true;
		} catch (Exception e) {
			logger.error("捕获错误");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		try {
			closeSession(session);
			removeChatUserFromRoomHashMap(this.roomId, this.chatUserId);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}

	/**
	 * 在线计数递增
	 */
	public static void addOnlineCount() {
		onlineCount.getAndIncrement();
	}

	/**
	 * 在线计数递减
	 */
	public static void subOnlineCount() {
		onlineCount.getAndDecrement();
	}

}