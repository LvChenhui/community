package com.wl.lch.controller;

import com.wl.lch.dto.EstherDTO;
import com.wl.lch.dto.EstherDetailDTO;
import com.wl.lch.service.LoginService;
import com.wl.lch.service.PostService;
import com.wl.lch.util.RevertResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("post")
public class PostController {

    static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Resource
    private PostService postService;

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "esther", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult esther(int pageNo, int length, String type, String search) {
        if (pageNo == 0 || length == 0) {
            return RevertResult.warn("pageNo或length参数为空！");
        }
        try {
            search = new String(search.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("字符串转换{}",e);
        }
        List<EstherDTO> esthers = postService.findPostEsther(pageNo, length, type, search);
        int pageSize = postService.sumPostPageSize(type, search);
        return RevertResult.ok("success", esthers, pageSize, length);
    }

    @RequestMapping(value = "detail/{postsId}", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult detail(@PathVariable("postsId") int postsId, int pageNo, int length) {
        if (pageNo == 0 || length == 0) {
            return RevertResult.warn("pageNo或length参数为空！");
        }
        EstherDetailDTO estherDetail = postService.findReplyEsther(postsId, pageNo, length);
        if (estherDetail == null) {
            return RevertResult.warn("无法获取该帖子的回复信息！");
        }
        int pageSize = postService.sumReplyPageSize(postsId);
        return RevertResult.ok("success", estherDetail, pageSize, length);
    }

}

