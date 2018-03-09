package com.cfl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cfl.common.Message;
import com.cfl.common.StatusQuery;
import com.cfl.common.UserAccountPasswordQuery;
import com.cfl.service.UserService;
import com.cfl.vo.Select2Vo;
import com.cfl.vo.UserVo;
import org.activiti.engine.identity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.json.Json;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController  {

    /**
     *
     */
    @Resource
    private UserService userService;
    @RequestMapping("loginPage")
    public String loginPage(){
        return  "login/loginPage";
    }
    @RequestMapping("getInfo")
    @ResponseBody
    public Message getInfo(String phone,String password){
        try{
            UserVo userVo = userService.getByAccountPassword(new UserAccountPasswordQuery(phone, new Md5Hash(password).toString()));
            if((userVo.getPhone().equals(phone) || userVo.getRealname().equals(phone) || userVo.getName().equals(phone) ) && userVo.getPassword().equals(new Md5Hash(password).toString())){
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(phone, new Md5Hash(password).toString()));
                Session session = subject.getSession();
                session.setAttribute("userVo", userVo);
                return  Message.success("验证成功");
            }else{
                return  Message.fail("账号或密码输入有误,或已被禁用");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("账号或密码输入有误,或已被禁用");
        }
    }
    @ResponseBody
    @RequestMapping("getImgCode/{code}")
    public Message getImgCode(@PathVariable("code") String code, HttpSession session){
        String realCode = (String) session.getAttribute("rand");
        if(!code.equals(realCode)){
            return  Message.fail("验证码输入错误");
        }else{
            return  Message.success("验证码输入成功");
        }
    }
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    @RequestMapping("exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "login/loginPage";
    }
    @RequestMapping("bossInfoPage")
    public String bossInfoPage() {
        return "user/bossInfoPage";
    }
    @RequestMapping("bossInfo")
    @ResponseBody
    public UserVo bossInfo(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        return userService.getById(userVo.getId());
    }
    @RequestMapping("updateBossInfo")
    @ResponseBody
    public Message updateBossInfo(UserVo userVo) {
        try{
            userService.update(userVo);
            return Message.success("资料修改成功！");
        }catch (Exception e){
            return Message.success("资料修改失败！");
        }
    }
    @RequestMapping("findByOpenid")
    @ResponseBody
    public Message findByOpenid(Integer qb,String openid) {
        System.out.println(openid+"================");
        try{
            UserVo userVo = userService.findByOpenid(qb, openid);
            if(userVo==null){
                return Message.fail("fail");
            }else{
                System.out.println(JSON.toJSONString(userVo));
                return Message.success(JSON.toJSONString(userVo));
            }
        }catch (Exception e){
            return Message.fail("fail");
        }
    }
    @RequestMapping("addUserByQQ")
    @ResponseBody
    public Message addUserByQQ(String info,String openid) {
        try{
            //{"ret":0,"msg":"","is_lost":0,"nickname":"絮落锦乡","gender":"男","province":"江西","city":"赣州","year":"1997","figureurl":"http://qzapp.qlogo.cn/qzapp/101465328/A68429AF7D54895EF27AEE6477EF9C3A/30","figureurl_1":"http://qzapp.qlogo.cn/qzapp/101465328/A68429AF7D54895EF27AEE6477EF9C3A/50","figureurl_2":"http://qzapp.qlogo.cn/qzapp/101465328/A68429AF7D54895EF27AEE6477EF9C3A/100","figureurl_qq_1":"http://thirdqq.qlogo.cn/qqapp/101465328/A68429AF7D54895EF27AEE6477EF9C3A/40","figureurl_qq_2":"http://thirdqq.qlogo.cn/qqapp/101465328/A68429AF7D54895EF27AEE6477EF9C3A/100","is_yellow_vip":"0","vip":"0","yellow_vip_level":"0","level":"0","is_yellow_year_vip":"0"}
            UserVo userVo = new UserVo();
            userVo.setInfo(info);
            JSONObject jsonObject= JSONObject.parseObject(info);
            userVo.setName(jsonObject.get("nickname").toString());
            userVo.setSex(jsonObject.get("gender").toString()=="男"?"0":"1");
            userVo.setFaceImg(jsonObject.get("figureurl_qq_1").toString());
            userVo.setIsVip(0);
            userVo.setStatus(0);
            userVo.setMoney(0d);
            userVo.setQqopenid(openid);
            userService.save(userVo);
            System.out.println(userVo.getId()+"============");
            return Message.success("ok");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("fail");
        }
    }
    @RequestMapping("checkPwd")
    @ResponseBody
    public Map<String, Boolean> checkPwd(String password, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        try {
            Subject subject = SecurityUtils.getSubject();
            String pwd = userService.getPassword(userVo.getId());
            if (pwd.equals(new Md5Hash(password).toString())) {
                result.put("valid", true);
            } else {
                result.put("valid", false);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("valid", false);
            return result;
        }
    }

    @RequestMapping("updatePassword")
    @ResponseBody
    public Message updatePassword(HttpSession session, String newpassword) {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            userService.updatePwd(userVo.getId(), new Md5Hash(newpassword).toString());
            return  Message.success("密码修改成功!");
        }catch (Exception e){
            return  Message.success("密码修改失败!");
        }
    }
    @RequestMapping("changePhone")
    public Message changePhone(HttpSession session, String phone) {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            userService.updatePhone(userVo.getId(), phone);
            return  Message.success("修改手机绑定成功!");
        }catch (Exception e){
            return  Message.success("修改手机绑定失败!");
        }
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id, @PathVariable("status") int status) throws Exception {
        try {
            userService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }
    @RequestMapping("/deleteManyUser")
    @ResponseBody
    public Message deleteManycashSubject(@Param("manyId") String manyId) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                userService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    public Message deletecashSubject(@PathVariable("id") long id) throws Exception {
        try {
            userService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
