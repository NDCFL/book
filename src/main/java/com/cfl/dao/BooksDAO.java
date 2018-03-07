package com.cfl.dao;

import com.cfl.common.PageQuery;
import com.cfl.vo.BooksVo;
import com.cfl.vo.Select2Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDAO extends BaseDAO<BooksVo>{
    List<Select2Vo> getBooks();
    List<BooksVo> getBooksByList();
    List<BooksVo> getListBooks(@Param("ifVal") String ifVal);
}
