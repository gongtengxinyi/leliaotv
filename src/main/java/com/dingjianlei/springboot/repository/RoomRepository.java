package com.dingjianlei.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dingjianlei.springboot.entity.Room;

public interface RoomRepository extends JpaRepository<Room, String> {
	Room findById(String id);
}
