package com.example.demo.codetype.repository;

import com.example.demo.codetype.entity.CodeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeTypeRepository extends JpaRepository<CodeType, Integer> {

    List<CodeType> findByCodeType(String code);

    CodeType findByCodeId(String codeId);
}
