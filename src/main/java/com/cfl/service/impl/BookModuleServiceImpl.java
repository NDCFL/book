package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BookModuleDAO;
import com.cfl.service.BookModuleService;
import com.cfl.vo.BookModuleVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookModuleServiceImpl implements BookModuleService{
    @Resource
    private BookModuleDAO bookModuleDAO;
    public void save(BookModuleVo bookModuleVo) {
        bookModuleDAO.save(bookModuleVo);
    }

    public void remove(BookModuleVo bookModuleVo) {
        bookModuleDAO.remove(bookModuleVo);
    }

    public void removeById(Long id) {
        bookModuleDAO.removeById(id);
    }

    public void update(BookModuleVo bookModuleVo) {
        bookModuleDAO.update(bookModuleVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        bookModuleDAO.updateStatus(statusQuery);
    }

    public BookModuleVo getById(Long id) {
        return bookModuleDAO.getById(id);
    }

    public List<BookModuleVo> listAll() {
        return bookModuleDAO.listAll();
    }

    public List<BookModuleVo> listPage(PageQuery pageQuery) {
        return bookModuleDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return bookModuleDAO.count(pageQuery);
    }

    @Override
    public List<Select2Vo> getBookModule() {
        return bookModuleDAO.getBookModule();
    }
}
