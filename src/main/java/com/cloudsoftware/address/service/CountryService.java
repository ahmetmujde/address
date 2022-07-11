package com.cloudsoftware.address.service;

import com.cloudsoftware.address.dto.request.CreateCountryRequest;
import com.cloudsoftware.address.dto.request.UpdateCountryRequest;
import com.cloudsoftware.address.entity.Country;
import com.cloudsoftware.address.exception.customexception.CountryAlreadyExistException;
import com.cloudsoftware.address.exception.customexception.CountryNotFoundException;
import com.cloudsoftware.address.repository.CountryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        Sort.Order sortByName = Sort.Order.asc("name");
        return countryRepository.findAll(Sort.by(sortByName));
    }

    public Country getCountryById(long id) {
        return getById(id)
                .orElseThrow(CountryNotFoundException::new);
    }

    public void deleteById(long id) {
        countryRepository.deleteById(id);
    }

    public Country create(CreateCountryRequest createCountryRequest) {
        String name = createCountryRequest.getName();
        String shortName = createCountryRequest.getShortName();

        Country country = Country.create(name, shortName);

        validateCountryInformationIsUnique(country);

        return countryRepository.save(country);
    }

    public void updateById(Long id, UpdateCountryRequest updateCountryRequest) {
        String name = updateCountryRequest.getName();
        String shortName = updateCountryRequest.getShortName();

        Country country = getCountryById(id);
        country.setName(name);
        country.setShortName(shortName);
        country.setUpdatedDate(new Date());

        validateCountryInformationIsUnique(country);

        countryRepository.save(country);
    }

    private void validateCountryInformationIsUnique(Country country) {
        boolean countryPropertySame = isCreateOperation(country) ?
                countryRepository.isCountryInformationUnique(country.getName(), country.getShortName()) :
                countryRepository.isCountryInformationUnique(country.getId(), country.getName(), country.getShortName());

        if (countryPropertySame) {
            throw new CountryAlreadyExistException();
        }
    }

    private boolean isCreateOperation(Country country) {
        return Objects.isNull(country.getId());
    }

    private Optional<Country> getById(long id) {
        return countryRepository.findById(id);
    }
}
