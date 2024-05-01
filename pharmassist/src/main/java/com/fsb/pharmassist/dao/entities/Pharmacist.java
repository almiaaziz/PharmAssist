package com.fsb.pharmassist.dao.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "pharmacists", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    @Cascade(CascadeType.PERSIST)
    private Pharmacy pharmacy;

    public Pharmacist(String firstName2, String lastName2, String username2, String email2, String password2,
            Pharmacy pharmacy) {
        this.firstName = firstName2;
        this.lastName = lastName2;
        this.username = username2;
        this.email = email2;
        this.password = password2;
        this.pharmacy = pharmacy;
    }

    public Pharmacist(String firstName2, String lastName2, String username2, String email2, String password2) {
        this.firstName = firstName2;
        this.lastName = lastName2;
        this.username = username2;
        this.email = email2;
        this.password = password2;
    }

}
