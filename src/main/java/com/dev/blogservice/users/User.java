package com.dev.blogservice.users;

import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    private Integer password;
}
