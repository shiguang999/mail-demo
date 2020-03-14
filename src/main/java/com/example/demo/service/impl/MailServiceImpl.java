package com.example.demo.service.impl;

import com.example.demo.dao.MailDao;
import com.example.demo.entrty.Emil;
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

    @Override
    public List<Emil> queryMail(Emil user) {
        return dao.queryMail(user);
    }

    @Override
    public String updateUser(User user) {
        List<User> users = dao.queryUser(user);
        if (users == null) {
            return "用户名不存在";
        }
        dao.updateUser(user);
        return "ok";
    }

    @Override
    public String addUser(User user) {
        User u = new User();
        u.setLoginname(user.getLoginname());
        List<User> users = dao.queryUser(u);
        if (users.size() != 0) {
            return "用户名已存在";
        }
        User u2 = new User();
        u2.setPhone(user.getPhone());
        List<User> users2 = dao.queryUser(u2);
        if (users2.size() != 0) {
            return "手机号已注册";
        }
        dao.add(user);
        return "ok";
    }

    @Override
    public Object sendMail(Emil mail) {

        return null;
    }
}
