package com.dev.blogservice.beans;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ResponseDTO<T> {

    private int status;
    private String message;
    private T data;

    public ResponseDTO success(T data) {
        ResponseDTO obj = new ResponseDTO();
        obj.status = HttpStatus.OK.value();
        obj.data = data;
        return obj;
    }
}
