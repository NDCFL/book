package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BooksSectionDAO;
import com.cfl.service.BooksSectionService;
import com.cfl.vo.BooksSectionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksSectionServiceImpl implements BooksSectionService {
    @Resource
    private BooksSectionDAO BooksSectionDAO;
    public void save(BooksSectionVo BooksSectionVo) {
        BooksSectionDAO.save(BooksSectionVo);
    }

    public void remove(BooksSectionVo BooksSectionVo) {
        BooksSectionDAO.remove(BooksSectionVo);
    }

    public void removeById(Long id) {
        BooksSectionDAO.removeById(id);
    }

    public void update(BooksSectionVo BooksSectionVo) {
        BooksSectionDAO.update(BooksSectionVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        BooksSectionDAO.updateStatus(statusQuery);
    }

    public BooksSectionVo getById(Long id) {
        return BooksSectionDAO.getById(id);
    }

    public List<BooksSectionVo> listAll() {
        return BooksSectionDAO.listAll();
    }

    public List<BooksSectionVo> listPage(PageQuery pageQuery) {
        return BooksSectionDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return BooksSectionDAO.count(pageQuery);
    }
}
