package com.dev.blogservice.users;

import com.dev.blogservice.beans.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserModel getUsers(UserDTO user) {
        UserModel u = repository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        return u;
    }

    public void save(UserModel user) {
        repository.saveAndFlush(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
