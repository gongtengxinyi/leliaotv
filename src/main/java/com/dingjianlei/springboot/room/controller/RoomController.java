package com.dingjianlei.springboot.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.service.RoomService;

@Controller("roomController")
@RequestMapping("room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@RequestMapping("/enter/{chatUserId}/{roomId}")
	public String enterRoom(@PathVariable String roomId,@PathVariable String chatUserId,ModelMap map) {
		//传身份到页面进行websocket的连接 用来初始化 弹幕
		Room room = roomService.findById(roomId);
		map.put("room", room);
		map.put("chatUserId", chatUserId);
		map.put("roomId", roomId);
		return "room";
	}

}
