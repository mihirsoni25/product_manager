package com.example.productManager.services;

import java.util.List;

import com.example.productManager.DTO.WarehouseDTO;

public interface WarehouseService {

	public List<WarehouseDTO> findAllProducts(String orderBy, String columnName, String category);
	public List<WarehouseDTO> deleteProductFromWarehouse(int Id);
	public List<WarehouseDTO> updateProductInWarehouse(int Id);
	public List<WarehouseDTO> findProductByPrice(float price);
	public List<WarehouseDTO> findProductByQuantity(int quantity);
}
