package org.light.portlets.ad.dao.hibernate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portlets.ad.CategoryAd;
import org.light.portlets.ad.CategoryAdComment;
import org.light.portlets.ad.dao.AdDao;

public class AdDaoImpl extends BaseDaoImpl implements AdDao{
	
	public CategoryAd getAdById(int id){
		return (CategoryAd)this.getHibernateTemplate().get(CategoryAd.class, id);
	}
	public List<CategoryAdComment> getAdCommentsById(int id){
		List<CategoryAdComment> list = this.getHibernateTemplate().find("select comment from CategoryAdComment comment where comment.categoryAdId=? order by id asc ",id);		
		return list;
	}
	public List<CategoryAd> getAdsByType(String type, int showNumber){
		Date currentDate = new Date(System.currentTimeMillis());
		String hql="from CategoryAd ad where ad.status=1 and ad.showDate <='"+currentDate+"' and ad.endEffDate >='"+currentDate+"' order by id desc";//type=1, newest 
		if("2".equals(type))//most popular
			hql = "from CategoryAd ad where ad.status=1 and ad.showDate <='"+currentDate+"' and ad.endEffDate >='"+currentDate+"' order by score desc, id desc" ;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(0)
					.setMaxResults(showNumber);
		List<CategoryAd> list = query.list();
		session.close();
		return list;
	}
	
	public List<CategoryAd> getAdsByCategory(int category, int showNumber,String country,String province,String city){
		Date currentDate = new Date(System.currentTimeMillis());
		StringBuffer hql= new StringBuffer();
		hql.append("from CategoryAd ad where ad.category="+category+" and ad.showDate <='"+currentDate+"' and ad.endEffDate >='"+currentDate+"'");
		if(country != null && country.trim().length() > 0)
			hql.append(" and ad.country='"+country+"'");
		if(province != null && province.trim().length() > 0)
			hql.append(" and ad.province='"+province+"'");
		if(city != null && city.trim().length() > 0)
			hql.append(" and ad.city='"+city+"'");
		hql.append(" order by id desc");		
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql.toString())
							.setFirstResult(0)
							.setMaxResults(showNumber);
		if(showNumber == 0)
			query = session.createQuery(hql.toString());
		List<CategoryAd> list = query.list();
		session.close();
		return list;
	}
	
}
