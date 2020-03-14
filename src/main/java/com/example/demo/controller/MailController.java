package com.example.demo.controller;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.service.MailService;
import com.example.demo.util.BackCommonsEnum;
import com.example.demo.util.BackMessage;
import com.example.demo.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MailController {

    @Autowired
    private MailService service;

    @RequestMapping("toBjdx")
    public String toBjdx(){
        return "bjdx";
    }

    @RequestMapping("toUser")
    public String toUser(){
        return "user";
    }

    @RequestMapping("toDxcx")
    public String toDxcx(){
        return "dxcx";
    }

    @GetMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("queryUser")
    @ResponseBody
    public PageEntity<User> queryUser(User user, Integer page, Integer limit){
        PageEntity<User> pageData=new PageEntity<User>(page,limit);
        return service.queryUser(user,pageData);
    }

    @PostMapping("addOrUpdateUser")
    @ResponseBody
    public BackMessage updateUser(User user){
        return BackMessage.success(service.updateUser(user));
    }

    @PostMapping("addUser")
    @ResponseBody
    public BackMessage addUser(User user){
        service.addUser(user);
        return BackMessage.success();
    }

    @PostMapping("login")
    @ResponseBody
    public BackMessage login(User user , HttpServletRequest request){
        if(null == user.getLoginname() || null == user.getPassword()){
            return BackMessage.success(BackCommonsEnum.LOGIN_ISNOT_USERNAMEORPWD);
        }
        User users = service.queryUserById(user);
        if(users == null){
            return BackMessage.success(BackCommonsEnum.LOGIN_USER_ERROR);
        }
        request.getSession().setAttribute("user",users);
        return BackMessage.success(users);
    }

    @PostMapping("queryMail")
    @ResponseBody
    public BackMessage queryMail(Emil user){
        return BackMessage.success(service.queryMail(user));
    }

    @PostMapping("sendMail")
    @ResponseBody
    public BackMessage sendMail(Emil mail){
        return BackMessage.success(service.sendMail(mail));
    }
}
