package com.example.demo.codetype.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.codetype.entity.CodeType;
import com.example.demo.codetype.repository.CodeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeTypeServiceImpl implements ICodeTypeService {

    @Autowired
    private CodeTypeRepository codeTypeRepository;

    @Override
    public List<CodeType> findByCodeType(String codeType) {
        if (StringUtil.isNullOrEmpty(codeType)) {
            throw new IllegalArgumentException("codeType is null or empty");
        }
        return codeTypeRepository.findByCodeType(codeType);
    }

    @Override
    public CodeType findByCodeId(String codeId) {
        if (StringUtil.isNullOrEmpty(codeId)) {
            throw new IllegalArgumentException("codeId is null or empty");
        }
        return codeTypeRepository.findByCodeId(codeId);
    }
}
