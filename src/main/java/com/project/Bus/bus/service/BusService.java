package com.project.Bus.bus.service;

import com.project.Bus.bus.entity.Bus;
import com.project.Bus.bus.entity.BusVO;
import com.project.Bus.bus.repository.BusRepository;
import com.project.Bus.bus.util.RoleUtils;
import com.project.Bus.route.entity.Route;
import com.project.Bus.route.repository.RouteRepository;
import com.project.Bus.route.util.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;

    @Autowired
    RouteRepository routeRepository;

    public List<BusVO> getAllBuses(){
        List<BusVO> buseVOs = new ArrayList<>();
        List<Route> routes = new ArrayList<>();
        routeRepository.findAll().forEach( route -> routes.add(route) );
        Map<String, Route> routeIdToRoute = populateRouteIdToRouteMap( routes );
        busRepository.findAll().forEach( bus -> {
            BusVO busVO;
            if( routeIdToRoute.containsKey( bus.getRouteId() ) ){
                busVO = new BusVO( bus, routeIdToRoute.get( bus.getRouteId()) );
            }else{
                busVO = new BusVO( bus, RouteUtils.getDefaultRoute() );
            }

            buseVOs.add( busVO );
        });

        return buseVOs;
    }

    private Map<String, Route> populateRouteIdToRouteMap(List<Route> routes ){
        Map<String, Route> routeIdToRoute = new HashMap<>();
        for( Route route: routes ){
            routeIdToRoute.put( route.getRouteId(), route );
        }
        return routeIdToRoute;
    }

    public Bus getBusById( Integer busId){
        Optional<Bus> bus = busRepository.findById(busId);
        return bus.get();
    }

    public Bus saveBus( Bus bus ){
        return busRepository.save( bus );
    }

}
