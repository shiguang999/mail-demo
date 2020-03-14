package com.example.demo.dao;

import com.example.demo.entrty.Emil;
import com.example.demo.entrty.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailDao {
    List<User> queryUser(@Param("user") User user);

    List<Emil> queryMail(@Param("user")Emil user);

    void updateUser(@Param("user")User user);

    void add(@Param("user")User user);
}
