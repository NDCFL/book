package com.cfl.controller;

import com.cfl.common.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public Message test(){
        return  Message.success("成功!");
    }
}
