package com.dev.blogservice.login;

import com.dev.blogservice.beans.ResponseDTO;
import com.dev.blogservice.beans.UserDTO;
import com.dev.blogservice.users.UserService;
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
    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid UserDTO user) throws Throwable{
        return ResponseEntity.ok(new ResponseDTO().success(service.getUsers(user)));
    }
}
