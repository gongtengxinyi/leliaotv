package com.dingjianlei.springboot.score.controller;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingjianlei.springboot.entity.ChatUser;
import com.dingjianlei.springboot.service.ChatUserService;

@Controller
@RequestMapping("score")
public class ScoreController {
	@Autowired
	private ChatUserService chatUserService;

	/**
	 * 排行榜 本来用redis sortedSet 存贮 本身自带排名 未做持久化保存数据库， 可以自行拓展本模块，做一个数据持久化操作
	 * 以后项目增大，可以将其独立做成一个模块，暂时备用
	 * @return
	 */
	@RequestMapping("/scoreList")
	@ResponseBody
	public List<ChatUser> ScoreList() {
		List<ChatUser> chatUserList = chatUserService.getRank();
		return chatUserList;
	}
	/** 增加分数controller
	 * @param chatUserId
	 * @param addScore
	 * @return
	 */
	@RequestMapping("/addScore")
	@ResponseBody
	public boolean addScore(String chatUserId, String addScore) {
		boolean updateScoreByChatUserId = chatUserService.updateScoreByChatUserId(chatUserId,addScore);
		return updateScoreByChatUserId;
	}
}
