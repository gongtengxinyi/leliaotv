package com.dingjianlei.springboot.draw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingjianlei.springboot.service.ChatUserService;

@Controller("drawController")
public class DrawController {
	@Autowired
	private ChatUserService chatUserService;
/**
 * 跳转抽奖程序
 * @return
 */
@RequestMapping("draw")
public String disPatcher(String chatUserId,ModelMap map ) {
	boolean res = chatUserService.existsById(chatUserId);
	if(res) {
		map.put("chatUserId", chatUserId);
		return "draw";	
	}else {
		return "login";
	}
}

}
