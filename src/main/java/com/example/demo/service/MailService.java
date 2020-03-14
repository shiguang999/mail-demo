package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.PageEntity;

import java.util.List;

public interface MailService {
    PageEntity<User> queryUser(User user, PageEntity<User> pageData);

    List<Emil> queryMail(Emil user);

    String updateUser(User user);

    String addUser(User user);

    Object sendMail(Emil mail);

    User queryUserById(User user);
}
