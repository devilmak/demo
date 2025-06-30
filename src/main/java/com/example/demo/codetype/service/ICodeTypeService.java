package com.example.demo.codetype.service;

import com.example.demo.codetype.entity.CodeType;

import java.util.List;

public interface ICodeTypeService {
    public List<CodeType> findByCodeType(String codeType);

    public CodeType findByCodeId(String codeId);
}
