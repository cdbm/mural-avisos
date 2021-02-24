package com.cdbm.restavisos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class NoticeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NoticeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(NoticeNotFoundException ex) {
        return ex.getMessage();
    }
}
