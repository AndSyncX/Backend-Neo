package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.CareerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerDataRepository extends JpaRepository<CareerData, Long> {
}
