package com.idat.neo.domain.service;

import com.idat.neo.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User save(User user);
    User update(String id, User user);
    void deleteById(String id);
}
