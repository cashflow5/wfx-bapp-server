package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * 文章
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public class DiscoverArticle extends BaseVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 频道id，频道表id
	 */
	private String channelId;
	/**
	 * 文章封面
	 */
	private String picCover;
	/**
	 * 时间
	 */
	private String showTime;
	/**
	 * 标题前的中括号内容
	 */
	private String classify;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getPicCover() {
		return picCover;
	}

	public void setPicCover(String picCover) {
		this.picCover = picCover;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
}
