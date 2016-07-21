package com.yougou.wfx.appservertest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class BaseControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected MockHttpSession session;

    @Autowired
    protected MockHttpServletRequest request;


    protected String sid = "yg_sid_12345678900000-00000-00000000-00000";

    protected Cookie getCookie() {
        Cookie cookie = new Cookie("yg_sid", sid);
        cookie.setPath("/");
        return cookie;
    }


    private static String contentTypeJson = "application/json;charset=UTF-8";

    private static String loginUrl = "/userCenter/login";
    private String loginVoJson = "{\"loginName\":\"13714407270\",\"password\":\"haocheng\"}";

    protected UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("123");
        userInfo.setSellerId("123");
        userInfo.setShopId("123");
        return userInfo;
    }

    protected String getUserInfoJson() {
        UserInfo userInfo = getUserInfo();
        String json = JSON.toJSONString(userInfo);
        return json;
    }

    protected void login() throws Exception {
        //session.setAttribute("_u", getUserInfoJson());
        MockHttpServletRequestBuilder builder = post(loginUrl);
        builder.session(session);
        builder.cookie(getCookie());
        builder.contentType(contentTypeJson);
        builder.content(loginVoJson.getBytes());
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
        ;
    }


    //@Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        login();

    }

}
