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
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User no encontrado con id: " + id));
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
                user.name(),
                user.email(),
                user.password(),
                user.role(),
                user.enable()
        );

        return userRepository.update(id, updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
