package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.seller.SubSellerDetail;
import com.yougou.wfx.appserver.vo.seller.SubSellerInfo;
import com.yougou.wfx.appserver.vo.seller.SubSellerSearcher;

/**
 * 我的分销商
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("mySeller")
@EnableAutoConfiguration
public class MySellerController extends BaseController {

    /**
     * 获取特定分销商ID下的分销商列表
     *
     * @return
     */
    @RequestMapping("getSubList")
    @NeedLoginAction
    public Object getSubList(SubSellerSearcher searcher) {

        searcher.setUserInfo(getUserInfo());
        //下级分销商名称、注册时间、佣金？
        //这个佣金是指他赚的佣金还是他作为下级分销商贡献给当前分销商的佣金
        PageSearchResult<SubSellerSearcher, SubSellerInfo> subSellerList = sellerService.getSubSellerList(searcher);

        return subSellerList;
    }

    /**
     * 获取下级分销商详情
     *
     * @param subSellerId
     * @return
     */
    @RequestMapping("getSubDetail")
    @NeedLoginAction
    public Object getSubSellerDetail(String subSellerId) {

        //分销商详情信息（店铺名称、分销商账号、真实姓名、性别、生日、注册时间、所属地区、详细地址）
        SubSellerDetail subSellerDetail = sellerService.getSubSellerDetail(getUserInfo(),subSellerId);
        return subSellerDetail;
    }
}
