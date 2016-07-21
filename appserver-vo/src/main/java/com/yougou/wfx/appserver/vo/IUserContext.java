package com.yougou.wfx.appserver.vo;


/**
 * Created by lizhw on 2016/4/22.
 */
public interface IUserContext {

    public String getSid();

    public void setSid(String sid);

    public String getIp();

    public void setIp(String ip);

    public String getReferer();

    public void setReferer(String referer);

    public String getUserAgent();

    public void setUserAgent(String userAgent);
}
