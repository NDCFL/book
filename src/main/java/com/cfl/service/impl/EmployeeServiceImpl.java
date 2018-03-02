package com.cfl.service.impl;

import org.springframework.stereotype.Service;
import com.cfl.dao.EmployeeDAO;
import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.service.EmployeeService;
import com.cfl.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDAO EmployeeDAO;
    @Override
    public void save(UserVo userVo) {
        EmployeeDAO.save(userVo);
    }

    @Override
    public void remove(UserVo userVo) {
        EmployeeDAO.remove(userVo);
    }

    @Override
    public void removeById(Long id) {
        EmployeeDAO.removeById(id);
    }

    @Override
    public void update(UserVo userVo) {
        EmployeeDAO.update(userVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        EmployeeDAO.updateStatus(statusQuery);
    }

    @Override
    public UserVo getById(Long id) {
        return EmployeeDAO.getById(id);
    }

    @Override
    public List<UserVo> listAll() {
        return EmployeeDAO.listAll();
    }

    @Override
    public List<UserVo> listPage(PageQuery pageQuery) {
        return EmployeeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return EmployeeDAO.count(pageQuery);
    }

    @Override
    public long counts(PageQuery pageQuery) {
        return EmployeeDAO.counts(pageQuery);
    }

    @Override
    public void initPwd(String password, Long id) {
        EmployeeDAO.initPwd(password, id);
    }


    @Override
    public List<UserVo> listPages(PageQuery pageQuery) {
        return EmployeeDAO.listPages(pageQuery);
    }
}
