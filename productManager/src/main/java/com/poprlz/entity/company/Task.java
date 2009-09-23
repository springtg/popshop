package com.poprlz.entity.company;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.poprlz.entity.IdEntity;
import com.poprlz.entity.security.User;

@Entity
// 表名与类名不相同时重新定义表名.
@Table(name = "TASKS")
public class Task extends IdEntity{

	
	private String productName;
	
	private String color;
	
	private int quantity;
	
	private String status;
	
	private Date createDate;
	
	private Company company;
	
	private User createUser;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	
	
	
	
}

 