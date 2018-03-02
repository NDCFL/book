package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

public class MoneyItemVo implements Serializable {

    private Long id;//'消费编号',
    private Long userId;//'用户编号',
    private Double money;//'消费金额',
    private Integer type;//'消费类型：0：充值，1：消费，2：赏金',
    private Integer issucc;//'消费状态，0：成功,1:失败',
    private String remark;//'备注',
    private Date createTime;//'消费时间'

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIssucc() {
        return issucc;
    }

    public void setIssucc(Integer issucc) {
        this.issucc = issucc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
