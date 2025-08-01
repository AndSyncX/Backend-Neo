package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.CourseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseDataRepository extends JpaRepository<CourseData, Long> {

    List<CourseData> findByActiveTrue();

    @Query("SELECT c FROM CourseData c WHERE LOWER(c.name) = LOWER(:name)")
    Optional<CourseData> findByNameIgnoreCase(@Param("name") String name);
}
