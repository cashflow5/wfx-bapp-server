package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/27.
 */
public class Style extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public String styleIds;
    @JsonIgnore
    private UserInfo userInfo;

    public String getStyleIds() {
        return styleIds;
    }

    public void setStyleIds(String styleIds) {
        this.styleIds = styleIds;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
