package com.bruce.manager.config.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Created by bruce on 19/5/23 -- 21:39
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //
        factoryBean.setLoginUrl("/login");
        //
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("/user/login", "anon");
        linkedHashMap.put("/**/**", "authc");
        //
        factoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return factoryBean;
    }

    @Bean("customCredentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CustomCredentialsMatcher();
    }

    @Bean("authRealm")
    public CustomAuthRealm authRealm(@Qualifier("customCredentialsMatcher") CredentialsMatcher credentialsMatcher) {
        CustomAuthRealm customAuthRealm = new CustomAuthRealm();
        customAuthRealm.setCredentialsMatcher(credentialsMatcher);
        return customAuthRealm;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") CustomAuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }
}
