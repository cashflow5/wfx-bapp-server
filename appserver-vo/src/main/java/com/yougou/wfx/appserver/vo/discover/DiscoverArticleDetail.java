package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * 文章详情
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public class DiscoverArticleDetail extends BaseVo implements Serializable {
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
	 * 作者类型（1、优购，2、分销商）
	 */
	private Integer authorType;
	/**
	 * 作者登录账号
	 */
	private String authorAccount;
	/**
	 * 频道id，频道表id
	 */
	private String channelId;

	/**
	 * 文章内容
	 */
	private String content;
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

	public Integer getAuthorType() {
		return authorType;
	}

	public void setAuthorType(Integer authorType) {
		this.authorType = authorType;
	}

	public String getAuthorAccount() {
		return authorAccount;
	}

	public void setAuthorAccount(String authorAccount) {
		this.authorAccount = authorAccount;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
}
