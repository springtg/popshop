package com.poprlz.consumer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.poprlz.user.entity.UserInfo;




@Entity
@Table(name="consumer")
public class ConsumerEntity implements Serializable {
	
	// 用户唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="consumerId")
	private Integer consumerId;
	
	
	@Column(name="tag",length=100, nullable=true)
	private String tag;
	
	
	@Column(name="information")
	private String information;
	
	
	@Column(name="price")
	private BigDecimal price;
	
	
	@Column(name="consumerDate")
	private Date consumerDate;
	
	@OneToOne
	@JoinColumn(name="userInfoId", referencedColumnName="userInfoId", unique=true, nullable=true, updatable=true)
	private UserInfo userInfo;

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

	public Date getConsumerDate() {
		return consumerDate;
	}

	public void setConsumerDate(Date consumerDate) {
		this.consumerDate = consumerDate;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	


}
