package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/13.
 */
public class OrderIdentity extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;
    @JsonIgnore
    private UserInfo userInfo;
	/**
     * 订单级别 对应分销商级别（2：二级 3：三级    其他：一级 ）
     */
    private int  level = 0;
    
    public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
