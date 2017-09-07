package com.dingjianlei.springboot.chat;



import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 即时通讯服务的服务模块<br/>
 * 使用tomcat自带的websocket库，位于lib目录下，文件名为 websocket-api.jar<br/>
 * 所有消息都经服务器转发。发送过的消息存储到MongoDB中<br/>
 * 如果收件人不在线，则暂存到数据库。收件 人上线之后，立即自动发送离线消息
 * 
 * @author Zlyj-B
 *
 */
@Component
@ServerEndpoint("/chatServer")
public class ChatServer {
	private static Log logger = LogFactory.getLog(ChatServer.class);
	/** AtomicInteger：线程安全的整数对象 */
	private static AtomicInteger onlineCount = new AtomicInteger(0);// 线程安全整数对象
	private static long MAX_BIG_LONG = 1024 * 4 * 1024;
	// 暂时图片路径
	/** chatUserId与一个集合的哈希。集合中存储同一个chatUser所连接的终端 */
	private static ConcurrentHashMap<String, CopyOnWriteArraySet<String>> chatUserTerminalUuidHashMap = new ConcurrentHashMap<String, CopyOnWriteArraySet<String>>();
	/** 终端uuid与chatServer实例的哈希。 */
	private static ConcurrentHashMap<String, ChatServer> terminalUuidChatServerHashMap = new ConcurrentHashMap<String, ChatServer>();
	/**
	 * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，
	 * 可以使用Map来存放，其中Key可以为用户标识·1
	 */
	/** 每个连接的唯一识别号 */
	private String terminalUuid;

	public void setTerminalUuid(String terminalUuid) {
		this.terminalUuid = terminalUuid;
	}

	public String getTerminalUuid() {
		return terminalUuid;
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
	 * 1、解析连接字符串，获得用户名、类型、终端uuid、订单id（如果需要）<br>
	 * 2、取得发起人的聊天账号<br>
	 * 3、为了应对多终端登录，将同一个发起人chatuser的终端uuid加入到一个集合，然后将集合加入到userUuidMap，以聊天账号id为键
	 * <br>
	 * 4、将当前会话websocket加入到hashmap，以uuid为键<br>
	 * 5、发送离线消息<br>
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
	}

	/**
	 * 将当前连接的uuid加入到chatUserTreminalUuidHashMap集合中，以便检索。
	 * 建立terminalUuid与chatServer的映射。发送的时候从哈希中查找对应的chatServer，执行sendMessage。
	 * 
	 * @param chatUserId
	 * @param terminalUuid
	 * @return
	 */
	private boolean addTerminalToHashMap(String chatUserId, String terminalUuid) {
		try {
			CopyOnWriteArraySet<String> terminalUuidSet = null;
			if (chatUserTerminalUuidHashMap.containsKey(chatUserId)) {
				terminalUuidSet = chatUserTerminalUuidHashMap.get(chatUserId);
			} else {
				terminalUuidSet = new CopyOnWriteArraySet<String>();
			}
			terminalUuidSet.add(terminalUuid);
			chatUserTerminalUuidHashMap.put(chatUserId, terminalUuidSet);
			terminalUuidChatServerHashMap.put(terminalUuid, this);
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
	private boolean removeTerminalFromHashMap(String chatUserId, String terminalUuid) {
		try {
			CopyOnWriteArraySet<String> terminalUuidSet = null;
			if (chatUserTerminalUuidHashMap.containsKey(chatUserId)) {// 如果存在
				terminalUuidSet = chatUserTerminalUuidHashMap.get(chatUserId);// 取得terminalUuid的集合
			} else {
				return true;
			}
			terminalUuidSet.remove(terminalUuid);// 从集合中移除
			if (terminalUuidSet.size() == 0) {// 如果已经没有连接终端
				chatUserTerminalUuidHashMap.remove(chatUserId);// 则清除
			} else {
				chatUserTerminalUuidHashMap.put(chatUserId, terminalUuidSet);// 更新哈希
			}
			ChatServer chatServer = terminalUuidChatServerHashMap.get(terminalUuid);
			// 释放资源，清空chatServer
			chatServer = null;
			terminalUuidChatServerHashMap.remove(terminalUuid);// 将chatServer的实例从哈希中移除。
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
			// //logger.error("传递字符串连接错误-----");
			return false;
		}
		String token = "TOKEN=";// TOKEN验证
		String userIdStart = "USERID="; // 查询字符串的每一节，以&隔开，传递用户id的部分以userID开头，必须有
		String typeStart = "USERTYPE="; // 用户类型的开头字符串，必须有
		String terminalStart = "TERMINALTYPE="; // 用户类型的开头字符串，必须有
		String indentStart = "INDENTID="; // 订单id的开头字符串。不必须的
		String versionStart = "V=";
		try {
			String[] queryStringArray = queryString.split("&");// 查询字符串用&连接
			if (queryStringArray.length == 0) // 如果没有查询字符串，则返回false，调用者会据此关闭连接
				return false;
			for (int i = 0; i < queryStringArray.length; i++) {// ‘对查询字符串进行检查，如果有uid等参数，则取出病赋值
				if (queryStringArray[i].toUpperCase().startsWith(userIdStart)) {// 用户id

				}
				if (queryStringArray[i].toUpperCase().startsWith(typeStart)) {// 类型

				}
				if (queryStringArray[i].toUpperCase().startsWith(terminalStart)) {// 终端类型,ANDROID，IOS，WECHAT，WEB，APPLET

				}
				if (queryStringArray[i].toUpperCase().startsWith(indentStart)) {// 订单类型

				}
				if (queryStringArray[i].toUpperCase().startsWith(token)) {// TOKEN

				}
				if (queryStringArray[i].toUpperCase().startsWith(versionStart)) {// version

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
			System.out.println("有一连接关闭发生错误");
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

			// removeTerminalFromHashMap(this.getChatUser().getId(),
			// this.getTerminalUuid());
			subOnlineCount(); // 在线数减1
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 收到客户端消息后调用的方法。 客户端发送消息的方法是，发送到服务器，消息中指明要传送给那个用户，消息的类型。<br/>
	 * 此处只管发送，至于发送的模式（紧急通知，普通通知，订单消息，聊天信息），这里并进行解析处理，由客户端自行处理。<br/>
	 * 
	 * TODO 还有一种情况需要注意：同一个账号从多个终端登录，在一个终端发言，需发送到其他的登录终端
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
		try {// 解析json串

		} catch (Exception e) {// 发生错误即退出
			e.printStackTrace();
			return;
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
			// removeTerminalFromHashMap(this.getChatUser().getId(),
			// this.getTerminalUuid());
			error.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.printStackTrace();
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