package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.IUserContext;
import com.yougou.wfx.appserver.vo.PageSearch;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CommissionSearcher extends PageSearch implements Serializable, IUserContext {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private UserInfo userInfo;


    @JsonIgnore
    private String ip;
    @JsonIgnore
    private String referer;
    @JsonIgnore
    private String userAgent;
    @JsonIgnore
    private String sid;


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String getReferer() {
        return referer;
    }

    @Override
    public void setReferer(String referer) {
        this.referer = referer;
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getSid() {
        return sid;
    }

    @Override
    public void setSid(String sid) {
        this.sid = sid;
    }
}
