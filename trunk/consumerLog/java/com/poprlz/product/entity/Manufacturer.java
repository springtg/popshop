package com.poprlz.product.entity;

import java.io.Serializable;
import java.util.Date;
/*
 * Copyright (c) 2000-9999 by RoweLuo 
 * All rights reserved.
 * 所有版权均属作者罗志恒.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DESCRIPTION:
 * @since JDK 1.4
 * @author Rowe Luo 罗志恒
 * @version 1.0 Create Date:2006-9-28 23:08:46
 * File Name: Manufacturer.java
 */

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
	/**
public boolean equals(Object obj) {
		
		if(null==obj)
			return false;
		
		if(!(obj instanceof  Manufacturer))
			return false;
		
		Manufacturer other=(Manufacturer)obj;
		
		if(hashCode()!=other.hashCode())
			return false;
		
		if(!(other==this))
			return false;
		return true;		
		
		
	
	}

	public int hashCode() {
		if (hash == Integer.MIN_VALUE) {
			hash = this.manufacturerId  + (manufacturerName == null ? 0 : manufacturerName.hashCode())
					* 1000;
			;
		}
		return hash;
	}
	
	
	private int hash = Integer.MIN_VALUE;
**/	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "manufacturerId")
	private Integer manufacturerId;
	
	@Column(name = "manufacturerName", length = 100, nullable = false)
	private String manufacturerName;
	
	@Column(name = "information", length = 200)
	private String information;
	
	@Column(name = "manufacturerImage", length = 100)
	private String manufacturerImage; 
	
	@Column(name = "manufacturerURL", length = 200)
	private String manufacturerURL; 
	
	@Column(name = "urlClicked")
	private Integer urlClicked; 
	
	@Column(name = "dateLastClick")
	private Date dateLastClick;
	
 

	public Integer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getManufacturerImage() {
		return manufacturerImage;
	}

	public void setManufacturerImage(String manufacturerImage) {
		this.manufacturerImage = manufacturerImage;
	}

	public String getManufacturerURL() {
		return manufacturerURL;
	}

	public void setManufacturerURL(String manufacturerURL) {
		this.manufacturerURL = manufacturerURL;
	}

	public Integer getUrlClicked() {
		return urlClicked;
	}

	public void setUrlClicked(Integer urlClicked) {
		this.urlClicked = urlClicked;
	}

	public Date getDateLastClick() {
		return dateLastClick;
	}

	public void setDateLastClick(Date dateLastClick) {
		this.dateLastClick = dateLastClick;
	}

 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((information == null) ? 0 : information.hashCode());
		result = prime * result
				+ ((manufacturerId == null) ? 0 : manufacturerId.hashCode());
		result = prime
				* result
				+ ((manufacturerImage == null) ? 0 : manufacturerImage
						.hashCode());
		result = prime
				* result
				+ ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		result = prime * result
				+ ((manufacturerURL == null) ? 0 : manufacturerURL.hashCode());
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
		Manufacturer other = (Manufacturer) obj;
		if (information == null) {
			if (other.information != null)
				return false;
		} else if (!information.equals(other.information))
			return false;
		if (manufacturerId == null) {
			if (other.manufacturerId != null)
				return false;
		} else if (!manufacturerId.equals(other.manufacturerId))
			return false;
		if (manufacturerImage == null) {
			if (other.manufacturerImage != null)
				return false;
		} else if (!manufacturerImage.equals(other.manufacturerImage))
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (manufacturerURL == null) {
			if (other.manufacturerURL != null)
				return false;
		} else if (!manufacturerURL.equals(other.manufacturerURL))
			return false;
		return true;
	}
	
	
	 
}
