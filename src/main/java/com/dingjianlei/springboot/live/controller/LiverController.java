package com.dingjianlei.springboot.live.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dingjianlei.springboot.config.StartUpListenerSpring;
import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.service.RoomService;

@Controller("liverController")
@RequestMapping("liver")
public class LiverController {
	@Autowired
	private RoomService roomService;
	/** 
	 * 跳到注册首页
	 * @return
	 */
	@RequestMapping("gotoliveRegister")
	public String getIndex() {
		return "liveRegister";
	}
	@RequestMapping("help")
	public String getHelp() {
		return "help";
	}
	@RequestMapping("becomeLiver")
	public String becomeLiver(Room room,@RequestParam(value="file",required=false) MultipartFile file) {
		String path=StartUpListenerSpring.uploadBasepath;//H:/zlyjfiles
		try {
		
			StringBuilder sb=new StringBuilder();
			 //生成uuid作为文件名称  
            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
            //获得文件类型（可以判断如果不是图片，禁止上传）  
            String contentType=file.getContentType();  
            //获得文件后缀名称  
            String imageName=contentType.substring(contentType.indexOf("/")+1); 
			sb.append(path).append("/").append(uuid).append(".").append(imageName);
			file.transferTo(new File(sb.toString()));
			StringBuilder sb1=new StringBuilder();
			//http://192.168.1.118:70
			sb1.append(StartUpListenerSpring.downloadBasepath).append("/").append(uuid).append(".").append(imageName);
			room.setRoomName(sb1.toString());
			roomService.saveOneRoom(room);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "help";
	}
}
