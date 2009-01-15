package org.light.portal.search.spring;

import org.light.portal.model.Entity;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserProfile;
import org.light.portal.search.Indexer;
import org.light.portal.search.SearchFactory;

public class IndexerImpl implements Indexer{
	
	public void reIndex(){
		for(Indexer indexer : SearchFactory.getInstance().getIndexers()){
			indexer.reIndex();
		}
	}
	
	public void reIndex(Class klass){
		Indexer indexer = SearchFactory.getInstance().getIndexer(klass);
		if(indexer != null){
			indexer.reIndex();
		}
	}
	
	public void updateIndex(Entity entity){
		Indexer indexer = SearchFactory.getInstance().getIndexer(entity.getClass());
		if(indexer != null){
			indexer.updateIndex(entity);
		}
	}
	
	public void deleteIndex(Entity entity){
		Indexer indexer = SearchFactory.getInstance().getIndexer(entity.getClass());
		if(indexer != null){
			indexer.deleteIndex(entity);
		}
	}

}
