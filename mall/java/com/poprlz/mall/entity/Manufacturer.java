package com.poprlz.mall.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturers")
public class Manufacturer implements Serializable {
	@Id
	@Column(name="manufacturers_id")
	private int manufacturersId;

	@Column(name="manufacturers_name")
	private String manufacturersName;

	@Column(name="manufacturers_image")
	private String manufacturersImage;

	@Column(name="manufacturers_url")
	private String manufacturersUrl;

	@Column(name="url_clicked")
	private int urlClicked;

	@Column(name="date_last_click")
	private Date dateLastClick;

	@Column(name="date_added")
	private Date dateAdded;

	@Column(name="last_modified")
	private Date lastModified;

	private static final long serialVersionUID = 1L;

	public Manufacturer() {
		super();
	}

	public int getManufacturersId() {
		return this.manufacturersId;
	}

	public void setManufacturersId(int manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	public String getManufacturersName() {
		return this.manufacturersName;
	}

	public void setManufacturersName(String manufacturersName) {
		this.manufacturersName = manufacturersName;
	}

	public String getManufacturersImage() {
		return this.manufacturersImage;
	}

	public void setManufacturersImage(String manufacturersImage) {
		this.manufacturersImage = manufacturersImage;
	}

	public String getManufacturersUrl() {
		return this.manufacturersUrl;
	}

	public void setManufacturersUrl(String manufacturersUrl) {
		this.manufacturersUrl = manufacturersUrl;
	}

	public int getUrlClicked() {
		return this.urlClicked;
	}

	public void setUrlClicked(int urlClicked) {
		this.urlClicked = urlClicked;
	}

	public Date getDateLastClick() {
		return this.dateLastClick;
	}

	public void setDateLastClick(Date dateLastClick) {
		this.dateLastClick = dateLastClick;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
