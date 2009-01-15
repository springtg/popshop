package org.light.portlets.ad.service;

import java.util.List;

import org.light.portlets.ad.CategoryAd;
import org.light.portlets.ad.CategoryAdComment;

public interface AdService {
	public CategoryAd getAdById(int id);
	public List<CategoryAdComment> getAdCommentsById(int id);
	public List<CategoryAd> getAdsByType(String type, int showNumber);
	public List<CategoryAd> getAdsByCategory(int category, int showNumber,String country,String province,String city);
}
