package com.cloudsoftware.address.repository;

import com.cloudsoftware.address.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository <City, Long>{
    @Query(nativeQuery = true, value = "select count(*) > 0 from " +
            "city where name = ?1 or postal_code = ?2 or number_plate = ?3")
    boolean isCityInformationUnique(String name, String postalCode, String number_plate);
}
