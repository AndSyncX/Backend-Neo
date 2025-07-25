package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.entity.MaterialData;
import com.idat.neo.infrastructure.adapter.mapper.MaterialMapper;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.MaterialDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MaterialRepositoryImpl implements MaterialRepository {

    private final MaterialDataRepository materialDataRepository;
    private final CourseDataRepository courseDataRepository;
    private final MaterialMapper materialMapper;

    @Override
    public List<Material> findAll() {
        return materialDataRepository.findAll()
                .stream()
                .map(materialMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Material> findById(Long id) {
        return materialDataRepository.findById(id)
                .map(materialMapper::toDomain);
    }

    @Override
    public Material save(Material material, Long courseId) {
        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        MaterialData materialData = materialMapper.toEntity(material);
        materialData.setCourseData(courseData);

        MaterialData saved = materialDataRepository.save(materialData);
        return materialMapper.toDomain(saved);
    }

    @Override
    public Material update(Long id, Material material, Long courseId) {
        MaterialData existingMaterialData = materialDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + id));

        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        existingMaterialData.setCourseData(courseData);
        existingMaterialData.setTitle(material.title());
        existingMaterialData.setDescription(material.description());
        existingMaterialData.setFirebaseFileUrl(material.firebaseFileUrl());

        MaterialData updatedMaterialData = materialDataRepository.save(existingMaterialData);
        return materialMapper.toDomain(updatedMaterialData);
    }
}
