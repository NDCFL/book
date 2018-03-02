package com.cfl.vo;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

public class BooksSectionVo implements Serializable  {
    private Long id;//'图书章节编号',
    private Long booksId;//'图书编号',
    private String name;//'图书章节名称',
    private String title;//'图书章节标题',
    private String content;//'图书本章节内容',
    private Date publishTime = new Date();//'发布时间',
    private Integer isMoney;//'是否收费，0：免费，1：收费',
    private Long publishUserId;//'图书章节发布用户编号'
    private BooksVo booksVo;//图书组件bean
    private BookTypeVo bookTypeVo;//小说类型组件
    private Integer sx;//排序顺序,0:升序，1：倒叙
    private Integer bookMoney;//收费时所需书币

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getIsMoney() {
        return isMoney;
    }

    public void setIsMoney(Integer isMoney) {
        this.isMoney = isMoney;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public BooksVo getBooksVo() {
        return booksVo;
    }

    public void setBooksVo(BooksVo booksVo) {
        this.booksVo = booksVo;
    }

    public BookTypeVo getBookTypeVo() {
        return bookTypeVo;
    }

    public void setBookTypeVo(BookTypeVo bookTypeVo) {
        this.bookTypeVo = bookTypeVo;
    }

    public Integer getSx() {
        return sx;
    }

    public void setSx(Integer sx) {
        this.sx = sx;
    }

    public Integer getBookMoney() {
        return bookMoney;
    }

    public void setBookMoney(Integer bookMoney) {
        this.bookMoney = bookMoney;
    }
}
