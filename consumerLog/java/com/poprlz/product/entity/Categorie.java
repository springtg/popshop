package com.poprlz.product.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @version 1.0 Create Date:2006-3-24 16:13:47 File Name: Categorie.java
 */
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categorieId")
	private Integer categorieId;

	@Column(name = "catName", length = 100, nullable = false)
	private String catName;
	
	@Column(name = "information", length = 200)
	private String information;
	
	@Column(name = "image", length = 100)
	private String image;
	
	@ManyToOne(targetEntity = com.poprlz.product.entity.Categorie.class)
	// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name = "parentId")
	private Categorie parentCat;
	
	@OneToMany(targetEntity = com.poprlz.product.entity.Categorie.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="categorieId")
	private List<Categorie> children;

	
	public List<Categorie> getChildren() {
		return children;
	}

	public void setChildren(List<Categorie> children) {
		this.children = children;
	}

	@Column(name = "sortOrder")
	private Integer sortOrder;

	// 状态 0为有效 1为无效
	@Column(name = "stutas")
	private Integer stutas;
	
	 
	

	public Integer getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Integer categorieId) {
		this.categorieId = categorieId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categorie getParentCat() {
		return parentCat;
	}

	public void setParentCat(Categorie parentCat) {
		this.parentCat = parentCat;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getStutas() {
		return stutas;
	}

	public void setStutas(Integer stutas) {
		this.stutas = stutas;
	}

 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result
				+ ((categorieId == null) ? 0 : categorieId.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result
				+ ((information == null) ? 0 : information.hashCode());
		result = prime * result
				+ ((sortOrder == null) ? 0 : sortOrder.hashCode());
		result = prime * result + ((stutas == null) ? 0 : stutas.hashCode());
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
		Categorie other = (Categorie) obj;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (categorieId == null) {
			if (other.categorieId != null)
				return false;
		} else if (!categorieId.equals(other.categorieId))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (information == null) {
			if (other.information != null)
				return false;
		} else if (!information.equals(other.information))
			return false;
		if (sortOrder == null) {
			if (other.sortOrder != null)
				return false;
		} else if (!sortOrder.equals(other.sortOrder))
			return false;
		if (stutas == null) {
			if (other.stutas != null)
				return false;
		} else if (!stutas.equals(other.stutas))
			return false;
		return true;
	}
	
	
	
	

}
