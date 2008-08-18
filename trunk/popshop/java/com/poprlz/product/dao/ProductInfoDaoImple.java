package com.poprlz.product.dao;

import java.io.Serializable;
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

}
