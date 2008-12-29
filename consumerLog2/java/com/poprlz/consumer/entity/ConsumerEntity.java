package com.poprlz.consumer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
import com.poprlz.user.entity.UserEntity;


@Entity
@Table(name="consumers")
public class ConsumerEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="consumer_id")
	private Integer consumerId;
	
	
	@Column(name="tag",nullable=false)
	private String tag;
	
	
	@Column(name="information",nullable=false)
	private String information;
	
	@Column(name="price",nullable=false)
	private BigDecimal price;
	
	@Column(name="status",nullable=false,length=2)
	private String status;
	
	@Column(name="consumer_date",nullable=false)
	private Date consumerDate;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private UserEntity UserEntity;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false, updatable = false)
	private CategoryEntity categoryEntity;

	public Integer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getConsumerDate() {
		return consumerDate;
	}

	public void setConsumerDate(Date consumerDate) {
		this.consumerDate = consumerDate;
	}

	public UserEntity getUserEntity() {
		return UserEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		UserEntity = userEntity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

}
