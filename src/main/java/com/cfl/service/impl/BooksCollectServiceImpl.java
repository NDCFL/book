package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BooksCollectDAO;
import com.cfl.service.BooksCollectService;
import com.cfl.vo.BooksCollectVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksCollectServiceImpl implements BooksCollectService {
    @Resource
    private BooksCollectDAO booksCollectDAO;
    public void save(BooksCollectVo BooksCollectVo) {
        booksCollectDAO.save(BooksCollectVo);
    }

    public void remove(BooksCollectVo BooksCollectVo) {
        booksCollectDAO.remove(BooksCollectVo);
    }

    public void removeById(Long id) {
        booksCollectDAO.removeById(id);
    }

    public void update(BooksCollectVo BooksCollectVo) {
        booksCollectDAO.update(BooksCollectVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        booksCollectDAO.updateStatus(statusQuery);
    }

    public BooksCollectVo getById(Long id) {
        return booksCollectDAO.getById(id);
    }

    public List<BooksCollectVo> listAll() {
        return booksCollectDAO.listAll();
    }

    public List<BooksCollectVo> listPage(PageQuery pageQuery) {
        return booksCollectDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return booksCollectDAO.count(pageQuery);
    }

    @Override
    public int findCollect(BooksCollectVo booksCollectVo) {
        return booksCollectDAO.findCollect(booksCollectVo);
    }
}
