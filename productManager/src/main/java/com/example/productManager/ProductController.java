package com.example.productManager;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productManager.DTO.WarehouseDTO;
import com.example.productManager.services.CartService;
import com.example.productManager.services.WarehouseService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private WarehouseService serviceProviderService;

	@Autowired
	private CartService cartService;

	@PostMapping(value = "addProductToCart/{productId}/{quantity}/{userId}")
	public String login(@PathVariable int productId, @PathVariable int quantity, @PathVariable int userId) {
		return cartService.addProductToCart(productId, quantity, userId);
	}

	@GetMapping(value = "/getproducts/{orderBy}/{columnName}/{category}")
	public List<WarehouseDTO> login(@PathVariable String orderBy, @PathVariable String columnName,
			@PathVariable String category) {

		return serviceProviderService.findAllProducts(orderBy, columnName, category);
	}
	@GetMapping (value = "/getproducts/{price}")
	public  List<WarehouseDTO> login(@PathVariable float price ){
		return serviceProviderService.findProductByPrice(price);
	}
	
	@GetMapping(value="/getproducts/quantity/{quantity}")
	public  List<WarehouseDTO> login(@PathVariable int quantity ){
		return serviceProviderService.findProductByQuantity(quantity);
	}
	@DeleteMapping(value="/deleteProductFromCart/{Id}")
	public String login1(@PathVariable int Id)
	{
	 return cartService.deleteProductFromCart(Id);
}
	@PutMapping(value="/updateProductFromCart/{Id}/{userId}/{quantity}")
	public void login2(@PathVariable int Id, @PathVariable int userId,@PathVariable int quantity)
	{
//		 return cartService.updateProductFromCart(Id,userId,quantity);
	}
	@DeleteMapping(value="/deleteProductFromWarehouse/{Id}")
	public List<WarehouseDTO> login3(@PathVariable int Id)
	{
	 return serviceProviderService.deleteProductFromWarehouse(Id);
}
	@PutMapping(value="/updateProductInWarehouse/{Id}")
	public List<WarehouseDTO> login4(@PathVariable int Id)
	{
		return serviceProviderService.updateProductInWarehouse(Id);
	}
}
