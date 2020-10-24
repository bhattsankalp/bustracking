package com.project.Bus.user.service;

import com.project.Bus.role.entity.Role;
import com.project.Bus.role.repository.RoleRepository;
import com.project.Bus.user.dto.UserVO;
import com.project.Bus.user.entity.User;
import com.project.Bus.user.repository.UserRepository;
import com.project.Bus.user.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<UserVO> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach( user -> users.add(user));
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach( role -> roles.add(role));
        List<UserVO> userVOs = populateRole( users, populateRoleIdToRoleMap( roles ) );
        return userVOs;

    }

    private Map< Integer, Role > populateRoleIdToRoleMap( List< Role > roles ){
        Map< Integer, Role > roleIdToRoleMap = new HashMap<>();
        for( Role role : roles ){
            roleIdToRoleMap.put( role.getRoleId(), role );
        }
        return roleIdToRoleMap;
    }

    private List<UserVO> populateRole( List< User > users, Map< Integer, Role > roleIdToRoleMap ){
        List<UserVO> userVOs = new ArrayList<>();
        for( User user: users ){
            UserVO userVO = null;
            if( roleIdToRoleMap.containsKey( user.getRoleId() ) ){
                userVO = new UserVO( user, roleIdToRoleMap.get( user.getRoleId() ) );
            }else{
                userVO = new UserVO( user, UserUtils.getDefaultRole() );
            }
            userVOs.add( userVO );
        }
        return userVOs;
    }
    public User getUserById( String userId){
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    public boolean authenticate( User user) {
        Optional<User> userFromDB = userRepository.findById( user.getUserId() );
        if( userFromDB.isPresent()
                && userFromDB.get().getUserName().equals(user.getUserName()) &&
                userFromDB.get().getPassword().equals(user.getPassword())){
            return true;
        }

        return false;
    }
}
