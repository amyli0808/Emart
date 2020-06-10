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

import com.shop.entity.CartEntity;
import com.shop.repository.CartRepository;
import com.shop.service.CartService;
@RestController
@RequestMapping("/api/cart")
//@CrossOrigin(origins="http://localhost:4200")
public class CartController {
	@Autowired
	private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<CartEntity> findAllCart(){		
		return cartService.getCartList();
	}
	
	/*
	 * @PostMapping public String save(CardEntity cardEntity) throws Exception{
	 * cardRepository.save(cardEntity); return null; }
	 */
	
	
}
