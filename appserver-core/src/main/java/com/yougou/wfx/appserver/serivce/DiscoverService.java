package com.yougou.wfx.appserver.serivce;

import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.discover.DiscoverArticle;
import com.yougou.wfx.appserver.vo.discover.DiscoverArticleDetail;
import com.yougou.wfx.appserver.vo.discover.DiscoverHome;
import com.yougou.wfx.appserver.vo.discover.DiscoverSearcher;

/**
 * 
 * @author li.lq
 * @Date 2016年6月3日
 */
public interface DiscoverService extends IBaseService {

	DiscoverHome getHomeData(DiscoverSearcher discoverSearcher);

	PageSearchResult<DiscoverSearcher, DiscoverArticle> getDiscoverArticleList(DiscoverSearcher discoverSearcher);

	DiscoverArticleDetail getDiscoverArticleById(String articleId);

}
