package com.shop.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="E_CART")
public class CartEntity {
	private Integer id;
	private Integer userId;
	private Integer itemsId;
    private String  itemsName;
    private String  itemsNum;
    private Double  itemspPrice;
    private Date    createTime;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	// user id	
	@Column(name="userId")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	// product id	
	@Column(name="itemsId")
	public Integer getItemsId() {
		return itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}
	@Column(name="ITEMSNAME")
	public String getItemsName() {
		return itemsName;
	}
	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	@Column(name="ITEMSNUM")
	public String getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(String itemsNum) {
		this.itemsNum = itemsNum;
	}
	@Column(name="ITEMSPRICE")
	public Double getItemspPrice() {
		return itemspPrice;
	}
	public void setItemspPrice(Double itemspPrice) {
		this.itemspPrice = itemspPrice;
	}
	@Column(name="createTime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	
}
