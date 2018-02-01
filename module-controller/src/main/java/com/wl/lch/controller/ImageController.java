package com.wl.lch.controller;

import com.wl.lch.domain.Resp;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.FileUtil;
import com.wl.lch.util.RevertResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("image")
public class ImageController {


    static final org.slf4j.Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "upload/{token}", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult doUploadFile(@PathVariable("token") String token, @RequestParam("file") MultipartFile file) {
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("未登录账号，请重新登录！");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isEmpty(accountNumber)) {
            return RevertResult.warn("session过期，请重新登录！");
        }
        try {
            String icon = FileUtil.uploadFile(file);
            if(StringUtils.isNotEmpty(icon)){
                String status = loginService.uploadIcon(accountNumber,icon);
                if(Resp.SUCCESS.equals(status)){
                    return RevertResult.ok("上传成功",icon);
                }
            }
        } catch (IOException e) {
            logger.error("上传图片异常:{}",e);
        }
        return RevertResult.error();
    }

    @RequestMapping(value = "getImage/{path}/{url}", method = RequestMethod.GET)
    public void getImage(@PathVariable("path") String path,@PathVariable("url") String url,HttpServletResponse response) {
        try {
            BufferedInputStream in =
                    new BufferedInputStream(
                            new FileInputStream(Resp.UPLOAD_PATH+path+"/"+url+".jpeg"));
            int str;
            response.setContentType("image/jpeg");
            while((str=in.read())!=-1){
                response.getOutputStream().write(str);
            }
            in.close();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
