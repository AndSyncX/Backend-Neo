package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.CareerCourseData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerCourseDataRepository extends JpaRepository<CareerCourseData, Long> {
}
