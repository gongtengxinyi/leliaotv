package com.dingjianlei.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dingjianlei.springboot.entity.ChatUser;

public interface ChatUserRepository extends JpaRepository< ChatUser, String>{

	ChatUser findByEmail(String email);

	ChatUser findByUsername(String username);
	@Transactional
	@Modifying
	@Query("update 	ChatUser u set u.score =?1  where u.id = ?2")
	int updateScoreByChatUserId(String score,String id);
}
