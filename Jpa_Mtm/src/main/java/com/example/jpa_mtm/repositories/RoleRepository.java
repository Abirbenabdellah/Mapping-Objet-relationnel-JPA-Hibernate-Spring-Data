package com.example.jpa_mtm.repositories;

import com.example.jpa_mtm.entities.Role;
import com.example.jpa_mtm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByNom(String nom);
}
