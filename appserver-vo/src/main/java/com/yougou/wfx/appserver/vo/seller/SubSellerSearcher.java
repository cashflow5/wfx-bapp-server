package com.yougou.wfx.appserver.vo.seller;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.PageSearch;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class SubSellerSearcher extends PageSearch implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        return userInfo;
    }


    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
