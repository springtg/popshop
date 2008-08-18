package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class ManufacturerDaoImple<Manufacturer> extends
		HibernateGenericDao<Manufacturer> implements
		IManufacturerDao<Manufacturer> {

	@Override
	public List<Manufacturer> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from Manufacturer as manufacturer ");

		return query.list();
	}

	public Manufacturer loadEntity(Serializable manufacturerId) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  Manufacturer as manufacturer  where manufacturer.manufacturerId =:manufacturerId");
		query.setParameter("manufacturerId", manufacturerId);
		List manufacturerList = query.list();
		if (manufacturerList == null || manufacturerList.size() < 1)
			return null;
		Manufacturer manufacturer = (Manufacturer) manufacturerList.get(0);
		return manufacturer;
	}

}
