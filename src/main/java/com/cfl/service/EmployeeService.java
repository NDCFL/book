package com.cfl.service;

import org.apache.ibatis.annotations.Param;
import com.cfl.common.PageQuery;
import com.cfl.vo.UserVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
public interface EmployeeService extends BaseService<UserVo>{
    long counts(PageQuery pageQuery);
    void initPwd(String password, Long id);
    List<UserVo> listPages(PageQuery pageQuery);

}
