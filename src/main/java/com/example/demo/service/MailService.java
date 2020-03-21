package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.PageEntity;
import com.example.demo.util.BackCommonsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MailService {
    PageEntity<User> queryUser(User user, PageEntity<User> pageData);

    PageEntity<Emil> queryMail(Emil user,PageEntity<Emil> pageData);

    String updateUser(User user);

    BackCommonsEnum addUser(User user);

    Object sendMail(Emil mail);

    BackCommonsEnum sendMailMath(Emil mail, HttpServletRequest request);

    User queryUserById(User user);

    BackCommonsEnum deleteUser(User user);

    BackCommonsEnum updateuserById(User user);
}
