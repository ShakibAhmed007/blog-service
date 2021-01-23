package com.dev.blogservice.users;

import com.dev.blogservice.beans.ResponseDTO;
import com.dev.blogservice.beans.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping(value = "/user/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid UserDTO user) throws Throwable{
        return ResponseEntity.ok(new ResponseDTO().success(service.getUsers(user)));
    }

    @PostMapping(value = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody @Valid User user) throws Throwable{
        service.save(user);
        return ResponseEntity.ok(new ResponseDTO().success(user));
    }
}
