package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.yougou.wfx.appserver.vo.discover.DiscoverArticleDetail;
import com.yougou.wfx.appserver.vo.shop.ShopInfoDetail;

/**
 * Created by lizhw on 2016/5/10.
 */
@Controller
@RequestMapping("h5")
@EnableAutoConfiguration
public class H5Controller extends BaseController {
	/**
	 * 关于
	 * 
	 * @return
	 */
	@RequestMapping("about")
	public String about() {
		return "about";
	}

	/**
	 * 隐私
	 * 
	 * @return
	 */
	@RequestMapping("secret")
	public String secret() {
		return "secret";
	}

	/**
	 * 协议
	 * 
	 * @return
	 */
	@RequestMapping("platform-protocol")
	public String platformProtocol() {
		return "platform-protocol";
	}

	/**
	 * 帮助
	 * 
	 * @return
	 */
	@RequestMapping("help")
	public String help() {
		return "help";
	}

	/**
	 * 发现文章详情
	 * 
	 * @return
	 */
	@RequestMapping("discoverArticleView")
	public String discoverArticleView(ModelMap modelMap, String articleId) {
		DiscoverArticleDetail discoverArticle = discoverService.getDiscoverArticleById(articleId);
		modelMap.put("discoverArticle", discoverArticle);
		if (discoverArticle.getAuthorType().intValue() == 2) {// 分销商
			ShopInfoDetail shopInfoDetail = shopService.getShopDetailInfoByLoginName(discoverArticle.getAuthorAccount());
			String storeNotice = shopInfoDetail.getStoreNotice();
			if (!StringUtils.isBlank(storeNotice)) {
				if (storeNotice.length() > 20) {
					shopInfoDetail.setStoreNotice(storeNotice.substring(0, 20) + "...");
				}
			}
			modelMap.put("shopInfoDetail", shopInfoDetail);
		}

		return "discoverArticleView";
	}

}
