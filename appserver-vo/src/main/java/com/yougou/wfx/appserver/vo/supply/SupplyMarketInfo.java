package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/20.
 */
public class SupplyMarketInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //分为三块，第一个是 展示图片，是一个数组。 第二个是 品牌数组（包括品牌名称和图片URL） 第三个是一级分类数组（分类名称和图片URL）

    //id,imageUrl
    private List<ShowImage> showImages = new ArrayList<ShowImage>();

    //id,name,imageUrl
    private List<List<BrandInfo>> brands = new ArrayList<List<BrandInfo>>();

    //id,name,imageUrl
    private List<CategoryInfo> firstCategorys = new ArrayList<CategoryInfo>();


    public List<ShowImage> getShowImages() {
        return showImages;
    }

    public void setShowImages(List<ShowImage> showImages) {
        this.showImages = showImages;
    }

    public List<List<BrandInfo>> getBrands() {
        return brands;
    }

    public void setBrands(List<List<BrandInfo>> brands) {
        this.brands = brands;
    }

    public List<CategoryInfo> getFirstCategorys() {
        return firstCategorys;
    }

    public void setFirstCategorys(List<CategoryInfo> firstCategorys) {
        this.firstCategorys = firstCategorys;
    }
}
