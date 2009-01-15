package org.light.portal.search;

import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;

public interface Searcher {
	public SearchResult search(SearchCriteria criteria) throws Exception;
	public SearchResult search(Class klass, SearchCriteria criteria) throws Exception;
}
