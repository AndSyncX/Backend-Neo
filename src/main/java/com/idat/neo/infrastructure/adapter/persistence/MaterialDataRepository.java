package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.MaterialData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialDataRepository extends JpaRepository<MaterialData, Long> {
}
