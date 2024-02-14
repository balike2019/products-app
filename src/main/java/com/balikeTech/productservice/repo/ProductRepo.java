package com.balikeTech.productservice.repo;

import com.balikeTech.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo  extends JpaRepository<Product,Integer> {


}
