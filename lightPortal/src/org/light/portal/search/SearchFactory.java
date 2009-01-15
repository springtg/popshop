package org.light.portal.search;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.light.portal.util.PropUtil;

public class SearchFactory {
	
	public static SearchFactory getInstance(){
		return _instance;
	}
	public Collection<Indexer> getIndexers(){
		return indexers.values();
	}
	public Indexer getIndexer(Class klass){
		return indexers.get(klass);
	}
	public Collection<Searcher> getSearchers(){
		return searchers.values();
	}
	public Searcher getSearcher(Class klass){
		return searchers.get(klass);
	}
	
	private SearchFactory(){
		String value=PropUtil.getString("portlet.search.list");
		String[] lists = value.split(";");
		for(String list : lists){
			String[] unit = list.split(",");
			try{
				Class klass = Class.forName(unit[0]);
				Indexer indexer = (Indexer)Class.forName(unit[1]).newInstance();
				indexers.put(klass,indexer);
				if(unit.length >= 3){
					Searcher searcher = (Searcher)Class.forName(unit[2]).newInstance();
					searchers.put(klass,searcher);
				}
			}catch(Exception e){
				continue;
			}
		}
	}
	
	private static SearchFactory _instance = new SearchFactory();
	private Map<Class,Indexer> indexers = new HashMap<Class,Indexer>();
	private Map<Class,Searcher> searchers = new HashMap<Class,Searcher>();
	
}
