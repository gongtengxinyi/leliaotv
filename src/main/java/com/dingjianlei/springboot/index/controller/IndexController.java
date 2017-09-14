package com.dingjianlei.springboot.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.service.RoomService;

@Controller("indexController")
@RequestMapping("index")
public class IndexController {
	@Autowired
	private RoomService roomService;
	/** 
	 * 跳到首页
	 * @return
	 */
	@RequestMapping("gotoIndex")
	public String getIndex(ModelMap map) {
		List<Room> roomList = roomService.findRoomFillIndex();
		List<Room> roomListTop=roomList.subList(0, Integer.parseInt(Constant.INDEX_ROOM_COUNT)/2-1);
		List<Room> roomListBottom=roomList.subList(Integer.parseInt(Constant.INDEX_ROOM_COUNT)/2,Integer.parseInt(Constant.INDEX_ROOM_COUNT));
		map.put("roomListTop", roomListTop);
		map.put("roomListBottom", roomListBottom);
		return "index";
	}
}
