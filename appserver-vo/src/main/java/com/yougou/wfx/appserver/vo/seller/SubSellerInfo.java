package com.yougou.wfx.appserver.vo.seller;

import java.io.Serializable;
import java.util.Date;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class SubSellerInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //下级分销商名称、注册时间、佣金？

    private String id;
    /**
     * 分销商名称
     */
    private String name;
    /**
     * 注册时间（或审核通过时间）
     */
    private Date regTime;
    /**
     * 佣金
     */
    private double commission;

    /**
     * 下级分销商数量
     */
    private int subSellerCount;
    
    /**
     * 图片LOGO
     */
    private String logoUrl;
    
	/**
	 * 为上级带来的佣金收入
	 */
	private Double commissionTotalAmountForParent;
	
	/** 店铺编码 */
	private String shopCode ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegTime() {
        return regTime;
    }

    public String getRegTimeStr() {
        return format(regTime);
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getCommission() {
        return format(commission);
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public int getSubSellerCount() {
        return subSellerCount;
    }

    public void setSubSellerCount(int subSellerCount) {
        this.subSellerCount = subSellerCount;
    }
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Double getCommissionTotalAmountForParent() {
		return commissionTotalAmountForParent;
	}

	public void setCommissionTotalAmountForParent(Double commissionTotalAmountForParent) {
		this.commissionTotalAmountForParent = commissionTotalAmountForParent;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
}
