package com.cfl.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cfl.common.Message;
import com.cfl.common.PagingBean;
import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.service.*;
import com.cfl.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by chenfeilong on 2017/11/12.
 */
@RequestMapping("employee")
@Controller
public class EmployeeController  {
    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    @RequestMapping("employeeList")
    @ResponseBody
    public PagingBean EmployeeList(int pageSize, int pageIndex,HttpSession session,String searchVal) throws Exception {
        UserVo userVo = (UserVo)session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(employeeService.count(pageQuery));
        pagingBean.setrows(employeeService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("addEmployee")
    @ResponseBody
    public Message addEmployee(UserVo userVo, HttpSession session) {
        UserVo user = (UserVo) session.getAttribute("userVo");
        UserRoleVo userRole = (UserRoleVo) session.getAttribute("userRole");
        userVo.setStatus(0);
        userVo.setPassword(new Md5Hash(userVo.getPassword()).toString());
        userVo.setName("未填写");
        userService.save(userVo);
        return Message.success("新增成功!");
    }
    @RequestMapping("/findEmployee/{id}")
    @ResponseBody
    public UserVo findEmployee(@PathVariable("id") long id) {
        UserVo Employee = employeeService.getById(id);
        return Employee;
    }
    @RequestMapping("/initPwd/{id}")
    @ResponseBody
    public Message initPwd(@PathVariable("id") long id) {
        try{
            employeeService.initPwd(new Md5Hash("888888").toString(),id);
            return Message.success("初始化成功，密码为888888请妥善保管");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("初始化失败");
        }

    }
    @RequestMapping("/employeeUpdateSave")
    @ResponseBody
    public Message updateEmployee(UserVo userVo) throws Exception {
        try {
            employeeService.update(userVo);
            return Message.success("修改成功!");
        } catch (Exception e) {
            return Message.fail("修改失败!");
        }
    }

    @RequestMapping("/deleteManyEmployee")
    @ResponseBody
    public Message deleteManyEmployee(@Param("manyId") String manyId) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                employeeService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/deleteEmployee/{id}")
    @ResponseBody
    public Message deleteEmployee(@PathVariable("id") long id) throws Exception {
        try {
            employeeService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/employeeListPage")
    public String table() throws Exception {
        return "employee/employeeList";
    }
    @RequestMapping("/hotelEmployeeListPage")
    public String hotelEmployeeListPage() throws Exception {
        return "employee/hotelEmployeeList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id, @PathVariable("status") int status) throws Exception {
        try {
            employeeService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
