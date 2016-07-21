package com.yougou.wfx.appserver.vo;

import java.io.Serializable;

/**
 * Created by lizhw on 2016/4/13.
 */
public class NeedLogin extends BaseVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean needLogin = false;

    public boolean isNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }
}
