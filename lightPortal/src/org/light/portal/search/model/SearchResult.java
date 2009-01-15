package org.light.portal.search.model;

import java.util.List;

public class SearchResult {
	
	private int total;
	private List<SearchResultItem> items;
	
	public SearchResult(){
		
	}
	public SearchResult(int total,List<SearchResultItem> items){
		this();
		this.total = total;
		this.items = items;
	}

	public List<SearchResultItem> getItems() {	
		return items;
	}

	public int getTotal() {
		return total;
	}
	
}
