package com.web.dao;

import java.util.List;

import com.web.model.BaUserRole;

public interface BaUserRoleMapper {
    /**
     * 通过id物理删除ba_user_role的数据.
     */
    int deleteById(Integer id);
    /**
     * 通过user_id物理删除ba_user_role的数据.
     */
    int deleteByUserId(Integer user_id);

    /**
     * 向表ba_user_role中插入数据.
     */
    int insert(BaUserRole record);

    /**
     * 通过id查询表ba_user_role.
     */
    BaUserRole selectById(Integer id);

    /**
     * 通过id修改表ba_user_role.
     */
    int updateById(BaUserRole record);
    
    /**
     * 通过user_id查询表ba_user_role.
     */
    List<BaUserRole> selectByUserId(Integer user_id);
}