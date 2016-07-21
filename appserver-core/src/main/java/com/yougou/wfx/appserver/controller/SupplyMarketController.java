package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.BooleanResult;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.login.LoginError;
import com.yougou.wfx.appserver.vo.product.Product;
import com.yougou.wfx.appserver.vo.product.ProductDetail;
import com.yougou.wfx.appserver.vo.product.ProductSearcher;
import com.yougou.wfx.appserver.vo.supply.BrandProductSearcher;
import com.yougou.wfx.appserver.vo.supply.CategoryBrandInfo;
import com.yougou.wfx.appserver.vo.supply.CategoryBrandSearcher;
import com.yougou.wfx.appserver.vo.supply.CategoryProductSearcher;
import com.yougou.wfx.appserver.vo.supply.Style;
import com.yougou.wfx.appserver.vo.supply.SupplyMarketInfo;

/**
 * 货源市场 Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("supplyMarket")
@EnableAutoConfiguration
public class SupplyMarketController extends BaseController {

	/**
	 * 货源市场 首页
	 *
	 * @return
	 */
	@RequestMapping("home")
	@NeedLoginAction
	public Object home() {
		Object sellerStatus = getRequest().getSession().getAttribute("sellerStatus");
		if (sellerStatus != null && "2".equals(sellerStatus)) {
			LoginError loginError = new LoginError();
			loginError.setErrorCode("2");
			loginError.setError("优购微店关闭了您的店铺");
			return loginError;
		}
		// 返回货源市场首页的广告图
		SupplyMarketInfo result = supplyService.getSupplyMarketInfo();

		return result;
	}

	/**
	 * 按照品牌搜索品牌下商品
	 *
	 * @return
	 */
	@RequestMapping("getProductByBrand")
	@NeedLoginAction
	public Object getProductByBrand(BrandProductSearcher searcher) {
		searcher.setUserInfo(getUserInfo());
		// 返回货源市场首页的广告图
		PageSearchResult<BrandProductSearcher, Product> result = productService.getProductByBrandNo(searcher);
		return result;
	}

	/**
	 * 获取分类信息 ，根据分类获取分类下的二级分类，根据二级分类获取所有叶子分类以及品牌
	 *
	 * @return
	 */
	@RequestMapping("getCategoryBrandInfo")
	public Object getCategoryBrandInfo(CategoryBrandSearcher searcher) {
		PageSearchResult<CategoryBrandSearcher, CategoryBrandInfo> result = productService.getCategoryBrandInfo(searcher);
		return result;
	}

	/**
	 * 根据叶子分类获取所有的商品 分类ID
	 *
	 * @return
	 */
	@RequestMapping("getProductByLeafCategory")
	@NeedLoginAction
	public Object getProductByLeafCategory(CategoryProductSearcher searcher) {
		searcher.setUserInfo(getUserInfo());
		// 商品列表信息（商品名称、URL、头图、售价、市场价、一级和二级佣金、二维码、多少人卖？）
		PageSearchResult<CategoryProductSearcher, Product> result = productService.getProductByLeafCategory(searcher);
		return result;
	}

	/**
	 * 根据商品ID获取商品详情
	 *
	 * @return
	 */
	@RequestMapping("getProductDetailByNo")
	@NeedLoginAction
	public Object getProductInfo(String productNo) {
		// 详情页涉及到的元素
		ProductDetail product = productService.getProductDetailById(productNo, getUserInfo());

		return product;
	}

	/**
	 * 商品搜索
	 *
	 * @return
	 */
	@RequestMapping("s")
	@NeedLoginAction
	public Object s(ProductSearcher searcher) {
		searcher.setUserInfo(getUserInfo());
		// 此功能涉及到商品筛选，由搜索组提供支持
		PageSearchResult<ProductSearcher, Product> result = productService.searchProduct(searcher);
		return result;
	}

	/**
	 * 设置代理商品 分销商ID，店铺ID，商品ID
	 *
	 * @return
	 */
	@RequestMapping(value = "setProxyProducts", method = RequestMethod.POST)
	@NeedLoginAction
	public Object setProxyProducts(@RequestBody Style style) {
		Object sellerStatus = getRequest().getSession().getAttribute("sellerStatus");
		if (sellerStatus != null && "2".equals(sellerStatus)) {
			LoginError loginError = new LoginError();
			loginError.setErrorCode("2");
			loginError.setError("优购微店关闭了您的店铺");
			return loginError;
		}
		style.setUserInfo(getUserInfo());
		// true or false
		BooleanResult result = supplyService.setProxyProduct(style);
		return result;
	}

	/**
	 * 一键代理所有商品
	 *
	 * @return
	 */
	@RequestMapping(value = "setAllProxyProducts")
	@NeedLoginAction
	public Object setAllProxyProducts() {
		Object sellerStatus = getRequest().getSession().getAttribute("sellerStatus");
		if (sellerStatus != null && "2".equals(sellerStatus)) {
			LoginError loginError = new LoginError();
			loginError.setErrorCode("2");
			loginError.setError("优购微店关闭了您的店铺");
			return loginError;
		}
		BooleanResult result = supplyService.setAllProxyProducts(getUserInfo());
		return result;
	}

}
