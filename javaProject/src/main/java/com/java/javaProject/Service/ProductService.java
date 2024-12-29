package com.java.javaProject.Service;
import java.util.Optional;
import com.java.javaProject.Entity.Product;
import com.java.javaProject.Entity.Order;
import com.java.javaProject.Repository.OrderRepository;
import com.java.javaProject.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Product> getAllProducts() {
	    List<Product> products = productRepository.findAll();
	    return products;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public String deleteProduct(Long id) {
        List<Order> orders = orderRepository.findByProductId(id);
        
        if (!orders.isEmpty()) {
            return "Bu ürüne bağlı siparişler bulunduğu için ürün silinemiyor.";
        }

        productRepository.deleteById(id);
        return null;
	}
	
	@Override
    public Optional<Product> findById(Long id) {
       return productRepository.findById(id);
    }
}