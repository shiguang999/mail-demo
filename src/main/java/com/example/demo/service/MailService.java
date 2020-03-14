package com.example.demo.service;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;

import java.util.List;

public interface MailService {
    List<User> queryUser(User user);

    List<Emil> queryMail(Emil user);

    String updateUser(User user);

    String addUser(User user);
}
