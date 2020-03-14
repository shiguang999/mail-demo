package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.BackCommonsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MailService {
    List<User> queryUser(User user);

    List<Emil> queryMail(Emil user);

    String updateUser(User user);

    String addUser(User user);

    Object sendMail(Emil mail);

    BackCommonsEnum sendMailMath(Emil mail, HttpServletRequest request);
}
