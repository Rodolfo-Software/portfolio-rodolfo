package com.rodolfo.taskmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name")
    private String name;

    // @Column(name = "CountryCode")
    // private String countryCode;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private Integer population;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // public String getCountryCode() { return countryCode; }
    // public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }
}
