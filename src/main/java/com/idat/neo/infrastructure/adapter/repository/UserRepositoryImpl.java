package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.repository.UserRepository;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import com.idat.neo.infrastructure.adapter.mapper.UserMapper;
import com.idat.neo.infrastructure.adapter.persistence.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDataRepository userDataRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userDataRepository.findAll()
                .stream()
                .filter(UserData::isEnable)
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(String id) {
        return userDataRepository.findById(id)
                .filter(UserData::isEnable)
                .map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserData saved = userDataRepository.save(userMapper.toEntity(user));
        return userMapper.toDomain(saved);
    }

    @Override
    public User update(String id, User user) {
        UserData existing = userDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        existing.setName(user.name());
        existing.setEmail(user.email());
        existing.setPassword(user.password());
        existing.setRole(user.role());
        existing.setEnable(user.enable());

        UserData updated = userDataRepository.save(existing);
        return userMapper.toDomain(updated);
    }

    public void deleteById(String id) {
        UserData existing = userDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        existing.setEnable(false);
        userDataRepository.save(existing);
    }
}
