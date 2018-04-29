package com.wl.lch.controller;

import com.wl.lch.domain.Resp;
import com.wl.lch.service.LoginService;
import com.wl.lch.service.NotificationService;
import com.wl.lch.service.ReplyService;
import com.wl.lch.util.RevertResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("reply")
public class ReplyController {

    @Resource
    private LoginService loginService;

    @Resource
    private ReplyService replyService;

    @Resource
    private NotificationService notificationService;

    @RequestMapping(value = "replyInfo", method = RequestMethod.POST)
    @ResponseBody
    public RevertResult reply(String content, int postsId, String token){
        if (StringUtils.isEmpty(token)) {
            return RevertResult.warn("token不存在，请重新登录！");
        }
        String accountNumber = loginService.checkSession(token);
        if (StringUtils.isEmpty(accountNumber)) {
            return RevertResult.warn("session过期，请重新登录！");
        }
        String status = replyService.reply(content,postsId, accountNumber);
        if(Resp.SUCCESS.equals(status)){
            return RevertResult.ok();
        }
        return null;
    }

    @RequestMapping(value = "notification/{id}",method = RequestMethod.GET)
    @ResponseBody
    public RevertResult getNotification(@PathVariable("id") int id){
        return RevertResult.ok(notificationService.getNotification(id));
    }

    @RequestMapping(value = "notification/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public RevertResult delNotification(@PathVariable("id") int id){
        notificationService.delNotification(id);
        return RevertResult.ok();
    }
}

