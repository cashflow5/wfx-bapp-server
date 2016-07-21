package com.yougou.wfx.appserver.vo.product;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class ProductDetail extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //商品列表信息（商品名称、URL、头图、售价、市场价、一级和二级佣金、二维码、多少人卖？）

    /**
     * styleNo,brandNo,catNo,years
     */
    public String getStyleId() {
        return styleNo + "," + brandNo + "," + catNo + "," + years;
    }

    private String styleNo;

    private String brandNo;

    private String catNo;

    private String years;

    /**
     * 商品id
     */
    private String id;

    /**
     * 商品编码
     */
    private String no;
    /**
     * 商品描述
     */
    private String describe;

    /**
     * 售价
     */
    private double price;

    /**
     * 原价
     */
    private double original_price;

    /**
     * 有多少人数在卖
     */
    private int people_num;

    /**
     * 商品图片URL
     */
    private String img_url;

    /**
     * 当前代理商是否已经代理
     */
    private boolean hasProxy = false;

    public String getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(String styleNo) {
        this.styleNo = styleNo;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    public String getCatNo() {
        return catNo;
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOriginal_price() {
        return format(original_price);
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isHasProxy() {
        return hasProxy;
    }

    public void setHasProxy(boolean hasProxy) {
        this.hasProxy = hasProxy;
    }
}
