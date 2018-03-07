package com.cfl.dao;

import com.cfl.common.PageQuery;
import com.cfl.vo.BooksDiscussVo;
import com.cfl.vo.BooksSectionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDiscussDAO extends BaseDAO<BooksDiscussVo>{
    List<BooksDiscussVo> getMuLu(PageQuery pageQuery);
}
