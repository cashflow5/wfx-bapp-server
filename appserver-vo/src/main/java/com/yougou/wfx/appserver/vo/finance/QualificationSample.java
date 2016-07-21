package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/5/11.
 */

public class QualificationSample extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 委托书扫描件示例地址
     */
    private String proxyPicSampleUrl;

    /**
     * 身份证扫描件示例地址
     */
    private String idPicSampleUrl;

    public String getProxyPicSampleUrl() {
        return proxyPicSampleUrl;
    }

    public void setProxyPicSampleUrl(String proxyPicSampleUrl) {
        this.proxyPicSampleUrl = proxyPicSampleUrl;
    }

    public String getIdPicSampleUrl() {
        return idPicSampleUrl;
    }

    public void setIdPicSampleUrl(String idPicSampleUrl) {
        this.idPicSampleUrl = idPicSampleUrl;
    }
}
