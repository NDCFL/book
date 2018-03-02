package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

public class BooksDiscussVo implements Serializable {
    private Long id;//'评论编号',
    private Long userId;//'评论编号',
    private Long booksId;//'图书编号',
    private String content;//'评论内容',
    private Date publishTime;//'评论时间'
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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
