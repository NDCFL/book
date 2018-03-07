package com.cfl.service;

import com.cfl.common.PageQuery;
import com.cfl.vo.BooksDiscussVo;

import java.util.List;

public interface BooksDiscussService extends BaseService<BooksDiscussVo>{
    List<BooksDiscussVo> getMuLu(PageQuery pageQuery);
}
