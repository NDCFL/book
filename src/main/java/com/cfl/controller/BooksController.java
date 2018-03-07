package com.cfl.controller;

import com.alibaba.fastjson.JSON;
import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BooksService;
import com.cfl.vo.BooksVo;
import com.cfl.vo.Select2Vo;
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
import javax.json.Json;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("books")
public class BooksController {

    @Resource
    private BooksService booksService;
    @RequestMapping("booksList")
    @ResponseBody
    public PagingBean BooksList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(booksService.count(new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(booksService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize())));
        return pagingBean;
    }
    @RequestMapping("geBooksByList")
    @ResponseBody
    public List<BooksVo> geBooksByList() throws  Exception{
       return  booksService.getBooksByList();
    }
    @RequestMapping("getListBooks/{id}")
    @ResponseBody
    public List<BooksVo> getListBooks(@PathVariable("id") Integer id) throws  Exception{
        String ifVal = "";
        if(id==null){
            ifVal = "read_count";
        }else {
            switch (id){
                case 0:
                    ifVal = "read_count ";
                    break;
                case 1:
                    ifVal = "collect_count ";
                    break;
                case 2:
                    ifVal = "create_time ";
                    break;
            }
        }
        return  booksService.getListBooks(ifVal);
    }
    @RequestMapping("/booksAddSave")
    @ResponseBody
    public Message addSaveBooks(BooksVo books,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            books.setName(books.getName());
            books.setPublishUserId(userVo.getId());
            books.setUpdateTime(new Date());
            books.setStatus(ActiveStatusEnum.ACTIVE.getValue());
            books.setCollectCount(0l);
            books.setRewardCount(0l);
            books.setDiscussCount(0l);
            books.setReadCount(0l);
            booksService.save(books);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBooks/{id}")
    @ResponseBody
    public BooksVo findBooks(@PathVariable("id") long id){
        BooksVo books = booksService.getById(id);
        return books;
    }
    @RequestMapping("/booksUpdateSave")
    @ResponseBody
    public Message updateBooks(BooksVo books) throws  Exception{
        try{
            books.setUpdateTime(new Date());
            booksService.update(books);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/getBooks")
    @ResponseBody
    public List<Select2Vo> getBooks() throws  Exception{
        return  booksService.getBooks();
    }
    @RequestMapping("/booksUpdatePage/{id}")
    @ResponseBody
    public ModelAndView booksUpdatePage(@PathVariable("id") Long id) throws  Exception{
        try{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("book/booksUpdate");
            modelAndView.addObject("books", JSON.toJSON(booksService.getById(id)));
            System.out.println(JSON.toJSON(booksService.getById(id))+"-----?>>>>>");
            return  modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/deleteManyBooks")
    @ResponseBody
    public Message deleteManyBooks(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                booksService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBooks/{id}")
    @ResponseBody
    public Message deleteBooks(@PathVariable("id") long id) throws  Exception{
        try{
            booksService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/booksPage")
    public String table() throws  Exception{
        return "book/booksList";
    }
    @RequestMapping("/booksAddPage")
    public String booksAddPage() throws  Exception{
        return "book/booksAdd";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            booksService.updateStatus(new StatusQuery(id,status));
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
