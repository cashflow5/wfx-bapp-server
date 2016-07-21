package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yougou.wfx.appserver.vo.order.OrderProduct;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CommissionDetail extends Commission implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 店铺名称
	 */
	private String shopName;

	/**
	 * 店铺级别
	 */
	private String shopLevel;
	/** 店铺编码 */
	private String shopCode ;

	private List<OrderProduct> products = new ArrayList<OrderProduct>();

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLevel() {
		return shopLevel;
	}

	public void setShopLevel(String shopLevel) {
		this.shopLevel = shopLevel;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

}
