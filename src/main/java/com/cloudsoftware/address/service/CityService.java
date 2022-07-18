package com.cloudsoftware.address.service;

import com.cloudsoftware.address.dto.request.CreateCityRequest;
import com.cloudsoftware.address.entity.City;
import com.cloudsoftware.address.exception.customexception.CityAlreadyExistException;
import com.cloudsoftware.address.repository.CityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(CreateCityRequest createCityRequest){
        String name = createCityRequest.getName();
        Long countryId = createCityRequest.getCountryId();
        String postalCode = createCityRequest.getPostalCode();
        String numberPlate = createCityRequest.getNumberPlate();

        City city = City.create(name, countryId, postalCode, numberPlate);

        boolean isCityNonUnique = cityRepository.isCityInformationUnique(name, postalCode, numberPlate);

        if (isCityNonUnique) {
            throw new CityAlreadyExistException();
        }

        return cityRepository.save(city);
    }

    public List<City> getAllCity() {
        Sort.Order sortByName = Sort.Order.asc("name");
        return cityRepository.findAll(Sort.by(sortByName));
    }

}
