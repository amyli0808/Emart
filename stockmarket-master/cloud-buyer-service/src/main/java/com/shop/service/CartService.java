package com.shop.service;

import java.util.List;
import com.shop.entity.CartEntity;;

public interface CartService {


	public List<CartEntity>  getCartList();
	
	public CartEntity findCardById(Integer id);
	
}
