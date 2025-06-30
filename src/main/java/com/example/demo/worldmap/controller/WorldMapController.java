package com.example.demo.worldmap.controller;

import com.example.demo.config.ApiResponse;
import com.example.demo.util.ResponseUtil;
import com.example.demo.worldmap.dto.CountryDto;
import com.example.demo.worldmap.service.IWorldMapService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/world-map")
public class WorldMapController {

    @Autowired
    private IWorldMapService worldMapService;

    @GetMapping("/detail/{countryId}")
    public ResponseEntity<ApiResponse<CountryDto>> getCountryDetail(@PathVariable("countryId") String countryId, HttpServletRequest request) {
        return ResponseEntity.ok(ResponseUtil.success(worldMapService.getCountryDetails(countryId), "", request.getRequestURI()));
    }
}
