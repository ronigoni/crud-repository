package com.radware.exercise.models;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

    @Id
    private int id;

    private String name;

    private String category;

    @ElementCollection
    private List <Aspect> aspects;


}
