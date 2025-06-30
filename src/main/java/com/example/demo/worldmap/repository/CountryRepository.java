package com.example.demo.worldmap.repository;

import com.example.demo.worldmap.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCountryId(String countryId);
}
