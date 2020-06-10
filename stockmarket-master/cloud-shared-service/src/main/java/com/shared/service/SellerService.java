package com.shared.service;

import java.util.List;

import com.shared.entity.SellerEntity;

public interface SellerService {
	
	public List<SellerEntity> findAllSeller();
	
	/**

	 */
	public SellerEntity findSellerById(Integer id);
	
	public SellerEntity findByUserName(String userName);
	
	/**
	 */
	public SellerEntity updateSeller(SellerEntity seller);
	
	/**
	 */
	public SellerEntity activeSeller(Integer id);
	
	/**
	 */
	public void delete(Integer id);
	
	
	
	public SellerEntity registSeller(SellerEntity seller);
	
	/**
	 */
}
