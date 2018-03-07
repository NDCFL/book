package com.cfl.service;

import com.cfl.common.PageQuery;
import com.cfl.vo.BooksSectionVo;
import com.cfl.vo.MinAndMaxIdVo;

import java.util.List;

public interface BooksSectionService extends BaseService<BooksSectionVo>{
    List<BooksSectionVo> getList(Long bookId);
    BooksSectionVo upList(PageQuery pageQuery);
    BooksSectionVo downList(PageQuery pageQuery);
    MinAndMaxIdVo minAndMaxId(PageQuery pageQuery);
    List<BooksSectionVo> getMuLu(PageQuery pageQuery);
}
