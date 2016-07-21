package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class ProfitSummary extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// （可用余额、提现中金额、已提现金额、账户总金额）

	/**
	 * 佣金收益
	 */

	private double commission;

	/**
	 * 可用余额（可提现金额）
	 */
	private double balance;

	/**
	 * 提现中金额
	 */

	private double onCash;

	/**
	 * 已提现金额
	 */
	private double hasCash;

	public String getBalance() {
		return format(balance);
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getOnCash() {
		return format(onCash);
	}

	public void setOnCash(double canCash) {
		this.onCash = canCash;
	}

	public String getHasCash() {
		return format(hasCash);
	}

	public void setHasCash(double hasCash) {
		this.hasCash = hasCash;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
}
