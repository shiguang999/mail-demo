package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @GetMapping("toBjdx")
    public String toBjdx(){
        return "/bidx";
    }

    @GetMapping("toIndex")
    public String toIndex(){
        return "index";
    }
}
