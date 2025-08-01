package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    List<User> findAllTeachers();

    List<User> findAllStudents();

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

    void updatePassword(Long id, String oldPassword, String newPassword);
}
