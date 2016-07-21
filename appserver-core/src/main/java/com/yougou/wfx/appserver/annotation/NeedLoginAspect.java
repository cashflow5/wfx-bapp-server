package com.yougou.wfx.appserver.annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.yougou.wfx.appserver.constant.WfxConstant;
import com.yougou.wfx.appserver.serivce.ISellerService;
import com.yougou.wfx.appserver.vo.login.LoginError;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/13.
 */
@Aspect
@Component
@Order(1)
public class NeedLoginAspect {

    @Autowired
    private ISellerService sellerService;

    @Pointcut("@annotation(com.yougou.wfx.appserver.annotation.NeedLoginAction)")
    public void annotationPointCut() {

    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        NeedLoginAction needLoginAction = method.getAnnotation(NeedLoginAction.class);
        HttpServletRequest request = getRequest();
        if (null == request) {
            return needLoginAction.json();
        }
        HttpSession session = request.getSession();
        if (null == session) {
            return needLoginAction.json();
        }
        UserInfo userInfo = getUserInfo(session);
        if (null == userInfo) {
            return needLoginAction.json();
        }
        int sellerStatus = sellerService.getSellerStatus(userInfo.getId());
        getRequest().getSession().setAttribute("sellerStatus", "" + sellerStatus);
        if (sellerStatus == 1) {
            //1就是停止合作  2就是 关店了
            LoginError loginError = new LoginError();
            loginError.setErrorCode("1");
            loginError.setError("优购微店已停止与您的合作");
            return loginError;

        } else if (sellerStatus == 2) {
            //1就是停止合作  2就是 关店了
            //return "{\"error\":\"优购微店关闭了您的店铺\"}";
        }

        return joinPoint.proceed();
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

    public UserInfo getUserInfo(HttpSession session) {
        Object o = session.getAttribute(WfxConstant.SESSION_USER_KEY);
        if (null == o) {
            return null;
        }
        String json = (String) o;
        if (StringUtils.isBlank(json)) {
            return null;
        }
        UserInfo userInfo = JSON.parseObject(json, UserInfo.class);
        return userInfo;

    }
}
