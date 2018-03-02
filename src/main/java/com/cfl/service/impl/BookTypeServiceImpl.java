package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BookTypeDAO;
import com.cfl.service.BookTypeService;
import com.cfl.vo.BookTypeVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService{
    @Resource
    private BookTypeDAO bookTypeDAO;
    public void save(BookTypeVo BookTypeVo) {
        bookTypeDAO.save(BookTypeVo);
    }

    public void remove(BookTypeVo BookTypeVo) {
        bookTypeDAO.remove(BookTypeVo);
    }

    public void removeById(Long id) {
        bookTypeDAO.removeById(id);
    }

    public void update(BookTypeVo BookTypeVo) {
        bookTypeDAO.update(BookTypeVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        bookTypeDAO.updateStatus(statusQuery);
    }

    public BookTypeVo getById(Long id) {
        return bookTypeDAO.getById(id);
    }

    public List<BookTypeVo> listAll() {
        return bookTypeDAO.listAll();
    }

    public List<BookTypeVo> listPage(PageQuery pageQuery) {
        return bookTypeDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return bookTypeDAO.count(pageQuery);
    }

    @Override
    public List<Select2Vo> getBookType() {
        return bookTypeDAO.getBookType();
    }
}
