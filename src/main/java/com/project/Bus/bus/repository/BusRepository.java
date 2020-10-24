package com.project.Bus.bus.repository;

import com.project.Bus.bus.entity.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends CrudRepository<Bus,Integer> {

}
