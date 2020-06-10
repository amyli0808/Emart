package com.seller.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.seller.entity.ProductsEntity;

public interface ProductsService {

	/**
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<ProductsEntity> findAll(int page, int pageSize);
	
	/**
	 * 
	 * 
	 * @return
	 */
	public List<ProductsEntity> findAllProducts();
	
	public ProductsEntity findByName(String name);
	
	public ProductsEntity findProductsById(Integer id);
	
	/**
	 * ע��һ���û�
	 * 
	 * @param user
	 * @return
	 */
	public ProductsEntity updateProducts(ProductsEntity products);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public ProductsEntity activeProducts(Integer id);
	
	/**
	 * 
	 * 
	 * @param id
	 */
	public void delete(Integer id);
	
	
	
	public ProductsEntity registProducts(ProductsEntity products);
	
	/**
	 * 
	 * 
	 * @param products
	 * @return
	 */
}
