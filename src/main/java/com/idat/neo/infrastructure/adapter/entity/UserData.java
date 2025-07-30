package com.idat.neo.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "role", length = 10)
    private String role;

    @Column(name = "enable")
    private boolean enable;
}
