package com.example.demo.service.impl;

import com.example.demo.dao.MailDao;
import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.send.SendsmsDemo;
import com.example.demo.service.MailService;
import com.example.demo.util.PageEntity;
import com.example.demo.util.BackCommonsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailDao dao;

    @Override
    public PageEntity<User> queryUser(User user, PageEntity<User> pageData) {
        Map map=new HashMap();
        map.put("page",pageData);
        map.put("user",user);
        Long count=dao.queryCount(user);
        pageData.setCount(count);
        List<User> stuList=dao.queryPageList(map);
        pageData.setData(stuList);
        return pageData;
    }

    @Override
    public PageEntity<Emil> queryMail(Emil email,PageEntity<Emil> pageData) {
        Map map=new HashMap();
        map.put("page",pageData);
        map.put("email",email);
        Long count=dao.queryEmailCount(email);
        pageData.setCount(count);
        List<Emil> stuList=dao.queryPageEmailList(map);
        pageData.setData(stuList);
        return pageData;
    }

    @Override
    public String updateUser(User user) {
//        List<User> users = dao.queryUser(user);
//        if (users == null) {
//            return "用户名不存在";
//        }
//        dao.updateUser(user);
        return "ok";
    }

    @Override
    public BackCommonsEnum addUser(User user) {
        User u = new User();
        u.setLoginname(user.getLoginname());
        User users =dao.queryUserById(u);
        if (users != null) {
            return  BackCommonsEnum.LOGIN_PHONECODE_ERROR;
        }
        User u2 = new User();
        u2.setPhone(user.getPhone());
        User users2 =dao.queryUserById(u2);
        if (users2 != null) {
            return BackCommonsEnum.LOGIN_MAILCODE_ERROR;
        }
        dao.add(user);
        return BackCommonsEnum.LOGIN_PWD_ERROR;
    }

    @Override
    public Object sendMail(Emil mail) {
        String s = SendsmsDemo.sendSms(mail.getMessage(), mail.getPhone());
        if(s != "" && s != null){
            mail.setStatus(1);
        }else {
            mail.setStatus(0);
        }
        mail.setTime(new Date());
        dao.addMail(mail);
        return null;
    }

    @Override
    public User queryUserById(User user) {
        return dao.queryUserById(user);
    }

    @Override
    public BackCommonsEnum deleteUser(User user) {
        dao.deleteUser(user);
        return BackCommonsEnum.SUCCESS;
    }

    @Override
    public BackCommonsEnum sendMailMath(Emil mail, HttpServletRequest request) {
        int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
        String content = "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。";
        String s = SendsmsDemo.sendSms(content,mail.getPhone());
        if(s != "" && s != null){
            mail.setStatus(1);
        }else {
            mail.setStatus(0);
        }
        mail.setMessage(content);
        mail.setTime(new Date());
        dao.addMail(mail);
        HttpSession session = request.getSession();
        session.setAttribute("content" + mail.getPhone(),mobile_code);
        session.setMaxInactiveInterval(300);
        return BackCommonsEnum.LOGIN_STATUS;
    }
}
