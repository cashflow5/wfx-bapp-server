package com.yougou.wfx.appserver.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by lizhw on 2016/4/11.
 */
public class PageSearch extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final ToStringStyle PAGE_SUFFIX_STYLE = new PageSuffixToStringStyle();


    /**
     * 当前页
     */
    private int page = 1;
    /**
     * 页大小
     */
    private int pageSize = 10;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getPage() {
        if (page < 1) {
            page = 1;
        }
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }

    public String getPagerParam() {
        String pageParam = new ReflectionToStringBuilder(this, PAGE_SUFFIX_STYLE).setExcludeFieldNames("page",
                "request", "response", "lastAccessUrl", "sellerId", "shopId", "userInfo", "ip", "referer", "userAgent",
                "sid")
                .toString();

        final Field[] fields = this.getClass().getDeclaredFields();
        for (final Field field : fields) {
            final String fieldName = field.getName();
            pageParam = StringUtils.replace(pageParam, fieldName.concat("=&"), "");
        }
        if (StringUtils.endsWith(pageParam, "=")) {
            pageParam = StringUtils.substringBeforeLast(pageParam, "&");
        }
        return pageParam;
    }


}

class PageSuffixToStringStyle extends ToStringStyle {

    private static final long serialVersionUID = 1L;

    /**
     *
     *
     *
     */
    PageSuffixToStringStyle() {
        super();
        this.setUseShortClassName(false);
        this.setUseIdentityHashCode(false);
        this.setDefaultFullDetail(true);
        this.setUseClassName(false);
        this.setFieldSeparator("&");
        this.setSummaryObjectStartText("");
        this.setSummaryObjectEndText("");
        this.setArrayStart("");
        this.setArrayEnd("");
        this.setNullText("");
        this.setContentStart("&");
        this.setContentEnd("");
    }

    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        if (value instanceof Date) {
            value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
        }
        buffer.append(value);
    }


    /**
     * @return the singleton
     */
    private Object readResolve() {
        return ToStringStyle.SHORT_PREFIX_STYLE;
    }

}


