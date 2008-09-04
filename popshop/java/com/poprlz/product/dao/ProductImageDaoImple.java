package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class ProductImageDaoImple<ProductImage> extends
		HibernateGenericDao<ProductImage> implements
		IProductImageDao<ProductImage> {

	public ProductImage loadEntity(Serializable imageId) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductImage as productImage  where productImage.imageId =:imageId");
		query.setParameter("imageId", imageId);
		List productImageList = query.list();
		if (productImageList == null || productImageList.size() < 1)
			return null;
		ProductImage productImage = (ProductImage) productImageList.get(0);
		return productImage;
	}

	public List<ProductImage> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from ProductImage as productImage ");

		return query.list();
	}

}
