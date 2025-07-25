package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MaterialRepositoryImpl implements MaterialRepository {
    @Override
    public List<Material> findAll() {
        return List.of();
    }

    @Override
    public Optional<Material> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Material save(Material material) {
        return null;
    }
}
