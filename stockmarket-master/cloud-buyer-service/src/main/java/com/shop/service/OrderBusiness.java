package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shop.entity.OrderEntity;
import com.shop.repository.OrderRepository;

@Service
public class OrderBusiness implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	public Page<OrderEntity> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderEntity findOrderById(Integer id) {
		return orderRepository.findById(id);
	}

	public List<OrderEntity> findAllOrder() {
		return orderRepository.findAll();
	}
	
	/**
	 * about seller
	 */
	public OrderEntity registOrder(OrderEntity order){
		return orderRepository.saveAndFlush(order);
	}

	/**
	 * SELLER JPA ID
	 */
	public OrderEntity update(OrderEntity order) {
		return orderRepository.save(order);
	}

	public OrderEntity updateOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}
	
	public OrderEntity activeOrder(Integer id) {
		int flag = orderRepository.activeOrder(id);
		return orderRepository.findById(id);
	}

	public void delete(Integer id) {
		orderRepository.delete(id);
	}

	@Override
	public OrderEntity findByName(String name) {
		// TODO Auto-generated method stub
		return orderRepository.findByName(name);
	}



}
