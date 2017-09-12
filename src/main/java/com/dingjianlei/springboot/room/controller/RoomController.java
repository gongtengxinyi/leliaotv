package com.dingjianlei.springboot.room.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.service.ChatUserService;
import com.dingjianlei.springboot.service.RoomService;

@Controller("roomController")
@RequestMapping("room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private ChatUserService chatUserService;
	@RequestMapping("/enter/{chatUserId}/{roomId}")
	public String enterRoom(@PathVariable String roomId,@PathVariable String chatUserId,ModelMap map,HttpServletRequest request) {
		//传身份到页面进行websocket的连接 用来初始化 弹幕
		Room room = roomService.findById(roomId);
		List<ChatUser> chatUserList = chatUserService.getRank();
		ChatUser chatUser  =  chatUserService.findChatUserById(chatUserId);
		map.addAttribute("chatUser", chatUser);
		map.addAttribute("chatUserList", chatUserList);
		 //获取浏览器访问访问服务器时传递过来的cookie数组
		       Cookie[] cookies = request.getCookies();
        //如果用户是第一次访问，那么得到的cookies将是null
	        if (cookies!=null) {
		           for (int i = 0; i < cookies.length; i++) {
	                Cookie cookie = cookies[i];
	              if (cookie.getName().equals(Constant.LOGIN_COOKIE)) {
	            		map.put("loginStatus", "yes");
	              }
	             }
	        }else {
	        	map.put("loginStatus", "no");
	       }		
		map.put("room", room);
		map.put("chatUserId", chatUserId);
		map.put("roomId", roomId);
		return "single";
	}

}
