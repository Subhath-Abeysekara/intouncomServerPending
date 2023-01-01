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
public class docCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "docCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("docCategory-image")
    @ToString.Exclude
    private List<docImage> docImages;


    public docCategories() {
    }
}
