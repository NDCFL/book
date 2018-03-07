package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BooksDAO;
import com.cfl.service.BooksService;
import com.cfl.service.BooksService;
import com.cfl.vo.BooksVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BooksServiceImpl implements BooksService {
        @Resource
        private BooksDAO booksDAO;
        public void save(BooksVo BooksVo) {
            booksDAO.save(BooksVo);
        }

        public void remove(BooksVo BooksVo) {
            booksDAO.remove(BooksVo);
        }

        public void removeById(Long id) {
            booksDAO.removeById(id);
        }

        public void update(BooksVo BooksVo) {
            booksDAO.update(BooksVo);
        }

        public void updateStatus(StatusQuery statusQuery) {
            booksDAO.updateStatus(statusQuery);
        }

        public BooksVo getById(Long id) {
            return booksDAO.getById(id);
        }

        public List<BooksVo> listAll() {
            return booksDAO.listAll();
        }

        public List<BooksVo> listPage(PageQuery pageQuery) {
            return booksDAO.listPage(pageQuery);
        }

        public long count(PageQuery pageQuery) {
            return booksDAO.count(pageQuery);
        }

    @Override
    public List<Select2Vo> getBooks() {
        return booksDAO.getBooks();
    }

    @Override
    public List<BooksVo> getBooksByList() {
        return booksDAO.getBooksByList();
    }

    @Override
    public List<BooksVo> getListBooks(String ifVal) {
        return booksDAO.getListBooks(ifVal);
    }
}
