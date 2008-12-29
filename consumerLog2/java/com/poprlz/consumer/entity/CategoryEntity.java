package com.poprlz.consumer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categorys")
public class CategoryEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="category_id")
	private Integer categoryId;
	
	
	@Column(name="category_name",nullable=false)
	private String name;
	
	@Column(name="information",nullable=false)
	private String information;

	
	@Column(name="status",nullable=false,length=2)
	private String status;
 
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", nullable = false, updatable = false)
	private CategoryEntity parent;
	
	
	@OneToMany(fetch = FetchType.LAZY)		
	@JoinTable(name = "categorys", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"), inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"))
	private List<CategoryEntity> children;


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


 

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public CategoryEntity getParent() {
		return parent;
	}


	public void setParent(CategoryEntity parent) {
		this.parent = parent;
	}


	public List<CategoryEntity> getChildren() {
		return children;
	}


	public void setChildren(List<CategoryEntity> children) {
		this.children = children;
	}
	
	
	
	
	
	

}
