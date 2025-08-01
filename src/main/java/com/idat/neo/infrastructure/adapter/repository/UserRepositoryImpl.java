package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.repository.UserRepository;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import com.idat.neo.infrastructure.adapter.mapper.UserMapper;
import com.idat.neo.infrastructure.adapter.persistence.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userDataRepository.findAll()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public List<User> findAllTeachers() {
        return userDataRepository.findAllTeachers()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public List<User> findAllStudents() {
        return userDataRepository.findAllStudents()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDataRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userDataRepository.findByName(name)
                .map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserData entity = userMapper.toEntity(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setActive(true);
        UserData saved = userDataRepository.save(entity);
        return userMapper.toDomain(saved);
    }

    @Override
    public User update(Long id, User user) {
        UserData existing = userDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        existing.setFirstName(user.firstName());
        existing.setLastName(user.lastName());
        existing.setEmail(user.email());
        existing.setDni(user.dni());
        existing.setPhone(user.phone());
        existing.setBirthDate(user.birthDate());
        existing.setAddress(user.address());
        existing.setRole(user.role());

        UserData updated = userDataRepository.save(existing);
        return userMapper.toDomain(updated);
    }

    public void deleteById(Long id) {
        UserData existing = userDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        existing.setActive(false);
        userDataRepository.save(existing);
    }

    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        UserData existing = userDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        if (!passwordEncoder.matches(oldPassword, existing.getPassword())) {
            throw new IllegalArgumentException("La contraseña actual no es válida");
        }

        existing.setPassword(passwordEncoder.encode(newPassword));
        userDataRepository.save(existing);
    }
}
