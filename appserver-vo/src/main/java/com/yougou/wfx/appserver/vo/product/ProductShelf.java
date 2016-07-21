package com.yougou.wfx.appserver.vo.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class ProductShelf extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private UserInfo userInfo;

	/**
	 * 上架商品ID，多个以“,”分隔
	 */
	private String onIds;
	/**
	 * 下架商品ID，多个以“,”分隔
	 */
	private String offIds;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getOnIds() {
		return onIds;
	}

	public void setOnIds(String onIds) {
		this.onIds = onIds;
	}

	public String getOffIds() {
		return offIds;
	}

	public void setOffIds(String offIds) {
		this.offIds = offIds;
	}
}
