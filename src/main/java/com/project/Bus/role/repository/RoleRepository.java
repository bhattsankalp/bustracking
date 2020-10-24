package com.project.Bus.role.repository;

import com.project.Bus.role.entity.Role;
import com.project.Bus.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//WHat have I done?
//Created a class and annotated it with anotation Repository
@Repository
public interface RoleRepository extends CrudRepository<Role,String> {

}
