package com.example.demo.dao;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import com.example.demo.util.PageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MailDao {
    List<User> queryUser(@Param("user") User user);

    List<Emil> queryMail(@Param("user") Emil user);

    void updateUser(@Param("user") User user);

    void add(@Param("user") User user);

    Long queryCount(@Param("user") User user);

    User queryUserById(@Param("user") User user);

    List<User> queryPageList(Map map);

    void addMail(@Param("user") Emil mail);
}
