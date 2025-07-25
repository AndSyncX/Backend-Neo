package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.repository.UserRepository;
import com.idat.neo.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;
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
    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado con id: " + id));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(String id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado con id: " + id));

        User updatedUser = new User(
                id,
                user.name(),
                user.email(),
                user.password(),
                user.role(),
                user.enable()
        );

        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
