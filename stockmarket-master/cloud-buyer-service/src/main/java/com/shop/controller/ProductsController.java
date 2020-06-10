package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.ProductsEntity;
import com.shop.service.ProductsService;

@RestController
@RequestMapping("/api/products")
//@CrossOrigin(origins="http://localhost:4200")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	/**
	 * 
	 * @return
	 */
	// findAllProducts
	@GetMapping
	public List<ProductsEntity> findAllProducts(){
		
		return productsService.findAllProducts();
	}
	// id update data
	@GetMapping("/active/{id}")
	public ResponseEntity<ProductsEntity> active(@PathVariable Integer id){
		ProductsEntity products = productsService.activeProducts(id);
		return ResponseEntity.ok(products); 
	}
	
	
	
}
