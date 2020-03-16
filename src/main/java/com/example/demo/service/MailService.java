package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.PageEntity;

import java.util.List;

public interface MailService {
    PageEntity<User> queryUser(User user, PageEntity<User> pageData);

    PageEntity<Emil> queryMail(Emil user,PageEntity<Emil> pageData);

    String updateUser(User user);

    String addUser(User user);

    Object sendMail(Emil mail);

    User queryUserById(User user);
}
