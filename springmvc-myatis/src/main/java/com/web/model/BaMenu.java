package com.web.model;

import java.io.Serializable;
import java.util.List;

public class BaMenu implements Serializable {
    /**
     * .
     */
    private Integer id;

    /**
     * .
     */
    private String name;

    /**
     * .
     */
    private String url;

    /**
     * 上级菜单，默认顶级菜单 -1.
     */
    private Integer parent;

    /**
     * 0 不启用 1 启用.
     */
    private Integer enable;

    private List<BaMenu> subList;

    /**
     * 是否叶子节点 0 是 1 非
     */
    private Integer isLeaf;

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public List<BaMenu> getSubList() {
        return subList;
    }

    public void setSubList(List<BaMenu> subList) {
        this.subList = subList;
    }

}