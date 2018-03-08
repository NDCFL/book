package com.cfl.service;

import com.cfl.common.PageQuery;
import com.cfl.vo.BookModuleVo;
import com.cfl.vo.Select2Vo;

import java.util.List;

public interface BookModuleService extends BaseService<BookModuleVo>{
    List<Select2Vo> getBookModule();
    List<BookModuleVo> getInfo();
    List<BookModuleVo> getInfos();
    List<BookModuleVo> getMuLu(PageQuery pageQuery);
}
