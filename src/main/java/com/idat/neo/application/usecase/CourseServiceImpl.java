package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.CourseRepository;
import com.idat.neo.domain.service.CourseService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + id));
    }

    @Override
    public Course save(Course course, Long userId) {
        return courseRepository.save(course, userId);
    }

    @Override
    public Course update(Long id, Course course, Long userId) {
        Course existingCourse = findById(id);

        Course updatedCourse = new Course(
                existingCourse.id(),
                course.name(),
                course.description(),
                course.user(),
                course.startDate(),
                course.endDate()
        );

        return courseRepository.update(id, updatedCourse, userId);
    }
}
