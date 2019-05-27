package com.bruce.manager.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by bruce on 19/5/23 -- 21:41
 */

/**
 * 重写密码校验类
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String passWord = new String(usernamePasswordToken.getPassword());
        String dbPassWord = (String) info.getCredentials();
        return this.equals(passWord, dbPassWord);
    }
}
