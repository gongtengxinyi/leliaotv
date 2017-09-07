package com.dingjianlei.springboot.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.repository.ChatUserRepository;
/**
 * 
 * And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang pwd)；
Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String addr)；
Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int min)；
LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)；
IsNull --- 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()；
IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByUsernameIsNotNull()；
NotNull --- 与 IsNotNull 等价；
Like --- 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)；
NotLike --- 等价于 SQL 中的 "not like"，比如 findByUsernameNotLike(String user)；
OrderBy --- 等价于 SQL 中的 "order by"，比如 findByUsernameOrderBySalaryAsc(String user)；
Not --- 等价于 SQL 中的 "！ ="，比如 findByUsernameNot(String user)；
In --- 等价于 SQL 中的 "in"，比如 findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
NotIn --- 等价于 SQL 中的 "not in"，比如 findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
 *
 */
@Service
public class ChatUserServiceImpl implements ChatUserService{
@Autowired
private ChatUserRepository chatUserRepository;

/* (non-Javadoc)
 * @see com.dingjianlei.springboot.service.ChatUserService#checkChatUser(java.lang.String, java.lang.String, java.lang.String)
 * 根据传入的type进行判断 检查邮箱或者用户名是否有注册的账号
 */
@Override
public boolean checkChatUser(String type, String username, String email) {
	ChatUser chatUser=null;
	if(StringUtils.equals(Constant.EMAIL_TYPE,type)){	
		if(StringUtils.isNotBlank(email)){
			chatUser=chatUserRepository.findByEmail(email);	
		}
		if(chatUser==null){
			return false;
		}
		
	}else if(StringUtils.equals(Constant.USER_TYPE,type)){
		if(StringUtils.isNotBlank(username)){
			chatUser=chatUserRepository.findByUsername(username);	
		}
		if(chatUser==null){
			return false;
		}
	}
	return true;
}

}
