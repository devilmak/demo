package com.example.demo.worldmap.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.worldmap.dto.CountryDto;
import com.example.demo.worldmap.entity.Country;
import com.example.demo.worldmap.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldMapServiceImpl implements IWorldMapService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryDto getCountryDetails(String countryId) {
        if (StringUtil.isNullOrEmpty(countryId)) {
            throw new IllegalArgumentException("countryId is null");
        }

        Country country = countryRepository.findByCountryId(countryId);
        CountryDto countryDto = new CountryDto();
        countryDto.mapToDto(country);

        return countryDto;
    }
}
