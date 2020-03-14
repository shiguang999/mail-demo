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
    public Map addUser(User user){
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg",service.addUser(user));
        return map;
    }

    @PostMapping("login")
    @ResponseBody
    public Map login(User user){
        Map map = new HashMap();
        map.put("code",200);
        if(null == user.getLoginname()){
            map.put("msg","用户名为空");
            return map;
        }
        if(null == user.getPassword()){
            map.put("msg","密码为空");
            return map;
        }
        List<User> users = service.queryUser(user);
        if(users.size() == 0){
            map.put("msg","用户名或密码错误");
            return map;
        }
        map.put("msg","成功");
        map.put("data",users.get(0));
        return map;
    }

    @PostMapping("queryMail")
    @ResponseBody
    public List<Emil> queryMail(Emil user){
        return service.queryMail(user);
    }


}
