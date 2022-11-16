package com.example.companytracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConverterService {
    private final ConversionService conversionService;

    public <T> T convert(Object source, Class<T> targetType) {
        return conversionService.convert(source, targetType);
    }
}
