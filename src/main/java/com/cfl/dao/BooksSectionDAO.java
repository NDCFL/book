package com.cfl.dao;

import com.cfl.common.PageQuery;
import com.cfl.vo.BooksSectionVo;
import com.cfl.vo.MinAndMaxIdVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksSectionDAO extends BaseDAO<BooksSectionVo>{
    List<BooksSectionVo> getList(Long bookId);
    BooksSectionVo upList(PageQuery pageQuery);
    BooksSectionVo downList(PageQuery pageQuery);
    MinAndMaxIdVo minAndMaxId(PageQuery pageQuery);
    List<BooksSectionVo> getMuLu(PageQuery pageQuery);
}
