package com.wl.lch.controller;

import com.wl.lch.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OptionController {

    static final Logger logger = LoggerFactory.getLogger(OptionController.class);

//    @RequestMapping(value = "/**",method = RequestMethod.OPTIONS)
//    public void getOption(HttpServletResponse response)
//    {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//    }

    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greeting");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping(value = "/test1")
    public ModelAndView test1() {
        System.out.println("111");
        logger.error("123");
        throw new BusinessException("test");
    }
}
