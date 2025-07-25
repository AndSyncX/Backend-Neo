package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDataRepository extends JpaRepository<TaskData, Long> {
}
