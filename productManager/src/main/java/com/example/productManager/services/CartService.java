package com.example.productManager.services;

public interface CartService {

	public String addProductToCart(int productId, int quantity, int userId);
	public String deleteProductFromCart(int Id);
	public void updateProductFromCart(int id, int userId,int quantity);
//	public String updateProductInCart(Integer Id, Integer userId);
//	String updateProductInCart(Integer Id, Integer userId);
	}

