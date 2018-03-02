package com.cfl.dao;

import com.cfl.vo.BookModuleVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookModuleDAO extends BaseDAO<BookModuleVo>{
    List<Select2Vo> getBookModule();
}
