package com.yougou.wfx.appserver.vo.login;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BooleanResult;

/**
 * Created by lizhw on 2016/4/20.
 */
public class ValidResult extends BooleanResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
