package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * 频道
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public class DiscoverChannel extends BaseVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 频道ID
	 */
	private String id;
	/**
	 * 频道编码
	 */
	private String channelCode;
	/**
	 * 频道名字
	 */
	private String channelName;

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
