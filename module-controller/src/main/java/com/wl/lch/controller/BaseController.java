package com.wl.lch.controller;

import com.wl.lch.util.ResultProcessor;
import com.wl.lch.util.RevertResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

        protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected RevertResult restProcessor(ResultProcessor processor) {
        RevertResult result = null;
        try {
            result = processor.process();
//        } catch (ServiceProcessException e1) {
//            logger.error("ServiceProcess Error Log :" + e1.getLocalizedMessage(), e1);
//            result = RevertResult.error(e1.getMessage());
        } catch (Exception e) {
            logger.error("Error Log :" + e.getLocalizedMessage(), e);
            result = RevertResult.error("服务器出现异常");
        }

        return result;
    }

}
