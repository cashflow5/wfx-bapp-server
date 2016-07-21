package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class OrderStat extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //分销商ID	进行中、已付款、退款以及已发货的数量

    private String sellerId;

    /**
     * 进行中的数量
     */
    private int onGoing;
    /**
     * 已付款的数量
     */
    private int hasPay;
    /**
     * 退款的数量
     */
    private int refund;
    /**
     * 已发货的数量
     */
    private int hasDelivery;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public int getOnGoing() {
        return onGoing;
    }

    public void setOnGoing(int onGoing) {
        this.onGoing = onGoing;
    }

    public int getHasPay() {
        return hasPay;
    }

    public void setHasPay(int hasPay) {
        this.hasPay = hasPay;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    public int getHasDelivery() {
        return hasDelivery;
    }

    public void setHasDelivery(int hasDelivery) {
        this.hasDelivery = hasDelivery;
    }
}
