package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.discover.DiscoverArticle;
import com.yougou.wfx.appserver.vo.discover.DiscoverHome;
import com.yougou.wfx.appserver.vo.discover.DiscoverSearcher;

/**
 * 发现模块
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
@RestController
@RequestMapping("discover")
@EnableAutoConfiguration
public class DiscoverController extends BaseController {

	/**
	 * 发现首页
	 * 
	 * @return
	 */
	@RequestMapping("home")
	public Object home(DiscoverSearcher discoverSearcher) {
		// 轮播图
		DiscoverHome result = discoverService.getHomeData(discoverSearcher);
		return result;
	}

	/**
	 * 发现列表
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public Object list(DiscoverSearcher discoverSearcher) {
		PageSearchResult<DiscoverSearcher, DiscoverArticle> result = discoverService.getDiscoverArticleList(discoverSearcher);
		return result;
	}

}
