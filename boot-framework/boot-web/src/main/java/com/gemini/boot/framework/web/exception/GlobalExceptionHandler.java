package com.gemini.boot.framework.web.exception;

import com.gemini.boot.framework.web.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public Message error(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Message.fail(e.getMessage());
    }
}
