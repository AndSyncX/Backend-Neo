package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.CourseRepository;
import com.idat.neo.domain.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
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
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + id));

        Course updatedCourse = new Course(
                id,
                course.name(),
                course.description(),
                course.user(),
                course.startDate(),
                course.endDate()
        );

        return courseRepository.save(updatedCourse);
    }

}
