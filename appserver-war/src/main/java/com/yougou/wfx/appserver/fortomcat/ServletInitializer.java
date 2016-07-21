package com.yougou.wfx.appserver.fortomcat;

import com.yougou.wfx.appserver.WfxAppServiceApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by lizhw on 2016/5/5.
 * 可直接部署本项目war包到tomcat。
 * <p/>
 * 如要将appserver-core直接部署到tomcat上:
 * 1.将appserver-core的pom.xml中的tomcat插件  <scope>provided</scope> 取消注释，
 * 2.将appserver-core的pom.xml中的<packaging>jar</packaging> 改为 <packaging>war</packaging>
 * 3.将下面ServletInitializer代码放入appserver-core
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WfxAppServiceApplication.class);
    }
}
