package com.fsb.pharmassist.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
public class Client {

    public Client(String firstName2, String lastName2, String username2, String email2, String password2) {
        this.firstName = firstName2;
        this.lastName = lastName2;
        this.username = username2;
        this.email = email2;
        this.password = password2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;
}
