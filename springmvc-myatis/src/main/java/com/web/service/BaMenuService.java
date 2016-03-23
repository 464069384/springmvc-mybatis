package com.web.service;

import java.util.List;

import com.web.model.BaMenu;

public interface BaMenuService {

    List<BaMenu> getMenuByParent(int parent);

    List<BaMenu> getMenuByParentNoTree(int parent);
}
