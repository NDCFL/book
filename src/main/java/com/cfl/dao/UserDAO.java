package com.cfl.dao;

import com.cfl.common.PageQuery;
import com.cfl.common.UserAccountPasswordQuery;
import com.cfl.vo.Select2Vo;
import com.cfl.vo.UserVo;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends BaseDAO<UserVo>{
    UserVo getByAccountPassword(UserAccountPasswordQuery userAccountPasswordQuery);
    int checkReg(String phone);
    int checkLogin(String account);
    void updatePwd(@Param("id") long id, @Param("pwd") String pwd);
    void updatePhone(@Param("id") long id,@Param("phone") String phone);
    String getPassword(long id);
    List<Select2Vo> getUser();
    UserVo findByPhone(String phone);
    UserVo findByOpenid(@Param("qb") Integer qb,@Param("openid") String openid);

}
