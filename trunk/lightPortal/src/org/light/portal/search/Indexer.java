package org.light.portal.search;

import org.light.portal.model.Entity;

public interface Indexer {
	
	public final static String _TYPE_ID= "portlet";
	public final static String _ENTRY_ID= "entryId";
	
	public void reIndex();
	public void reIndex(Class klass);
	public void deleteIndex(Entity entity);
	public void updateIndex(Entity entity);	
}
