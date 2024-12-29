package com.java.javaProject.Service;

import java.util.List;
import java.util.Optional;

import com.java.javaProject.Entity.WareHouse;

public interface IWareHouseService {
	List<WareHouse> getAllWarehouses();

	WareHouse saveWarehouse(WareHouse warehouse);

	String deleteWareHouse(Long id);

	Optional<WareHouse> findById(Long id);

	WareHouse updateWarehouse(WareHouse wareHouse);
}
