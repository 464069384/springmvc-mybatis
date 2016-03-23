package com.web.dao;

import java.util.List;

import com.web.model.BaRole;
import com.web.model.ManagerRoleQueryDto;

public interface BaRoleMapper {
    /**
     * 通过id物理删除ba_role的数据.
     */
    int deleteById(Integer id);

    /**
     * 向表ba_role中插入数据.
     */
    int insert(BaRole record);

    /**
     * 通过id查询表ba_role.
     */
    BaRole selectById(Integer id);

    /**
     * 通过id修改表ba_role.
     */
    int updateById(BaRole record);
    
    /**
     * 根据roleName查询存在条数
     * @param roleName
     * @return
     */
    Integer selectByName(String roleName);
    
    /**
     * 查询所有角色 包含相关联的功能信息
     * @return
     */
    List<ManagerRoleQueryDto> selectAll();
    
    /**
     * 查询所有的id
     * @return
     */
	List<Integer> selectAllRoleIds();
}