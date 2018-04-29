package com.wl.lch.controller;


import com.wl.lch.domain.Resp;
import com.wl.lch.service.AddService;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.RevertResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("add")
@Controller
public class AddController {

    @Resource
    private LoginService loginService;

    @Resource
    private AddService addService;

    @RequestMapping(value = "addInfo", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult addInfo(String title, String content, int labelId, String token) {
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("token不存在，请重新登录！");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isEmpty(accountNumber)) {
            return RevertResult.warn("session过期，请重新登录！");
        }
        String status = addService.add(title, content, labelId, accountNumber);
        if (Resp.SUCCESS.equals(status)) {
            return RevertResult.ok("发帖成功！");
        }
        return RevertResult.warn("发帖失败！");
    }

}
