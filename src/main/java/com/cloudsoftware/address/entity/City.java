package com.cloudsoftware.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "number_plate", unique = true)
    private String numberPlate;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "postal_code", unique = true)
    private String postalCode;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    public City() {

    }

    public City(String name, Long countryId, String postalCode, String numberPlate){
        this.name = name;
        this.countryId = countryId;
        this.postalCode = postalCode;
        this.numberPlate = numberPlate;
    }

    public static City create(String name, Long countryId, String postalCode, String numberPlate) {
        return new City(name, countryId, postalCode, numberPlate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.nonNull(name)){
            this.name = name;
        }
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        if (Objects.nonNull(countryId)){
            this.countryId = countryId;
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (Objects.nonNull(postalCode)){
            this.postalCode = postalCode;
        }
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        if (Objects.nonNull(numberPlate)){
            this.numberPlate = numberPlate;
        }
    }
}
