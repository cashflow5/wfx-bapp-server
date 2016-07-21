package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.order.OrderDetailInfo;
import com.yougou.wfx.appserver.vo.order.OrderIdentity;
import com.yougou.wfx.appserver.vo.order.OrderInfo;
import com.yougou.wfx.appserver.vo.order.OrderSearcher;

/**
 * 订单管理
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("orderManage")
@EnableAutoConfiguration
public class OrderManageController extends BaseController {
    /**
     * 获取订单信息
     * 订单状态、当前页、订单条数、店铺ID
     *
     * @return
     */
    @RequestMapping("list")
    @NeedLoginAction
    public Object getOrderInfo(OrderSearcher searcher) {
        searcher.setUserInfo(getUserInfo());
        setUserContext(searcher);
        //订单基本信息（分销商名称、付款状态、订单金额、佣金、订单ID）
        PageSearchResult<OrderSearcher, OrderInfo> result = orderService.getOrderInfoList(searcher);

        return result;
    }


    /**
     * 订单详情
     *
     * @return
     */
    @RequestMapping("detail")
    @NeedLoginAction
    public Object getDetail(OrderIdentity identity) {
        identity.setUserInfo(getUserInfo());
        OrderDetailInfo od = orderService.getOrderDetail(identity);
        return od;
    }
}
