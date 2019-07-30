package com.bruce.manager.model.to;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce on 19/5/23 -- 19:10
 */
@Data
public class User {
    private int id;
    private String user_name;
    private String pass_word;
    private String salt;
    private Set<Role> roles = new HashSet<>();

}
