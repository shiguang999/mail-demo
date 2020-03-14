package com.example.demo.service.impl;

import com.example.demo.dao.MailDao;
import com.example.demo.entrty.User;
import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailDao dao;

    @Override
    public List<User> queryUser(User user) {
        return dao.queryUser(user);
    }
}
