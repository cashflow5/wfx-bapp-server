package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

/**
 * Created by lizhw on 2016/4/13.
 */
public class IncomingDetail extends Incoming implements Serializable {

    private static final long serialVersionUID = 1L;
    //base:收支明细ID、状态、时间、金额
    //收支明细详情（类型、状态、时间、支付方式、交易单号、分销商账号、订单号、状态【收入 or 支出】）
    /**
     * 类型
     */
    private String type;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 交易单号
     */
    private String billNo;
    /**
     * 分销商账号
     */
    private String sellerId;
    private String sellerName;
    /**
     * 订单号
     */
    private String orderNo;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


}
