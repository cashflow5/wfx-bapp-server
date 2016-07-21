package com.yougou.wfx.appserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.yougou.wfx.appserver.context.SpringContextHolder;

/**
 * Created by fenglvming on 16/3/22.
 */

@SpringBootApplication(scanBasePackages = "com.yougou.wfx")
@EnableAspectJAutoProxy
@ImportResource({"classpath:applicationContext-dubbo.xml"})
@PropertySources({
    /*标准配置*/
    @PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true),
    /*本地开发环境配置*/
    @PropertySource(value = "file:/d:/yougouconf/wfx/config.properties", ignoreResourceNotFound = true),
    /*服务器生产环境配置*/
    @PropertySource(value = "file:/etc/yougouconf/wfx/config.properties", ignoreResourceNotFound = true)

})
public class WfxAppServiceApplication {

    @Autowired
    private StringRedisTemplate template;

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }


    public static void main(String[] args) {
        SpringApplication.run(WfxAppServiceApplication.class, args);
    }


}
