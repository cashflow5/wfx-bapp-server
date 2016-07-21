package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;
import java.util.Date;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/13.
 */
public class Incoming extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 收支明细ID、状态、时间、金额

	/**
	 * 收支明细ID
	 */
	private String id;
	/**
	 * 流水号
	 */
	private String billNo;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 时间
	 */
	private Date time;

	/**
	 * 交易标识
	 * 1：收入，2-支出
	 */
	private String transactionFlag;

	/**
	 * 支出金额
	 */
	private double expendAmount;

	/**
	 * 收入金额
	 */
	private double incomeAmount; 

	/**
	 * 收支类型 (1.佣金收益,2.提现)
	 */
	private String incomingType;

	/**
	 * 状态(1,交易成功2,处理中,3,交易关闭,4,交易失败)
	 */
	private String state;

	/**
	 * 支付方式
	 */
	private String payWay;

	private String payWayName;

	/**
	 * 分销商帐号（登录名）
	 */
	private String sellerAccount;

	/**
	 * 备注
	 */
	private String remark;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getTimeStr() {
		return format(time);
	}


	public String getIncomingType() {
		return incomingType;
	}

	public void setIncomingType(String incomingType) {
		this.incomingType = incomingType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}

	public String getSellerAccount() {
		return sellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTransactionFlag() {
		return transactionFlag;
	}

	public void setTransactionFlag(String transactionFlag) {
		this.transactionFlag = transactionFlag;
	}

	public double getExpendAmount() {
		return expendAmount;
	}

	public void setExpendAmount(double expendAmount) {
		this.expendAmount = expendAmount;
	}

	public double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
}
