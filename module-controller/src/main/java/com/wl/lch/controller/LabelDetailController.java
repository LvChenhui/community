package com.wl.lch.controller;


import com.wl.lch.dto.EstherDTO;
import com.wl.lch.entity.Label;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.service.LabelService;
import com.wl.lch.util.RevertResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("label")
public class LabelDetailController {

    @Resource
    private LabelService labelService;

    @RequestMapping(value = "findLabels", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult findLabels() {
        return RevertResult.ok(labelService.findLabels());
    }

    @RequestMapping(value = "findLabelDetail/{labelId}", method = RequestMethod.GET)
    @ResponseBody
    public RevertResult findLabelDetail(@PathVariable("labelId") int labelId, int pageNo, int length) {
        if (labelId == 0 || pageNo == 0 || length == 0) {
            return RevertResult.warn("pageNo或length参数为空！");
        }
        List<EstherDTO> esthers = labelService.findPostByLabel(labelId, pageNo, length);
        int pageSize = labelService.sumPageSizeByLabel(labelId);
        return RevertResult.ok("success",esthers,pageSize,length);
    }
}
