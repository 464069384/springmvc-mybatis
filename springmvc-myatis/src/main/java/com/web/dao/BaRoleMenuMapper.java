package com.web.dao;

import java.util.List;

import com.web.model.BaRoleMenu;

public interface BaRoleMenuMapper {
    /**
     * 通过id物理删除ba_role_menu的数据.
     */
    int deleteById(Integer id);

    /**
     * 向表ba_role_menu中插入数据.
     */
    int insert(BaRoleMenu record);

    /**
     * 通过id查询表ba_role_menu.
     */
    BaRoleMenu selectById(Integer id);

    /**
     * 通过id修改表ba_role_menu.
     */
    int updateById(BaRoleMenu record);

    /**
     * 通过roleId查询表ba_role_menu.
     */
    List<BaRoleMenu> selectByRoleId(Integer roleId);
    
    /**
     * 通过roleId物理删除ba_role_menu的数据.
     */
    int deleteByRoleId(Integer roleId);
}