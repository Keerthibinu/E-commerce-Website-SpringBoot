package com.project.EcommerceWebsite.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String categoryid;
    private Float price;
    private Integer quantity;
    private String description;
    private Integer rating;
    private List<String> comments;
}
