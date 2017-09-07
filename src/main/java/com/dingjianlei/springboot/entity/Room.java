package com.dingjianlei.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Room {
	@Id
    private String id;
    @Column(nullable = false)
    /**房间名字**/
    private String roomName;
    /**直播者id**/
    @Column(nullable = false)
    private String liverId;
    /**房间号   **/
    @Column(nullable = false)
    private String roomNum;
    /**是否开放  **/
    @Column(nullable = false)
    private boolean status;
    /**房间 直播 类型**/
    @Column(nullable = false)
    private String liveType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getLiverId() {
		return liverId;
	}
	public void setLiverId(String liverId) {
		this.liverId = liverId;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getLiveType() {
		return liveType;
	}
	public void setLiveType(String liveType) {
		this.liveType = liveType;
	}
    
}
