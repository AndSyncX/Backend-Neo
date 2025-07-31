package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.CourseRepository;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.mapper.CourseMapper;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import jakarta.persistence.EntityNotFoundException;
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
        CourseData courseData = courseMapper.toEntity(course);
        courseData.setActive(true);
        CourseData saved = courseDataRepository.save(courseData);
        return courseMapper.toDomain(saved);
    }

    @Override
    public Course update(Long id, Course course) {
        CourseData existing = courseDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrada con id: " + id));

        existing.setName(course.name());
        existing.setCode(course.code());
        existing.setCredits(course.credits());
        existing.setActive(course.active());

        CourseData update = courseDataRepository.save(existing);
        return courseMapper.toDomain(update);
    }

    @Override
    public void deleteById(Long id) {
        CourseData existing = courseDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrada con id: " + id));

        existing.setActive(false);
        courseDataRepository.save(existing);
    }
}
