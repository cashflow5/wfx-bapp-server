package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.PageSearch;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CategoryBrandSearcher extends PageSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *父分类ID
     */
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
