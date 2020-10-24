package com.project.Bus.route.repository;

import com.project.Bus.bus.entity.Bus;
import com.project.Bus.route.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends CrudRepository<Route,String> {

}
