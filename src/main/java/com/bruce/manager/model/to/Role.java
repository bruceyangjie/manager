package com.bruce.manager.model.to;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce on 19/5/23 -- 20:50
 */
@Data
public class Role {
    private Integer id;
    private String name;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>();

}
