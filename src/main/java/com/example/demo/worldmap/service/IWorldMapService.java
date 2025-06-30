package com.example.demo.worldmap.service;

import com.example.demo.worldmap.dto.CountryDto;

public interface IWorldMapService {

    public CountryDto getCountryDetails(String countryId);
}
