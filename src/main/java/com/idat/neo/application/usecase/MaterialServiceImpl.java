package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import com.idat.neo.domain.service.MaterialService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material no encontrado con id: " + id));
    }

    @Override
    public Material save(Material material, Long scheduledCourseId) {
        return materialRepository.save(material, scheduledCourseId);
    }

    @Override
    public Material update(Long id, Material material, Long scheduledCourseId) {
        Material existing = findById(id);

        Material updateMaterial = new Material(
                existing.id(),
                material.scheduledCourse(),
                material.title(),
                material.description(),
                material.uploadDate(),
                material.fileUrl(),
                material.fileType(),
                material.isRequired()
        );

        return materialRepository.update(id, updateMaterial, scheduledCourseId);
    }

    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}
