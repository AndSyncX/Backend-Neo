package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.repository.MaterialRepository;
import com.idat.neo.infrastructure.adapter.entity.MaterialData;
import com.idat.neo.infrastructure.adapter.mapper.MaterialMapper;
import com.idat.neo.infrastructure.adapter.persistence.MaterialDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MaterialRepositoryImpl implements MaterialRepository {
    
    private final MaterialDataRepository materialDataRepository;
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
    public Material save(Material material) {
        MaterialData materialData = materialDataRepository.save(materialMapper.toEntity(material));
        return materialMapper.toDomain(materialData);
    }
}
