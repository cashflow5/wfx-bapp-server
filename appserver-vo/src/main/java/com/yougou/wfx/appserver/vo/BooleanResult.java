package com.yougou.wfx.appserver.vo;

import java.io.Serializable;

/**
 * Created by lizhw on 2016/4/12.
 */
public class BooleanResult extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean result;
    private String msg;
    private String error;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
