package com.web.model;

import java.io.Serializable;

/**
 * 角色信息查询DTO
 */
public class ManagerRoleQueryDto implements Serializable{

	private static final long serialVersionUID = 7680252894834846408L;
	/**
	 * 角色id
	 */
	private String roleId;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 功能名称  多个以英文逗号分隔
	 */
	private String menuNames;
	
	/**
	 * 功能id 多个以英文逗号进行分隔
	 */
	private String menuIds;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMenuNames() {
		return menuNames;
	}

	public void setMenuNames(String menuNames) {
		this.menuNames = menuNames;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
