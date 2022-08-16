package com.example.productManager.services.impl;

import java.io.Console;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productManager.DTO.CartDTO;
import com.example.productManager.DTO.WarehouseDTO;
import com.example.productManager.entity.Cart;
import com.example.productManager.entity.Warehouse;
import com.example.productManager.repositories.CartRepository;
import com.example.productManager.repositories.WarehouseRepository;
import com.example.productManager.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	public WarehouseRepository warehouseRepository;

	@Autowired
	public CartRepository cartRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addProductToCart(int productId, int quantity, int userId) {

		Optional<Warehouse> warehouse = warehouseRepository.findById(productId);
		if (warehouse.isPresent()) {
			WarehouseDTO warehouseDTO = modelMapper.map(warehouse.get(), WarehouseDTO.class);
			if (warehouseDTO.getQuantity() > quantity) {
				CartDTO cartDTO = new CartDTO();
				cartDTO.setWarehouse(warehouse.get());
				cartDTO.setQuantity(quantity);
				cartRepository.saveAndFlush(modelMapper.map(cartDTO, Cart.class));

				return "Product added successfully in the cart";
			} else {
				return "inventory has less number of products than required";
			}
		}
		return "No Product Found";
	}

	@Override
	public String deleteProductFromCart(int Id) {
		cartRepository.deleteById(Id);
		return null;
	}
	@Override
	public void updateProductFromCart(int id, int userId,int quantity) {
		Optional<Warehouse> warehouse = warehouseRepository.findById(id);	
		if (warehouse.isPresent()) {
			System.out.println("cart is present");
			WarehouseDTO warehouseDTO = modelMapper.map(warehouse.get(), WarehouseDTO.class);
		//	if (warehouseDTO.getQuantity() > quantity) {
				CartDTO cartDTO = new CartDTO();
				cartDTO.setWarehouse(warehouse.get());
				cartDTO.setQuantity(quantity);
				//cartDTO.setUserId(userId);
				cartDTO.setId(userId);
				cartRepository.saveAndFlush(modelMapper.map(cartDTO, Cart.class));

				
		//}  
				
			
		}
		System.out.println("outside cart is present");
		
	}
}





	




	

