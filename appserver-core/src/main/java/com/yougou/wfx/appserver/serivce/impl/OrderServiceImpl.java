package com.yougou.wfx.appserver.serivce.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yougou.wfx.appserver.serivce.IOrderService;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.order.OrderDetailInfo;
import com.yougou.wfx.appserver.vo.order.OrderIdentity;
import com.yougou.wfx.appserver.vo.order.OrderInfo;
import com.yougou.wfx.appserver.vo.order.OrderProduct;
import com.yougou.wfx.appserver.vo.order.OrderSearcher;
import com.yougou.wfx.dto.base.PageModel;
import com.yougou.wfx.dto.base.UserContext;
import com.yougou.wfx.enums.OrderStatusEnum;
import com.yougou.wfx.enums.RefundStatusEnum;
import com.yougou.wfx.enums.SellerLevelEnum;
import com.yougou.wfx.order.dto.input.SellerOrderSearchDto;
import com.yougou.wfx.order.dto.output.OrderDetailDto;
import com.yougou.wfx.order.dto.output.OrderInfoDto;
import com.yougou.wfx.order.dto.output.OrderOutputDto;

/**
 * Created by lizhw on 2016/4/11.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl implements IOrderService {

	@Override
	public PageSearchResult<OrderSearcher, OrderInfo> getOrderInfoList(OrderSearcher searcher) {
		// ok :搜索状态,订单佣金,商品图片,佣金一级佣金二级佣金
		PageSearchResult<OrderSearcher, OrderInfo> result = new PageSearchResult<OrderSearcher, OrderInfo>();
		result.setSearcher(searcher);
		String sellerId = getSellerId(searcher.getUserInfo());
		if (isBlank(sellerId)) {
			result.setTotal(0);
			return result;
		}
		PageModel<Object> page = new PageModel<Object>();
		page.setPage(searcher.getPage());
		page.setLimit(searcher.getPageSize());
		UserContext uc = getUserContext(searcher, "getSellerOrders");
		// status: 订单状态
		// 1:'全部订单',2:'待付款',3:'待发货',4:'部分发货',5:'已发货',6:'交易成功',7:'交易关闭'
		/*
		 * 
		 * WAIT_PAY("WAIT_PAY", "待付款"), WAIT_DELIVER("WAIT_DELIVER", "待发货"),
		 * PART_DELIVERED("PART_DELIVERED", "部分发货"), DELIVERED("DELIVERED",
		 * "已发货"), TRADE_SUCCESS("TRADE_SUCCESS", "交易成功"),
		 * TRADE_CLOSED("TRADE_CLOSED", "交易关闭");
		 */
		// ok:status
		String status = searcher.getStatus();
		OrderStatusEnum ose = null;
		if ("1".equals(status)) {
			ose = null;
		} else if ("2".equals(status)) {
			ose = OrderStatusEnum.WAIT_PAY;
		} else if ("3".equals(status)) {
			ose = OrderStatusEnum.WAIT_DELIVER;
		} else if ("4".equals(status)) {
			ose = OrderStatusEnum.PART_DELIVERED;
		} else if ("5".equals(status)) {
			ose = OrderStatusEnum.DELIVERED;
		} else if ("6".equals(status)) {
			ose = OrderStatusEnum.TRADE_SUCCESS;
		} else if ("7".equals(status)) {
			ose = OrderStatusEnum.TRADE_CLOSED;
		} else {
			ose = null;
		}

		SellerOrderSearchDto sDto = new SellerOrderSearchDto();

		sDto.setUserContext(uc);
		// status
		if (ose != null) {
			sDto.setOrderStatus(ose.getKey());
		}

		// 复杂条件搜索先不用了【商品名称，手机号，订单号】
		sDto.setReceiverMobile(searcher.getPhone());
		sDto.setWfxOrderNo(searcher.getOrderNo());
		PageModel<OrderOutputDto> orders = orderFrontApi.getSellerOrdersByLevel(sellerId, SellerLevelEnum.getEnumByKey(searcher.getLevel() + ""), page, sDto);
		if (orders != null) {
			result.setTotal(orders.getTotalCount());

			List<OrderOutputDto> items = orders.getItems();
			if (null != items && items.size() > 0) {
				for (OrderOutputDto item : items) {
					OrderInfoDto order = orderFrontApi.getOrderById(item.getId());
					OrderInfo o = new OrderInfo();
					o.setId(item.getId());
					// 订单号
					o.setOrder_num(item.getWfxOrderNo());
					// 实际付款
					o.setPaying(item.getPayTime() == null ? 0.00d : item.getPayment());
					// 分销商名称
					o.setStore_name(item.getShopName());
					// 运费
					o.setCharges(item.getPostFee());
					// 状态
					o.setState_flag(OrderStatusEnum.getDescByKey(item.getStatus()));
					// 预计佣金
					// ok:订单佣金=一级佣金
					int sellerLevel = item.getSellerLevel();
					o.setBrokerage(toDouble(sellerLevel == 1 ? item.getCommissionLevel1() : (sellerLevel == 2 ? item.getCommissionLevel2() : item.getCommissionLevel3())));
					// o.setBrokerage();
					// 商品总金额
					o.setMoney_total(item.getTotalFee());
					// 支付方式
					o.setPay_mode(item.getPayTypeName());
					// 配送方式
					o.setPost_info(item.getShippingType());
					// 下单时间
					o.setOrderTime(item.getCreatedTime());
					// 店铺编码
					o.setShopCode(item.getShopCode());

					fillOrderDetailInfo(o, order);
					// int level =
					// orderFrontApi.getSellerLevel(item.getSellerId(),
					// searcher.getUserInfo().getSellerId());
					if (order != null) {
						List<OrderDetailDto> ods = order.getOrderDetailList();
						if (ods != null && ods.size() > 0) {
							for (OrderDetailDto od : ods) {
								OrderProduct oi = new OrderProduct();
								// 商品图片
								// ok:商品图片
								oi.setUrl(od.getPicSmall());
								oi.setDescribe(od.getProdName());
								oi.setPrice(od.getPrice());
								oi.setNum(od.getNum());
								// 退款状态
								oi.setRefundShowStatus(getRefundShowStatus(od.getRefundShowStatus()));
								// 商品行的佣金  // Mark by LQ.
								Double oiCommission = toDouble( sellerLevel == 1 ? od.getCommissionLevel1() : ( sellerLevel == 2 ? od.getCommissionLevel2() : od.getCommissionLevel3() ) );								
								oi.setCommission( oiCommission );
								
								o.getProducts().add(oi);
							}
						}
					}
					result.getItems().add(o);
				}
			}
		}

		return result;
	}

	// 订单详情是每个订单多个商品，佣金详情是每条佣金一个商品
	@Override
	public OrderDetailInfo getOrderDetail(OrderIdentity identity) {
		// ok : 订单佣金,商品图片,佣金一级佣金二级佣金
		OrderDetailInfo o = new OrderDetailInfo();
		if (isBlank(identity.getOrderId())) {
			return o;
		}
		OrderInfoDto item = orderFrontApi.getOrderById(identity.getOrderId());
		if (item == null) {
			return o;
		}
		String sellerId = getSellerId(identity.getUserInfo());
		if (isBlank(sellerId)) {
			// return null;
		}
		if (!sellerId.equals(item.getSellerId())) {
			// return null;
		}

		o.setId(item.getId());
		// 订单号
		o.setOrder_num(item.getWfxOrderNo());
		// 实际付款
		o.setPaying(item.getPayTime() == null ? 0.00d : item.getPayment());
		// 分销商名称
		o.setStore_name(item.getShopName());
		// 运费
		o.setCharges(item.getPostFee());
		// 状态
		o.setState_flag(OrderStatusEnum.getDescByKey(item.getStatus()));

		// 商品总金额
		o.setMoney_total(item.getTotalFee());
		// 支付方式
		o.setPay_mode(item.getPayTypeName());
		// 配送方式
		o.setPost_info(item.getShippingType());
		// 下单时间
		o.setOrderTime(item.getCreatedTime());
		// 预计佣金
		// ok:订单佣金=一级佣金
		int level = orderFrontApi.getSellerLevel(item.getSellerId(), identity.getUserInfo().getSellerId());
		o.setBrokerage(toDouble(level == 1 ? item.getCommissionLevel1() : (level == 2 ? item.getCommissionLevel2() : item.getCommissionLevel3())));

		o.setShopCode(item.getShopCode());
		fillOrderDetailInfo(o, item);

		List<OrderDetailDto> ods = item.getOrderDetailList();

		if (ods != null && ods.size() > 0) {
			for (OrderDetailDto od : ods) {
				OrderProduct oi = new OrderProduct();
				// 商品图片
				oi.setUrl(od.getPicSmall());
				oi.setDescribe(od.getProdName());
				oi.setPrice(od.getPrice());
				oi.setNum(od.getNum());
				// 退款状态
				oi.setRefundShowStatus(getRefundShowStatus(od.getRefundShowStatus()));
				o.getProducts().add(oi);
			}
		}
		return o;
	}

	private String getRefundShowStatus(String refundShowStatus) {
		String returnStr = "";
		if (refundShowStatus == null || "".equals(refundShowStatus)) {
			return returnStr;
		}
		if ("2".equals(refundShowStatus)) {
			returnStr = "退款中";
		} else if ("3".equals(refundShowStatus)) {
			returnStr = "已退款";
		}
		return returnStr;
	}

	private void fillOrderDetailInfo(OrderInfo o, OrderInfoDto item) {
		String receiverName = item.getReceiverName() + "";
		StringBuilder s = new StringBuilder();
		if (!isBlank(receiverName)) {
			s.append(receiverName.substring(0, 1));
		}
		for (int i = 1; i < receiverName.length(); i++) {
			s.append("*");
		}
		// 收货人
		o.setReceiver(s.toString());
		String phone = item.getReceiverPhone() + "";
		if (phone.length() <= 7) {
			phone = "*******";
		} else {
			phone = phone.substring(0, 3) + "****" + phone.substring(7);
		}
		// 收件人电话
		o.setPhone(phone);
		// 收货地址
		String address = item.getReceiverAddress() + "";
		if (address.length() > 40) {
			address = "******" + address.substring(40);
		} else if (address.length() > 35) {
			address = "******" + address.substring(35);
		} else if (address.length() > 30) {
			address = "******" + address.substring(30);
		} else if (address.length() > 25) {
			address = "******" + address.substring(25);
		} else if (address.length() > 20) {
			address = "******" + address.substring(20);
		} else if (address.length() > 15) {
			address = "******" + address.substring(15);
		} else if (address.length() > 10) {
			address = "******" + address.substring(10);
		} else if (address.length() > 5) {
			address = "******" + address.substring(5);
		} else {
			address = "******";
		}

		o.setAddress(item.getReceiverState() + item.getReceiverCity() + item.getReceiverDistrict() + address);
	}
}
