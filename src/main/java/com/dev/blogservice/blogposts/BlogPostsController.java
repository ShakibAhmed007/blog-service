package com.dev.blogservice.blogposts;

import com.dev.blogservice.beans.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/blog-posts")
public class BlogPostsController {

    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping(value = "/get-list")
    public List<BlogPosts> getDashboardList(Pageable pageable) throws Throwable {
        return blogPostsService.getBlogPostsList();
    }

}
