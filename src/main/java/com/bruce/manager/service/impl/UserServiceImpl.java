package com.bruce.manager.service.impl;

import com.bruce.manager.dao.UserDao;
import com.bruce.manager.model.to.User;
import com.bruce.manager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by bruce on 19/5/23 -- 20:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}
