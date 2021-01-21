package com.dev.blogservice.beans;

import com.dev.blogservice.blogposts.BlogPosts;
import liquibase.pro.packaged.T;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseModel {

    private int status;
    private String message;
    private List<BlogPosts> data;

    public ResponseModel success(List<BlogPosts> data) {
        ResponseModel obj = new ResponseModel();
        obj.status = HttpStatus.OK.value();
        obj.data = data;
        return obj;
    }
}
