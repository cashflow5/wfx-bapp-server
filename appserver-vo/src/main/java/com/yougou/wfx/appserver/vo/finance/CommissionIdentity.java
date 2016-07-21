package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CommissionIdentity extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private UserInfo userInfo;
    private String id;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
