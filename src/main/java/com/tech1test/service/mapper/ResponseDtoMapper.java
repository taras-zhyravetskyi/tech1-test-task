package com.tech1test.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}