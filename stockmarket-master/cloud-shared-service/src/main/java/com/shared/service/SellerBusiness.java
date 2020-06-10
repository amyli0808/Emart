package com.shared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shared.entity.SellerEntity;
import com.shared.repository.SellerRepository;

@Service
public class SellerBusiness implements SellerService{
	
	@Autowired
	private SellerRepository sellerRepository;


	public SellerEntity findSellerById(Integer id) {
		return sellerRepository.findById(id);
	}

	public List<SellerEntity> findAllSeller() {
		return sellerRepository.findAll();
	}
	
	/**
	 * about seller
	 */
	public SellerEntity registSeller(SellerEntity seller){
		return sellerRepository.saveAndFlush(seller);
	}

	/**
	 * SELLER JPA ID
	 */
	public SellerEntity update(SellerEntity seller) {
		return sellerRepository.save(seller);
	}

	public SellerEntity updateSeller(SellerEntity seller) {
		// TODO Auto-generated method stub
		return sellerRepository.save(seller);
	}
	

	public void delete(Integer id) {
		sellerRepository.delete(id);
	}

	@Override
	public SellerEntity activeSeller(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellerEntity findByUserName(String userName) {
		// 
		return sellerRepository.findByUserName(userName);
	}

}
