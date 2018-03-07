package com.cfl.common;

/**
 * 分页查询对象
 * 创建于2017-08-23
 *
 * @author 陈飞龙
 * @version 1.0
 */
public class PageQuery {

    private Integer pageNo;
    private Integer pageSize;
    private String searchVal;
    private Integer sx;
    private Long id;
    private Long bookId;
    private Long sectionId;
    public PageQuery() {
    }
    public PageQuery(String searchVal) {
        this.searchVal = searchVal;
    }

    public PageQuery(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchVal() {
        return searchVal;
    }

    public void setSearchVal(String searchVal) {
        this.searchVal = searchVal;
    }

    public Integer getSx() {
        return sx;
    }

    public void setSx(Integer sx) {
        this.sx = sx;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
