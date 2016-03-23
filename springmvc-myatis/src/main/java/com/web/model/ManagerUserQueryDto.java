package com.web.model;

import java.io.Serializable;


public class ManagerUserQueryDto implements Serializable{

	private static final long serialVersionUID = -1826163311346877216L;

	/**
	 * 账号
	 */
	private String username;
	
	/**
	 * 角色名
	 */
	private String name;
	
	/**
	 * 用户id
	 */
	private String id;
	
	/**
	 * 角色id以英文逗号分隔
	 */
	private String roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ManagerUserQueryDto [username=" + username + ", name=" + name + ", id=" + id
				+ ", roles=" + roles + "]";
	}
}
