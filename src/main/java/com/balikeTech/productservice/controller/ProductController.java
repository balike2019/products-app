package com.balikeTech.productservice.controller;

import com.balikeTech.productservice.model.Product;
import com.balikeTech.productservice.service.ProductService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("This is Product Service")
@RestController
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;

@Autowired
    public ProductController(ProductService productService) {

    this.productService = productService;
    }
@CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Product> findAll(){
        return  productService.getAllProducts();

    }
    /*@GetMapping("/product/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name){
        return  new ResponseEntity<Product>(productService.findByName(name), HttpStatus.OK);
    }

*/@CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public  ResponseEntity<Product>updateProducts(@PathVariable Integer id,@RequestBody Product pd){
        return new ResponseEntity<Product>(productService.updateProduct(id,pd),HttpStatus.CREATED);

    }
    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<Product>createProduct(@RequestBody Product p){
        return new ResponseEntity<Product>(productService.createProduct(p),HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
