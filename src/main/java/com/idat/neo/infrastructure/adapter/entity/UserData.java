package com.idat.neo.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "neo", name = "user")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 70)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 200)
    private String email;

    @Column(name = "dni", nullable = false, unique = true, length = 12)
    private String dni;

    @Column(name = "phone", nullable = false, unique = true, length = 12)
    private String phone;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "address", nullable = false, length = 300)
    private String address;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "role", nullable = false, length = 10)
    private String role;

    @Column(name = "active")
    private boolean active;
}
