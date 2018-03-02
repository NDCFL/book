package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

public class ShopVo implements Serializable {
    private Long id;//商品编号
    private String name;//商品名称
    private Integer price;//商品价格
    private Long bookMoney;//所得书币数
    private String introduction;//商品描述
    private Integer status;//状态
    private Date createTime = new Date();//创建时间

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getBookMoney() {
        return bookMoney;
    }

    public void setBookMoney(Long bookMoney) {
        this.bookMoney = bookMoney;
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
