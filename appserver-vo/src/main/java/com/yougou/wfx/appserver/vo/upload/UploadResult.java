package com.yougou.wfx.appserver.vo.upload;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BooleanResult;

/**
 * Created by lizhw on 2016/4/26.
 */
public class UploadResult extends BooleanResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String url;
    private String fileName;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
