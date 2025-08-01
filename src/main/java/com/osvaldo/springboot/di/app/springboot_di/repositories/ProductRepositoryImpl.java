package com.osvaldo.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.osvaldo.springboot.di.app.springboot_di.models.Product;

@Primary
// @RequestScope is a Spring annotation used to define a bean's lifecycle so that a new instance is created for each HTTP request.
@RequestScope
//@SessionScope creates one bean instance per user session, allowing you to store and reuse user-specific data across multiple HTTP requests during that session.
// @SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L,"Memory Corsair 32",300L),
            new Product(2L,"CPU Intel i9",850L),
            new Product(3L,"Keyboard Razer Mini 60%",180L),
            new Product(4L,"Motherboard Gogabyte",490L)



        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }
    
    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


}
