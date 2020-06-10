package com.seller.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.exception.StockEXConstants;
import com.emart.exception.StockRequestException;
import com.seller.entity.ProductsEntity;
import com.seller.service.ProductsService;

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
	@GetMapping
	public List<ProductsEntity> findAllProducts(){
		
		return productsService.findAllProducts();
	}
	

	// this is add product for seller
	@PostMapping
	public ResponseEntity<ProductsEntity> regist(@RequestBody @Valid ProductsEntity products, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		
		ProductsEntity existedProducts = productsService.findByName(products.getName());
		if(existedProducts != null){
			bindingResult.rejectValue("Name", "400001", "the product is existed.");
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		ProductsEntity productsEntity = productsService.registProducts(products);
		return ResponseEntity.status(HttpStatus.CREATED).body(productsEntity); 
	}
	
	@PutMapping
	public ResponseEntity<ProductsEntity> update(ProductsEntity products){
		ProductsEntity productsEntity = productsService.updateProducts(products);
		return ResponseEntity.ok(productsEntity); 
	}
	
	@GetMapping("/active/{id}")
	public ResponseEntity<ProductsEntity> active(@PathVariable Integer id){
		ProductsEntity products = productsService.activeProducts(id);
		return ResponseEntity.ok(products); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		productsService.delete(id);
		return ResponseEntity.ok("Delete products successfully.");
	}
	
	
}
