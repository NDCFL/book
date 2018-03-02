package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

public class BookModuleVo implements Serializable {
    private Long id;//'小说模块等级',
    private String name;//'小说模块名称',
    private Integer levels;//'小说模块排序级别',
    private Integer status;//'小说模块状态',
    private Date createTime = new Date();//'小说创建时间'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
