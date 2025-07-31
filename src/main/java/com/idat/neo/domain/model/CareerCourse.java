package com.idat.neo.domain.model;

public record CareerCourse(
        Long id,
        Career career,
        Course course,
        boolean isMandatory // -> Es obligatorio
) {
}
