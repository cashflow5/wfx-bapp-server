package com.yougou.wfx.appserver.serivce;


import com.yougou.wfx.appserver.vo.BooleanResult;
import com.yougou.wfx.appserver.vo.login.UserInfo;
import com.yougou.wfx.appserver.vo.shop.ShopInfo;
import com.yougou.wfx.appserver.vo.shop.ShopInfoDetail;

/**
 * Created by lizhw on 2016/4/11.
 */
public interface IShopService  extends IBaseService{
    com.yougou.wfx.appserver.vo.home.ShopInfo getShop(UserInfo userInfo, boolean b);

    ShopInfoDetail getShopDetailInfo(UserInfo userInfo);

    BooleanResult setShopInfo(ShopInfo shopInfo);

	ShopInfoDetail getShopDetailInfoByLoginName(String authorAccount);


}
