package com.dingjianlei.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dingjianlei.springboot.entity.ChatUser;

public interface ChatUserRepository extends JpaRepository< ChatUser, String>{

	ChatUser findByEmail(String email);

	ChatUser findByUsername(String username);

}
