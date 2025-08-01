package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.User;
import com.idat.neo.domain.service.UserService;
import com.idat.neo.entrypoints.dto.PasswordUpdateDTO;
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
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
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
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
                                                      @RequestBody @Valid UserRequestDTO requestDTO) {
        User userToUpdate = userDtoMapper.toDomain(requestDTO);
        User updatedUser = userService.update(id, userToUpdate);
        return ResponseEntity.ok(userDtoMapper.toDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<UserResponseDTO>> getAllTeachers() {
        List<UserResponseDTO> response = userService.findAllTeachers()
                .stream()
                .map(userDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students")
    public ResponseEntity<List<UserResponseDTO>> getAllStudents() {
        List<UserResponseDTO> response = userService.findAllStudents()
                .stream()
                .map(userDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserResponseDTO> getByName(@PathVariable String name) {
        User user = userService.findByName(name);
        return ResponseEntity.ok(userDtoMapper.toDto(user));
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<Void> updateUserPassword(@PathVariable Long id,
                                                   @RequestBody @Valid PasswordUpdateDTO dto) {
        userService.updatePassword(id, dto);
        return ResponseEntity.noContent().build();
    }
}
