package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/20.
 */
public class CategoryInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //分类名称和图片URL
    private String id;
    private String name;
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
