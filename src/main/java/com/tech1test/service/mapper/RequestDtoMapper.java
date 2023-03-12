package com.tech1test.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToEntity(D dto);
}