package com.idat.neo.domain.service;

import com.idat.neo.domain.model.User;
import com.idat.neo.entrypoints.dto.PasswordUpdateDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findAllTeachers();

    List<User> findAllStudents();

    User findById(Long id);

    User findByName(String name);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

    void updatePassword(Long id, PasswordUpdateDTO dto);
}
