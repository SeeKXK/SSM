package com.seekxk.user.service.serviceImpl;

import com.seekxk.user.dao.UserDao;
import com.seekxk.user.model.User;
import com.seekxk.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User selectByUserName(String name) {
        return userDao.selectByUserName(name);
    }

    public List<Map<String, Object>> getList(Map<String, Object> m) {
        return userDao.getList(m);
    }
}
