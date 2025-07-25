package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.service.CourseService;
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

    @GetMapping
    ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Course> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping
    ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(courseService.save(course));
    }

    @PutMapping("/{id}")
    ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(courseService.update(id, course));
    }
}
