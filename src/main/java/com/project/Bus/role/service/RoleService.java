package com.project.Bus.role.service;

import com.project.Bus.role.entity.Role;
import com.project.Bus.role.repository.RoleRepository;
import com.project.Bus.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach( role -> roles.add(role));
        return roles;

    }

    public Role getRoleById( String roleId){
        Optional<Role> role = roleRepository.findById(roleId);
        return role.get();
    }

    public Role saveRole( Role role ){
        return roleRepository.save( role );
    }
}
