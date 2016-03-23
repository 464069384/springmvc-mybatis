package com.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.BaMenuMapper;
import com.web.dao.BaRoleMapper;
import com.web.dao.BaRoleMenuMapper;
import com.web.execption.ParamInvalidException;
import com.web.model.BaRole;
import com.web.model.BaRoleMenu;
import com.web.service.BaRoleService;

@Service
public class BaRoleServiceImpl implements BaRoleService{
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BaRoleMapper baRoleMapper;
	
	@Autowired
	private BaRoleMenuMapper baRoleMenuMapper;
	
	@Autowired
	private BaMenuMapper baMenuMapper;
	
	@Override
	public void delete(Integer roleId){
		
		BaRole baRole = baRoleMapper.selectById(roleId);
		if (baRole == null) {
			throw new ParamInvalidException("未查询到需删除的角色信息");
		}
		
		//先删除 角色与功能相关联的子表
		int i = baRoleMenuMapper.deleteByRoleId(roleId);
		LOG.info("已删除roleId为{}的{}条ba_Role_Menu记录",roleId,i);
		//删除主表
		int j = baRoleMapper.deleteById(roleId);
		LOG.info("已删除roleId为{}的{}条ba_role记录",roleId,j);
	}
	
	@Override
	public void edit(Integer roleId,List<Integer> menuIds){
		if (menuIds.isEmpty() || menuIds == null ) {
			throw new ParamInvalidException("menuIds不能为空");
		}
		
		if (!this.checkMenuIds(menuIds)) {
			throw new ParamInvalidException("存在非法的menuId");
		}
		
		List<BaRoleMenu> roleMenuList = baRoleMenuMapper.selectByRoleId(roleId);
		if (roleMenuList == null || roleMenuList.isEmpty()) {
			LOG.info("未查询到角色{}相关menu信息" , roleId);
			throw new ParamInvalidException("未查询到需编辑的角色信息");
		}
		
		for (BaRoleMenu baRoleMenu : roleMenuList) {
			if (menuIds.contains(baRoleMenu.getMenuId())) {
				menuIds.remove(baRoleMenu.getMenuId());
			}else{
				baRoleMenuMapper.deleteById(baRoleMenu.getId());
			}
		}
		
		for (Integer menuId : menuIds) {
			BaRoleMenu baRoleMenu = new BaRoleMenu();
			baRoleMenu.setMenuId(menuId);
			baRoleMenu.setRoleId(roleId);
			baRoleMenuMapper.insert(baRoleMenu);
		}
	}
	
	@Override
	public void insert(BaRole baRole,List<Integer> menuIds){
		
		if (menuIds.isEmpty() || menuIds == null ) {
			throw new ParamInvalidException("menuIds不能为空");
		}
		
		if (!this.checkMenuIds(menuIds)) {
			throw new ParamInvalidException("存在非法的menuId");
		}
		
		//插role主表
		baRoleMapper.insert(baRole);
		
		//插role_menu关联表
		for (Integer menuId : menuIds) {
			BaRoleMenu baRoleMenu = new BaRoleMenu(); 
			baRoleMenu.setRoleId(baRole.getId());
			baRoleMenu.setMenuId(menuId);
			baRoleMenuMapper.insert(baRoleMenu);
		}
	}
	
	@Override
	public boolean checkRoleName(String roleName){
		Integer i = baRoleMapper.selectByName(roleName);
		return i > 0;
	}
	
	/**
	 * 验证传入的功能id 是否存在于ba_menu表中 
	 * menuIds size=0 时 会返回true 上层可排除此情况
	 * @param menuIds
	 * @return
	 */
	private boolean checkMenuIds(List<Integer> menuIds){
		List<Integer> list = baMenuMapper.selectAllMenuIds();
		
		if (list == null || list.isEmpty()) {
			LOG.info("未查询到功能信息");
			return false;
		}
		
		return list.containsAll(menuIds);
	}
	
//	@Override
//	public PageInfoQB<ManagerRoleQueryDto> selectAllByPage(int pageNo, int pageSize) {
//    	PageHelper.startPage(pageNo, pageSize);
//    	List<ManagerRoleQueryDto> roleList = baRoleMapper.selectAll();
//    	return new PageInfoQB<ManagerRoleQueryDto>(roleList);
//    }
}
