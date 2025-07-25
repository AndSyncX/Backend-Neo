package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import com.idat.neo.domain.service.MaterialService;
import jakarta.persistence.EntityNotFoundException;
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
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material update(Long id, Material material) {
        Material existing = materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material no encontrado con id: " + id));

        Material updatedMaterial = new Material(
                id,
                material.course(),
                material.title(),
                material.description(),
                material.firebaseFileUrl()
        );

        return materialRepository.save(updatedMaterial);
    }
}
