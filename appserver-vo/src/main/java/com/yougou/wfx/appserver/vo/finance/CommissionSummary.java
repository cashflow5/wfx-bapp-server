package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CommissionSummary extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //未结算和已结算的信息


    /**
     * 未结算
     */
    private double notSettled;
    /**
     * 已结算
     */
    private double hasSettled;



    public double getNotSettled() {
        return notSettled;
    }

    public void setNotSettled(double notSettled) {
        this.notSettled = notSettled;
    }

    public String   getHasSettled() {
        return format(hasSettled);
    }

    public void setHasSettled(double hasSettled) {
        this.hasSettled = hasSettled;
    }
}
