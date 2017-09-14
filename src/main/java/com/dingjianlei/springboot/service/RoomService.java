package com.dingjianlei.springboot.service;

import java.util.List;

import com.dingjianlei.springboot.entity.Room;

/**
 * **/
public interface RoomService {
Room findById(String roomId);

void saveOneRoom(Room room);
boolean checkRoomNumExists(String roomNum);

List<Room> findRoomFillIndex();
}
