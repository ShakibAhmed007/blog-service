package com.dev.blogservice.comments;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, String> {

    @Query(value = "SELECT c FROM Comments c WHERE c.postId=:postId and c.status = 1")
    List<Comments> findCommentsByPostId(@Param(value = "postId") String postId);
}
