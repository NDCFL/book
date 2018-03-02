package com.cfl.vo;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;
import java.util.Date;

public class BookTypeVo implements Serializable  {

    private Long id;//'图书类型编号',
    private String name;//'图书类型名称',
    private String introduction;//'图书类型简介',
    private Integer status;//'图书类型状态',
    private Date createTime = new Date();//'图书类型创建时间'

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
