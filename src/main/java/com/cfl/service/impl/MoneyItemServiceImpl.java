package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.MoneyItemDAO;
import com.cfl.service.MoneyItemService;
import com.cfl.vo.MoneyItemVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MoneyItemServiceImpl implements MoneyItemService {
    @Resource
    private MoneyItemDAO moneyItemDAO;
    public void save(MoneyItemVo moneyItemVo) {
        moneyItemDAO.save(moneyItemVo);
    }

    public void remove(MoneyItemVo moneyItemVo) {
        moneyItemDAO.remove(moneyItemVo);
    }

    public void removeById(Long id) {
        moneyItemDAO.removeById(id);
    }

    public void update(MoneyItemVo moneyItemVo) {
        moneyItemDAO.update(moneyItemVo);
    }

    public void updateStatus(StatusQuery statusQuery) {
        moneyItemDAO.updateStatus(statusQuery);
    }

    public MoneyItemVo getById(Long id) {
        return moneyItemDAO.getById(id);
    }

    public List<MoneyItemVo> listAll() {
        return moneyItemDAO.listAll();
    }

    public List<MoneyItemVo> listPage(PageQuery pageQuery) {
        return moneyItemDAO.listPage(pageQuery);
    }

    public long count(PageQuery pageQuery) {
        return moneyItemDAO.count(pageQuery);
    }
}
