package com.java.javaProject.Service;
import java.util.Optional;
import com.java.javaProject.Entity.Product;
import com.java.javaProject.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
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
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	@Override
    public Optional<Product> findById(Long id) {
       return productRepository.findById(id);
    }
}