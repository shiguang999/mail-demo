package com.example.demo.controller;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    @Autowired
    private MailService service;

    @RequestMapping("toBjdx")
    public String toBjdx(){
        return "bjdx";
    }

    @GetMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("queryUser")
    @ResponseBody
    public List<User> queryUser(User user){
        return service.queryUser(user);
    }

    @PostMapping("addOrUpdateUser")
    @ResponseBody
    public String updateUser(User user){
        return service.updateUser(user);
    }

    @PostMapping("addUser")
    @ResponseBody
    public String addUser(User user){
        return service.addUser(user);
    }

    @PostMapping("login")
    public String login(User user){
        if(null == user.getLoginname()){
            return "用户名为空";
        }
        if(null == user.getPassword()){
            return "密码为空";
        }
        List<User> users = service.queryUser(user);
        if(null == users){
            return "用户名或密码错误";
        }
        return "index";
    }

    @PostMapping("queryMail")
    @ResponseBody
    public List<Emil> queryMail(Emil user){
        return service.queryMail(user);
    }


}
