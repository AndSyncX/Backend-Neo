package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAll();
    Material findById(Long id);
    Material save(Material material, Long courseId);
    Material update(Long id, Material material, Long courseId);
}
