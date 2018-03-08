package com.cfl.controller;

import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BookModuleService;
import com.cfl.service.BooksService;
import com.cfl.vo.*;
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
import java.util.*;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("bookModule")
public class BookModuleController {

    @Resource
    private BookModuleService bookModuleService;
    @Resource
    private BooksService booksService;
    @RequestMapping("bookModuleList")
    @ResponseBody
    public PagingBean BookModuleList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(bookModuleService.count(new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(bookModuleService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize())));
        return pagingBean;
    }
    @RequestMapping("/bookModuleAddSave")
    @ResponseBody
    public Message addSaveBookModule(BookModuleVo bookModule,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            bookModule.setStatus(ActiveStatusEnum.ACTIVE.getValue());
            bookModuleService.save(bookModule);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/getBookModule")
    @ResponseBody
    public List<Select2Vo> getBookModule(){
        return  bookModuleService.getBookModule();
    }
    @RequestMapping("/findBookModule/{id}")
    @ResponseBody
    public BookModuleVo findBookModule(@PathVariable("id") long id){
        BookModuleVo bookModule = bookModuleService.getById(id);
        return bookModule;
    }
    @RequestMapping("/bookModuleUpdateSave")
    @ResponseBody
    public Message updateBookModule(BookModuleVo bookModule) throws  Exception{
        try{
            bookModuleService.update(bookModule);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyBookModule")
    @ResponseBody
    public Message deleteManyBookModule(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                bookModuleService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBookModule/{id}")
    @ResponseBody
    public Message deleteBookModule(@PathVariable("id") long id) throws  Exception{
        try{
            bookModuleService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/bookModulePage")
    public String table() throws  Exception{
        return "book/bookModuleList";
    }
    @RequestMapping("/getList")
    @ResponseBody
    public List<BookModuleVo> getList() throws  Exception{
        return bookModuleService.getInfo();
    }
    @RequestMapping("/getLists")
    @ResponseBody
    public Map<Integer,Object> getLists() throws  Exception{
        Map<Integer,Object> moduleVoMap = new HashMap<>();
        moduleVoMap.put(0,bookModuleService.getInfos());
        moduleVoMap.put(1,booksService.getWanBen());
        return moduleVoMap;
    }
    @RequestMapping("/getMulu")
    @ResponseBody
    public List<BookModuleVo> getMulu(PageQuery pageQuery){
        pageQuery.setId(pageQuery.getBookId());
        long count = bookModuleService.count(pageQuery);
        long pages = (long) Math.ceil((float)count/pageQuery.getPageSize());
        if(pageQuery.getPageNo()>=pages){
            pageQuery.setPageNo((int)pages);
        }else if(pageQuery.getPageNo()<=1){
            pageQuery.setPageNo(1);
        }
        pageQuery.setPageNo((pageQuery.getPageNo()-1)*pageQuery.getPageSize());
        return bookModuleService.getMuLu(pageQuery);
    }
    @RequestMapping("/mulu")
    @ResponseBody
    public PagingBean mulu(long bookId,int pageSize,int pageNo){
        try{
            PagingBean pagingBean = new PagingBean();
            PageQuery pageQuery = new PageQuery();
            pageQuery.setBookId(bookId);
            pageQuery.setId(bookId);
            long count = bookModuleService.count(pageQuery);
            pagingBean.setTemp(count);
            long pages = (long) Math.ceil((float)count/pageSize);
            List<Select2Vo> muluList = new ArrayList<>();
            for (int i=0;i<pages;i++){
                Select2Vo select2Vo = new Select2Vo();
                select2Vo.setId(i+1);
                select2Vo.setText((i+1)+"/"+pages);
                muluList.add(select2Vo);
            }
            pagingBean.setMulu(muluList);
            pageQuery.setPageNo((pageNo-1)*pageSize);
            pageQuery.setPageSize(pageSize);
            pagingBean.setTotal(pages);
            pagingBean.setrows(bookModuleService.getMuLu(pageQuery));
            return pagingBean;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("bookModuleAllList")
    @ResponseBody
    public List<BookModuleVo> bookModuleAllList() throws  Exception{
        return bookModuleService.listAll();
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            bookModuleService.updateStatus(new StatusQuery(id,status));
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
