package com.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.dao.BaMenuMapper;
import com.web.model.BaMenu;
import com.web.service.BaMenuService;

@Service
public class BaMenuServiceImpl implements BaMenuService {

    @Resource
    private BaMenuMapper baMenuMapper;

    @Override
    public List<BaMenu> getMenuByParent(int parent) {
        List<BaMenu> list = baMenuMapper.selectByParent(parent);
        treeMenuList(list);
        return list;
    }

    @Override
    public List<BaMenu> getMenuByParentNoTree(int parent) {
        List<BaMenu> list = baMenuMapper.selectByParent(parent);
        return list;
    }

    /**
     *
     * @param list
     *private void treeMenuList(List<BaMenu> list) {
        if (list.isEmpty()) {
            return;
        }
        for (BaMenu menu : list) {
            List<BaMenu> subList = baMenuMapper.selectByParent(menu.getId());
            treeMenuList(subList);
            menu.setSubList(subList);
        }

    }*/
    private List<BaMenu> treeMenuList(List<BaMenu> list) {

        if (list.isEmpty()) {
            return null;
        }

        List<BaMenu> listTmp = new ArrayList<>();
        listTmp.addAll(list);

        for (int i = 0; i < listTmp.size(); i++) {
            BaMenu menu = listTmp.get(i);
            if (menu.getIsLeaf() == 1) {
                List<BaMenu> subList = baMenuMapper.selectByParent(menu.getId());
                menu.setSubList(subList);
                if (!subList.isEmpty()) {
                    listTmp.addAll(subList);
                }
            }
        }

        return list;

    }

}
