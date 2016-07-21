package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/13.
 */
public class IncomingIdentity  extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String incomingId;
    @JsonIgnore
    private UserInfo userInfo;

    public String getIncomingId() {
        return incomingId;
    }

    public void setIncomingId(String incomingId) {
        this.incomingId = incomingId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
