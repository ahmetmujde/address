package com.cloudsoftware.address.repository;

import com.cloudsoftware.address.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(nativeQuery = true, value = "select count(*) > 0 from country where name = ?1 or short_name = ?2")
    boolean isCountryInformationUnique(String name, String shortName);

    @Query(nativeQuery = true, value = "select count(*) > 0 from country where id != ?1 and (name = ?2 or short_name = ?3)")
    boolean isCountryInformationUnique(Long id, String name, String shortName);
}
