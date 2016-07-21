package com.yougou.wfx.appservertest.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Created by lizhw on 2016/4/21.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WfxAppServiceApplicationTest.class})
//@WebAppConfiguration("src/main/resources")
public class UserCenterControllerTest extends BaseControllerTest {
    //@Test
    public void testLogin() throws Exception {
        String loginUrl = "/userCenter/login";
        String loginVoJson = "{\"loginName\":\"13714407270\",\"password\":\"haocheng\"}";
        String contentTypeJson = "application/json;charset=UTF-8";
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

}


