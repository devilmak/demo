package com.example.demo.worldmap.dto;

import com.example.demo.worldmap.entity.Country;
import lombok.Data;

@Data
public class CountryDto {

    private String countryId;

    private String countryName;

    private Integer studentPopulation;

    private Integer year;

    public void mapToDto(Country country) {
        this.countryId = country.getCountryId();
        this.countryName = country.getCountryName();
        this.studentPopulation = country.getStudentPopulation();
        this.year = country.getYear();
    }
}
