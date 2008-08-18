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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.poprlz.user.entity.UserInfo;


@Entity
@Table(name = "orderInfomation")
public class OrderInfomation implements Serializable {
	
	public static final int INIT_STATUS=0;//客户刚刚下订单的状态
	public static final int ENSURE_STATUS=1;//客户确认订单的状态
	 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")	
	private Integer orderId;

	@ManyToOne(targetEntity = com.poprlz.user.entity.UserInfo.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="userInfoId")
	private UserInfo userInfo;

	@Column(name="customerName",length=100, nullable=false)
	private String customerName;


	@Column(name="customerCompany",length=200)
	private String customerCompany;

	@Column(name="customerStreetAddress",length=200)
	private String customerStreetAddress;

	@Column(name="customerSuburb",length=200)
	private String customerSuburb;

	@Column(name="customerCity",length=200)
	private String customerCity;

	@Column(name="customerPostcode",length=100)
	private String customerPostcode;
	
	@Column(name="customerSate",length=200)
	private String customerSate;
	
	@Column(name="customerCountry",length=200)
	private String customerCountry;

	@Column(name="customerTelephone",length=50)
	private String customerTelephone;
	
	@Column(name="customerEmailAddress",length=100)
	private String customerEmailAddress;

	@Column(name="customerMobile",length=100)
	private String customerMobile;

	@Column(name="deliveryName",length=100,nullable=false)
	private String deliveryName;

	@Column(name="deliveryCompany",length=100,nullable=false)
	private String deliveryCompany;

	@Column(name="deliveryStreetAddress",length=100,nullable=false)
	private String deliveryStreetAddress;

	@Column(name="deliverySuburb",length=100,nullable=false)
	private String deliverySuburb;

	@Column(name="deliveryCity",length=100)
	private String deliveryCity;

	@Column(name="deliveryPostcode",length=100)
	private String deliveryPostcode;

	@Column(name="deliveryState",length=100)
	private String deliveryState;

	@Column(name="deliveryCountry",length=100)
	private String deliveryCountry;

	@Column(name="deliveryMobile",length=100)
	private String deliveryMobile;

	@Column(name="deliveryEmail",length=100)
	private String deliveryEmail; 
 
	@Column(name="deliveryTelephone",length=100)
	private String deliveryTelephone;
	

	@Column(name="paymentMethod",length=100)
	private String paymentMethod;

	@Column(name="ccType",length=100)
	private String ccType;

	@Column(name="ccOwner",length=100)
	private String ccOwner;

	@Column(name="ccNumber",length=100)
	private String ccNumber;

	@Column(name="ccExpires",length=100)
	private String ccExpires;

	@Column(name="lastModified")
	private Date lastModified;

	@Column(name="datePurchased")
	private Date datePurchased;

	@Column(name="orderStatus")
	private Integer orderStatus;

	@Column(name="orderDateFinished")
	private Date orderDateFinished;

	@Column(name="currency",length=100)
	private String currency;


	@Column(name="orderBillNumber",length=100)
	private String orderBillNumber;
	

	
	@Column(name="orderMark",length=255)
	private String orderMark;
	

	@Column(name="finalOrderPrice")
	private BigDecimal finalOrderPrice;
	
	
	@OneToMany(targetEntity = com.poprlz.product.entity.OrderProductItem.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="orderId")
	private List<OrderProductItem> orderProductItemList;


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerCompany() {
		return customerCompany;
	}


	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}


	public String getCustomerStreetAddress() {
		return customerStreetAddress;
	}


	public void setCustomerStreetAddress(String customerStreetAddress) {
		this.customerStreetAddress = customerStreetAddress;
	}


	public String getCustomerSuburb() {
		return customerSuburb;
	}


	public void setCustomerSuburb(String customerSuburb) {
		this.customerSuburb = customerSuburb;
	}


	public String getCustomerCity() {
		return customerCity;
	}


	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}


	public String getCustomerPostcode() {
		return customerPostcode;
	}


	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}


	public String getCustomerSate() {
		return customerSate;
	}


	public void setCustomerSate(String customerSate) {
		this.customerSate = customerSate;
	}


	public String getCustomerCountry() {
		return customerCountry;
	}


	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}


	public String getCustomerTelephone() {
		return customerTelephone;
	}


	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}


	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}


	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}


	public String getCustomerMobile() {
		return customerMobile;
	}


	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}


	public String getDeliveryName() {
		return deliveryName;
	}


	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}


	public String getDeliveryCompany() {
		return deliveryCompany;
	}


	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}


	public String getDeliveryStreetAddress() {
		return deliveryStreetAddress;
	}


	public void setDeliveryStreetAddress(String deliveryStreetAddress) {
		this.deliveryStreetAddress = deliveryStreetAddress;
	}


	public String getDeliverySuburb() {
		return deliverySuburb;
	}


	public void setDeliverySuburb(String deliverySuburb) {
		this.deliverySuburb = deliverySuburb;
	}


	public String getDeliveryCity() {
		return deliveryCity;
	}


	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}


	public String getDeliveryPostcode() {
		return deliveryPostcode;
	}


	public void setDeliveryPostcode(String deliveryPostcode) {
		this.deliveryPostcode = deliveryPostcode;
	}


	public String getDeliveryState() {
		return deliveryState;
	}


	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}


	public String getDeliveryCountry() {
		return deliveryCountry;
	}


	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}


	public String getDeliveryMobile() {
		return deliveryMobile;
	}


	public void setDeliveryMobile(String deliveryMobile) {
		this.deliveryMobile = deliveryMobile;
	}


	public String getDeliveryEmail() {
		return deliveryEmail;
	}


	public void setDeliveryEmail(String deliveryEmail) {
		this.deliveryEmail = deliveryEmail;
	}


	public String getDeliveryTelephone() {
		return deliveryTelephone;
	}


	public void setDeliveryTelephone(String deliveryTelephone) {
		this.deliveryTelephone = deliveryTelephone;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getCcType() {
		return ccType;
	}


	public void setCcType(String ccType) {
		this.ccType = ccType;
	}


	public String getCcOwner() {
		return ccOwner;
	}


	public void setCcOwner(String ccOwner) {
		this.ccOwner = ccOwner;
	}


	public String getCcNumber() {
		return ccNumber;
	}


	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}


	public String getCcExpires() {
		return ccExpires;
	}


	public void setCcExpires(String ccExpires) {
		this.ccExpires = ccExpires;
	}


	public Date getLastModified() {
		return lastModified;
	}


	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}


	public Date getDatePurchased() {
		return datePurchased;
	}


	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}


	public Integer getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getOrderDateFinished() {
		return orderDateFinished;
	}


	public void setOrderDateFinished(Date orderDateFinished) {
		this.orderDateFinished = orderDateFinished;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getOrderBillNumber() {
		return orderBillNumber;
	}


	public void setOrderBillNumber(String orderBillNumber) {
		this.orderBillNumber = orderBillNumber;
	}


	public String getOrderMark() {
		return orderMark;
	}


	public void setOrderMark(String orderMark) {
		this.orderMark = orderMark;
	}


	public BigDecimal getFinalOrderPrice() {
		return finalOrderPrice;
	}


	public void setFinalOrderPrice(BigDecimal finalOrderPrice) {
		this.finalOrderPrice = finalOrderPrice;
	}


	public List<OrderProductItem> getOrderProductItemList() {
		return orderProductItemList;
	}


	public void setOrderProductItemList(List<OrderProductItem> orderProductItemList) {
		this.orderProductItemList = orderProductItemList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ccExpires == null) ? 0 : ccExpires.hashCode());
		result = prime * result
				+ ((ccNumber == null) ? 0 : ccNumber.hashCode());
		result = prime * result + ((ccOwner == null) ? 0 : ccOwner.hashCode());
		result = prime * result + ((ccType == null) ? 0 : ccType.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((customerCity == null) ? 0 : customerCity.hashCode());
		result = prime * result
				+ ((customerCompany == null) ? 0 : customerCompany.hashCode());
		result = prime * result
				+ ((customerCountry == null) ? 0 : customerCountry.hashCode());
		result = prime
				* result
				+ ((customerEmailAddress == null) ? 0 : customerEmailAddress
						.hashCode());
		result = prime * result
				+ ((customerMobile == null) ? 0 : customerMobile.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime
				* result
				+ ((customerPostcode == null) ? 0 : customerPostcode.hashCode());
		result = prime * result
				+ ((customerSate == null) ? 0 : customerSate.hashCode());
		result = prime
				* result
				+ ((customerStreetAddress == null) ? 0 : customerStreetAddress
						.hashCode());
		result = prime * result
				+ ((customerSuburb == null) ? 0 : customerSuburb.hashCode());
		result = prime
				* result
				+ ((customerTelephone == null) ? 0 : customerTelephone
						.hashCode());
		result = prime * result
				+ ((datePurchased == null) ? 0 : datePurchased.hashCode());
		result = prime * result
				+ ((deliveryCity == null) ? 0 : deliveryCity.hashCode());
		result = prime * result
				+ ((deliveryCompany == null) ? 0 : deliveryCompany.hashCode());
		result = prime * result
				+ ((deliveryCountry == null) ? 0 : deliveryCountry.hashCode());
		result = prime * result
				+ ((deliveryEmail == null) ? 0 : deliveryEmail.hashCode());
		result = prime * result
				+ ((deliveryMobile == null) ? 0 : deliveryMobile.hashCode());
		result = prime * result
				+ ((deliveryName == null) ? 0 : deliveryName.hashCode());
		result = prime
				* result
				+ ((deliveryPostcode == null) ? 0 : deliveryPostcode.hashCode());
		result = prime * result
				+ ((deliveryState == null) ? 0 : deliveryState.hashCode());
		result = prime
				* result
				+ ((deliveryStreetAddress == null) ? 0 : deliveryStreetAddress
						.hashCode());
		result = prime * result
				+ ((deliverySuburb == null) ? 0 : deliverySuburb.hashCode());
		result = prime
				* result
				+ ((deliveryTelephone == null) ? 0 : deliveryTelephone
						.hashCode());
		result = prime * result
				+ ((finalOrderPrice == null) ? 0 : finalOrderPrice.hashCode());
		result = prime * result
				+ ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result
				+ ((orderBillNumber == null) ? 0 : orderBillNumber.hashCode());
		result = prime
				* result
				+ ((orderDateFinished == null) ? 0 : orderDateFinished
						.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((orderMark == null) ? 0 : orderMark.hashCode());
		result = prime
				* result
				+ ((orderProductItemList == null) ? 0 : orderProductItemList
						.hashCode());
		result = prime * result
				+ ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result
				+ ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result
				+ ((userInfo == null) ? 0 : userInfo.hashCode());
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
		OrderInfomation other = (OrderInfomation) obj;
		if (ccExpires == null) {
			if (other.ccExpires != null)
				return false;
		} else if (!ccExpires.equals(other.ccExpires))
			return false;
		if (ccNumber == null) {
			if (other.ccNumber != null)
				return false;
		} else if (!ccNumber.equals(other.ccNumber))
			return false;
		if (ccOwner == null) {
			if (other.ccOwner != null)
				return false;
		} else if (!ccOwner.equals(other.ccOwner))
			return false;
		if (ccType == null) {
			if (other.ccType != null)
				return false;
		} else if (!ccType.equals(other.ccType))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (customerCity == null) {
			if (other.customerCity != null)
				return false;
		} else if (!customerCity.equals(other.customerCity))
			return false;
		if (customerCompany == null) {
			if (other.customerCompany != null)
				return false;
		} else if (!customerCompany.equals(other.customerCompany))
			return false;
		if (customerCountry == null) {
			if (other.customerCountry != null)
				return false;
		} else if (!customerCountry.equals(other.customerCountry))
			return false;
		if (customerEmailAddress == null) {
			if (other.customerEmailAddress != null)
				return false;
		} else if (!customerEmailAddress.equals(other.customerEmailAddress))
			return false;
		if (customerMobile == null) {
			if (other.customerMobile != null)
				return false;
		} else if (!customerMobile.equals(other.customerMobile))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPostcode == null) {
			if (other.customerPostcode != null)
				return false;
		} else if (!customerPostcode.equals(other.customerPostcode))
			return false;
		if (customerSate == null) {
			if (other.customerSate != null)
				return false;
		} else if (!customerSate.equals(other.customerSate))
			return false;
		if (customerStreetAddress == null) {
			if (other.customerStreetAddress != null)
				return false;
		} else if (!customerStreetAddress.equals(other.customerStreetAddress))
			return false;
		if (customerSuburb == null) {
			if (other.customerSuburb != null)
				return false;
		} else if (!customerSuburb.equals(other.customerSuburb))
			return false;
		if (customerTelephone == null) {
			if (other.customerTelephone != null)
				return false;
		} else if (!customerTelephone.equals(other.customerTelephone))
			return false;
		if (datePurchased == null) {
			if (other.datePurchased != null)
				return false;
		} else if (!datePurchased.equals(other.datePurchased))
			return false;
		if (deliveryCity == null) {
			if (other.deliveryCity != null)
				return false;
		} else if (!deliveryCity.equals(other.deliveryCity))
			return false;
		if (deliveryCompany == null) {
			if (other.deliveryCompany != null)
				return false;
		} else if (!deliveryCompany.equals(other.deliveryCompany))
			return false;
		if (deliveryCountry == null) {
			if (other.deliveryCountry != null)
				return false;
		} else if (!deliveryCountry.equals(other.deliveryCountry))
			return false;
		if (deliveryEmail == null) {
			if (other.deliveryEmail != null)
				return false;
		} else if (!deliveryEmail.equals(other.deliveryEmail))
			return false;
		if (deliveryMobile == null) {
			if (other.deliveryMobile != null)
				return false;
		} else if (!deliveryMobile.equals(other.deliveryMobile))
			return false;
		if (deliveryName == null) {
			if (other.deliveryName != null)
				return false;
		} else if (!deliveryName.equals(other.deliveryName))
			return false;
		if (deliveryPostcode == null) {
			if (other.deliveryPostcode != null)
				return false;
		} else if (!deliveryPostcode.equals(other.deliveryPostcode))
			return false;
		if (deliveryState == null) {
			if (other.deliveryState != null)
				return false;
		} else if (!deliveryState.equals(other.deliveryState))
			return false;
		if (deliveryStreetAddress == null) {
			if (other.deliveryStreetAddress != null)
				return false;
		} else if (!deliveryStreetAddress.equals(other.deliveryStreetAddress))
			return false;
		if (deliverySuburb == null) {
			if (other.deliverySuburb != null)
				return false;
		} else if (!deliverySuburb.equals(other.deliverySuburb))
			return false;
		if (deliveryTelephone == null) {
			if (other.deliveryTelephone != null)
				return false;
		} else if (!deliveryTelephone.equals(other.deliveryTelephone))
			return false;
		if (finalOrderPrice == null) {
			if (other.finalOrderPrice != null)
				return false;
		} else if (!finalOrderPrice.equals(other.finalOrderPrice))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (orderBillNumber == null) {
			if (other.orderBillNumber != null)
				return false;
		} else if (!orderBillNumber.equals(other.orderBillNumber))
			return false;
		if (orderDateFinished == null) {
			if (other.orderDateFinished != null)
				return false;
		} else if (!orderDateFinished.equals(other.orderDateFinished))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderMark == null) {
			if (other.orderMark != null)
				return false;
		} else if (!orderMark.equals(other.orderMark))
			return false;
		if (orderProductItemList == null) {
			if (other.orderProductItemList != null)
				return false;
		} else if (!orderProductItemList.equals(other.orderProductItemList))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		return true;
	}
	
	
	
 
}
