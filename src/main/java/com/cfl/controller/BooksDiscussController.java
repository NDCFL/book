package com.cfl.controller;

import com.alibaba.fastjson.JSON;
import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.service.BooksDiscussService;
import com.cfl.vo.BooksDiscussVo;
import com.cfl.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("booksDiscuss")
public class BooksDiscussController {

    @Resource
    private BooksDiscussService booksDiscussService;
    @RequestMapping("booksDiscussList")
    @ResponseBody
    public PagingBean BooksDiscussList(int pageSize, int pageIndex, String searchVal, HttpSession session,Long id) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setSearchVal(searchVal);
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setId(id);
        pagingBean.setTotal(booksDiscussService.count(pageQuery));
        pagingBean.setrows(booksDiscussService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("/booksDiscussAddSave")
    @ResponseBody
    public Message addSaveBooksDiscuss(BooksDiscussVo booksDiscuss,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            booksDiscussService.save(booksDiscuss);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBooksDiscuss/{id}")
    @ResponseBody
    public BooksDiscussVo findBooksDiscuss(@PathVariable("id") long id){
        BooksDiscussVo booksDiscuss = booksDiscussService.getById(id);
        return booksDiscuss;
    }
    @RequestMapping("/booksDiscussUpdateSave")
    @ResponseBody
    public Message updateBooksDiscuss(BooksDiscussVo booksDiscuss) throws  Exception{
        try{
            booksDiscuss.setPublishTime(new Date());
            booksDiscussService.update(booksDiscuss);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/booksDiscussUpdatePage/{id}")
    @ResponseBody
    public ModelAndView booksDiscussUpdatePage(@PathVariable("id") Long id) throws  Exception{
        try{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("book/booksDiscussUpdate");
            modelAndView.addObject("booksDiscuss", JSON.toJSON(booksDiscussService.getById(id)));
            System.out.println(JSON.toJSON(booksDiscussService.getById(id))+"-----?>>>>>");
            return  modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/deleteManyBooksDiscuss")
    @ResponseBody
    public Message deleteManyBooksDiscuss(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                booksDiscussService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBooksDiscuss/{id}")
    @ResponseBody
    public Message deleteBooksDiscuss(@PathVariable("id") long id) throws  Exception{
        try{
            booksDiscussService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/booksDiscussPage")
    public String table() throws  Exception{
        return "book/booksDiscussList";
    }
    @RequestMapping("/booksDiscussAddPage")
    public String booksDiscussAddPage() throws  Exception{
        return "book/booksDiscussAdd";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            booksDiscussService.updateStatus(new StatusQuery(id,status));
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
