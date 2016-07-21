package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.PageSearch;

/**
 * 
 * @author li.lq
 * @Date 2016年6月4日
 */
public class DiscoverSearcher  extends PageSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 频道ID
	 */
	private String channelId;

	
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
