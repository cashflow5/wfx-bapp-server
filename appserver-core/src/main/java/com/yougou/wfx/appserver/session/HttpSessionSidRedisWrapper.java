package com.yougou.wfx.appserver.session;


import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.yougou.wfx.appserver.context.SpringContextHolder;

public class HttpSessionSidRedisWrapper extends HttpSessionWrapper {

    private String sid = "";

    private StringRedisTemplate redisTemplate;

    public HttpSessionSidRedisWrapper(String sid, HttpSession session) {
        super(session);
        this.sid = sid;
        this.redisTemplate = SpringContextHolder.getBean(StringRedisTemplate.class);
    }

    public Object getAttribute(String name) {
        return this.redisTemplate.opsForHash().get(this.sid, name);
    }

    public String getId() {
        return sid;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public Enumeration getAttributeNames() {
        return (new Enumerator(this.redisTemplate.opsForHash().keys(this.sid), true));
    }

    public void invalidate() {
        //session存储在Redis中设置过期时间，过期之前都有效。不再删除。
        //this.redisTemplate.delete(this.sid);
        super.invalidate();
    }

    public void removeAttribute(String name) {
        this.redisTemplate.opsForHash().delete(this.sid, name);
    }

    public void setAttribute(String name, Object value) {
        this.redisTemplate.opsForHash().put(this.sid, name, value);
        //expire过期时间不能超过       2147483647 毫秒 约24天
        //3600 * 24 * 30*1000=2592000000
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, 30);
        this.redisTemplate.expireAt(this.sid, cal.getTime());// 设置属性时，重新设置超时时间续命
    }

}
