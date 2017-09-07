package com.dingjianlei.springboot.constants;

/**
 * 即时通讯模式枚举
 * @author 丁建磊
 *
 */
public enum EnumMessageMode {
	CHAT_MESSAGE("聊天消息"),
	ADMIN_MESSAGE("管理员消息"),
	;

	private String text;

	private EnumMessageMode(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}
}
