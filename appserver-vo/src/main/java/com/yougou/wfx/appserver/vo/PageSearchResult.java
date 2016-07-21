package com.yougou.wfx.appserver.vo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lizhw on 2016/4/11.
 */
public class PageSearchResult<TIN, TOUT> extends BaseVo  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 查询条件
     */
    private TIN searcher;

    /**
     * 二级经销商总数
     */
    private int total = 0;// TODO Rename
    /**
     * 三级经销商总数
     */
    private int level3total = 0;

    /**
     * 当前页
     */
    private List<TOUT> items = new LinkedList<TOUT>();

	public int getLevel3total() {
		return level3total;
	}

	public void setLevel3total(int level3total) {
		this.level3total = level3total;
	}

	public TIN getSearcher() {
        return searcher;
    }

    public void setSearcher(TIN searcher) {
        this.searcher = searcher;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TOUT> getItems() {
        return items;
    }

    public void setItems(List<TOUT> items) {
        this.items = items;
    }
}
