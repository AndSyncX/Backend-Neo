package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import com.idat.neo.domain.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> findById(Long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material update(Long id, Material material) {
        return materialRepository.update(id, material);
    }

    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}
