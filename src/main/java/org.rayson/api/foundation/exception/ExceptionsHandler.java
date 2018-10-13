package org.rayson.api.foundation.exception;


import org.rayson.api.foundation.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午3:24
 *  Description:
 **/
@ControllerAdvice
public class ExceptionsHandler {

    private final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public HttpResponse handleBusinessException(BusinessException e) {
        logger.error("Error: {}", e.getMessage());
        return new HttpResponse(e.getCode(), e.getMessage());
    }

}
