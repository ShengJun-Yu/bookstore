package com.jun.conrtoller.until;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Bojack
 * @date : Created in 15:27 2022.11.06
 * 作为SpringMVC的异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public R doException(Exception e) {
        e.printStackTrace();
        return new R("服务器异常！！！");
    }
}
