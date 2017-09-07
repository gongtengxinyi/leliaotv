package com.dingjianlei.springboot.dto;

public class ResultObject {
	/**错误码**/
private String code;
/**错误消息**/
private String message;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
