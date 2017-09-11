package com.dingjianlei.springboot.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.service.ChatUserService;

/**
 * @author dingjianlei
 */
@Component
public class StartUpListenerSpring implements ApplicationListener<ContextRefreshedEvent> {
	public static String uploadBasepath = "";
	public static String downloadBasepath = "";
	@Autowired
	private ChatUserService chatUserService;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");// 从配置文件中读取配置信
			uploadBasepath = properties.getProperty("file.upload.basepath");// 图片存放地址
			downloadBasepath = properties.getProperty("file.download.basepath");// 图片下载地址
			// 检查系统推送账号是否存在，如果不存在创建系统推送账号，此类是检测系统启动，检查各项配置
			boolean existsById = chatUserService.existsById(Constant.SYSTEM_PUSH_ID);
			if (!existsById) {
				ChatUser systemPush = createSystemPush();
				chatUserService.insertChatUser(systemPush);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 如果不存在则创建系统推送账号
	 * 
	 * @return
	 */
	private ChatUser createSystemPush() {
		ChatUser chatUser = new ChatUser();
		chatUser.setId(Constant.SYSTEM_PUSH_ID);
		chatUser.setUsername(Constant.SYSTEM_PUSH_NAME);
		return chatUser;
	}

}
