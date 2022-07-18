package com.cloudsoftware.address.controller;

import com.cloudsoftware.address.dto.request.CreateCityRequest;
import com.cloudsoftware.address.entity.City;
import com.cloudsoftware.address.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    private List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody CreateCityRequest createCityRequest){
        return cityService.create(createCityRequest);
    }
}
