package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.IUserContext;
import com.yougou.wfx.appserver.vo.PageSearch;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class OrderSearcher extends PageSearch implements Serializable, IUserContext {

    private static final long serialVersionUID = 1L;

    /**
     * 订单状态 1:'全部订单',2:'待付款',3:'待发货',4:'部分发货',5:'已发货',6:'交易成功',7:'交易关闭'
     */
    private String status;
    //订单号 or 商品名称 or 手机号
    /**
     * sellerId,shopId
     */
    @JsonIgnore
    private UserInfo userInfo;

    /**
     * 分销商级别（0：全部 1：一级 2：二级 3：三级）
     */
    private int  level;

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 手机号
     */
    private String phone;

    @JsonIgnore
    private String ip;
    @JsonIgnore
    private String referer;
    @JsonIgnore
    private String userAgent;
    @JsonIgnore
    private String sid;


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

