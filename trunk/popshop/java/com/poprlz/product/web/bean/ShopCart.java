package com.poprlz.product.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.poprlz.user.entity.UserInfo;

public class ShopCart implements Serializable {

	private String sessionId;

	private Integer userInfoId;
	
	private String userName;

	private Date createDate;

	private Date lastAcessDate;

	private String clientIP;
	
	private BigDecimal totalPrice;

	private List<ShopCartProductItem> productItemInfo;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

 

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastAcessDate() {
		return lastAcessDate;
	}

	public void setLastAcessDate(Date lastAcessDate) {
		this.lastAcessDate = lastAcessDate;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public List<ShopCartProductItem> getProductItemInfo() {
		return productItemInfo;
	}

	public void setProductItemInfo(List<ShopCartProductItem> productItemInfo) {
		this.productItemInfo = productItemInfo;
	}

	public Integer getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientIP == null) ? 0 : clientIP.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((lastAcessDate == null) ? 0 : lastAcessDate.hashCode());
		result = prime * result
				+ ((productItemInfo == null) ? 0 : productItemInfo.hashCode());
		result = prime * result
				+ ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result
				+ ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result
				+ ((userInfoId == null) ? 0 : userInfoId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		ShopCart other = (ShopCart) obj;
		if (clientIP == null) {
			if (other.clientIP != null)
				return false;
		} else if (!clientIP.equals(other.clientIP))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (lastAcessDate == null) {
			if (other.lastAcessDate != null)
				return false;
		} else if (!lastAcessDate.equals(other.lastAcessDate))
			return false;
		if (productItemInfo == null) {
			if (other.productItemInfo != null)
				return false;
		} else if (!productItemInfo.equals(other.productItemInfo))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (userInfoId == null) {
			if (other.userInfoId != null)
				return false;
		} else if (!userInfoId.equals(other.userInfoId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	 
	
	

}
