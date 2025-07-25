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
    public Material save(Material material, Long courseId) {
        return materialRepository.save(material, courseId);
    }

    @Override
    public Material update(Long id, Material material, Long courseId) {
        Material existingMaterial = findById(id);

        Material updatedMaterial = new Material(
                existingMaterial.id(),
                material.course(),
                material.title(),
                material.description(),
                material.firebaseFileUrl()
        );

        return materialRepository.update(id, updatedMaterial, courseId);
    }
}
