package com.web.service;

import java.util.List;

import com.web.execption.ParamInvalidException;
import com.web.model.BaRole;
import com.web.model.ManagerRoleQueryDto;

public interface BaRoleService {
	/**
	 * 添加角色   并添加相应的功能
	 * @param baRole
	 * @param menuIds	功能项id集合
	 */
	void insert(BaRole baRole, List<Integer> menuIds) throws ParamInvalidException;

	/**
	 * 验证角色是否存在   true :验证失败(角色已存在)  false :验证通过  
	 */
	boolean checkRoleName(String roleName);

	/**
	 * 编辑角色所对应的功能
	 * @param roleId
	 * @param menuIds
	 */
	void edit(Integer roleId, List<Integer> menuIds) throws ParamInvalidException;

	/**
	 * 删除角色信息  并删除与之关联的role_menu关联信息
	 * @param roleId
	 */
	void delete(Integer roleId) throws ParamInvalidException;
	
	/**
	 * 分页查询角色及其相关联的功能信息
	 * @param pageNo	起始页码
	 * @param pageSize	每页条数	
	 * @return
	 */
//	PageInfoQB<ManagerRoleQueryDto> selectAllByPage(int pageNo, int pageSize);
	
}
