package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.CareerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CareerDataRepository extends JpaRepository<CareerData, Long> {

    List<CareerData> findByActiveTrue();

    @Query("SELECT c FROM CareerData c WHERE LOWER(c.name) = LOWER(:name)")
    Optional<CareerData> findByNameIgnoreCase(@Param("name") String name);
}
