package com.yougou.wfx.appserver.vo.shop;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class ShopInfoDetail extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //店铺名称、店铺LOGO、店招信息、店铺公告、联系人、联系人电话、店铺的URL、店铺的二维码信息

    private String id;

    /**
     * 店铺编号
     */
    private String storeNum;

    /**
     * 店铺头像
     */
    private String storeHeaderImg;

    /**
     * 店铺地址
     */
    private String storeUrl;

    private String distributors;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 店招
     */
    private String storeZhao;

    /**
     * 店铺公告
     */
    private String storeNotice;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话
     */
    private String phone;
    /** 店铺编码 */
	private String shopCode ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreHeaderImg() {
        return storeHeaderImg;
    }

    public void setStoreHeaderImg(String storeHeaderImg) {
        this.storeHeaderImg = storeHeaderImg;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public String getDistributors() {
        return distributors;
    }

    public void setDistributors(String distributors) {
        this.distributors = distributors;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreZhao() {
        return storeZhao;
    }

    public void setStoreZhao(String storeZhao) {
        this.storeZhao = storeZhao;
    }

    public String getStoreNotice() {
        return storeNotice;
    }

    public void setStoreNotice(String storeNotice) {
        this.storeNotice = storeNotice;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
}
