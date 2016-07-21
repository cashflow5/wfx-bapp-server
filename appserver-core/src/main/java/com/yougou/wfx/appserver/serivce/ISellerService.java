package com.yougou.wfx.appserver.serivce;

import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.login.UserInfo;
import com.yougou.wfx.appserver.vo.seller.SubSellerDetail;
import com.yougou.wfx.appserver.vo.seller.SubSellerInfo;
import com.yougou.wfx.appserver.vo.seller.SubSellerSearcher;

/**
 * Created by lizhw on 2016/4/11.
 */
public interface ISellerService extends IBaseService {
    PageSearchResult<SubSellerSearcher, SubSellerInfo> getSubSellerList(SubSellerSearcher searcher);

    SubSellerDetail getSubSellerDetail(UserInfo userInfo, String subSellerId);
     int getSellerStatus(String memberId);
}
