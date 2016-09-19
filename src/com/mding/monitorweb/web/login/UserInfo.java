package com.mding.monitorweb.web.login;

import com.mding.monitorweb.base.BaseObject;

public class UserInfo extends BaseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8719866656112292001L;

	private String userName;
	
	private String password;
	
	private Integer id;
	
	public UserInfo() {
		
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
