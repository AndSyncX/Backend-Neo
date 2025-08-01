package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.repository.UserRepository;
import com.idat.neo.domain.service.UserService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllTeachers() {
        return userRepository.findAllTeachers();
    }

    @Override
    public List<User> findAllStudents() {
        return userRepository.findAllStudents();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado con id: " + id));
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con nombre " + name));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User existingUser = findById(id);

        User updatedUser = new User(
                existingUser.id(),
                user.firstName(),
                user.lastName(),
                user.email(),
                user.dni(),
                user.phone(),
                user.birthDate(),
                user.address(),
                user.password(),
                user.role(),
                user.active()
        );

        return userRepository.update(id, updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
