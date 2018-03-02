package com.cfl.service;

import com.cfl.vo.BookTypeVo;
import com.cfl.vo.Select2Vo;

import java.util.List;

public interface BookTypeService extends BaseService<BookTypeVo>{
    List<Select2Vo> getBookType();
}
