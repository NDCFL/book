package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BooksSectionDAO;
import com.cfl.service.BooksSectionService;
import com.cfl.vo.BooksSectionVo;
import com.cfl.vo.MinAndMaxIdVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksSectionServiceImpl implements BooksSectionService {
    @Resource
    private BooksSectionDAO booksSectionDAO;
    public void save(BooksSectionVo BooksSectionVo) {
        booksSectionDAO.save(BooksSectionVo);
    }

    public void remove(BooksSectionVo BooksSectionVo) {
        booksSectionDAO.remove(BooksSectionVo);
    }

    public void removeById(Long id) {
        booksSectionDAO.removeById(id);
    }

    public void update(BooksSectionVo BooksSectionVo) {
        booksSectionDAO.update(BooksSectionVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        booksSectionDAO.updateStatus(statusQuery);
    }

    public BooksSectionVo getById(Long id) {
        return booksSectionDAO.getById(id);
    }

    public List<BooksSectionVo> listAll() {
        return booksSectionDAO.listAll();
    }

    public List<BooksSectionVo> listPage(PageQuery pageQuery) {
        return booksSectionDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return booksSectionDAO.count(pageQuery);
    }

    @Override
    public List<BooksSectionVo> getList(Long bookId) {
        return booksSectionDAO.getList(bookId);
    }

    @Override
    public BooksSectionVo upList(PageQuery pageQuery) {
        return booksSectionDAO.upList(pageQuery);
    }

    @Override
    public BooksSectionVo downList(PageQuery pageQuery) {
        return booksSectionDAO.downList(pageQuery);
    }

    @Override
    public MinAndMaxIdVo minAndMaxId(PageQuery pageQuery) {
        return booksSectionDAO.minAndMaxId(pageQuery);
    }

    @Override
    public List<BooksSectionVo> getMuLu(PageQuery pageQuery) {
        return booksSectionDAO.getMuLu(pageQuery);
    }
}
