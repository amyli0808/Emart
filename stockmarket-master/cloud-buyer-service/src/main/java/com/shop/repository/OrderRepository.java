package com.shop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.OrderEntity;;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	
	public OrderEntity findById(Integer id);
	public OrderEntity findByName(String name);
	
	@Modifying
	@Transactional
	@Query(value = "update e_order u set u.GSTIN='123' where u.id=?",nativeQuery = true)
	public int activeOrder(@Param("id")Integer id);
}