package com.osvaldo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.osvaldo.springboot.di.app.springboot_di.models.Product;
import com.osvaldo.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
   
   
    private Environment environment;
    @Value("${config.price.tax}")
    private Double tax;
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productList")ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            // // Printed tax value to console using Postman to confirm correct retrieval from configuration.
            // System.out.println(environment.getProperty("config.price.tax", Double.class));
            // System.out.println("Tax: " + tax);
            Double priceTax = p.getPrice() * tax;
            // Product newProd = new Product(p.getId(),p.getName(),priceTax.longValue());
            
            Product newProd = (Product) p.clone(); // Using clone method to create a new instance
            newProd.setPrice(priceTax.longValue());
            return newProd;
            
            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }



}
