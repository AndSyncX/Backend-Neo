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
@Table(schema = "db_neo", name = "user")
public class UserData {

    @Id
    @Column(name = "id", length = 12)
    private String id;

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
