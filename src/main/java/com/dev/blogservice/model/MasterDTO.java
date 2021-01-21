package com.dev.blogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterDTO {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false)
    private String id;

    @JsonIgnore
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private String createdBy;

    @JsonIgnore
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON", nullable = false, updatable = false)
    @CreatedDate
    @JsonIgnore
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON", nullable = true)
    @LastModifiedDate
    @JsonIgnore
    private Date updatedOn;
}
