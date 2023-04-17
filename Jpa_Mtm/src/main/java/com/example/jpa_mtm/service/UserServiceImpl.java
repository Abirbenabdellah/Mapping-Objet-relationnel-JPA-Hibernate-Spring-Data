package com.example.jpa_mtm.service;

import com.example.jpa_mtm.entities.Role;
import com.example.jpa_mtm.entities.User;
import com.example.jpa_mtm.repositories.RoleRepository;
import com.example.jpa_mtm.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
    @Override
    public Role addNewRole(Role role) {
        return  roleRepository.save(role);
    }
    @Override
    public User findUserByName(String username) {

        return userRepository.findByUsername(username);
    }
    @Override
    public Role findRoleByName(String nom) {
        return roleRepository.findByNom(nom);
    }
    @Override
    public void  addRoleToUser(String username, String nom) {

        User user=findUserByName(username);
        Role role=findRoleByName(nom);
        user.getRoles().add(role);
        role.getUsers().add(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user=userRepository.findByUsername(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        throw  new RuntimeException("erroné");
    }
}
