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
    private BooksCollectDAO BooksCollectDAO;
    public void save(BooksCollectVo BooksCollectVo) {
        BooksCollectDAO.save(BooksCollectVo);
    }

    public void remove(BooksCollectVo BooksCollectVo) {
        BooksCollectDAO.remove(BooksCollectVo);
    }

    public void removeById(Long id) {
        BooksCollectDAO.removeById(id);
    }

    public void update(BooksCollectVo BooksCollectVo) {
        BooksCollectDAO.update(BooksCollectVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        BooksCollectDAO.updateStatus(statusQuery);
    }

    public BooksCollectVo getById(Long id) {
        return BooksCollectDAO.getById(id);
    }

    public List<BooksCollectVo> listAll() {
        return BooksCollectDAO.listAll();
    }

    public List<BooksCollectVo> listPage(PageQuery pageQuery) {
        return BooksCollectDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return BooksCollectDAO.count(pageQuery);
    }
}
