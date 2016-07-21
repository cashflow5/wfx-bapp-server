package com.yougou.wfx.appservertest.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Created by lizhw on 2016/4/18.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WfxAppServiceApplicationTest.class})
//@WebAppConfiguration("src/main/resources")
public class ShopManageControllerTest extends BaseControllerTest {
    //@Test
    public void testGetShopDetailInfo() throws Exception {
		/*String json = "{\"id\":\"shopid12341234\",\"storeNum\":\"xxxx88888\",\"storeHeaderImg\":\"http://pic2.ooopic" +
                ".com/01/37/79/28b1OOOPIC30.jpg\",\"storeUrl\":\"http://www.yougou.com\",\"distributors\":\"分销商名称\",\"storeName\":\"店铺名称\",\"storeZhao\":\"http://s14.sinaimg.cn/middle/647ef7cbta6ec5097497d&690\",\"storeNotice\":\"我是公告\",\"contacts\":\"li.zw\",\"phone\":\"13812345678\",\"clazz\":\"shop.ShopInfoDetail\"}";
       */ MockHttpServletRequestBuilder builder = get("/shopManage/getShopDetailInfo");
        builder.session(session);

        mockMvc.perform(builder)
                .andExpect(status().isOk());
    }

}
