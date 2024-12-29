package com.java.javaProject.Service;
import com.java.javaProject.Repository.*;
import com.java.javaProject.Entity.WareHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WareHouseService implements IWareHouseService{
	@Autowired
	private final WareHouseRepository wareHouseRepository;
	
	public WareHouseService(WareHouseRepository wareHouseRepository) {
		this.wareHouseRepository = wareHouseRepository;
	}
	
    @Override
	public List<WareHouse> getAllWarehouses(){
		return wareHouseRepository.findAll();
	}
	
	public WareHouse saveWarehouse(WareHouse warehouse) {
		return wareHouseRepository.save(warehouse);
	}
	
	public void deleteWareHouse(Long id) {
		wareHouseRepository.deleteById(id);
	}
	
	@Override
	public void findById(Long id) {
		wareHouseRepository.findById(id);
	}
}