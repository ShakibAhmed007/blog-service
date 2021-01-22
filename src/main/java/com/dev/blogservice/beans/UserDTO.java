package com.dev.blogservice.beans;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {

    private String email;
    private String password;
}
