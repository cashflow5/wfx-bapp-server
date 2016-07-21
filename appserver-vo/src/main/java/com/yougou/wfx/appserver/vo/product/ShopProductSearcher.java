package com.yougou.wfx.appserver.vo.product;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.PageSearch;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class ShopProductSearcher  extends PageSearch implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 店铺ID
     */
    @JsonIgnore
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
