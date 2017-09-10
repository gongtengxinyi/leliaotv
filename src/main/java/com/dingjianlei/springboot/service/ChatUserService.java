package com.dingjianlei.springboot.service;

import com.dingjianlei.springboot.dto.ResultObject;
import com.dingjianlei.springboot.entity.ChatUser;

public interface ChatUserService {
/**检查邮箱 用户名false 没有 true**/
public ResultObject checkChatUser(String type,String username,String email);
/**插入一个chatUser对象，返回影响的行数**/
public int insertChatUser(ChatUser chatUser);
/**根据用户名和密码登录**/
public ChatUser login(String username, String password);
/**根据主键id判断用户是否存在**/
public boolean existsById(String chatUserId);
/**通过主键寻找chatUser对象**/
public ChatUser findChatUserById(String chatUserId);
/**获取积分排行榜的前几位**/
public java.util.List<ChatUser> getRank();
/**通过chatUserId来增加分数，一般充值或者登陆增加分数**/
public boolean updateScoreByChatUserId(String chatUserId, String addScore);
}
