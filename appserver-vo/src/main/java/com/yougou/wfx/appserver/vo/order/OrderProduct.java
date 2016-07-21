package com.yougou.wfx.appserver.vo.order;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/15.
 */
public class OrderProduct extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //商品图片，名称，颜色，尺码，分销价，数量。
    /**
     * 商品图片
     */
    private String url;
    /**
     * 名称，颜色，尺码
     */
    private String describe;
    /**
     * 分销价
     */
    private double price;
    /**
     * 数量
     */
    private int num;
    /**
     * 佣金
     */
    private double commission;
    /**
	 * 订单列表中子订单显示退款的状态类型
	 * 1.退货/退款
	 * 2.退款中
	 * 3.已退款
	 * 4.无（确认收货7天后关闭退款）
	 */
    private String refundShowStatus;
    
    private String commodityNo;

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPrice() {
        return format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCommission() {
        return format(commission);
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

	public String getRefundShowStatus() {
		return refundShowStatus;
	}

	public void setRefundShowStatus(String refundShowStatus) {
		this.refundShowStatus = refundShowStatus;
	}
}
