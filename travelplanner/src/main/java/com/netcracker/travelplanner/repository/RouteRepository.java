package com.netcracker.travelplanner.repository;

import com.netcracker.travelplanner.entities.Route;
import com.netcracker.travelplanner.entities.RouteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findByStartPointIsAndDestinationPointIs(String s, String d);
    List<Route> findByStartPointIsOrDestinationPointIs(String s, String d);
    List<Route> findByRouteTypeIs(RouteType routeType);
    List<Route> findByUserId(Integer id);
}
