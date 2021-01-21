package com.dev.blogservice.blogposts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BlogPostsRepository extends JpaRepository<BlogPosts, String> {

    @Query(value = "SELECT b FROM BlogPosts b")
    List<BlogPosts> getBlogPosts();
}
