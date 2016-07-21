package com.yougou.wfx.appserver.vo.upload;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/14.
 */
public class FileInfo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private byte[] bytes;
    private String fileName;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
