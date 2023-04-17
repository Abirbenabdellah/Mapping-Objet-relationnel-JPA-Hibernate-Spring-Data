package com.example.jpa_mtm.service;

import com.example.jpa_mtm.entities.Role;
import com.example.jpa_mtm.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByName(String username);
    Role findRoleByName(String rolename);
    void addRoleToUser(String username,String rolename);

    User authenticate(String username,String password);

}
