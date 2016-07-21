package com.yougou.wfx.appservertest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Created by lizhw on 2016/4/11.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WfxAppServiceApplicationTest.class})
//@WebAppConfiguration("src/main/resources")
public class HomeControllerTest extends BaseControllerTest {


    //@Test
    public void testNormalController() throws Exception {
        MockHttpServletRequestBuilder builder = get("/home");
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(view().name("page"))
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                .andExpect(model().attribute("msg", "hello"));

    }

    //@Test
    public void testGetOk() throws Exception {

        mockMvc.perform(get("/home/getOk"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("ok"));
    }


}
