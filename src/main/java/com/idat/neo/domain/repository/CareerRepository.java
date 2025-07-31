package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Career;

import java.util.List;
import java.util.Optional;

public interface CareerRepository {
    List<Career> findAll();
    Optional<Career> findById(Long id);
    Career save(Career career);
    Career update(Long id, Career career);
    void deleteById(Long id);
}
