package com.dev.blogservice.blogposts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostsService {

    @Autowired
    private BlogPostsRepository repository;

    public List<BlogPosts> getBlogPostsList() {
        List<BlogPosts> data = repository.getBlogPosts();
        return data;
    }
}
