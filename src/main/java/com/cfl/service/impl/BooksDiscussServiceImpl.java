package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BooksDiscussDAO;
import com.cfl.service.BooksDiscussService;
import com.cfl.vo.BooksDiscussVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksDiscussServiceImpl implements BooksDiscussService{
    @Resource
    private BooksDiscussDAO booksDiscussDAO;
    public void save(BooksDiscussVo BooksDiscussVo) {
        booksDiscussDAO.save(BooksDiscussVo);
    }

    public void remove(BooksDiscussVo BooksDiscussVo) {
        booksDiscussDAO.remove(BooksDiscussVo);
    }

    public void removeById(Long id) {
        booksDiscussDAO.removeById(id);
    }

    public void update(BooksDiscussVo BooksDiscussVo) {
        booksDiscussDAO.update(BooksDiscussVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        booksDiscussDAO.updateStatus(statusQuery);
    }

    public BooksDiscussVo getById(Long id) {
        return booksDiscussDAO.getById(id);
    }

    public List<BooksDiscussVo> listAll() {
        return booksDiscussDAO.listAll();
    }

    public List<BooksDiscussVo> listPage(PageQuery pageQuery) {
        return booksDiscussDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return booksDiscussDAO.count(pageQuery);
    }
}
