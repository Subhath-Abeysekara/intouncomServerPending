package com.intouncmmon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class pendingProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uses;

    private String specialData;

    private String size;

    private String color;

    private String price;

    private String material;

    private String options;

    private String warranty;

    private String delivery;

    private String brand;

    private Long producerId;

    private Long categoryId;

    @OneToMany(mappedBy = "productions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("product-image")
    @ToString.Exclude
    private List<productImagesPending> productImagesPending;


    public pendingProducts() {
    }
}
