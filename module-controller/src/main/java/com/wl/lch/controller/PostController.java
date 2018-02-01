package com.wl.lch.controller;

import com.wl.lch.dto.EstherDTO;
import com.wl.lch.dto.EstherDetailDTO;
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
import java.util.List;

@Controller
@RequestMapping("post")
public class PostController {

    static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Resource
    private PostService postService;

    @RequestMapping(value = "esther", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult esther(int pageNo, int length, String type, String search) {
        if (pageNo == 0 || length == 0) {
            return RevertResult.warn("pageNo或length参数为空");
        }
        List<EstherDTO> esthers = postService.findPostEsther(pageNo, length, type, search);
        int pageSize = postService.sumPageSize();
        RevertResult result = RevertResult.ok(esthers);
        result.setPageSize(pageSize);
        result.setTotal(length);
        return result;
    }

    @RequestMapping(value = "detail/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult detail(@PathVariable("postId") int postId, int pageNo, int length) {
        if (pageNo == 0 || length == 0) {
            return RevertResult.warn("pageNo或length参数为空");
        }
        EstherDetailDTO estherDetail = postService.findReplyEsther(postId, pageNo, length);
        if (estherDetail != null) {


        }
        return null;
    }

}

