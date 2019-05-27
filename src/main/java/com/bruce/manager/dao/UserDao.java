package com.bruce.manager.dao;

import com.bruce.manager.model.to.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bruce on 19/5/23 -- 19:10
 */
@Mapper
public interface UserDao {
    List<User> getAll();

    User getByUserName(@Param("user_name") String user_name);

}
