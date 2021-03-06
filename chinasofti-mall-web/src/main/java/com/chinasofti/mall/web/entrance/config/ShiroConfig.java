package com.chinasofti.mall.web.entrance.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chinasofti.mall.web.entrance.cache.RedisCacheManager;
//import com.chinasofti.mall.web.entrance.cache.RedisSessionDAO;
import com.chinasofti.mall.web.entrance.shiro.AuthRealm;
import com.chinasofti.mall.web.entrance.shiro.CredentialsMatcher;
/**
 * 
* @ClassName: ShiroConfiguration
* @Description: shiro的配置类
* @author xiaokunxiong
* @date 2017年11月6日 上午9:40:30 
*
 */
@Configuration
public class ShiroConfig {
	
	/*
	@Autowired
    private RedisSessionDAO sessionDAO;
	*/
	@Bean(name="redisCacheManager")
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager();
    }
	
	@Bean(name="sessionManager")
    public SessionManager sessionManager(@Qualifier("redisCacheManager") RedisCacheManager redisCacheManager) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(redisCacheManager);
        //sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setGlobalSessionTimeout(180000);
        //sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }
    //配置核心安全事务管理器
    @Bean(name = "securityManager")
    public SecurityManager securityManager(
            @Qualifier("authRealm") AuthRealm authRealm,
            @Qualifier("sessionManager") SessionManager sessionManager,
            @Qualifier("redisCacheManager") RedisCacheManager redisCacheManager) {
        System.err.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        manager.setSessionManager(sessionManager);
        manager.setCacheManager(redisCacheManager);
        return manager;
    }
    
    //配置自定义的权限登录器
    @Bean(name = "authRealm")
    public AuthRealm authRealm(
            @Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }
    
    //配置自定义的密码比较器
    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }
    

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(
            @Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/home");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/templates/login.ftl*", "anon"); //表示可以匿名访问,anon表示不需要拦截
        filterChainDefinitionMap.put("/loginUser", "anon");
        filterChainDefinitionMap.put("/logout*", "anon");
        filterChainDefinitionMap.put("/templates/error.ftl*", "anon");
        filterChainDefinitionMap.put("/templates/index.ftl*", "authc");
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        //        creator.setOrder(1);
        return creator;
    }
    
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        //        advisor.setOrder(0);
        return advisor;
    }
}
