package com.yougou.wfx.appserver.vo.home;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class ShopInfo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 店铺名称、店铺LOGO、招聘信息,今日收益,总收益（累计收益）,今日访客 ,7日订单,可体现金额（单位：分）

	private String id;
	/** 店铺名称 */
	private String name;
	/** 店铺LOGO */
	private String logo;
	/** 招聘信息 */
	private String recruitPic;
	/** 今日收益 */
	private double todayProfit;
	/** 总收益（累计收益）（佣金收益） */
	private double totalProfit;
	/** 今日访客 */
	private int todayVisitorCount;
	/** 7日订单 */
	private int sevenDayOrderCount;
	/** 可体现金额（单位：分） */
	private double canCash;
	/** 店铺编码 */
	private String shopCode ;
	/** 粉丝数目 */
	private int fansCount;
	/** 手机 */
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getFansCount() {
		return fansCount;
	}

	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTodayProfit() {
		return format(todayProfit);
	}

	public void setTodayProfit(double todayProfit) {
		this.todayProfit = todayProfit;
	}

	public String getRecruitPic() {
		return recruitPic;
	}

	public void setRecruitPic(String recruitPic) {
		this.recruitPic = recruitPic;
	}

	public void setTodayProfit(long todayProfit) {
		this.todayProfit = todayProfit;
	}

	public String getTotalProfit() {
		return format(totalProfit);
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public int getTodayVisitorCount() {
		return todayVisitorCount;
	}

	public void setTodayVisitorCount(int todayVisitorCount) {
		this.todayVisitorCount = todayVisitorCount;
	}

	public int getSevenDayOrderCount() {
		return sevenDayOrderCount;
	}

	public void setSevenDayOrderCount(int sevenDayOrderCount) {
		this.sevenDayOrderCount = sevenDayOrderCount;
	}

	public String getCanCash() {
		return format(canCash);
	}

	public void setCanCash(double canCash) {
		this.canCash = canCash;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

}
