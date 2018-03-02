package com.cfl.controller;

import com.cfl.vo.Select2Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cfl.common.Message;
import com.cfl.common.PagingBean;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.service.BookTypeService;
import com.cfl.vo.BookTypeVo;
import com.cfl.vo.UserVo;

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
@RequestMapping("bookType")
public class BookTypeController {

    @Resource
    private BookTypeService bookTypeService;
    @RequestMapping("bookTypeList")
    @ResponseBody
    public PagingBean BookTypeList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(bookTypeService.count(new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(bookTypeService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize())));
        return pagingBean;
    }
    @RequestMapping("/bookTypeAddSave")
    @ResponseBody
    public Message addSaveBookType(BookTypeVo bookType,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            bookType.setStatus(ActiveStatusEnum.ACTIVE.getValue());
            bookTypeService.save(bookType);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/getBookType")
    @ResponseBody
    public List<Select2Vo> getBookType(){
        return  bookTypeService.getBookType();
    }
    @RequestMapping("/findBookType/{id}")
    @ResponseBody
    public BookTypeVo findBookType(@PathVariable("id") long id){
        BookTypeVo bookType = bookTypeService.getById(id);
        return bookType;
    }
    @RequestMapping("/bookTypeUpdateSave")
    @ResponseBody
    public Message updateBookType(BookTypeVo bookType) throws  Exception{
        try{
            bookTypeService.update(bookType);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyBookType")
    @ResponseBody
    public Message deleteManyBookType(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                bookTypeService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBookType/{id}")
    @ResponseBody
    public Message deleteBookType(@PathVariable("id") long id) throws  Exception{
        try{
            bookTypeService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/bookTypePage")
    public String table() throws  Exception{
        return "book/bookTypeList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            bookTypeService.updateStatus(new StatusQuery(id,status));
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
