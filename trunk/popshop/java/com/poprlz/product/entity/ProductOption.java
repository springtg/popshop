package com.poprlz.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Copyright (c) 2000-9999 by RoweLuo 
 * All rights reserved.
 * 所有版权均属作者罗志恒.
 */

/**
 * DESCRIPTION:
 * 
 * @since JDK 1.4
 * @author Rowe Luo 罗志恒
 * @version 1.0 Create Date:2006-3-24 16:30:21 File Name: ProductOption.java
 */
@Entity
@Table(name = "productOption")
public class ProductOption  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "optionId")
	private Integer optionId;


	@ManyToOne(targetEntity = com.poprlz.product.entity.ProductInfo.class)
	// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name = "productId")
	private ProductInfo productInfo;

	@Column(name="name",length=100, nullable=false)
	private String name;

	@Column(name="value",length=100, nullable=false)
	private String value;

	@Column(name="mark")
	private String mark;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((optionId == null) ? 0 : optionId.hashCode());
		result = prime * result
				+ ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOption other = (ProductOption) obj;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (optionId == null) {
			if (other.optionId != null)
				return false;
		} else if (!optionId.equals(other.optionId))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	} 
	
	
}
