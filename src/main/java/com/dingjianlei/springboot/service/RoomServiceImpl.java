package com.dingjianlei.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.entity.Room;
import com.dingjianlei.springboot.repository.RoomRepository;

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

	@Override
	public List<Room> findRoomFillIndex() {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(0,Integer.parseInt(Constant.INDEX_ROOM_COUNT));
		Page<Room> chatPage = 	roomRepository.findAll(pageable);
		List<Room>  roomList=new ArrayList<Room>();
		if(chatPage.getContent().size()<4){
	Room room =	roomRepository.findOne("1");	
	for (int i = 0; i < 4-chatPage.getContent().size(); i++) {
	if(room!=null)
	roomList.add(room);
	}
		}
		roomList=chatPage.getContent();
		return roomList;
	}

	@Override
	public void saveOneRoom(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
	}

	@Override
	public boolean checkRoomNumExists(String roomNum) {
		// TODO Auto-generated method stub
		Room findByRoomNum = roomRepository.findByRoomNum(roomNum);
		if(findByRoomNum==null)
		return false;
		else{
			return true;
		}
	}

}
