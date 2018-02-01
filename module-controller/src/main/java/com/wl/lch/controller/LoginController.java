package com.wl.lch.controller;


import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.ResultProcessor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.wl.lch.util.RevertResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> signIn(String email, String password) {
        String msg = loginService.signIn(email, password);
        if (Resp.SUCCESS.equals(msg)) {
            return RevertResult.ok(msg, loginService.sessionAccount(email));
        }
        return RevertResult.warn("账号不存在或者密码错误！");
    }

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> regist(String email, String username, String password) {
        String msg = loginService.regist(email, username, password, "");
        if (Resp.SUCCESS.equals(msg)) {
            return RevertResult.ok();
        }
        if (Resp.EXIST.equals(msg)) {
            return RevertResult.warn("该账号已被注册！");
        }
        if (Resp.NAMEEXIST.equals(msg)) {
            return RevertResult.warn("该昵称已被占用！");
        }
        return RevertResult.error(msg);
    }

    @RequestMapping(value = "signOut", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> signOut(String token) {
        String status = loginService.signOut(token);
        if (Resp.SUCCESS.equals(status)) {
            return RevertResult.ok();
        }
        return RevertResult.error();
    }




}
