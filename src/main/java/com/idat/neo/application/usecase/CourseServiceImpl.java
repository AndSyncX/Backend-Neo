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
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id " + id));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course existing = findById(id);

        Course updateCourse = new Course(
                existing.id(),
                course.name(),
                course.code(),
                course.credits(),
                course.active()
        );

        return courseRepository.update(id, updateCourse);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
