package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by PD on 2017/5/3.
 */
public interface UserRepository extends JpaRepository<User, String> {

    User save(User user);
    User findByUsername(String username);
}
