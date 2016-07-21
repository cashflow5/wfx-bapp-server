package com.yougou.wfx.appserver.vo.product;

import java.io.Serializable;

public class OnAndOffProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 返回结果状态
	 */
	private boolean result;
	/**
	 * 错误信息描述
	 */
	private String error;
	/**
	 * 上下架类型 1:上架 2：下架
	 */
	private String type;

	/**
	 * 成功商品ID，多个以“,”分隔
	 */
	private String successIds;

	/**
	 * 失败商品ID，多个以“,”分隔
	 */
	private String failIds;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuccessIds() {
		return successIds;
	}

	public void setSuccessIds(String successIds) {
		this.successIds = successIds;
	}

	public String getFailIds() {
		return failIds;
	}

	public void setFailIds(String failIds) {
		this.failIds = failIds;
	}
}
