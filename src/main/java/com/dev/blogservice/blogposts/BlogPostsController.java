package com.dev.blogservice.blogposts;

import com.dev.blogservice.beans.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/blog-posts")
public class BlogPostsController {

    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping(value = "/post/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getBlogPosts() throws Throwable {
        return ResponseEntity.ok(new ResponseDTO().success(blogPostsService.getBlogPostsList()));
    }

    @GetMapping(value = "/post/get/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getBlog(@PathVariable("postId") String postId) throws Throwable{
        return ResponseEntity.ok(new ResponseDTO().success(blogPostsService.getBlogPostById(postId)));
    }

    @PostMapping(value = "/post", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveBlog(@RequestBody @Valid BlogPosts post) throws Throwable{
        blogPostsService.save(post);
        return ResponseEntity.ok(new ResponseDTO().success(post));
    }

    @DeleteMapping(value = "/post/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> deleteBlog(@PathVariable("postId") String postId) throws Throwable{
        blogPostsService.delete(postId);
        return ResponseEntity.ok(new ResponseDTO().success(postId));
    }





}
