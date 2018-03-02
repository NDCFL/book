package com.cfl.dao;

import com.cfl.vo.BooksVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDAO extends BaseDAO<BooksVo>{
    List<Select2Vo> getBooks();
    List<BooksVo> getBooksByList();
}
