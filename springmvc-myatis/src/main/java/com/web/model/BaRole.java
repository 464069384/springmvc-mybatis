package com.web.model;

import java.io.Serializable;

public class BaRole implements Serializable {
    /**
     * .
     */
    private Integer id;

    /**
     * .
     */
    private String name;

    /**
     * 0 不启用 1 启用.
     */
    private Integer enable;

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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}