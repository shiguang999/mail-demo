package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
