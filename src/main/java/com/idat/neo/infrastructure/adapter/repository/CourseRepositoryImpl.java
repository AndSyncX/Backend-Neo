package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.CourseRepository;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.mapper.CourseMapper;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseDataRepository courseDataRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseDataRepository.findAll()
                .stream()
                .map(courseMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseDataRepository.findById(id)
                .map(courseMapper::toDomain);
    }

    @Override
    public Course save(Course course) {
        CourseData courseData = courseDataRepository.save(courseMapper.toEntity(course));
        return courseMapper.toDomain(courseData);
    }
}
