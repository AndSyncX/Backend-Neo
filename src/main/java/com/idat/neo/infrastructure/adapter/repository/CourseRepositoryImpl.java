package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.CourseRepository;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.mapper.CourseMapper;
import com.idat.neo.infrastructure.adapter.persistence.UserDataRepository;
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
    private final UserDataRepository userDataRepository;
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
    public Course save(Course course, String userId) {
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        CourseData courseData = courseMapper.toEntity(course);
        courseData.setUserData(userData);

        CourseData saved = courseDataRepository.save(courseData);
        return courseMapper.toDomain(saved);
    }

    @Override
    public Course update(Long id, Course course, String userId) {
        CourseData existingCourseData = courseDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + id));

        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        existingCourseData.setName(course.name());
        existingCourseData.setDescription(course.description());
        existingCourseData.setUserData(userData);
        existingCourseData.setStartDate(course.startDate());
        existingCourseData.setEndDate(course.endDate());

        CourseData updatedCourseData = courseDataRepository.save(existingCourseData);
        return courseMapper.toDomain(updatedCourseData);
    }
}
