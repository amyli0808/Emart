package com.shop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.CartEntity;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	
	public CartEntity findById(Integer id);
	
	@Modifying
	@Transactional
	/*
	 * @Query(value = "update e_seller u set u.GSTIN='123' where u.id=?",nativeQuery
	 * = true) public int activeSeller(@Param("id")Integer id);
	 */
    @Query(value = "select * from e_cart c where c.user_id=:user_id", nativeQuery = true)
    List<CartEntity> findCartByIdNative(@Param("user_id") long user_id);
	
}