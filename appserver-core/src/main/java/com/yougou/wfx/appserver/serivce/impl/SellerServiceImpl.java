package com.yougou.wfx.appserver.serivce.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yougou.wfx.appserver.serivce.ISellerService;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.login.UserInfo;
import com.yougou.wfx.appserver.vo.seller.SubSellerDetail;
import com.yougou.wfx.appserver.vo.seller.SubSellerInfo;
import com.yougou.wfx.appserver.vo.seller.SubSellerSearcher;
import com.yougou.wfx.dto.base.PageModel;
import com.yougou.wfx.dto.base.WFXResult;
import com.yougou.wfx.seller.dto.output.SellerInfoOutputDto;
import com.yougou.wfx.shop.dto.output.ShopOutputDto;

/**
 * Created by lizhw on 2016/4/11.
 */
@Service
public class SellerServiceImpl extends BaseServiceImpl implements ISellerService {
    //ok
    @Override
    public PageSearchResult<SubSellerSearcher, SubSellerInfo> getSubSellerList(SubSellerSearcher searcher) {
        PageSearchResult<SubSellerSearcher, SubSellerInfo> result =
                new PageSearchResult<SubSellerSearcher, SubSellerInfo>();
        result.setSearcher(searcher);

        String sellerId = getSellerId(searcher.getUserInfo());
        if (isBlank(sellerId)) {
            result.setTotal(0);
            return result;
        }
        PageModel<Object> page = new PageModel<Object>();
        page.setPage(searcher.getPage());
        page.setLimit(searcher.getPageSize());

        PageModel<SellerInfoOutputDto> subSellers = sellerInfoFrontApi.getSubSellerListById(sellerId, page);
        

        if (null != subSellers) {
            result.setTotal(subSellers.getTotalCount());
            List<SellerInfoOutputDto> items = subSellers.getItems();
            if (items != null && items.size() > 0) {
                for (SellerInfoOutputDto item : items) {
                    SubSellerInfo subSeller = new SubSellerInfo();
                    //id
                    subSeller.setId(item.getId());
                    //分销商名称
                    subSeller.setName(item.getSellerName());
                    //佣金
                    if (item.getCommissionTotalAmountForParent() != null) {
                        subSeller.setCommissionTotalAmountForParent(item.getCommissionTotalAmountForParent());
                        subSeller.setCommission(item.getCommissionTotalAmountForParent());
                    }
                    //注册时间 （审核通过时间）
                    subSeller.setRegTime(item.getPassDate());
                    //下级分销商数量
                    subSeller.setSubSellerCount(toInt(item.getSubSellerCount()));
                    //LOGO图片
                    ShopOutputDto shop = shopFrontApi.getShopBySeller(item.getId());
                    subSeller.setLogoUrl(shop.getLogoUrl());
                    subSeller.setShopCode(shop.getShopCode());
                    result.getItems().add(subSeller);
                }
            }
        }

        return result;
    }


    @Override
    public SubSellerDetail getSubSellerDetail(UserInfo userInfo, String subSellerId) {
        SubSellerDetail d = new SubSellerDetail();
        if (isBlank(subSellerId)) {
            return d;
        }
        SellerInfoOutputDto seller = sellerInfoFrontApi.getSellerInfoById(subSellerId);
        String sellerId = getSellerId(userInfo);
        if (null == seller || isBlank(seller.getParentId()) || !seller.getParentId().equals(sellerId)) {
            return d;
        }
        //ok:call api

        d.setId(seller.getId());
        //分销商账号
        d.setAccount(seller.getLoginName());
        d.setBirthDayDate(seller.getBirthday());
        d.setRealName(seller.getSellerName());
        d.setRegTimeDate(seller.getRegisterDate());
        //会员性别,1=男，2=女
        d.setSex("1".equals(seller.getMemberSex()) ? "男" : ("2".equals(seller.getMemberSex()) ? "女" : ""));
        d.setShopName(seller.getShopName());
        d.setSubSellerCount(toInt(seller.getSubSellerCount()));
        d.setShopCode(seller.getShopCode());
        return d;
    }

    public int getSellerStatus(String memberId) {
        WFXResult<Integer> wfxResult = sellerInfoFrontApi.getSellerStatusByMemberId(memberId);
        if (wfxResult == null || wfxResult.getResult() == null) {
            return 0;
        }
        return wfxResult.getResult();
    }
}
