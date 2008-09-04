package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.Inject;
import com.poprlz.product.dao.IProductInfoDao;
import com.poprlz.product.entity.Categorie;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.web.ProductInfoView;
import com.poprlz.util.PaginationSupport;

public class ProductServiceLogic implements  IProductServiceLogic{

	
	@Inject
	private IProductInfoDao<ProductInfo> productInfoDao;
	 
	public List<ProductInfo> getNewProducts() throws ServiceException {
		List<ProductInfo>  productInfoList=productInfoDao.getNewProducts();
		
		if(productInfoList==null || productInfoList.size()<1)
			throw new ServiceException("These is no Product Infomation");
		return productInfoList;
		 
	}

	public List<ProductInfo> getTopSellProducts()   throws ServiceException {
		List<ProductInfo>  productInfoList=productInfoDao.getTopSellProducts();
		
		if(productInfoList==null || productInfoList.size()<1)
			throw new ServiceException("These is no Product Infomation");
		return productInfoList;
	}

	public List<ProductInfo> getTopViewProducts()   throws ServiceException {
		List<ProductInfo>  productInfoList=productInfoDao.getTopViewProducts();
		
		if(productInfoList==null || productInfoList.size()<1)
			throw new ServiceException("These is no Product Infomation");
		return productInfoList;
	}

	public PaginationSupport<ProductInfoView> searchProductAction(
			int currentPage, String productName, int manufacturerId,
			int categorieId, int orderType) {
		// TODO Auto-generated method stub
		return null;
	}

}
