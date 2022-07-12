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
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "short_name", nullable = false, unique = true, length = 5)
    private String shortName;

    @Column(name = "area_code", nullable = false, unique = true)
    private Long areaCode;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    public Country() {

    }

    public Country(String name, String shortName, Long areaCode) {
        this.name = name;
        this.shortName = shortName;
        this.areaCode = areaCode;
    }

    public static Country create(String name, String shortName, Long areaCode) {
        return new Country(name, shortName, areaCode);
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
        if (Objects.nonNull(name)) {
            this.name = name;
        }
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        if (Objects.nonNull(shortName)) {
            this.shortName = shortName;
        }
    }

    public Long getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Long areaCode) {
        if (Objects.nonNull(areaCode)) {
            this.areaCode = areaCode;
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
}
