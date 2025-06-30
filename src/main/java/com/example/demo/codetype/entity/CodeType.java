package com.example.demo.codetype.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "CD_TYPE")
@Entity
@Data
public class CodeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CD_TYPE")
    private String codeType;

    @Column(name = "CD_ID")
    private String codeId;

    @Column(name = "CD_DESC")
    private String codeDescription;
}
