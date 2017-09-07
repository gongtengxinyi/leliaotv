package com.dingjianlei.springboot.constants;

/**
 * 聊天信息类型
 * @author丁建磊
 *
 */
public enum EnumMessageType{
	TEXT("文本"),
	IMAGE("图片"),
	AUDIO("音频"),
	BINARY("二进制"),
	VIDEO("小视频"),
	LOCATION("位置")
	;

	private String text;

	private EnumMessageType(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
