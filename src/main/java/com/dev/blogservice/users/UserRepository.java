package com.dev.blogservice.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u FROM User u WHERE u.email = :email and u.password = :password and u.status = 1")
    User findUserByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);
}
