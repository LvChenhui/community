package com.wl.lch.exception;

import com.wl.lch.controller.PostController;
import com.wl.lch.util.RevertResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    RevertResult handleException(Exception e){
        logger.error(e.getMessage(), e);
        return RevertResult.error("系统异常！");
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    RevertResult handleBusinessException(BusinessException e){
        logger.error(e.getMessage(), e);
        return RevertResult.error(e.getMessage());
    }
}
