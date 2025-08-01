package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository {

    List<Material> findAll();

    Optional<Material> findById(Long id);

    Material save(Material material, Long scheduledCourseId);

    Material update(Long id, Material material, Long scheduledCourseId);

    void deleteById(Long id);
}
