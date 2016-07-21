package com.yougou.wfx.appserver.configurations.dubbo;

import com.alibaba.dubbo.config.ProtocolConfig;

/**
 * Created by lizhw on 2016/4/8.
 */
public class DubboDestruction {
    public DubboDestruction() {
    }

    public void destroy() throws Exception {
        ProtocolConfig.destroyAll();
    }
}
