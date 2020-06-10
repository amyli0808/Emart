package com.user.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.user.entity.UserEntity;

public interface UserService {

	/** 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<UserEntity> findAll(int page, int pageSize);
	
	/**
	 * @return
	 */
	public List<UserEntity> findAllUsers();
	
	/**
	 * @param 
	 * @return
	 */
	public UserEntity findUserById(Integer id);
	
	public UserEntity findUserByUserName(String userName);
	
	/**
	 * @param user
	 * @return
	 */
	public UserEntity registUser(UserEntity user);
	
	/**
	 * @param user
	 * @return
	 */
	public UserEntity updateUser(UserEntity user);
	
	/**
	 * @param id
	 * @return
	 */
	public UserEntity activeUser(Integer id);
	
	/**
	 * @param id
	 */
	public void delete(Integer id);
}
