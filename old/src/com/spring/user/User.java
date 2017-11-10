package com.spring.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.base.entity.BaseEntity;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="user_name")
	private String userName;
	
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
