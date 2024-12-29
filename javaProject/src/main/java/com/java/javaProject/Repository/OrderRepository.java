package com.java.javaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaProject.Entity.*;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
