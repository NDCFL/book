package com.cfl.controller;

import com.alibaba.fastjson.JSON;
import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BooksSectionService;
import com.cfl.vo.BooksSectionVo;
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
@RequestMapping("booksSection")
public class BooksSectionController {

    @Resource
    private BooksSectionService booksSectionService;
    @RequestMapping("booksSectionList/{id}")
    @ResponseBody
    public PagingBean BooksSectionList(@PathVariable Long id, int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setSearchVal(searchVal);
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setId(id);
        pagingBean.setTotal(booksSectionService.count(pageQuery));
        pagingBean.setrows(booksSectionService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("/booksSectionAddSave")
    @ResponseBody
    public Message addSaveBooksSection(BooksSectionVo books,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            books.setName(books.getName());
            books.setPublishUserId(userVo.getId());
            if(books.getBookMoney()>0){
                books.setIsMoney(1);//如果书币大于0则是收费
            }else{
                books.setBookMoney(0);
                books.setIsMoney(0);//如果书币大于0则是免费
            }
            booksSectionService.save(books);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBooksSectionSection/{id}")
    @ResponseBody
    public BooksSectionVo findBooksSection(@PathVariable("id") long id){
        BooksSectionVo books = booksSectionService.getById(id);
        return books;
    }
    @RequestMapping("/booksSectionUpdateSave")
    @ResponseBody
    public Message updateBooksSection(BooksSectionVo books) throws  Exception{
        try{
            if(books.getBookMoney()>0){
                books.setIsMoney(1);//如果书币大于0则是收费
            }else{
                books.setBookMoney(0);
                books.setIsMoney(0);//如果书币大于0则是免费
            }
            booksSectionService.update(books);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/booksSectionUpdatePage/{id}")
    @ResponseBody
    public ModelAndView booksUpdatePage(@PathVariable("id") Long id) throws  Exception{
        try{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("book/booksSectionUpdate");
            modelAndView.addObject("booksSection", JSON.toJSON(booksSectionService.getById(id)));
            System.out.println(JSON.toJSON(booksSectionService.getById(id))+"-----?>>>>>");
            return  modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/deleteManyBooksSection")
    @ResponseBody
    public Message deleteManyBooksSection(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                booksSectionService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBooksSection/{id}")
    @ResponseBody
    public Message deleteBooksSection(@PathVariable("id") long id) throws  Exception{
        try{
            booksSectionService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/booksSectionPage/{id}")
    public ModelAndView table(@PathVariable Long id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/booksSectionList");
        modelAndView.addObject("id",id);
        return modelAndView;
    }
    @RequestMapping("/booksSectionAddPage/{id}")
    public ModelAndView booksAddPage(@PathVariable Long id) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/booksSectionAdd");
        modelAndView.addObject("booksId",id);
        return modelAndView;
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            booksSectionService.updateStatus(new StatusQuery(id,status));
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
