package com.shop.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.shop.entity.OrderEntity;;

public interface OrderService {


	public Page<OrderEntity> findAll(int page, int pageSize);
	
	public List<OrderEntity> findAllOrder();
	
	//
	public OrderEntity findByName(String name);
	
	
	public OrderEntity findOrderById(Integer id);
	
	/**
	 * ע��һ���û�
	 * 
	 * @param user
	 * @return
	 */
	public OrderEntity updateOrder(OrderEntity order);
	
	/**
	 * �����û�
	 * 
	 * @param id
	 * @return
	 */
	public OrderEntity activeOrder(Integer id);
	
	/**
	 * ɾ��һ���û�
	 * 
	 * @param id
	 */
	public void delete(Integer id);
	
	
	
	public OrderEntity registOrder(OrderEntity order);
	
	/**
	 * �����û���Ϣ
	 * 
	 * @param order
	 * @return
	 */
}
