package com.cfl.dao;

import org.springframework.stereotype.Repository;
import com.cfl.vo.UserRoleVo;

import java.util.List;

/**
 * Created by chenfeilong on 2017/10/27.
 */
@Repository
public interface UserRoleDAO extends BaseDAO<UserRoleVo> {
    List<String> pageListByUserId(String userId);
    UserRoleVo getRole(Long userId);
}
