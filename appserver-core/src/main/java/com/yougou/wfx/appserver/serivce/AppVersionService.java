package com.yougou.wfx.appserver.serivce;

import com.yougou.wfx.appserver.vo.version.AppVersion;

/**
 * Created by lizhw on 2016/4/13.
 */
public interface AppVersionService extends IBaseService {

	AppVersion getAndroidNewestVersion();

}
