package com.dev.blogservice.comments;

import com.dev.blogservice.beans.ResponseModel;
import com.dev.blogservice.blogposts.BlogPosts;
import com.dev.blogservice.blogposts.BlogPostsService;
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

//    @GetMapping(value = "/comment/get", produces= MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> getComments() throws Throwable {
//        return ResponseEntity.ok(new ResponseModel().success(service.getCommentsList()));
//    }

    @GetMapping(value = "/comment/get/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> getComment(@PathVariable("postId") String postId) throws Throwable{
        return ResponseEntity.ok(new ResponseModel().success(service.getCommentByPostId(postId)));
    }

    @PostMapping(value = "/comment", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> saveComment(@RequestBody @Valid Comments comment) throws Throwable{
        service.save(comment);
        return ResponseEntity.ok(new ResponseModel().success(comment));
    }

//    @DeleteMapping(value = "/comment/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> deleteComment(@PathVariable("postId") String postId) throws Throwable{
//        service.delete(postId);
//        return ResponseEntity.ok(new ResponseModel().success(commentId));
//    }

}
