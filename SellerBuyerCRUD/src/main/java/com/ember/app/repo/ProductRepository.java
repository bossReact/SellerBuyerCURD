package com.ember.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ember.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
