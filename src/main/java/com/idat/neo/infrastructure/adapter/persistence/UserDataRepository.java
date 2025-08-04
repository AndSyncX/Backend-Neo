package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    Optional<UserData> findByEmail(String email);

    //Optional<UserData> findByName(String firstName);

    @Query("SELECT u FROM UserData u WHERE u.role = 'TEACHER'")
    List<UserData> findAllTeachers();

    @Query("SELECT u FROM UserData u WHERE u.role = 'STUDENT'")
    List<UserData> findAllStudents();
}
