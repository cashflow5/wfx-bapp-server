package com.yougou.wfx.appserver.annotation;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/**
 * Created by lizhw on 2016/4/28.
 */
@Aspect
@Component
public class LogAspect {

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doLoggerProfiler(JoinPoint joinPoint) throws Throwable {
        try {
            if (logger.isInfoEnabled()) {
                HashMap<String, String> logMap = new HashMap<String, String>();
                String methodName = joinPoint.getSignature().getName();
                String className = joinPoint.getTarget().getClass().getSimpleName();

                logMap.put("action", className + "." + methodName);
                Object[] args = joinPoint.getArgs();
                if (args != null && args.length > 0 && !className.equals("UserCenterController")) {
                    for (int i = 0; i < args.length; i++) {
                        String json = "";
                        try {
                            json = JSON.toJSONString(args[i]);
                        } catch (Exception ex) {
                            json = "{err}";
                        }
                        logMap.put("arg-" + i, json);
                    }
                }
//                Map<String, String[]> par = getRequest().getParameterMap();
//                logMap.put("params", par);
                String ip = getIp();
                logMap.put("ip", ip);
                logger.info(JSON.toJSONString(logMap));
            }
        } catch (Exception var11) {
            logger.error("LoggerProfile Exception ", var11);
        }

    }

    public String getIp() {
        return getIpAddr(getRequest());
    }

    public String getReferer() {
        return getRequest().getHeader("referer");
    }

    public String getUserAgent() {
        return getRequest().getHeader("user-agent");
    }


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtils.isNotEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            String[] strIps = StringUtils.stripToEmpty(ip).split(",");
            if (strIps != null && strIps.length > 1) {
                return StringUtils.stripToEmpty(strIps[1]);
            }
        }
        return ip;
    }

}
