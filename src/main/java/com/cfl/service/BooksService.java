package com.cfl.service;

import com.cfl.vo.BooksVo;
import com.cfl.vo.Select2Vo;

import java.util.List;

public interface BooksService extends BaseService<BooksVo>{
    List<Select2Vo> getBooks();
    List<BooksVo> getBooksByList();
    List<BooksVo> getListBooks(String ifVal);
}
