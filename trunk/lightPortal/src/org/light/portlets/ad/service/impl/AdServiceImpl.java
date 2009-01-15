package org.light.portlets.ad.service.impl;

import java.util.List;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.ad.CategoryAd;
import org.light.portlets.ad.CategoryAdComment;
import org.light.portlets.ad.dao.AdDao;
import org.light.portlets.ad.service.AdService;

public class AdServiceImpl extends BaseServiceImpl implements AdService{
	private AdDao adDao;
	
	public CategoryAd getAdById(int id){
	    return adDao.getAdById(id);	
	}
	
	public List<CategoryAdComment> getAdCommentsById(int id){
		return adDao.getAdCommentsById(id);
	}
	
	public List<CategoryAd> getAdsByType(String type, int showNumber){
		return adDao.getAdsByType(type,showNumber);
	}
	
	public List<CategoryAd> getAdsByCategory(int category, int showNumber,String country,String province,String city){
		return adDao.getAdsByCategory(category,showNumber,country,province,city);
	}
	
	public AdDao getAdDao() {
		return adDao;
	}
	public void setAdDao(AdDao adDao) {
		this.adDao = adDao;
	}
}
