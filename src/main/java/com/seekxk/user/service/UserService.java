package com.seekxk.user.service;

import com.seekxk.user.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User selectByUserName(String name);
    List<Map<String,Object>> getList(Map<String, Object> m);

}
