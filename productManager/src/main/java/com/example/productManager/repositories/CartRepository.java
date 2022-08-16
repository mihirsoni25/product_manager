package com.example.productManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productManager.entity.Cart;
import com.example.productManager.entity.Warehouse;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


	//public Optional<Cart> findByUserId(Integer UserId);

	




}
