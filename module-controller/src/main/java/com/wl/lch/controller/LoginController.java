package com.wl.lch.controller;


import com.wl.lch.domain.Resp;
import com.wl.lch.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wl.lch.util.RevertResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value="signIn",method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> signIn(@RequestBody Map<String, Object> map){
        String accountNumber = (String)map.get("accountNumber");
        String password = (String)map.get("password");
        String msg = loginService.signIn(accountNumber,password);
        RevertResult<Object> result = new RevertResult<Object>();
        if(Resp.SUCCESS.equals(msg)){
            result.setMsg(msg);
            result.setStatus(0);
            return result;
        }
        result.setMsg(msg);
        result.setStatus(2);
        return result;
    }

    @RequestMapping(value="regist",method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> regist(@RequestBody Map<String, Object> map){
        String accountNumber = (String)map.get("accountNumber");
        String password = (String)map.get("password");
        String verificationCode = (String)map.get("verificationCode");
        String msg = loginService.regist(accountNumber,password,verificationCode);
        RevertResult<Object> result = new RevertResult<Object>();
        if(Resp.SUCCESS.equals(msg)){
            result.setMsg(msg);
            result.setStatus(0);
            return result;
        }
        if(Resp.EXIST.equals(msg)){
            result.setMsg(msg);
            result.setStatus(1);
            return result;
        }
        result.setMsg(msg);
        result.setStatus(2);
        return result;
    }

    @RequestMapping(value="forget",method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> forget(@RequestBody Map<String, Object> map){
        String accountNumber = (String)map.get("accountNumber");
        String password = (String)map.get("newPwd");
        String verificationCode = (String)map.get("verificationCode");
        String msg = loginService.forget(accountNumber,verificationCode,password);
        RevertResult<Object> result = new RevertResult<Object>();
        if(Resp.SUCCESS.equals(msg)){
            result.setMsg(msg);
            result.setStatus(0);
            return result;
        }
        if(Resp.NOTEXIST.equals(msg)){
            result.setMsg(msg);
            result.setStatus(1);
            return result;
        }
        result.setMsg(msg);
        result.setStatus(2);
        return result;
    }

    @RequestMapping(value="signOut",method = RequestMethod.POST)
    @ResponseBody
    public RevertResult<Object> signOut(){
        loginService.registLogin();
        System.out.println(1);
        return new RevertResult<Object>();
    }

}
