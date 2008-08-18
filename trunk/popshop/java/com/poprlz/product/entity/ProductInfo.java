package com.poprlz.product.entity;

import java.io.Serializable;

 
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@Entity
@Table(name="productInfo")
public class ProductInfo implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="productId")
	private Integer productId;
	
	
	@Column(name="productName",length=100, nullable=false)
	private String productName;
	
	@Column(name="price",nullable=false)
	private BigDecimal price;
	
	@Column(name="quantity",nullable=false)
	private Integer quantity;
	
	@Column(name="description", nullable=false)
	private String description;
	
	// 状态 0为有效 1为无效
	@Column(name="stutas")
	private Integer stutas;
	
 
	@Column(name="model",length=100)
	private String model;
	
	@Column(name="dateAdded")
	private Date dateAdded;
	
	@Column(name="lastModified")
	private Date lastModified;
	
	@Column(name="dateAvailable")
	private Date dateAvailable;
	
	@Column(name="weight",length=100)
	private String weight;
	
	@Column(name="URL")
	private String URL;

 
	@Column(name="viewed")
	private Integer viewed;
	
	@Column(name="ordered")
	private Integer ordered;
	
	@ManyToMany(targetEntity=com.poprlz.product.entity.Categorie.class)// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinTable(name="cat_product",joinColumns=@JoinColumn(name="productId", referencedColumnName="productId"),inverseJoinColumns=@JoinColumn(name="categorieId", referencedColumnName="categorieId"))
	private List<Categorie> catList;
	
	@ManyToOne(targetEntity = com.poprlz.product.entity.Manufacturer.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="manufacturerId")
	private Manufacturer manufacturer;
	
	
	@OneToMany(targetEntity = com.poprlz.product.entity.ProductAttribute.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="productId")
	private List<ProductAttribute> productAttributeList;

	@OneToMany(targetEntity = com.poprlz.product.entity.ProductOption.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="productId")
	private List<ProductOption> productOptionList;
	
	@OneToMany(targetEntity = com.poprlz.product.entity.ProductReview.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="productId")
	private List<ProductReview> productReviewList;


	 
	@OneToMany(targetEntity = com.poprlz.product.entity.ProductImage.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="productId")
	private List<ProductImage> productImageList;
 	
	 
	public List<ProductAttribute> getProductAttributeList() {
		return productAttributeList;
	}

	public void setProductAttributeList(List<ProductAttribute> productAttributeList) {
		this.productAttributeList = productAttributeList;
	}

	public List<ProductOption> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<ProductOption> productOptionList) {
		this.productOptionList = productOptionList;
	}

	public List<ProductReview> getProductReviewList() {
		return productReviewList;
	}

	public void setProductReviewList(List<ProductReview> productReviewList) {
		this.productReviewList = productReviewList;
	}
  
	public List<ProductImage> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImage> productImageList) {
		this.productImageList = productImageList;
	}
 
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Categorie> getCatList() {
		return catList;
	}

	public void setCatList(List<Categorie> catList) {
		this.catList = catList;
	}

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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result
				+ ((dateAvailable == null) ? 0 : dateAvailable.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((ordered == null) ? 0 : ordered.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((stutas == null) ? 0 : stutas.hashCode());
		result = prime * result + ((viewed == null) ? 0 : viewed.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		ProductInfo other = (ProductInfo) obj;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (dateAvailable == null) {
			if (other.dateAvailable != null)
				return false;
		} else if (!dateAvailable.equals(other.dateAvailable))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (ordered == null) {
			if (other.ordered != null)
				return false;
		} else if (!ordered.equals(other.ordered))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (stutas == null) {
			if (other.stutas != null)
				return false;
		} else if (!stutas.equals(other.stutas))
			return false;
		if (viewed == null) {
			if (other.viewed != null)
				return false;
		} else if (!viewed.equals(other.viewed))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

 
	
	
	
}
