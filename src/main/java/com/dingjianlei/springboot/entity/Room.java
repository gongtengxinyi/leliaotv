package com.dingjianlei.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Room {
    // PK ID
    @Id
    @JsonProperty
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    @Column(name = "id", nullable = false, length = 32)
    private String id;
    @Column(nullable = false)
    /**房间名字**/
    private String roomName;
    /**直播者id**/
    @Column(nullable = true,length=35)
    private String liverId;
    /**房间号   **/
    @Column(nullable = true,length=35)
    private String roomNum;
    /**是否开放  **/
    @Column(nullable = true,length=35)
    private boolean status;
    /**房间 直播 类型**/
    @Column(nullable = true,length=35)
    private String liveType;
    /**创建时间**/
    @Column(nullable = true,length=35)
    private String createDate;
    @Column(nullable = true,length=255)
    /**房间简介**/
    private String roomIntroduce;
    @Column(nullable = true,length=100)
    /**房间图片**/
    private String roomImg;
    
	public String getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}
	public String getRoomIntroduce() {
		return roomIntroduce;
	}
	public void setRoomIntroduce(String roomIntroduce) {
		this.roomIntroduce = roomIntroduce;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
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
