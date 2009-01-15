package org.light.portal.search;

import java.io.File;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.light.portal.core.service.ServiceContext;
import org.light.portal.model.Entity;
import org.light.portal.user.dao.UserDao;

public abstract class GenericIndexer implements Indexer{
	
	protected void deleteAllIndex(String type){
		try {			
			File file = new File(SearcherUtil.getPath());
			if(!file.exists()) return;
			IndexReader reader = IndexReader.open(SearcherUtil.getPath());
			Term term = new Term(_TYPE_ID, type);
			int deleted = reader.deleteDocuments(term);
			reader.close();

	    } catch (Exception e) {
	     
	    }
	}

	protected void deleteIndex(Entity entity, String type){
		try {
			File file = new File(SearcherUtil.getPath());
			if(!file.exists()) return;
			IndexReader reader = IndexReader.open(SearcherUtil.getPath());
			Term term = new Term(_ENTRY_ID, type+String.valueOf(entity.getId()));
			int deleted = reader.deleteDocuments(term);
			reader.close();

	    } catch (Exception e) {
	     
	    }
	}

	protected UserDao getUserDao() {
		return (UserDao)ServiceContext.getInstance().getContext().getBean("userDao");
	}
	
}