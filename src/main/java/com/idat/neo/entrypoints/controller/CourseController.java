package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.service.CourseService;
import com.idat.neo.entrypoints.dto.CourseRequestDTO;
import com.idat.neo.entrypoints.dto.CourseResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.CourseDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseDtoMapper courseDtoMapper;

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO> response = courseService.findAll()
                .stream()
                .map(courseDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable("id") Long id){
        Course course = courseService.findById(id);
        return ResponseEntity.ok(courseDtoMapper.toDto(course));
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody @Valid CourseRequestDTO requestDTO) {
        Course courseToSave = courseDtoMapper.toDomain(requestDTO);
        Course savedCourse = courseService.save(courseToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseDtoMapper.toDto(savedCourse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id,
                                                      @RequestBody @Valid CourseRequestDTO requestDTO) {
        Course courseToUpdate = courseDtoMapper.toDomain(requestDTO);
        Course updatedCourse = courseService.update(id, courseToUpdate);
        return ResponseEntity.ok(courseDtoMapper.toDto(updatedCourse));
    }
}
