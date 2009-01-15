package org.light.portal.search.spring;

import java.util.LinkedList;
import java.util.List;

import org.light.portal.search.SearchFactory;
import org.light.portal.search.Searcher;
import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;
import org.light.portal.search.model.SearchResultItem;

public class SearcherImpl implements Searcher{
			
	public SearchResult search(SearchCriteria criteria) throws Exception{
		List<SearchResult> results = new LinkedList<SearchResult>();
		for(Searcher searcher : SearchFactory.getInstance().getSearchers()){
			results.add(searcher.search(criteria));
		}
		int total = 0;
		List<SearchResultItem> items = new LinkedList<SearchResultItem>();
		for(SearchResult result : results){
			total+=result.getTotal();
			items.addAll(result.getItems());
		}
		int number= 0;
		for(SearchResultItem item : items){
			item.setNumber(number++);
		}
		return new SearchResult(total, items);
	}
	public SearchResult search(Class klass, SearchCriteria criteria) throws Exception{
		Searcher searcher = SearchFactory.getInstance().getSearcher(klass);
		if(searcher != null){
			return searcher.search(criteria);
		}
		return null;
	}
		
}
