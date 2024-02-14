package com.balikeTech.productservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false)
    private  String productName;

    @Column(nullable = false)
    private  Double productPrice;

    @Column(nullable = false)
    private Integer quantity;


}
