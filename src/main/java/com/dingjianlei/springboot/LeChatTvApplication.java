package com.dingjianlei.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 
 * @author dingjianlei
 *
 */
@SpringBootApplication
@EnableScheduling
public class LeChatTvApplication {
	public static void main(String[] args) {
		SpringApplication.run(LeChatTvApplication.class, args);
	}
}
