package com.project.Bus.bus.util;

import com.project.Bus.role.entity.Role;

public class RoleUtils {

    public static Role getDefaultRole(){
        return new Role( 3, "Passenger", "view buses,view routes" );
    }
}
