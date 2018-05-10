package com.wl.lch.controller.routerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author LHR
 * Create By 2017/9/4
 */
@RequestMapping("/label")
@Controller
public class LabelController {

    @RequestMapping("/detail")
    public String getLabelDetail() {
        return "label/detail";
    }

}
