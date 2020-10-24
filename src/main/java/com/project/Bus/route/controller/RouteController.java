package com.project.Bus.route.controller;

import com.project.Bus.route.entity.Route;
import com.project.Bus.route.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    @GetMapping
    public List<Route> getRoutes(){
        return routeService.getAllRoutes();

    }

    @PutMapping
    public Route saveRoute( @RequestBody Route route ){
        return routeService.saveRoute( route );
    }

}
