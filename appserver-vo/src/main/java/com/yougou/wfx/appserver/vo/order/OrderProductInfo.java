package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/11.
 */
public class OrderProductInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
