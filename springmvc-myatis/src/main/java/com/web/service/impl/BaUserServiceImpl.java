package com.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.BaRoleMapper;
import com.web.dao.BaUserMapper;
import com.web.dao.BaUserRoleMapper;
import com.web.execption.ParamInvalidException;
import com.web.model.BaUser;
import com.web.model.BaUserRole;
import com.web.service.BaUserService;

/**
 * Created by chenwei on 2016/3/15
 */
@Service
public class BaUserServiceImpl implements BaUserService {


	private final Logger LOG = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private BaUserMapper baUserMapper;
	
	@Autowired
	private BaUserRoleMapper baUserRoleMapper;
	
	@Autowired
	private BaRoleMapper baRoleMapper;
	
//	@Override
//    public PageInfoQB<ManagerUserQueryDto> selectAllByPage(int pageNo, int pageSize) {
//    	PageHelper.startPage(pageNo, pageSize);
//    	List<ManagerUserQueryDto> userList = baUserMapper.selectAll();
//    	return new PageInfoQB<ManagerUserQueryDto>(userList);
//    }

	@Override
	public void insertUser(BaUser baUser, List<Integer> roleIds) {
		
		if (roleIds.isEmpty() || roleIds == null ) {
			throw new ParamInvalidException("roleIds不能为空");
		}
		
		if (!this.checkRoleIds(roleIds)) {
			throw new ParamInvalidException("存在非法的roleId");
		}
		
		//插user
		baUserMapper.insert(baUser);
		
		//插对应的role
		for (Integer roleId : roleIds) {
			BaUserRole baUserRole = new BaUserRole();
			baUserRole.setUserId(baUser.getId());
			baUserRole.setRoleId(roleId);
			baUserRoleMapper.insert(baUserRole);
		}
	}
	
	/**
	 * 验证传入的功能id 是否存在于ba_role表中 
	 * roleIds size=0 时 会返回true 上层可排除此情况
	 * @param roleIds
	 * @return
	 */
	private boolean checkRoleIds(List<Integer> roleIds){
		List<Integer> list = baRoleMapper.selectAllRoleIds();
		
		if (list == null || list.isEmpty()) {
			LOG.info("未查询到角色信息");
			return false;
		}
		
		return list.containsAll(roleIds);
	}
	
	

	@Override
	public void removeUserById(Integer id) {
		
		BaUser baUser =  baUserMapper.selectById(id);
		
		if (baUser ==  null ) {
			throw new ParamInvalidException("未查询到需删除的账户信息");
		}
		
		//先删除角色子表
		int i = baUserRoleMapper.deleteByUserId(id);
		LOG.info("已删除id为{}的{}条role记录",id,i);
		//再删除主表
		int j = baUserMapper.deleteById(id);
		LOG.info("已删除id为{}的{}条user记录",id,j);
	}

	@Override
	public void editUser(Integer id, List<Integer> roleIds) {
		List<BaUserRole> userRoleList = baUserRoleMapper.selectByUserId(id);
		
		if (userRoleList == null || userRoleList.isEmpty()) {
			LOG.info("未查询到需编辑的账户{}信息" , id);
			throw new ParamInvalidException("未查询到需编辑的账户信息");
		}
		
		for (BaUserRole baUserRole : userRoleList) {
			if (roleIds.contains(baUserRole.getRoleId())) {
				roleIds.remove(baUserRole.getRoleId());
			}else{
				baUserRoleMapper.deleteById(baUserRole.getId());
			}
		}
		
		for (Integer roleId : roleIds) {
			BaUserRole baUserRole = new BaUserRole();
			baUserRole.setRoleId(roleId);
			baUserRole.setUserId(id);
			baUserRoleMapper.insert(baUserRole);
		}
	}

	@Override
	public boolean checkUserName(String userName) {
		Integer i = baUserMapper.selectByUsername(userName);
		return i > 0;
	}

	@Override
	public BaUser login(String username, String password) {
		return baUserMapper.login(username,password);
	}
	
	@Override
	public void updatePassWord(String username,String password,String newPassWord){
		BaUser baUser = baUserMapper.login(username,password);
		if (baUser == null) {
			LOG.warn("账户{}未校验通过,不允许进行登录",username);
			throw new ParamInvalidException("账户或密码错误");
		}
		baUser.setPassword(newPassWord);
		baUserMapper.updateById(baUser);
	}
}
