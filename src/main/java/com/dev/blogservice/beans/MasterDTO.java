package com.dev.blogservice.beans;

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

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @JsonIgnore
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Basic(optional = false)
    @Column(name = "CREATED_ON", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    @LastModifiedDate
    @JsonIgnore
    private Date updatedOn;


}
