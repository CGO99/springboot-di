package com.osvaldo.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.osvaldo.springboot.di.app.springboot_di.models.Product;


@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        // Implementation for finding all products
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        // Implementation for finding a product by ID
        return new Product(id, "Monitor Asus 27", 600L); 
    }

}   
