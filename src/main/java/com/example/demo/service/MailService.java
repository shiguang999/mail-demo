package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.PageEntity;
import com.example.demo.util.BackCommonsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MailService {
    PageEntity<User> queryUser(User user, PageEntity<User> pageData);

    List<Emil> queryMail(Emil user);

    String updateUser(User user);

    String addUser(User user);

    Object sendMail(Emil mail);

    BackCommonsEnum sendMailMath(Emil mail, HttpServletRequest request);

    User queryUserById(User user);
}
