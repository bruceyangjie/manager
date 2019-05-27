package com.bruce.manager.service;

import com.bruce.manager.model.to.User;

/**
 * Created by bruce on 19/5/23 -- 20:57
 */
public interface UserService {
    User getByUserName(String userName);
}
