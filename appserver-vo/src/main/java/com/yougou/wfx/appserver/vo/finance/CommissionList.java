package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/21.
 */
public class CommissionList extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private CommissionSearcher searcher;

    private CommissionSummary summary;

    public CommissionSummary getSummary() {
        return summary;
    }

    public void setSummary(CommissionSummary summary) {
        this.summary = summary;
    }

    /**
     * 未结算 总数量
     */
    private int total1;
    /**
     * 已结算 总数量
     */
    private int total2;

    /**
     * 未结算 当前页
     */
    private List<Commission> items1 = new ArrayList<Commission>();


    /**
     * 已结算 当前页
     */
    private List<Commission> items2 = new ArrayList<Commission>();

    public CommissionSearcher getSearcher() {
        return searcher;
    }

    public void setSearcher(CommissionSearcher searcher) {
        this.searcher = searcher;
    }

    public int getTotal1() {
        return total1;
    }

    public void setTotal1(int total1) {
        this.total1 = total1;
    }

    public int getTotal2() {
        return total2;
    }

    public void setTotal2(int total2) {
        this.total2 = total2;
    }

    public List<Commission> getItems1() {
        return items1;
    }

    public void setItems1(List<Commission> items1) {
        this.items1 = items1;
    }

    public List<Commission> getItems2() {
        return items2;
    }

    public void setItems2(List<Commission> items2) {
        this.items2 = items2;
    }
}
