package com.cfl.controller;

import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BookModuleService;
import com.cfl.vo.BookModuleVo;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("bookModule")
public class BookModuleController {

    @Resource
    private BookModuleService bookModuleService;
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
