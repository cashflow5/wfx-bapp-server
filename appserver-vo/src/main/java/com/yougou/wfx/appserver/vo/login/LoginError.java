package com.yougou.wfx.appserver.vo.login;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/18.
 */
public class LoginError extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 错误码 */
	private String errorCode;
	/** 错误描述 */
	private String error;

	public LoginError() {
	}

	public LoginError(String error) {
		this.error = error;
	}

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
}
