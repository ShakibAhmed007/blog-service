package com.dev.blogservice.votes;

import com.dev.blogservice.beans.MasterDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "votes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Votes  extends MasterDTO {

    @Column(name = "POST_ID", nullable = false)
    private String postId;
    @Column(name = "UPVOTE", nullable = false)
    private String upVote;
    @Column(name = "DOWNVOTE", nullable = false)
    private Integer downVote;
}
