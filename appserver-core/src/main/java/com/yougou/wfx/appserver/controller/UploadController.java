package com.yougou.wfx.appserver.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.yougou.wfx.appserver.vo.upload.FileInfo;
import com.yougou.wfx.appserver.vo.upload.UploadResult;


/**
 * Created by lizhw on 2016/4/14.
 */


@EnableAutoConfiguration
@RequestMapping("file")
@Controller
public class UploadController extends BaseController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //private static final String PIC_FILE_PATH = "/data/applogs/wfx-bapp-server/pic/";

    @Autowired
    @Value("${pic-file-path}")
    private String picFilePath;


    @ResponseBody
    @RequestMapping(value = "uploadPic", method = RequestMethod.POST)
    public Object uploadPic(StandardMultipartHttpServletRequest multipartRequest, HttpServletResponse response, String
            type) {
        response.setContentType("text/html;charset=UTF-8");
        MultipartFile multipartFile = multipartRequest.getFile("file");
        UploadResult result = new UploadResult();
        try {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                // 以gb2312编码读取上传的文件
                byte[] bytes = multipartFile.getBytes();

                InputStream inputStream = new ByteArrayInputStream(bytes);
                String filename = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                if (filename.indexOf(".") == -1) {
                    result.setError("上传文件类型错误");
                    return result;
                }
                String ext = filename.substring(filename.lastIndexOf("."));
                filename = uuid + ext;
                try {
                    if (!StringUtils.isBlank(picFilePath)) {
                        boolean windows = System.getProperties().getProperty("os.name").contains("Windows");
                        String prefix = "";
                        if (windows) {
                            prefix = "d:/";
                        }
                        File path = new File(prefix + picFilePath);
                        if (!path.exists()) {
                            path.mkdir();
                        }
                        File file = new File(prefix + picFilePath + filename);
                        multipartFile.transferTo(file);
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }

                if ("id".equals(type)) {
                    result = fileUploadService.uploadIdPic(inputStream, filename);
                } else if ("proxy".equals(type)) {
                    result = fileUploadService.uploadProxyAuthorizPic(inputStream, filename);
                }
                return result;

            } else {
                result.setError("上传文件失败，提交中不含文件");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setError("上传文件失败！");
        }
        return result;
    }


    @RequestMapping("getImg")
    public String getImage(String fileName, HttpServletResponse response) throws Exception {

        if (stringRedisTemplate.hasKey(fileName)) {
            String json = stringRedisTemplate.opsForValue().get(fileName);
            if (StringUtils.isBlank(json)) {
                response.getWriter().write("Error");
                return null;
            }
            FileInfo fileInfo = JSON.parseObject(json, FileInfo.class);
            if (null == fileInfo) {
                response.getWriter().write("Error");
                return null;
            }

            response.setContentType("image/jpeg");
            ServletOutputStream ouputStream = response.getOutputStream();

            try {
                ouputStream.write(fileInfo.getBytes());
                ouputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    ouputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;

        } else {
            response.getWriter().write("Error");
        }
        return null;
    }
}
