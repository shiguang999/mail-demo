package com.example.demo.dao;

import com.example.demo.entrty.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailDao {
    List<User> queryUser(User user);
}
