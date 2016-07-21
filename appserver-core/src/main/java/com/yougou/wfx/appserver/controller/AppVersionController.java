package com.yougou.wfx.appserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.vo.version.AppVersion;

/**
 * App版本管理 Created by LLQ on 2016/4/8.
 */
@RestController
@RequestMapping("version")
@EnableAutoConfiguration
public class AppVersionController extends BaseController {

	/**
	 * 获取最新的APP版本
	 * 
	 * @return
	 */
	@RequestMapping("getAndroidNewestVersion")
	public Object getAppVersion() {
		AppVersion appVersion = appVersionService.getAndroidNewestVersion();
		return appVersion;
	}

}
