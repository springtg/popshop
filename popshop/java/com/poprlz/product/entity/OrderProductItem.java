package com.poprlz.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "orderProductItem")
public class OrderProductItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderItemId")
	private Integer orderItemId;

	@ManyToOne(targetEntity = com.poprlz.product.entity.OrderInfomation.class)
	// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name = "orderId")
	private OrderInfomation orderInfomation;

	@OneToOne(targetEntity = com.poprlz.product.entity.ProductInfo.class)
	// cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name = "productId")
	private ProductInfo productInfo;

	@Column(name="prodModel",length=100, nullable=false)
	private String prodModel;

	@Column(name="prodName",length=100, nullable=false)
	private String prodName;

	@Column(name="prodPice", nullable=false)
	private BigDecimal prodPice;

	@Column(name="finalPrice", nullable=false)
	private BigDecimal finalPrice;

	@Column(name="tax", nullable=false)
	private BigDecimal tax;

	@Column(name="qrantity", nullable=false)
	private Integer qrantity;

	@Column(name="mark")
	private String mark;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderInfomation getOrderInfomation() {
		return orderInfomation;
	}

	public void setOrderInfomation(OrderInfomation orderInfomation) {
		this.orderInfomation = orderInfomation;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getProdModel() {
		return prodModel;
	}

	public void setProdModel(String prodModel) {
		this.prodModel = prodModel;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public BigDecimal getProdPice() {
		return prodPice;
	}

	public void setProdPice(BigDecimal prodPice) {
		this.prodPice = prodPice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Integer getQrantity() {
		return qrantity;
	}

	public void setQrantity(Integer qrantity) {
		this.qrantity = qrantity;
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
		result = prime * result
				+ ((finalPrice == null) ? 0 : finalPrice.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result
				+ ((orderInfomation == null) ? 0 : orderInfomation.hashCode());
		result = prime * result
				+ ((orderItemId == null) ? 0 : orderItemId.hashCode());
		result = prime * result
				+ ((prodModel == null) ? 0 : prodModel.hashCode());
		result = prime * result
				+ ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result
				+ ((prodPice == null) ? 0 : prodPice.hashCode());
		result = prime * result
				+ ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result
				+ ((qrantity == null) ? 0 : qrantity.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
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
		OrderProductItem other = (OrderProductItem) obj;
		if (finalPrice == null) {
			if (other.finalPrice != null)
				return false;
		} else if (!finalPrice.equals(other.finalPrice))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (orderInfomation == null) {
			if (other.orderInfomation != null)
				return false;
		} else if (!orderInfomation.equals(other.orderInfomation))
			return false;
		if (orderItemId == null) {
			if (other.orderItemId != null)
				return false;
		} else if (!orderItemId.equals(other.orderItemId))
			return false;
		if (prodModel == null) {
			if (other.prodModel != null)
				return false;
		} else if (!prodModel.equals(other.prodModel))
			return false;
		if (prodName == null) {
			if (other.prodName != null)
				return false;
		} else if (!prodName.equals(other.prodName))
			return false;
		if (prodPice == null) {
			if (other.prodPice != null)
				return false;
		} else if (!prodPice.equals(other.prodPice))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (qrantity == null) {
			if (other.qrantity != null)
				return false;
		} else if (!qrantity.equals(other.qrantity))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		return true;
	}
	
	
 
}
