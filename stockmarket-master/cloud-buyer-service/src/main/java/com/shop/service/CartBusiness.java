package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.entity.CartEntity;
import com.shop.repository.CartRepository;;

@Service
public class CartBusiness implements CartService{
	
	@Autowired
	private CartRepository cartRepository;



	public CartEntity findCardById(Integer id) {
		return cartRepository.findById(id);
	}

	public List<CartEntity>  getCartList() {
		return cartRepository.findAll();
	}

	
	
}
