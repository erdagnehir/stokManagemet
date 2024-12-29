package com.java.javaProject.Service;

import com.java.javaProject.Repository.*;
import com.java.javaProject.Entity.Order;
import com.java.javaProject.Entity.Product;
import com.java.javaProject.Entity.WareHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService implements IWareHouseService {

	@Autowired
	private final WareHouseRepository wareHouseRepository;

	@Autowired
	private final ProductRepository productRepository;

	public WareHouseService(WareHouseRepository wareHouseRepository) {
		this.wareHouseRepository = wareHouseRepository;
		this.productRepository = null;
	}

	@Override
	public List<WareHouse> getAllWarehouses() {
		return wareHouseRepository.findAll();
	}

	@Override
	public WareHouse saveWarehouse(WareHouse warehouse) {
		return wareHouseRepository.save(warehouse);
	}

	@Override
	public String deleteWareHouse(Long id) {
		List<Product> product = productRepository.findByWareHouse_Id(id);

		if (!product.isEmpty()) {
			return "Bu depoda ürün bulunduğu için depo silinemiyor.";
		}

		wareHouseRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<WareHouse> findById(Long id) {
		return wareHouseRepository.findById(id);
	}

	@Override
	public WareHouse updateWarehouse(WareHouse wareHouse) {
		if (wareHouse.getId() != null && wareHouseRepository.existsById(wareHouse.getId())) {
			return wareHouseRepository.save(wareHouse);
		}
		throw new IllegalArgumentException("Depo bulunamadı");
	}
}