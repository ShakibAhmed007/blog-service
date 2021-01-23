package com.dev.blogservice.comments;

import com.dev.blogservice.beans.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/comments")
public class CommentsController {

    @Autowired
    private CommentsService service;

    @GetMapping(value = "/comment/get/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getComment(@PathVariable("postId") String postId) throws Throwable{
        return ResponseEntity.ok(new ResponseDTO().success(service.getCommentByPostId(postId)));
    }

    @PostMapping(value = "/comment", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveComment(@RequestBody @Valid Comments comment) throws Throwable{
        service.save(comment);
        return ResponseEntity.ok(new ResponseDTO().success(comment));
    }

}
