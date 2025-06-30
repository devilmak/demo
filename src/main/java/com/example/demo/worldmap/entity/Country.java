package com.example.demo.worldmap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "COUNTRY")
@Entity
@Data
public class Country {

    @Id
    private Long id;

    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "student_pop")
    private Integer studentPopulation;

    @Column(name = "year")
    private Integer year;
}
