package com.cfl.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class BooksVo implements Serializable {

    private Long id;//'图书编号',
    private String name;//'图书名称',
    private String title;//'图书标题',
    private String introduction;//'图书简介',
    private Long bookTypeId;//'图书类型编号',
    private String author;//'图书作者',
    private Long wordCount;//'字数',
    private Long section;//'章节数',
    private Date updateTime;//'更新时间',
    private String faceImg;//'封面图片',
    private Long collectCount;//'收藏人数',
    private Long rewardCount;//'打赏人数',
    private Long discussCount;//'评论人数',
    private Long readCount;//'追读人数',
    private Long publishUserId;//'图书发布人编号',
    private Integer isLast;//'是否完本'
    private Integer status;//小说状态
    private String bookTypeName;//类型名称
    private Date createTime = new Date();//创建时间
    private Long bookModule;//模块编号
    private String bookModuleName;//所属小说模块名称

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public Long getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Long collectCount) {
        this.collectCount = collectCount;
    }

    public Long getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(Long rewardCount) {
        this.rewardCount = rewardCount;
    }

    public Long getDiscussCount() {
        return discussCount;
    }

    public void setDiscussCount(Long discussCount) {
        this.discussCount = discussCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Integer getIsLast() {
        return isLast;
    }

    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBookModule() {
        return bookModule;
    }

    public void setBookModule(Long bookModule) {
        this.bookModule = bookModule;
    }

    public String getBookModuleName() {
        return bookModuleName;
    }

    public void setBookModuleName(String bookModuleName) {
        this.bookModuleName = bookModuleName;
    }
}
