package com.yougou.wfx.appserver.vo;

import java.io.Serializable;

/**
 * Created by lizhw on 2016/5/12.
 */
public class ServerError extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String error = "";
    private String errorCode = "";
    private String errorMsg = "";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
