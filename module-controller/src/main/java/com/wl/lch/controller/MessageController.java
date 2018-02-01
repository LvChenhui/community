package com.wl.lch.controller;


import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.RedisUtil;
import com.wl.lch.util.RevertResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "{token}", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult<Object> getUserByToken(@PathVariable("token") String token) {
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("token不存在，请重新登录");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isNotEmpty(accountNumber)) {
            Subscriber subscriber = loginService.findSubscriberDeatail(accountNumber);
            return RevertResult.ok(subscriber);
        }
        return RevertResult.warn("session过期");
    }

    @RequestMapping(value = "updateUser/{token}", method = RequestMethod.PUT)
    @ResponseBody
    public RevertResult updateUser(@PathVariable("token") String token, String username, String signature, String sex) {
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("未登录账号，请重新登录！");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isEmpty(accountNumber)) {
            return RevertResult.warn("session过期，请重新登录！");
        }
        String status = loginService.updateUser(accountNumber, username, signature, sex);
        if (Resp.SUCCESS.equals(status)) {
            return RevertResult.ok();
        }
        return null;
    }

    @RequestMapping(value = "forget/{token}", method = RequestMethod.PUT)
    @ResponseBody
    public RevertResult<Object> forget(@PathVariable("token") String token, String newpsd, String oldpsd) {
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("未登录账号，请重新登录！");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isEmpty(accountNumber)) {
            return RevertResult.warn("session过期，请重新登录！");
        }
        if (StringUtils.isEmpty(newpsd) || StringUtils.isEmpty(oldpsd)) {
            return RevertResult.warn("输入的新旧密码都不能为空！");
        }
        String status = loginService.forget(accountNumber, newpsd, oldpsd);
        if (Resp.SUCCESS.equals(status)) {
            return RevertResult.ok();
        }
        if (Resp.PWDERROR.equals(status)) {
            return RevertResult.warn("密码错误！");
        }
        if (Resp.NOTEXIST.equals(status)) {
            return RevertResult.error("账号不存在，请联系管理员！");
        }
        return RevertResult.error("ERROR!");
    }


}
