package com.project.Bus.user.util;

import com.project.Bus.role.entity.Role;

public class UserUtils {

    public static Role getDefaultRole(){
        return new Role( 3, "Passenger", "view buses,view routes" );
    }
}
