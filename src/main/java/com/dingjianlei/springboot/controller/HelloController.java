package com.dingjianlei.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class HelloController {
	@Autowired
	private User user;

    @Autowired
    private DiscoveryClient client;
	@ApiOperation(value="hello接口", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
@RequestMapping("hello")
@ResponseBody
public String getHello(String a,String b) throws Exception{
		 ServiceInstance instance = client.getLocalServiceInstance();
	        Integer r =Integer.parseInt(a)  + Integer.parseInt(b);
	    System.out.println("getHello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);    
	        return String.valueOf(r);
	    }
@RequestMapping("live")
public String getName(ModelMap map){
	return "live";
}
@RequestMapping("chat")
public String getChat(ModelMap map){
	return "chat";
}
@RequestMapping("index")
public String getIndex(ModelMap map){
	return "index";
}
@RequestMapping("archive")
public String getarchive(ModelMap map){
	return "archive";
}
@RequestMapping("contact")
public String getContact(ModelMap map){
	return "contact";
}
@RequestMapping("single")
public String getsingle(ModelMap map){
	return "single";
}
}
