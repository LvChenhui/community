package com.wl.lch.controller;

import com.wl.lch.service.RankService;
import com.wl.lch.util.RevertResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("rank")
@Controller
public class RankController {

    @Resource
    private RankService rankService;

    @RequestMapping(value = "newUser",method = RequestMethod.GET)
    @ResponseBody
    public RevertResult newUser(){
        return RevertResult.ok(rankService.findNewUser());
    }

    @RequestMapping(value = "topPost")
    @ResponseBody
    public RevertResult topPost(){
        return RevertResult.ok(rankService.findTopPost());
    }
}
