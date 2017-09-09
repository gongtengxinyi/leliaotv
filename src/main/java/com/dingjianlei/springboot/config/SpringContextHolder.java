package com.dingjianlei.springboot.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 
 * @author dingjianlei
 * 
 * 从spring上下文中获取bean
 * 
 *ApplicationContextAware 实现这个接口就可以从spring上下文中获取bean
 *
 */
@Component
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        if(SpringContextHolder.applicationContext == null) {
	        	SpringContextHolder.applicationContext = applicationContext;
	        }	     
	    }

	    //获取applicationContext
	    public static ApplicationContext getApplicationContext() {
	        return applicationContext;
	    }

	    //通过name获取 Bean.
	    public static Object getBean(String name){
	        return getApplicationContext().getBean(name);
	    }

	    //通过class获取Bean.
	    public static <T> T getBean(Class<T> clazz){
	        return getApplicationContext().getBean(clazz);
	    }

	    //通过name,以及Clazz返回指定的Bean
	    public static <T> T getBean(String name,Class<T> clazz){
	        return getApplicationContext().getBean(name, clazz);
	    }

}
