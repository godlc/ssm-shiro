package com.wtu.service.impl;


import com.wtu.dao.UserMapper;
import com.wtu.model.User;
import com.wtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 实现UserService
 *
 * @Author menglanyingfei
 * @Created on 2017.11.02 14:49
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
