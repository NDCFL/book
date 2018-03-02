package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

public class BooksCollectVo implements Serializable  {
    private Long id;//'图书收藏编号',
    private Long userId;//'用户编号',
    private Long booksId;//'图书编号',
    private Date createTime;//'收藏时间'
    private BooksVo booksVo;//图书组件
    private UserVo userVo;//用户组件

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

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BooksVo getBooksVo() {
        return booksVo;
    }

    public void setBooksVo(BooksVo booksVo) {
        this.booksVo = booksVo;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
