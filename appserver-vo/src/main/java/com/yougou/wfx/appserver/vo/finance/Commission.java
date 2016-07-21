package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;
import java.util.Date;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class Commission  extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //订单号、时间、金额

    private String id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 时间
     */
    private Date time;
    /**
     * 佣金金额
     */
    private double amount;
    
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimeStr() {
        return format(time);
    }



    public String  getAmount() {
        return format(amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
    
}
