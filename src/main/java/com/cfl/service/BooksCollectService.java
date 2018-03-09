package com.cfl.service;

import com.cfl.vo.BooksCollectVo;

public interface BooksCollectService extends BaseService<BooksCollectVo>{
    int findCollect(BooksCollectVo booksCollectVo);
}
