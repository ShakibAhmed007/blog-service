package com.dev.blogservice.beans;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ResponseModel<T> {

    private int status;
    private String message;
    private T data;

    public ResponseModel success(T data) {
        ResponseModel obj = new ResponseModel();
        obj.status = HttpStatus.OK.value();
        obj.data = data;
        return obj;
    }
}
