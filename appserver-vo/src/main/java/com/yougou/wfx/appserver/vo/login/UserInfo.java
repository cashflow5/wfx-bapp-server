package com.yougou.wfx.appserver.vo.login;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class UserInfo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private String id;
	/** 登录中 */
	private String loginName;
	/** 店铺ID */
	private String shopId;
	/** 分销商ID */
	private String sellerId;
	/** 会员身份，1:普通会员，2：分销商 */
	private Integer memberType;
	/** 店铺编码 */
	private String shopCode ;
	/** openId */
	private String openId;
	/** 微信昵称 */
	private String wxNickName;

	public UserInfo() {
	}

	public UserInfo(String id, String shopId, String sellerId, String loginName) {
		this.id = id;
		this.shopId = shopId;
		this.sellerId = sellerId;
		this.loginName = loginName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWxNickName() {
		return wxNickName;
	}

	public void setWxNickName(String wxNickName) {
		this.wxNickName = wxNickName;
	}
	
}
