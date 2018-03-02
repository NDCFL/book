package com.cfl.dao;

import com.cfl.vo.BookTypeVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeDAO extends BaseDAO<BookTypeVo>{
    List<Select2Vo> getBookType();
}
