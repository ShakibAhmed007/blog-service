package com.dev.blogservice.comments;

import com.dev.blogservice.beans.MasterDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments extends MasterDTO {

    @Column(name = "POST_ID", nullable = false)
    private String postId;
    @Column(name = "COMMENT", columnDefinition = "TEXT")
    private String comment;
    @Column(name = "STATUS", nullable = false)
    private Integer status;
}
