package com.dingjianlei.springboot.service;

import java.util.List;

import com.dingjianlei.springboot.entity.Favorites;

public interface FavoritesService {
	/**通过姓名查找List**/
	public List<Favorites>  findFavoritesListByUsername(String username);
public List<Favorites> findFavoritesListByChatUserId(String chatUserId);
}
