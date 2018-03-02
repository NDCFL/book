package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.ShopDAO;
import com.cfl.service.ShopService;
import com.cfl.vo.ShopVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Resource
    private ShopDAO ShopDAO;
    public void save(ShopVo ShopVo) {
        ShopDAO.save(ShopVo);
    }

    public void remove(ShopVo ShopVo) {
        ShopDAO.remove(ShopVo);
    }

    public void removeById(Long id) {
        ShopDAO.removeById(id);
    }

    public void update(ShopVo ShopVo) {
        ShopDAO.update(ShopVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        ShopDAO.updateStatus(statusQuery);
    }

    public ShopVo getById(Long id) {
        return ShopDAO.getById(id);
    }

    public List<ShopVo> listAll() {
        return ShopDAO.listAll();
    }

    public List<ShopVo> listPage(PageQuery pageQuery) {
        return ShopDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return ShopDAO.count(pageQuery);
    }
}
