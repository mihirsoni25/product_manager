package com.example.productManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productManager.DTO.WarehouseDTO;
import com.example.productManager.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

	public List<Warehouse> findByCategory(Sort sort, String category);

	public Optional<Warehouse> findById(int id);
	
	default void deleteById(int id) {
	
	}
	
	public List<Warehouse> findByPrice(float price);
	public List<Warehouse> findByQuantity(int quantity);
	//public List<Warehouse> deleteById(Integer Id);
}

