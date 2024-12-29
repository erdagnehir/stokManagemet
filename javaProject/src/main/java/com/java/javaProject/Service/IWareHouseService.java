package com.java.javaProject.Service;

import java.util.List;

import com.java.javaProject.Entity.WareHouse;
import com.java.javaProject.Repository.WareHouseRepository;

public interface IWareHouseService {	
	List<WareHouse> getAllWarehouses();
	WareHouse saveWarehouse(WareHouse warehouse);
	void deleteWareHouse(Long id);
	void findById(Long id);
}
