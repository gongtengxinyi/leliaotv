package com.dingjianlei.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChatUser {
	@Id
    private String id;
    @Column(nullable = false)
    private String username;
    /**密码**/
    @Column(nullable = false)
    private String password;
   /**邮箱设置**/
    @Column(nullable = false)
    private String email;
    /**是否开启禁言**/
    @Column(nullable = false)
    private boolean speak;
    /**账户**/
    @Column(nullable = false)
    private Integer account;
    /**手机号**/
    @Column(nullable = false)
    private String  mobile;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSpeak() {
		return speak;
	}
	public void setSpeak(boolean speak) {
		this.speak = speak;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
    
}
