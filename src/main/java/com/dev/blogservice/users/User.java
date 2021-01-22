package com.dev.blogservice.users;

import com.dev.blogservice.model.MasterDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends MasterDTO {
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "CONTACT_NO", nullable = false)
    private String contactNo;
    @Column(name = "USER_TYPE", nullable = false)
    private String userType;
    @Column(name = "STATUS", nullable = false)
    private Integer status;
}
