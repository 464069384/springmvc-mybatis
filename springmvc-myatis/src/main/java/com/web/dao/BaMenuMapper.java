package com.web.dao;

import java.util.List;

import com.web.model.BaMenu;

public interface BaMenuMapper {
    /**
     * 通过id物理删除ba_menu的数据.
     */
    int deleteById(Integer id);

    /**
     * 向表ba_menu中插入数据.
     */
    int insert(BaMenu record);

    /**
     * 通过id查询表ba_menu.
     */
    BaMenu selectById(Integer id);

    /**
     * 通过id修改表ba_menu.
     */
    int updateById(BaMenu record);

    /**
     * 根据父类菜单找子类菜单
     * @param parentId
     * @return
     */
    List<BaMenu> selectByParent(int parentId);
    
    /**
     * 查询所有的id
     * @return
     */
    List<Integer> selectAllMenuIds();
}