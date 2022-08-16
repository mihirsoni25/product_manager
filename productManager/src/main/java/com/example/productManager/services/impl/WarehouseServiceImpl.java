package com.example.productManager.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.productManager.DTO.WarehouseDTO;
import com.example.productManager.entity.Warehouse;
import com.example.productManager.repositories.WarehouseRepository;
import com.example.productManager.services.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<WarehouseDTO> findAllProducts(String orderBy, String columnName, String category) {

		List<Warehouse> products = null;
		Sort sort = Sort.by(orderBy.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, columnName);
		System.out.println(category);
		products = warehouseRepository.findByCategory(sort, category);

		List<WarehouseDTO> productDTO = null;
		if (products != null) {
			productDTO = modelMapper.map(products, ArrayList.class);
		}
		return productDTO;
	}



	@Override
	public List<WarehouseDTO> findProductByPrice(float price) {
		List<Warehouse> products = null;
		
		
		products= warehouseRepository.findByPrice(price);
		 List<WarehouseDTO> productDTO = null;
			if (products  != null) {
				productDTO = modelMapper.map(products, ArrayList.class);
			}
			return productDTO;
	}

@Override
public List<WarehouseDTO> findProductByQuantity(int quantity) {
	List<Warehouse> products = null;
	
	
	products= warehouseRepository.findByQuantity(quantity);
	 List<WarehouseDTO> productDTO = null;
		if (products  != null) {
			productDTO = modelMapper.map(products, ArrayList.class);
		}
		return productDTO;
}

@Override
public List<WarehouseDTO> deleteProductFromWarehouse(int Id) {
	warehouseRepository.deleteById(Id);
	return null;
}

@Override
public List<WarehouseDTO> updateProductInWarehouse(int Id) {
	// TODO Auto-generated method stub
	return null;
}

	

}
