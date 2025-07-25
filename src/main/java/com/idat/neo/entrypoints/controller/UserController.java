package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.service.UserService;
import com.idat.neo.entrypoints.dto.UserRequestDTO;
import com.idat.neo.entrypoints.dto.UserResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.UserDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/user")
public class UserController {

    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> response = userService.findAll()
                .stream()
                .map(userDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(userDtoMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        User userToSave = userDtoMapper.toDomain(requestDTO);
        User savedUser = userService.save(userToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDtoMapper.toDto(savedUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String id,
                                                      @RequestBody @Valid UserRequestDTO requestDTO) {
        User userToUpdate = userDtoMapper.toDomain(requestDTO);
        User updatedUser = userService.update(id, userToUpdate);
        return ResponseEntity.ok(userDtoMapper.toDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
