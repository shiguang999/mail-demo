package com.example.demo.service;

import com.example.demo.entrty.User;

import java.util.List;

public interface MailService {
    List<User> queryUser(User user);
}
