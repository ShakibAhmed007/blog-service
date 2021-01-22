package com.dev.blogservice.votes;

import com.dev.blogservice.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotesRepository extends JpaRepository<Votes, String> {

    @Query(value = "SELECT v FROM Votes v WHERE v.postId=:postId")
    List<Votes> findVotesByPostId(@Param(value = "postId") String postId);

    @Query(value = "SELECT v FROM Votes v WHERE v.postId=:postId and v.createdBy = :createdBy")
    Votes findVotesByPostIdAndCreatedBy(@Param(value = "postId") String postId, @Param(value = "createdBy") String createdBy);
}
