package com.yougou.wfx.appserver.vo.shop;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class ShopInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private UserInfo userInfo;
    /**
     * 公告
     */
    private String notice;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 电话
     */
    private String phone;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
