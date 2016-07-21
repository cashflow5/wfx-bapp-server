package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.PageSearchResult;

/**
 * Created by lizhw on 2016/5/3.
 */
public class CashDetailList extends PageSearchResult<CashApplySearcher, CashDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

    private double amount;

    public String  getAmount() {
        return format(amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
