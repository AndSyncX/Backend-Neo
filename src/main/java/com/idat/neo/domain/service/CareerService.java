package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Career;

import java.util.List;

public interface CareerService {

    List<Career> findAll();

    Career findById(Long id);

    List<Career> findActive();

    Career findByName(String name);

    Career save(Career career);

    Career update(Long id, Career career);

    void deleteById(Long id);
}
