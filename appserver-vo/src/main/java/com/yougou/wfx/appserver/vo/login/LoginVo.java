package com.yougou.wfx.appserver.vo.login;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.IUserContext;

/**
 * Created by lizhw on 2016/4/8.
 */
public class LoginVo extends BaseVo implements Serializable, IUserContext {

    private static final long serialVersionUID = 1L;
    private String loginName;
    private String password;
    private String opendId;
    private String loginType;//1：用户名密码登录 2：WX登录
    @JsonIgnore
    private String ip;
    @JsonIgnore
    private String referer;
    @JsonIgnore
    private String userAgent;
    @JsonIgnore
    private String sid;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

	public String getOpendId() {
		return opendId;
	}

	public void setOpendId(String opendId) {
		this.opendId = opendId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
