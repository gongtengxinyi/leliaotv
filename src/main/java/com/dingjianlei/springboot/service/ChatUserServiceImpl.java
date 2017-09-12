package com.dingjianlei.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.dto.ResultObject;
import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.repository.ChatUserRepository;

/**
 * 
 * And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang
 * pwd)； Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String
 * addr)； Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int
 * min)； LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
 * GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)； IsNull ---
 * 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()； IsNotNull --- 等价于 SQL 中的 "is
 * not null"，比如 findByUsernameIsNotNull()； NotNull --- 与 IsNotNull 等价； Like ---
 * 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)； NotLike --- 等价于 SQL 中的
 * "not like"，比如 findByUsernameNotLike(String user)； OrderBy --- 等价于 SQL 中的
 * "order by"，比如 findByUsernameOrderBySalaryAsc(String user)； Not --- 等价于 SQL 中的
 * "！ ="，比如 findByUsernameNot(String user)； In --- 等价于 SQL 中的 "in"，比如
 * findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection
 * 类型，也可以是数组或者不定长参数； NotIn --- 等价于 SQL 中的 "not in"，比如
 * findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection
 * 类型，也可以是数组或者不定长参数；
 *
 */
@Service
public class ChatUserServiceImpl implements ChatUserService {
	@Autowired
	private ChatUserRepository chatUserRepository;

	@Override
	public boolean existsById(String chatUserId) {

		return chatUserRepository.exists(chatUserId);

	}

	@Override
	public List<ChatUser> getRank() {
		Sort sort = new Sort(Direction.DESC, "score");
		List<ChatUser> chatUserList = new ArrayList<ChatUser>();
		Pageable pageable = new PageRequest(0, Constant.RANK_COUNT, sort);
		Page<ChatUser> chatPage = chatUserRepository.findAll(pageable);
		if (chatPage != null) {
			chatUserList = chatPage.getContent();
		}
		if (chatUserList.isEmpty()) {
			ChatUser chatUser = createVirturlChatUser();
			chatUserList.add(chatUser);
		}
		return chatUserList;
	}

	/**
	 * 造假的chatUser 把他加入到list,用来填充排行榜数据
	 * 
	 * @return
	 */
	private ChatUser createVirturlChatUser() {
		ChatUser chatUser = new ChatUser();
		chatUser.setUsername("工藤新一");
		chatUser.setScore("1000");
		return chatUser;
	}

	@Override
	public boolean updateScoreByChatUserId(String chatUserId, String addScore) {
		ChatUser chatUser = chatUserRepository.findOne(chatUserId);
		int res=0;
		if(chatUser!=null){
			int count=Integer.parseInt(chatUser.getScore())+Integer.parseInt(addScore);
			res = chatUserRepository.updateScoreByChatUserId(String.valueOf(count), chatUserId);	
		}
		if (res > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ChatUser findChatUserById(String chatUserId) {

		return chatUserRepository.findOne(chatUserId);
	}

	@Override
	public ChatUser login(String username, String password) {
		ChatUser chatUser = null;
		try {
			chatUser = chatUserRepository.findByUsername(username);
			if (chatUser == null) {
				return chatUser;
			} else {
				if (StringUtils.equals(password, chatUser.getPassword())) {
					return chatUser;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return chatUser;

		}
		return chatUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dingjianlei.springboot.service.ChatUserService#insertChatUser(com.
	 * dingjianlei.springboot.entity.ChatUser)
	 */
	@Override
	public int insertChatUser(ChatUser chatUser) {
		// TODO Auto-generated method stub
		try {

			chatUserRepository.save(chatUser);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dingjianlei.springboot.service.ChatUserService#checkChatUser(java.
	 * lang.String, java.lang.String, java.lang.String) 根据传入的type进行判断
	 * 检查邮箱或者用户名是否有注册的账号
	 */
	@Override
	public ResultObject checkChatUser(String type, String username, String email) {
		ResultObject resultObject = new ResultObject();
		try {
			ChatUser chatUser = null;
			// 判断邮箱是否存在
			if (StringUtils.equals(Constant.EMAIL_TYPE, type)) {
				if (StringUtils.isNotBlank(email)) {
					chatUser = chatUserRepository.findByEmail(email);
				}
				if (chatUser == null) {
					resultObject.setCode(Constant.SUCCESS_CODE);
					resultObject.setSuccess(true);
					return resultObject;
				} else {
					resultObject.setCode(Constant.ERROR_CODE_EXISIS);
					resultObject.setSuccess(false);
					resultObject.setMessage(Constant.ERROR_EMAIL_EXISIS);
				}

			}
			// 判断用户名是否存在
			else if (StringUtils.equals(Constant.USER_TYPE, type)) {
				if (StringUtils.isNotBlank(username)) {
					chatUser = chatUserRepository.findByUsername(username);
				}
				if (chatUser == null) {
					resultObject.setCode(Constant.SUCCESS_CODE);
					resultObject.setSuccess(true);
					return resultObject;
				} else {
					resultObject.setCode(Constant.ERROR_CODE_EXISIS);
					resultObject.setSuccess(false);
					resultObject.setMessage(Constant.ERROR_USERNAME_EXISIS);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			resultObject.setCode(Constant.ERROR_CODE_EXCEPTION);
			resultObject.setSuccess(false);
			resultObject.setMessage(Constant.ERROR_EXCEPTION);
		}

		return resultObject;
	}

}
