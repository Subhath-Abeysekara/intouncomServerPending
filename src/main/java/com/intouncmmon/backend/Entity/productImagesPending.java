package com.intouncmmon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class productImagesPending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "productions", foreignKey = @ForeignKey(name = "product_image_fk1"))
    @JsonBackReference(value = "product-image")
    @ToString.Exclude
    private pendingProducts productions;

    public productImagesPending() {
    }

}
