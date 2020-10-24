package com.project.Bus.role.controller;

import com.project.Bus.role.entity.Role;
import com.project.Bus.role.service.RoleService;
import com.project.Bus.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable("id") String id){
        return roleService.getRoleById( id );
    }

    @PutMapping
    public Role saveRole( @RequestBody Role role ){
        return roleService.saveRole( role );
    }

}
