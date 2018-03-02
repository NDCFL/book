package com.cfl.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.cfl.common.PageQuery;
import com.cfl.service.BaseService;
import com.cfl.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Repository
public interface EmployeeDAO extends BaseDAO<UserVo>{
    long counts(PageQuery pageQuery);
    void initPwd(@Param("password") String password, @Param("id") Long id);
    List<UserVo> listPages(PageQuery pageQuery);

}
