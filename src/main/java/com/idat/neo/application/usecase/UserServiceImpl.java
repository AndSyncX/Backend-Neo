package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.repository.UserRepository;
import com.idat.neo.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
