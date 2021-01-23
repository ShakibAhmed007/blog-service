package com.dev.blogservice.blogposts;

import com.dev.blogservice.beans.MasterDTO;
import com.dev.blogservice.votes.Votes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "blog_posts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogPosts extends MasterDTO{

    @Column(name = "POST_TITLE", nullable = false)
    private String postTitle;
    @Column(name = "POST_DESCRIPTION", columnDefinition = "TEXT")
    private String postDescription;
    @Column(name = "POST_STATUS", nullable = false)
    private Integer postStatus;

    @Transient
    private List<Votes> votes;


}
