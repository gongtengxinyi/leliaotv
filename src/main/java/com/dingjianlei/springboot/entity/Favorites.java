package com.dingjianlei.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Favorites {
	@Id
    private String id;
	/**喜爱的**/
    @Column(nullable = false)
    private String liver;
    /**创建日期**/
    @Column(nullable = false)
    private Date createDate;
    /**chatUser的id **/
    @Column(nullable = false)
    private String chatUserId;
    /**chatUser的名字**/
    @Column(nullable = false)
    private String username;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getChatUserId() {
		return chatUserId;
	}
	public void setChatUserId(String chatUserId) {
		this.chatUserId = chatUserId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLiver() {
		return liver;
	}
	public void setLiver(String liver) {
		this.liver = liver;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
 
}
