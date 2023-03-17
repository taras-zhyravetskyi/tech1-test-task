package com.tech1test.service.mapper;

import com.tech1test.entity.Color;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        return Color.valueOf(source.toUpperCase());
    }
}
