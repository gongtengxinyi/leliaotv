package com.dingjianlei.springboot.constants;

/**
 * 即时通讯模式枚举
 * @author 丁建磊
 *
 */
public enum EnumMessageFrom {
	ORIGNL_AREA("普通区"),
	FULI_AREA("福利区"),
	;

	private String text;

	private EnumMessageFrom(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}
}
