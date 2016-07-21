package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * 轮播图
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public class DiscoverCarouselFigure extends BaseVo implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 轮播图名称
	 */
	private String name;
	/**
	 * 轮播图图片
	 */
	private String picture;

	/**
	 * 文章
	 */
	private DiscoverArticle discoverArticle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public DiscoverArticle getDiscoverArticle() {
		return discoverArticle;
	}

	public void setDiscoverArticle(DiscoverArticle discoverArticle) {
		this.discoverArticle = discoverArticle;
	}

	
}
