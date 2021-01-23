package com.dev.blogservice.users;

import com.dev.blogservice.beans.ResponseModel;
import com.dev.blogservice.beans.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService service;

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> getUser(@RequestBody @Valid UserDTO user) throws Throwable{
        return ResponseEntity.ok(new ResponseModel().success(service.getUsers(user)));
    }
}
