package com.yougou.wfx.appserver.vo.login;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.IUserContext;

/**
 * Created by lizhw on 2016/4/27.
 */
public class ModifyPasswordVo extends BaseVo implements Serializable, IUserContext {
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private UserInfo userInfo;

    private String password;

    private String newPassword;

    @JsonIgnore
    private String sid;

    @JsonIgnore
    private String ip;
    @JsonIgnore
    private String referer;
    @JsonIgnore
    private String userAgent;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String getSid() {
        return sid;
    }

    @Override
    public void setSid(String sid) {
        this.sid = sid;
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
}
