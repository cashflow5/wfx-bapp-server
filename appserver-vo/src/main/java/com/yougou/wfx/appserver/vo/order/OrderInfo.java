package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class OrderInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //订单的配送信息、下单时间、订单中的商品信息、支付信息、订单状态

    /**
     * 订单id
     */
    private String id;

    /**
     * 订单号
     */
    private String order_num;

    /**
     * 实际付款
     */
    private double paying;


    /**
     * 预计佣金
     */
    private double brokerage;


    /**
     * 分销商名称
     */
    private String store_name;
    /**
     * 订单状态：待付款,...
     */
    private String state_flag;
    /**
     * 运费
     */
    private double charges;

    /**
     * 商品总金额
     */
    private double money_total;

    /**
     * 支付方式
     */
    private String pay_mode;

    /**
     * 配送方式
     */
    private String post_info;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收件人电话
     */
    private String phone;

    /**
     * 收货地址
     */
    private String address;
    /** 店铺编码 */
	private String shopCode ;
	
	/** 店铺ID */
	private String shopId ;

	/**
	 * 佣金生成状态
	 */
	private Integer commissionStatus;

    public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private List<OrderProduct> products = new ArrayList<OrderProduct>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getPaying() {
        return format(paying);
    }

    public void setPaying(double paying) {
        this.paying = paying;
    }

    public String getBrokerage() {
        return format(brokerage);
    }

    public void setBrokerage(double brokerage) {
        this.brokerage = brokerage;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getState_flag() {
        return state_flag;
    }

    public void setState_flag(String state_flag) {
        this.state_flag = state_flag;
    }

    public String getCharges() {
        return format(charges);
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    public String getMoney_total() {
        return format(money_total);
    }

    public void setMoney_total(double money_total) {
        this.money_total = money_total;
    }

    public String getPay_mode() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode;
    }

    public String getPost_info() {
        return post_info;
    }

    public void setPost_info(String post_info) {
        this.post_info = post_info;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        return format(orderTime);
    }

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public Integer getCommissionStatus() {
		return commissionStatus;
	}

	public void setCommissionStatus(Integer commissionStatus) {
		this.commissionStatus = commissionStatus;
	}
	
}
