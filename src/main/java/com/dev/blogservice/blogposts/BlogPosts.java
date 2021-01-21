package com.dev.blogservice.blogposts;

import com.dev.blogservice.model.MasterDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "blog_posts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogPosts extends MasterDTO {
    @NotNull
    @Column(name = "POST_TITLE")
    private String postTitle;
    @Column(name = "POST_DESCRIPTION", columnDefinition = "TEXT")
    private String postDescription;
    @Column(name = "POST_STATUS")
    private Integer postStatus;

}
