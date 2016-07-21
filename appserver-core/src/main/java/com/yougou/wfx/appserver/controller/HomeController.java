package com.yougou.wfx.appserver.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.home.ShopInfo;

/**
 * 首页
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("home")
@EnableAutoConfiguration
public class HomeController extends BaseController {
    /**
     * 获取店铺信息
     *
     * @return
     */
    @RequestMapping("getShop")
    @NeedLoginAction
    public Object getShopInfo() {
        //店铺名称、店铺LOGO、招聘信息,今日收益,总收益（累计收益）,今日访客 ,7日订单,可体现金额（单位：分）
        ShopInfo shop = shopService.getShop(getUserInfo(), false);
        return shop;
    }

    @RequestMapping("getOk")
    public Object getOk(HttpServletResponse response) {
        response.setContentType("text/plain;charset=UTF-8");
        return "ok";
    }

    @RequestMapping("testError")
    public Object testError(HttpServletResponse response) throws Exception {
        response.setContentType("text/plain;charset=UTF-8");
        throw new Exception("testError");
    }
}
