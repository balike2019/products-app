package com.balikeTech.productservice.service;

import com.balikeTech.productservice.model.Product;
import com.balikeTech.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    //private final PatientInterface patientInterface;


    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Add methods for patient-related operations
    public List<Product> getAllProducts() {
        return(List<Product>) productRepo.findAll();
    }

  /* public Product findByName(String pname) {
       return productRepo.findByName(pname)
            .orElse(null);
   */
        public Product getProductById(Integer id) {
        return productRepo.findById(id)
                .orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Integer id, Product pr) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("No Product with Id exist"));

        if (pr.getProductName() != null)
            existing.setProductId(pr.getProductId());

        if (pr.getProductPrice() != null)
            existing.setProductPrice(pr.getProductPrice());

        return productRepo.save(existing);


    }

   /* public String deleteProduct(Integer id) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("No Product with Id exist"));
        productRepo.deleteById(id);
        return  "Product deleted";
    }


    */
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}





