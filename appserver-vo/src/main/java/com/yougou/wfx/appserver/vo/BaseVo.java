package com.yougou.wfx.appserver.vo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhw on 2016/4/12.
 */
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat simpleDateFormatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");

    protected String format(Date date) {
        if (null == date) {
            return "";
        }
        String str = simpleDateFormatDateTime.format(date);
        return str;
    }

    protected String formatDate(Date date) {
        if (null == date) {
            return "";
        }
        String str = simpleDateFormatDate.format(date);
        return str;
    }

    protected String format(Double d) {
        if (d == null) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("0.00");

        return df.format(d.doubleValue());
    }


    public String getClazz() {
        return this.getClass().getName().replace("com.yougou.wfx.appserver.vo.", "");
    }
}
