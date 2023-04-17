package com.example.jpa_mtm.repositories;

import com.example.jpa_mtm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
