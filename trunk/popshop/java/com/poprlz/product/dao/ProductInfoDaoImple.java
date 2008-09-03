package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class ProductInfoDaoImple<ProductInfo> extends
		HibernateGenericDao<ProductInfo> implements
		IProductInfoDao<ProductInfo> {

	@Override
	public List<ProductInfo> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from ProductInfo as productInfo ");

		return query.list();
	}

	public ProductInfo loadEntity(Serializable productId) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo  where productInfo.productId =:productId");
		query.setParameter("productId", productId);
		List ProductInfoList = query.list();
		if (ProductInfoList == null || ProductInfoList.size() < 1)
			return null;
		ProductInfo productInfo = (ProductInfo) ProductInfoList.get(0);
		return productInfo;
	}

	public List<ProductInfo> getNewProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<:currentDate and quantity>0 order by lastModified ");

		query.setDate("currentDate", new Date());

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

	public List<ProductInfo> getTopSellProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<:currentDate and quantity>0 order by ordered ");

		query.setDate("currentDate", new Date());

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

	public List<ProductInfo> getTopViewProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<:currentDate and quantity>0 order by viewed ");

		query.setDate("currentDate", new Date());

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

}
