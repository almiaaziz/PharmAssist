package com.fsb.pharmassist.dao.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pharmacies")
public class Pharmacy {

    public Pharmacy(String name2, String city2, int zipCode2, String latitude2, String longitude2) {
        this.name = name2;
        this.city = city2;
        this.zipCode = zipCode2;
        this.latitude = latitude2;
        this.longitude = longitude2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String city;

    @Column(name = "zip_code", length = 30)
    private int zipCode;

    @Column(length = 50, nullable = false)
    private String latitude;

    @Column(length = 50, nullable = false)
    private String longitude;

    @OneToMany(mappedBy = "pharmacy")
    private List<Pharmacist> pharmacists;

    public void setPharmacist(Pharmacist pharmacist) {
        if (pharmacists == null) {
            pharmacists = new ArrayList<>();
        }
        pharmacists.add(pharmacist);
        pharmacist.setPharmacy(this);
    }

    public Pharmacy(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    
}
