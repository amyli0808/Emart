package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shop.entity.ProductsEntity;
import com.shop.repository.ProductsRepository;

@Service
public class ProductsBusiness implements ProductsService{
	
	@Autowired
	private ProductsRepository productsRepository;

	public Page<ProductsEntity> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductsEntity findProductsById(Integer id) {
		return productsRepository.findById(id);
	}

	public List<ProductsEntity> findAllProducts() {
		return productsRepository.findAll();
	}
	
	/**
	 * about seller
	 */
	public ProductsEntity registProducts(ProductsEntity products){
		return productsRepository.saveAndFlush(products);
	}

	/**
	 * SELLER JPA ID
	 */
	public ProductsEntity update(ProductsEntity products) {
		return productsRepository.save(products);
	}

	//update
	public ProductsEntity updateProducts(ProductsEntity products) {
		// TODO Auto-generated method stub
		return productsRepository.save(products);
	}
	
	//update  by id
	public ProductsEntity activeProducts(Integer id) {
		int flag = productsRepository.activeProducts(id);
		return productsRepository.findById(id);
	}

	// delete
	public void delete(Integer id) {
		productsRepository.delete(id);
	}

	
	}


