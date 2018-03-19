package com.seekxk.user.dao;

import com.seekxk.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    List<Map<String, Object>> getList(Map<String, Object> m);
    User selectByUserName(String username);
}
