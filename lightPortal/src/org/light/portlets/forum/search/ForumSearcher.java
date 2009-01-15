package org.light.portlets.forum.search;

import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.light.portal.model.UserEntity;
import org.light.portal.search.Indexer;
import org.light.portal.search.SearcherUtil;
import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;
import org.light.portal.search.model.SearchResultItem;

public class ForumSearcher implements org.light.portal.search.Searcher{
	
	public SearchResult search(Class entityType, SearchCriteria criteria) throws Exception{
		if(!UserEntity.class.equals(entityType)) return null;
		return search(criteria);
	}
	public SearchResult search(SearchCriteria criteria) throws Exception { 
		SearchResult result = null;
		try {
			IndexReader reader = IndexReader.open(SearcherUtil.getPath());
			Searcher searcher = new IndexSearcher(reader);
			Analyzer analyer = new StandardAnalyzer();
			BooleanQuery query = new BooleanQuery();
			Query query1 = new QueryParser(Indexer._TYPE_ID,analyer).parse(ForumIndexer._TYPE_VALUE);			
			query.add(query1,BooleanClause.Occur.MUST);
			if(criteria.getKeyword() != null){
				Query query2 = new QueryParser("keyword",analyer).parse(SearcherUtil.getKeyword(criteria.getKeyword()));
				query.add(query2,BooleanClause.Occur.MUST);
			}
			Sort sort = new Sort(criteria.getSort());
			TopDocs docs = searcher.search(query,null,SearcherUtil.top(),sort);
			ScoreDoc[] scoreDocs = docs.scoreDocs;			
			int total = docs.totalHits;						
			List<SearchResultItem> items = null;
			items = new LinkedList<SearchResultItem>();
			for(int i=0;i<total;i++){
				Document doc = searcher.doc(scoreDocs[i].doc);
				items.add(new SearchResultItem(
						i,
						doc.get("id"),
						doc.get("name"),
						doc.get("uri"),
						doc.get("photoUrl"),
						doc.get("photoWidth"),
						doc.get("photoHeight"),
						doc.get("subject"),
						doc.get("summary"),
						doc.get("content"),
						doc.get("link"),
						ForumIndexer._TYPE_DESC
						));
			}				
			result = new SearchResult(total,items);	
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
        return result;
	}

}