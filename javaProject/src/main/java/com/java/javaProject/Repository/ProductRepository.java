package com.java.javaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaProject.Entity.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

}