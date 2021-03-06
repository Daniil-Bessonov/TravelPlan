package com.netcracker.travelplanner.service;

import com.netcracker.travelplanner.entities.newKiwi.MyAirport;
import com.netcracker.travelplanner.repository.AirportsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportRepoService {

    @Autowired
    private AirportsRepo airportsRepo;

    public MyAirport getMyAirport(String city){
        return airportsRepo.myFind(city);
    }

    public String getIataCode(String city){
        MyAirport airport = airportsRepo.myFind(city);
        return airport != null ? airport.getCode() : "-1";
    }

    public List<Double> getLatLong(String iataCode,String type){
        List<Double> list = new ArrayList<>();
        MyAirport airport = airportsRepo.getByCodeAndType(iataCode,type);
        if(airport != null){
            list.add(airport.getLat());
            list.add(airport.getLon());}
        return list;
    }

}
