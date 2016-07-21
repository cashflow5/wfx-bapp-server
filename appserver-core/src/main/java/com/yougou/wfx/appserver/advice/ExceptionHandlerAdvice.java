package com.yougou.wfx.appserver.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yougou.wfx.appserver.vo.ServerError;

/**
 * Created by lizhw on 2016/4/28.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exception(HttpServletRequest request, Exception ex) {
        if (logger.isInfoEnabled()) {
            logger.error("error:", ex);
        }
        ServerError error = new ServerError();
        error.setErrorCode("500");
        error.setErrorMsg(ex.getMessage());
        return error;
    }
}
