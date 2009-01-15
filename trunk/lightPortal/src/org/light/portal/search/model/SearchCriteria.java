package org.light.portal.search.model;

import org.light.portal.util.PropUtil;

public class SearchCriteria {

	private String keyword;
	private int page = 1;
	private int rowPerPage = 5;
	private String sort;
	
	public SearchCriteria(){
		try{
			page = Integer.parseInt(PropUtil.getString("search.criteria.page.begin"));
			rowPerPage = Integer.parseInt(PropUtil.getString("search.criteria.page.rows"));
			sort = PropUtil.getString("search.criteria.sort");
		}catch(Exception e){}
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
