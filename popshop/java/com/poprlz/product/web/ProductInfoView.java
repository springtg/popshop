package com.poprlz.product.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.poprlz.product.entity.ProductImage;

public class ProductInfoView  implements Serializable{	
 
	private Integer productId;	
 
	private String productName;	
 
	private BigDecimal price;	
 
	private Integer quantity;	
 
	private String description;
	
	// 状态 0为有效 1为无效 
	private Integer stutas; 
 
	private String model;	
 
	private Date dateAdded;	
 
	private Date lastModified;	
 
	private Date dateAvailable;	
 
	private BigDecimal weight;	
 
	private String URL; 
 
	private Integer viewed;	
 
	private Integer ordered;
	
	private ProductImage productImage;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStutas() {
		return stutas;
	}

	public void setStutas(Integer stutas) {
		this.stutas = stutas;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String url) {
		URL = url;
	}

	public Integer getViewed() {
		return viewed;
	}

	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	
	

}
