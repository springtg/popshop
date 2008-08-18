package com.poprlz.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * @version 1.0 Create Date:2006-3-24 16:34:59 File Name: ProductAttribute.java
 */

@Entity
@Table(name = "productAttribute")
public class ProductAttribute  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attributeId")
	private Integer attributeId;

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

	@Column(name="price")
	private BigDecimal price;

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		ProductAttribute other = (ProductAttribute) obj;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
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
