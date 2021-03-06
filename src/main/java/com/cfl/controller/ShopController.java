package com.cfl.controller;

import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.ShopService;
import com.cfl.vo.ShopVo;
import com.cfl.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("shop")
public class ShopController {

    @Resource
    private ShopService shopService;
    @RequestMapping("shopList")
    @ResponseBody
    public PagingBean ShopList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(shopService.count(new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(shopService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize())));
        return pagingBean;
    }
    @RequestMapping("/shopAddSave")
    @ResponseBody
    public Message addSaveShop(ShopVo shop,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            shop.setStatus(ActiveStatusEnum.ACTIVE.getValue());
            shopService.save(shop);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findShop/{id}")
    @ResponseBody
    public ShopVo findShop(@PathVariable("id") long id){
        ShopVo shop = shopService.getById(id);
        return shop;
    }
    @RequestMapping("/shopUpdateSave")
    @ResponseBody
    public Message updateShop(ShopVo shop) throws  Exception{
        try{
            shopService.update(shop);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyShop")
    @ResponseBody
    public Message deleteManyShop(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                shopService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteShop/{id}")
    @ResponseBody
    public Message deleteShop(@PathVariable("id") long id) throws  Exception{
        try{
            shopService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/shopPage")
    public String table() throws  Exception{
        return "book/shopList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            shopService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
