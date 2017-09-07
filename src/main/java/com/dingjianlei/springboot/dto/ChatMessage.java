package com.dingjianlei.springboot.dto;

/**
 * @author 丁建磊 目前不打算消息持久化 1.弹幕是即时型的，只推送给当场在线的观众即可
 */
public class ChatMessage {

	private String id;
	private String level;
	private String timeTag;// 显示人性化的时间标记，如：5分钟前，1小时前等等
	private String roomId;// 房间id
	private String messageMode;// 信息模式： 聊天 语音
	private String messageType;// 消息类型：1,文本；2，图片；3，小视频；4，文件；5，地理位置；6，语音；7，视频通话
	private String message;// 文本消息内容
	private boolean succ;// 是否成功
	private String suffix;// 二进制文件后缀，如txt,acc,jpg,png,gif等
	private String uuid;// 文件名字
	private String binaryAddress;// 二进制文件的存储位置。上传之后，将文件存储在指定的位置，然后将binary清空
	private String imageBase64;// 图片的base64字符串
    
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimeTag() {
		return timeTag;
	}

	public void setTimeTag(String timeTag) {
		this.timeTag = timeTag;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getMessageMode() {
		return messageMode;
	}

	public void setMessageMode(String messageMode) {
		this.messageMode = messageMode;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucc() {
		return succ;
	}

	public void setSucc(boolean succ) {
		this.succ = succ;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getBinaryAddress() {
		return binaryAddress;
	}

	public void setBinaryAddress(String binaryAddress) {
		this.binaryAddress = binaryAddress;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

}
