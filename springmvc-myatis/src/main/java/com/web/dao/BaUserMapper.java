package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.model.BaUser;
import com.web.model.ManagerUserQueryDto;

public interface BaUserMapper {
    /**
     * 通过id物理删除ba_user的数据.
     */
    int deleteById(Integer id);

    /**
     * 向表ba_user中插入数据.
     */
    int insert(BaUser record);

    /**
     * 通过id查询表ba_user.
     */
    BaUser selectById(Integer id);

    /**
     * 通过id修改表ba_user.
     */
    int updateById(BaUser record);
    
    /**
     * 查询所有用户 包含相关联的角色信息
     * @return
     */
    List<ManagerUserQueryDto> selectAll();
    
    /**
     * 根据账号查询用户
     * @param username
     * @return
     */
    Integer selectByUsername(String username);

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    BaUser login(@Param("username")String username,@Param("password") String password);
}