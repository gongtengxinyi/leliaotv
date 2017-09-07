package com.dingjianlei.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.repository.RoomRepository;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

/**
 * @author =丁建磊
 *
 */
@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room findById(String roomId) {
		return roomRepository.findById(roomId);
	}

}
