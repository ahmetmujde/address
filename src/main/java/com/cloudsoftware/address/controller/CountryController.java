package com.cloudsoftware.address.controller;

import com.cloudsoftware.address.dto.request.CreateCountryRequest;
import com.cloudsoftware.address.dto.request.UpdateCountryRequest;
import com.cloudsoftware.address.entity.Country;
import com.cloudsoftware.address.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country create(@RequestBody CreateCountryRequest createCountryRequest) {
        return countryService.create(createCountryRequest);
    }

    @GetMapping
    private List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("{id}")
    private Country getCountryById(@PathVariable("id") Long id) {
        return countryService.getCountryById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    private void deleteById(@PathVariable("id") Long id) {
        countryService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    private void updateById(@PathVariable("id") Long id, @RequestBody UpdateCountryRequest updateCountryRequest) {
        countryService.updateById(id,updateCountryRequest);
    }
}
