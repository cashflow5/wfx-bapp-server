package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/13.
 */
public class CashSetting  extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //可提现金额
    /**
     * 可提现金额
     */
    private double lowerstAmount;
    
    private double highestAmount;
    
    private double monthTotalAmount;

	public double getLowerstAmount() {
		return lowerstAmount;
	}

	public void setLowerstAmount(double lowerstAmount) {
		this.lowerstAmount = lowerstAmount;
	}

	public double getHighestAmount() {
		return highestAmount;
	}

	public void setHighestAmount(double highestAmount) {
		this.highestAmount = highestAmount;
	}

	public double getMonthTotalAmount() {
		return monthTotalAmount;
	}

	public void setMonthTotalAmount(double monthTotalAmount) {
		this.monthTotalAmount = monthTotalAmount;
	}
    
}
