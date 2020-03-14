package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    @RequestMapping("toBjdx")
    public String toBjdx(){
        return "bjdx";
    }

    @GetMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @PostMapping("queryUser")
    @ResponseBody
    public List queryUser(){
        return new ArrayList();
    }
}
