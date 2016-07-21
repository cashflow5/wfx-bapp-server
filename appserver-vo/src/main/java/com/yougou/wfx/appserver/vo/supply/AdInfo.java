package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class AdInfo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adPic;

    public String getAdPic() {
        return adPic;
    }

    public void setAdPic(String adPic) {
        this.adPic = adPic;
    }
}
