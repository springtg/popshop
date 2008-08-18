package com.poprlz.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
import javax.persistence.Table;

import com.poprlz.user.entity.UserInfo;

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
 * @version 1.0 Create Date:2006-3-24 16:26:41 File Name: Prodreview.java
 */


@Entity
@Table(name = "ProductReview")
public class ProductReview  implements Serializable{

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="reviewId")
	private  Integer  reviewId;

	
	@ManyToOne(targetEntity = com.poprlz.product.entity.ProductInfo.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="productId")
	private ProductInfo productInfo;
	
	@ManyToOne(targetEntity = com.poprlz.user.entity.UserInfo.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="userInfoId")
	private UserInfo userInfo;

 
	@Column(name="rating")
	private Integer rating;

	@Column(name="dateAdded")
	private Date dateAdded;

	@Column(name="lastModify")
	private Date lastModify;

	@Column(name="content")
	private String content;

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getLastModify() {
		return lastModify;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result
				+ ((lastModify == null) ? 0 : lastModify.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result
				+ ((reviewId == null) ? 0 : reviewId.hashCode());
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
		ProductReview other = (ProductReview) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (lastModify == null) {
			if (other.lastModify != null)
				return false;
		} else if (!lastModify.equals(other.lastModify))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (reviewId == null) {
			if (other.reviewId != null)
				return false;
		} else if (!reviewId.equals(other.reviewId))
			return false;
		return true;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

	 
}
