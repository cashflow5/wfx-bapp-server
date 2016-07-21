package com.yougou.wfx.appserver.vo.seller;

import java.io.Serializable;
import java.util.Date;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class SubSellerDetail extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //分销商详情信息（店铺名称、分销商账号、真实姓名、性别、生日、注册时间、所属地区、详细地址）
    private String id;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 分销商账号
     */
    private String account;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthDayDate;


    /**
     * 注册时间
     */
    private Date regTimeDate;


    /**
     * 下级分销商数量
     */
    private int subSellerCount;
    
    /** 店铺编码 */
	private String shopCode ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return formatDate(birthDayDate);
    }

    public Date getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(Date birthDayDate) {
        this.birthDayDate = birthDayDate;
    }

    public Date getRegTimeDate() {
        return regTimeDate;
    }

    public void setRegTimeDate(Date regTimeDate) {
        this.regTimeDate = regTimeDate;
    }

    public String getRegTime() {
        return format(this.regTimeDate);
    }

    public int getSubSellerCount() {
        return subSellerCount;
    }

    public void setSubSellerCount(int subSellerCount) {
        this.subSellerCount = subSellerCount;
    }

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
}
