package com.poprlz.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * @version 1.0 Create Date:2006-3-24 16:32:40 File Name: ProductImage.java
 */

@Entity
@Table(name = "productImage")
public class ProductImage  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "imageId")
	private Integer imageId;

	@ManyToOne(targetEntity = com.poprlz.product.entity.ProductInfo.class)
	// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name = "productId")
	private ProductInfo productInfo;
	
	@Column(name = "path", length = 100,nullable=false)
	private String path;

	@Column(name = "alt", length = 200)
	private String alt;
	
	@Column(name = "content", length = 255)
	private String content;
	
	@Column(name = "mark", length = 255)
	private String mark;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
 
	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		result = prime * result + ((alt == null) ? 0 : alt.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		ProductImage other = (ProductImage) obj;
		if (alt == null) {
			if (other.alt != null)
				return false;
		} else if (!alt.equals(other.alt))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (imageId == null) {
			if (other.imageId != null)
				return false;
		} else if (!imageId.equals(other.imageId))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	
	
 

}
