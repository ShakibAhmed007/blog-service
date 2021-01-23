package com.dev.blogservice.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

    @Query(value = "SELECT u FROM UserModel u WHERE u.email = :email and u.password = :password and u.status = 1")
    UserModel findUserByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);
}
