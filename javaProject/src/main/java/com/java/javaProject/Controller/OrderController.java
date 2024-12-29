package com.java.javaProject.Controller;
import com.java.javaProject.Entity.Order;
import com.java.javaProject.Entity.Product;
import com.java.javaProject.Entity.WareHouse;
import com.java.javaProject.Service.IOrderService;
import com.java.javaProject.Service.IProductService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private IOrderService orderService;
	@Autowired
	private IProductService productService;
	
    @GetMapping
    public String listOrders(Model model) {
		List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
    	List<Product> products = productService.getAllProducts();
        model.addAttribute("order", new Order());
        model.addAttribute("products", products);
        return "order/add";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}