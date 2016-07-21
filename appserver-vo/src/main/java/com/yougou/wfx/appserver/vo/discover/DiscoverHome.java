package com.yougou.wfx.appserver.vo.discover;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.PageSearchResult;

/**
 * 发现首页
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public class DiscoverHome extends BaseVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 频道列表
	 */
	private List<DiscoverChannel> discoverChannelList = new ArrayList<DiscoverChannel>();
	/**
	 * 文章列表
	 */
	private PageSearchResult<DiscoverSearcher, DiscoverArticle> pageDiscoverArticleResult;
	/**
	 * 轮播图
	 */
	private List<DiscoverCarouselFigure> discoverCarouselFigureList = new ArrayList<DiscoverCarouselFigure>();

	public List<DiscoverChannel> getDiscoverChannelList() {
		return discoverChannelList;
	}

	public void setDiscoverChannelList(List<DiscoverChannel> discoverChannelList) {
		this.discoverChannelList = discoverChannelList;
	}

	public PageSearchResult<DiscoverSearcher, DiscoverArticle> getPageDiscoverArticleResult() {
		return pageDiscoverArticleResult;
	}

	public void setPageDiscoverArticleResult(PageSearchResult<DiscoverSearcher, DiscoverArticle> pageDiscoverArticleResult) {
		this.pageDiscoverArticleResult = pageDiscoverArticleResult;
	}

	public List<DiscoverCarouselFigure> getDiscoverCarouselFigureList() {
		return discoverCarouselFigureList;
	}

	public void setDiscoverCarouselFigureList(List<DiscoverCarouselFigure> discoverCarouselFigureList) {
		this.discoverCarouselFigureList = discoverCarouselFigureList;
	}
}
