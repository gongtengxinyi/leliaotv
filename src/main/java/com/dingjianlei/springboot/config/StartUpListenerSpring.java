package com.dingjianlei.springboot.config;

import java.util.Properties;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

/**
 * @author dingjianlei
 */
@Component
public class StartUpListenerSpring implements ApplicationListener<ContextRefreshedEvent> {
	public static String uploadBasepath = "";
	public static String downloadBasepath = "";

	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");// 从配置文件中读取配置信
			uploadBasepath = properties.getProperty("file.upload.basepath");// 图片存放地址
			downloadBasepath = properties.getProperty("file.download.basepath");// 图片下载地址
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
