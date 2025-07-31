package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.CareerCourse;
import com.idat.neo.domain.repository.CareerCourseRepository;
import com.idat.neo.domain.service.CareerCourseService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerCourseServImpl implements CareerCourseService {

    private CareerCourseRepository careerCourseRepository;

    @Override
    public List<CareerCourse> findAll() {
        return List.of();
    }

    @Override
    public CareerCourse findById(Long id) {
        return careerCourseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CursoCarrera no encontrado con id " + id));
    }

    @Override
    public CareerCourse save(CareerCourse careerCourse, Long courseId, Long careerId) {
        return careerCourseRepository.save(careerCourse, courseId, careerId);
    }

    @Override
    public CareerCourse update(Long id, CareerCourse careerCourse, Long courseId, Long careerId) {
        CareerCourse existing = findById(id);

        CareerCourse updateCareerCourse = new CareerCourse(
                existing.id(),
                careerCourse.career(),
                careerCourse.course(),
                careerCourse.isMandatory()
        );

        return careerCourseRepository.update(id, updateCareerCourse, courseId, careerId);
    }

    @Override
    public void deleteById(Long id) {
        careerCourseRepository.deleteById(id);
    }
}
