package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.PageSearchResult;

/**
 * Created by lizhw on 2016/5/3.
 */
public class CashApplyListResult extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    CashApplySearcher searcher;
    //1:提现中，2:已提现，3:提现失败
    CashDetailList cashing = new CashDetailList();
    CashDetailList cashed = new CashDetailList();
    CashDetailList cashErr = new CashDetailList();


    public CashApplySearcher getSearcher() {
        return searcher;
    }

    public void setSearcher(CashApplySearcher searcher) {
        this.searcher = searcher;
    }

    public PageSearchResult<CashApplySearcher, CashDetail> getCashing() {
        return cashing;
    }

    public void setCashing(CashDetailList cashing) {
        this.cashing = cashing;
    }

    public CashDetailList getCashed() {
        return cashed;
    }

    public void setCashed(CashDetailList cashed) {
        this.cashed = cashed;
    }

    public CashDetailList getCashErr() {
        return cashErr;
    }

    public void setCashErr(CashDetailList cashErr) {
        this.cashErr = cashErr;
    }
}
