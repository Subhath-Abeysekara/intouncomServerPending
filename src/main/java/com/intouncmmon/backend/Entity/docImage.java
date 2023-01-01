package com.intouncmmon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class docImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "docCategory", foreignKey = @ForeignKey(name = "docCategory_image_fk1"))
    @JsonBackReference(value = "docCategory-image")
    @ToString.Exclude
    private docCategories docCategory;

    public docImage() {
    }

}
