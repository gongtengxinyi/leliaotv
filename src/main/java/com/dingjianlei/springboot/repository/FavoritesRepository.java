package com.dingjianlei.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dingjianlei.springboot.entity.Favorites;

public interface FavoritesRepository extends JpaRepository< Favorites, String>{
	List<Favorites>findByChatUserId(String chatUserId);
	List<Favorites>findByUsername(String username);
}
