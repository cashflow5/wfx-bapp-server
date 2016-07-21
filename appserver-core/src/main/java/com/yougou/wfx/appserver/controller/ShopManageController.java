package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.BooleanResult;
import com.yougou.wfx.appserver.vo.shop.ShopInfo;
import com.yougou.wfx.appserver.vo.shop.ShopInfoDetail;

/**
 * 店铺管理
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("shopManage")
@EnableAutoConfiguration
public class ShopManageController extends BaseController {
    /**
     * 获取店铺详情信息
     *
     * @return
     */
    @RequestMapping("getShopDetailInfo")
    @NeedLoginAction
    public Object getShopDetailInfo() {

        //店铺名称、店铺LOGO、店招信息、店铺公告、联系人、联系人电话、店铺的URL、店铺的二维码信息
        ShopInfoDetail result = shopService.getShopDetailInfo(getUserInfo());
        return result;
    }

    /**
     * 设置店铺公告	店铺ID、公告信息	true or false
     *
     * @return
     */
    @RequestMapping(value = "setShopInfo", method = RequestMethod.POST)
    @NeedLoginAction
    public Object setShopInfo(@RequestBody ShopInfo shopInfo) {

        shopInfo.setUserInfo(getUserInfo());
        //true or false
        BooleanResult result = shopService.setShopInfo(shopInfo);
        return result;
    }
}
