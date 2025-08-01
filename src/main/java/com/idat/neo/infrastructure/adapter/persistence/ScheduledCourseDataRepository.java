package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.ScheduledCourseData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledCourseDataRepository extends JpaRepository<ScheduledCourseData, Long> {
}
