package com.dingjianlei.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ChatUser {
	   @Id
	    @JsonProperty
	    @GenericGenerator(name = "systemUUID", strategy = "uuid")
	    @GeneratedValue(generator = "systemUUID")
	    @Column(name = "id", nullable = false, length = 32)
    private String id;
	/**姓名**/
    @Column(nullable = false,length=60)
    private String username;
    /**密码**/
    @Column(nullable = true,length=35)
    private String password;
   /**邮箱设置**/
    @Column(nullable = true,length=35)
    private String email;
    /**是否开启禁言**/
    @Column(nullable = true,length=35)
    private boolean speak;
    /**账户**/
    @Column(nullable =true)
    private Integer account;
    /**手机号**/
    @Column(nullable = true,length=35)
    private String  mobile;   
    /**积分**/
    @Column(nullable = true,length=35)
    private String score;
    
    /**是否是方管**/
    @Column(nullable = true,length=35)
    private String  roomAdmin;  
    
	public String getRoomAdmin() {
		return roomAdmin;
	}
	public void setRoomAdmin(String roomAdmin) {
		this.roomAdmin = roomAdmin;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
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
