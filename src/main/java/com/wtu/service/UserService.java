package com.wtu.service;

import com.wtu.model.User;
import org.springframework.stereotype.Service;

/**
 *  业务层 接口
 *
 * menglanyingfei
 * on 2017.11.02 14:46
 */
@Service
public interface UserService {
    User getUserById(int userId);
}
