package com.web.service;

/**
 * Created by chenwei on 2016/3/15
 */
import java.util.List;

import com.web.execption.ParamInvalidException;
import com.web.model.BaUser;
import com.web.model.ManagerUserQueryDto;

public interface BaUserService {

    BaUser login(String username, String password);
	
	/**
	 * 添加账户信息并添加相应角色信息
	 * @param baUser 账号信息
	 * @param roleIds 角色id集合
	 */
	public void insertUser(BaUser baUser,List<Integer> roleIds) throws ParamInvalidException;

	/**
	 * 查询所有用户
	 * @return
	 */
//	public PageInfoQB<ManagerUserQueryDto> selectAllByPage(int pageNo, int pageSize);

	/**
	 * 根据id删除user 并删除对应的role
	 * @param id 用户id
	 */
	public void removeUserById(Integer id) throws ParamInvalidException;
	
	/**
	 * @param id
	 * @param roleIds
	 */
	public void editUser(Integer id,List<Integer> roleIds) throws ParamInvalidException;
	
	/**
	 * 验证账号是否存在   true :验证失败(账号已存在)  false :验证通过  
	 */
	public boolean checkUserName(String userName);

	/**
	 * 修改密码
	 * @param username		账户
	 * @param password		原始密码
	 * @param newPassWord	新密码
	 */
	public void updatePassWord(String username, String password, String newPassWord) throws ParamInvalidException;

}
