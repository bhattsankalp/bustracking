package com.project.Bus.bus.controller;

import com.project.Bus.bus.entity.Bus;
import com.project.Bus.bus.entity.BusVO;
import com.project.Bus.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping
    public List<BusVO> getBuses(){
        return busService.getAllBuses();
    }

    @PutMapping
    public Bus saveBuses( @RequestBody Bus bus ){
        return busService.saveBus( bus );
    }

}
