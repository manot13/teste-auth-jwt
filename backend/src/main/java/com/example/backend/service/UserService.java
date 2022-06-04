package com.example.backend.service;

import com.example.backend.entity.Role;
import com.example.backend.entity.UserR;
import com.example.backend.repository.RoleRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserR registerNewUser(UserR userR){
        return userRepository.save(userR);
    }

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User role for newly created record");
        roleRepository.save(userRole);

        UserR adminUSer = new UserR();
        adminUSer.setUserFirstName("admin");
        adminUSer.setUserLastName("admin");
        adminUSer.setUserName("admin123");
        adminUSer.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUSer.setRole(adminRoles);
        userRepository.save(adminUSer);

        UserR userR = new UserR();
        userR.setUserFirstName("raj");
        userR.setUserLastName("sharma");
        userR.setUserName("raj123");
        userR.setUserPassword("raj@pass");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        userR.setRole(userRoles);
        userRepository.save(userR);
    }
}
