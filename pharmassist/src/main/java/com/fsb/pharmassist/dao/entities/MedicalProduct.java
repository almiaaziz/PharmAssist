package com.fsb.pharmassist.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "medical_products")
public class MedicalProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String medicineName;

    @Column
    private String composition;

    @Column
    private String uses;

    @Column
    private String sideEffects;

    @Column
    private String imageURL;

    @Column
    private String manufacturer;

    @Column
    private String excellentReview;

    @Column
    private String averageReview;

    @Column
    private String poorReview;

    @Column(nullable = true)
    private String quantity;

    public MedicalProduct orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

    public MedicalProduct(String medicineName, String composition, String uses, String manufacturer, String quantity) {
        this.medicineName = medicineName;
        this.composition = composition;
        this.uses = uses;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

}
