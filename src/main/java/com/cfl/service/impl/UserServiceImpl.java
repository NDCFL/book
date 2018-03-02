package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.common.UserAccountPasswordQuery;
import com.cfl.dao.UserDAO;
import com.cfl.service.UserService;
import com.cfl.vo.Select2Vo;
import com.cfl.vo.UserVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    public void save(UserVo userVo) {
        userDAO.save(userVo);
    }

    public void remove(UserVo userVo) {
        userDAO.remove(userVo);
    }

    public void removeById(Long id) {
        userDAO.removeById(id);
    }

    public void update(UserVo userVo) {
        userDAO.update(userVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        userDAO.updateStatus(statusQuery);
    }

    public UserVo getById(Long id) {
        return userDAO.getById(id);
    }

    public List<UserVo> listAll() {
        return userDAO.listAll();
    }

    public List<UserVo> listPage(PageQuery pageQuery) {
        return userDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return userDAO.count(pageQuery);
    }

    public UserVo getByAccountPassword(UserAccountPasswordQuery userAccountPasswordQuery) {
        return userDAO.getByAccountPassword(userAccountPasswordQuery);
    }

    public int checkReg(String phone) {
        return userDAO.checkReg(phone);
    }

    public int checkLogin(String account) {
        return userDAO.checkLogin(account);
    }

    public void updatePwd(long id, String pwd) {
        userDAO.updatePwd(id, pwd);
    }

    public void updatePhone(long id, String phone) {
        userDAO.updatePhone(id, phone);
    }

    public String getPassword(long id) {
        return userDAO.getPassword(id);
    }

    public List<Select2Vo> getUser() {
        return userDAO.getUser();
    }

    public UserVo findByPhone(String phone) {
        return userDAO.findByPhone(phone);
    }
}
