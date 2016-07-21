package com.yougou.wfx.appserver.vo.version;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * AppVersion
 * 
 * @author wfx
 * @Date 创建时间：2016-05-19 09:43:27
 */
public class AppVersion implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 版本名称
	 */
	private String versionName;
	/**
	 * 版本编号
	 */
	private String versionCode;
	/**
	 * 版本APK存放地址
	 */
	private String versionUrl;
	/**
	 * 版本描述
	 */
	private String versionContent;
	/**
	 * 是否强制更新，1:是 2否
	 */
	private Integer forceUpdate;

	public AppVersion() {
	}

	public void setVersionName(String value) {
		this.versionName = value;
	}

	public String getVersionName() {
		return this.versionName == null ? null : this.versionName.trim();
	}

	public void setVersionCode(String value) {
		this.versionCode = value;
	}

	public String getVersionCode() {
		return this.versionCode == null ? null : this.versionCode.trim();
	}

	public void setVersionUrl(String value) {
		this.versionUrl = value;
	}

	public String getVersionUrl() {
		return this.versionUrl == null ? null : this.versionUrl.trim();
	}

	public void setVersionContent(String value) {
		this.versionContent = value;
	}

	public String getVersionContent() {
		return this.versionContent == null ? null : this.versionContent.trim();
	}

	public void setForceUpdate(Integer value) {
		value = value == null ? 0 : value;
		this.forceUpdate = value;
	}

	public Integer getForceUpdate() {
		return this.forceUpdate == null ? 0 : this.forceUpdate;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
