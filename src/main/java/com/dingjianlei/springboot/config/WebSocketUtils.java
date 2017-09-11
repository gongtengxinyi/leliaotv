package com.dingjianlei.springboot.config;

import java.net.URI;
import java.util.Properties;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * websocket 推送客户端，把爬虫爬到的视频 种子 图片 广播给每个在线的用户
 */
public class WebSocketUtils {

	public static boolean sendSpiderToOnlinePeople(String roomId, String chatUserId, String pushType, 
			String jsonMessage) {
		Session session;
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer(); // 获取WebSocket连接器，其中具体实现可以参照websocket-api.jar的源码,Class.forName("org.apache.tomcat.websocket.WsWebSocketContainer");
			Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");// 从配置文件中读取配置信息
			String chatServerAddress = properties.getProperty("chat.server.address");// 地址
			String uri = String.format("%s?ROOMID=%s&CHATUSERID=%s", chatServerAddress,
					roomId,chatUserId);// 连接字符串
			session = container.connectToServer(WebSocketClient.class, new URI(uri)); // 连接会话
			session.getBasicRemote().sendText(jsonMessage); // 发送文本消息，一个json串
			session.close();// 主动关闭连接，以节省资源
			session = null;// 释放资源
			return true;// 发送成功
		} catch (Exception e) {// 发生错误
			e.printStackTrace();
			session = null;// 释放资源
			return false;
		}
	}
}
