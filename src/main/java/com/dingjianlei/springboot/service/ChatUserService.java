package com.dingjianlei.springboot.service;

import com.dingjianlei.springboot.dto.ResultObject;

public interface ChatUserService {
/**检查邮箱 用户名false 没有 true**/
public ResultObject checkChatUser(String type,String username,String email);
}
