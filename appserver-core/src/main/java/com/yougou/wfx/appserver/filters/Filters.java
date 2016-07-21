package com.yougou.wfx.appserver.filters;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.yougou.wfx.appserver.session.RedisSessionFilter;

/**
 * Created by fenglvming on 16/3/22.
 */
@Configuration
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@ConditionalOnWebApplication
public class Filters {
    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("redisSessionFilter");
        RedisSessionFilter redisSessionFilter = new RedisSessionFilter();
        registration.setFilter(redisSessionFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registration.setUrlPatterns(urlPatterns);
        return registration;
    }
}
