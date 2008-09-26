package com.poprlz.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.ProductImage;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.product.logic.IShopCartServiceLogic;
import com.poprlz.product.web.bean.ShopCart;
import com.poprlz.product.web.bean.ShopCartProductItem;
import com.poprlz.user.entity.UserInfo;

public class ShopCartInfoManagerAction extends ActionSupport {
	
	@Inject
	private IShopCartServiceLogic shopCartServiceLogic; 
	
	@Inject
	private IProductServiceLogic productServiceLogic;
	
	private Integer productId;		 
	 
	private Integer orderQuantity;	
	
	private ShopCart shopCartInfo;
	
	
	public ShopCart getShopCartInfo() {
		return shopCartInfo;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String saveProductItem() throws Exception {
		
		String sessionId=getHttpSession().getId();
		ShopCart shopCart=loadShopCartInfo(sessionId);
		
		if(shopCart==null){
			shopCart=createNewShopCart();
		}
		
		ShopCartProductItem shopCartProductItem= createShopCartProductItem(sessionId);
		
		shopCartInfo=shopCartServiceLogic.saveProductItem(shopCart,shopCartProductItem);
		return SUCCESS;
		
		
		
	}
	
	public String shopCartInfoLoad()throws Exception {
		
		String sessionId=getHttpSession().getId();
		shopCartInfo=loadShopCartInfo(sessionId);
		return SUCCESS;
	}
	
	private HttpSession getHttpSession(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		
		return request.getSession(true);
		
		
	}
	
	private ShopCart loadShopCartInfo(String sessionId){
		return shopCartServiceLogic.loadShopCartInfo(sessionId);
	}
	
	private ShopCartProductItem createShopCartProductItem(String sessionId){
		
		ShopCartProductItem shopCartProductItem=new ShopCartProductItem();
		shopCartProductItem.setProductId(productId);
		shopCartProductItem.setSessionId(sessionId);
		shopCartProductItem.setOrderQuantity(orderQuantity);
		ProductInfo productInfo=productServiceLogic.loadProductInfoLogic(productId);
		shopCartProductItem.setDescription(productInfo.getDescription());
		shopCartProductItem.setPrice(productInfo.getPrice());
		shopCartProductItem.setProductName(productInfo.getProductName());
		shopCartProductItem.setURL(productInfo.getURL());
		shopCartProductItem.setWeight(productInfo.getWeight());
		
		List<ProductImage> imageList=productInfo.getProductImageList();
		
		if(imageList!=null && imageList.size()>0){
			shopCartProductItem.setImageId(imageList.get(0).getImageId()); 
			shopCartProductItem.setImgPath(imageList.get(0).getPath());
		}
		return shopCartProductItem;
	}
	
	private ShopCart createNewShopCart(){
		
		ShopCart shopCart=new ShopCart();
		
		HttpServletRequest request = ServletActionContext.getRequest(); 
		
		HttpSession httpSession= request.getSession(true);
		
		shopCart.setClientIP(request.getRemoteAddr());
		shopCart.setSessionId(httpSession.getId());
		
		UserInfo userInfo=(UserInfo)httpSession.getAttribute("userInfo");
		
		if(userInfo!=null){
			shopCart.setUserInfoId(userInfo.getUserInfoId());
			shopCart.setUserName(userInfo.getUserName());
			
		}
		shopCart=shopCartServiceLogic.saveShopCartInfo(shopCart);
		return shopCart;
		
		 
		 
		
		
	}

}
