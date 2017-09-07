package com.dingjianlei.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingjianlei.springboot.entity.Favorites;
import com.dingjianlei.springboot.repository.FavoritesRepository;

@Service
public class FavoritesServiceImpl implements FavoritesService {
	@Autowired
	private FavoritesRepository favoritesRepository;
	
	@Override
	public List<Favorites> findFavoritesListByUsername(String username) {
		List<Favorites> favoritesList=null;
		try {
			  favoritesRepository.findByChatUserId(username);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查找最喜欢主播出错");
			e.printStackTrace();
		}	
		return favoritesList;
	}
	
	@Override
	public List<Favorites> findFavoritesListByChatUserId(String chatUserId) {
		List<Favorites> favoritesList=null;
		try {
			  favoritesRepository.findByChatUserId(chatUserId);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查找最喜欢主播出错");
			e.printStackTrace();
		}	
		return favoritesList;
	}

}
