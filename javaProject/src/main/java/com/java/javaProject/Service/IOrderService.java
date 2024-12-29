package com.java.javaProject.Service;

import java.util.List;
import java.util.Optional;

import com.java.javaProject.Entity.Order;

public interface IOrderService {
	List<Order> getAllOrders();

	Order saveOrder(Order product);

	void deleteOrder(Long id);

	Optional<Order> findById(Long id);

	List<Order> findByProductId(Long productId);
}