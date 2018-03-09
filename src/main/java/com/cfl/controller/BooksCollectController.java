package com.cfl.controller;

import com.alibaba.fastjson.JSON;
import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BooksCollectService;
import com.cfl.vo.BooksCollectVo;
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
@RequestMapping("booksCollect")
public class BooksCollectController {

    @Resource
    private BooksCollectService booksCollectService;
    @RequestMapping("booksCollectList")
    @ResponseBody
    public PagingBean BooksCollectList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(booksCollectService.count(new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(booksCollectService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize())));
        return pagingBean;
    }
    @RequestMapping("/booksCollectAddSave")
    @ResponseBody
    public Message addSaveBooksCollect(BooksCollectVo booksCollect,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            booksCollectService.save(booksCollect);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBooksCollect/{id}")
    @ResponseBody
    public BooksCollectVo findBooksCollect(@PathVariable("id") long id){
        BooksCollectVo booksCollect = booksCollectService.getById(id);
        return booksCollect;
    }
    @RequestMapping("/findCollect")
    @ResponseBody
    public Message findCollect(BooksCollectVo booksCollectVo){
        int cnt = booksCollectService.findCollect(booksCollectVo);
        if(cnt==0){
            return Message.fail("0");
        }else{
            return  Message.success("1");
        }
    }
    @RequestMapping("/booksCollectUpdateSave")
    @ResponseBody
    public Message updateBooksCollect(BooksCollectVo booksCollect) throws  Exception{
        try{
            booksCollectService.update(booksCollect);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/booksCollectUpdatePage/{id}")
    @ResponseBody
    public ModelAndView booksCollectUpdatePage(@PathVariable("id") Long id) throws  Exception{
        try{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("book/booksCollectUpdate");
            modelAndView.addObject("booksCollect", JSON.toJSON(booksCollectService.getById(id)));
            System.out.println(JSON.toJSON(booksCollectService.getById(id))+"-----?>>>>>");
            return  modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/deleteManyBooksCollect")
    @ResponseBody
    public Message deleteManyBooksCollect(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                booksCollectService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBooksCollect/{id}")
    @ResponseBody
    public Message deleteBooksCollect(@PathVariable("id") long id) throws  Exception{
        try{
            booksCollectService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/booksCollectPage")
    public String table() throws  Exception{
        return "book/booksCollectList";
    }
    @RequestMapping("/booksCollectAddPage")
    public String booksCollectAddPage() throws  Exception{
        return "book/booksCollectAdd";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            booksCollectService.updateStatus(new StatusQuery(id,status));
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
