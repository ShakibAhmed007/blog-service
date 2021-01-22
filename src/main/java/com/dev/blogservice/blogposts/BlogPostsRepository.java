package com.dev.blogservice.blogposts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPosts, String> {

    @Query(value = "SELECT b FROM BlogPosts b WHERE b.postStatus = 1 order by b.createdOn desc")
    List<BlogPosts> findAllByOrder();
}
