package com.shared.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shared.entity.SellerEntity;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer>{
	
	public SellerEntity findById(Integer id);
	public SellerEntity findByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query(value = "update e_seller u set u.companyName='sellerceo' where u.id=?",nativeQuery = true)
	public int activeProducts(@Param("id")Integer id);
}