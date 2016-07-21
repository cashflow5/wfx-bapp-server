package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.product.OnAndOffProduct;
import com.yougou.wfx.appserver.vo.product.Product;
import com.yougou.wfx.appserver.vo.product.ProductShelf;
import com.yougou.wfx.appserver.vo.product.ShopProductSearcher;

/**
 * 商品管理
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("productManage")
@EnableAutoConfiguration
public class ProductManageController extends BaseController {
    /**
     * 获取当前店铺下的所有商品
     *
     * @return
     */
    @RequestMapping("getShopProduct")
    @NeedLoginAction
    public Object getShopProduct(ShopProductSearcher searcher) {
        searcher.setUserInfo(getUserInfo());
        //商品列表信息（商品名称、URL、头图、售价、市场价、一级和二级佣金、二维码、多少人卖？）
        //多少人卖感觉是另外一个接口的信息，不过是否可以打包一个接口给我？
        PageSearchResult<ShopProductSearcher, Product> result = productService.getShopProduct(searcher);
        return result;
    }

    /**
     * 批量上下架
     *
     * @return
     */
    @RequestMapping(value = "productShelfManage", method = RequestMethod.POST)
    @NeedLoginAction
    public Object productShelfManage(@RequestBody ProductShelf onAndoff) {
        onAndoff.setUserInfo(getUserInfo());
        OnAndOffProduct result = productService.productShelfManage(onAndoff);
        return result;
    }


}
