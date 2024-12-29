package com.java.javaProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaProject.Entity.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByWareHouse_Id(Long warehouseId);
}
