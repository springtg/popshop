package org.light.portlets.forum.search;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.light.portal.core.service.ServiceContext;
import org.light.portal.model.Entity;
import org.light.portal.model.User;
import org.light.portal.search.GenericIndexer;
import org.light.portal.search.Indexer;
import org.light.portal.search.SearcherUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.dao.ForumDao;

public class ForumIndexer extends GenericIndexer implements Indexer{
	
	public final static String _TYPE_VALUE = "forum";
	public final static String _TYPE_DESC = "Forum";
	
	public synchronized void reIndex(){
		deleteAllIndex(_TYPE_VALUE);
		List<ForumPost> posts = getForumDao().getPosts(OrganizationThreadLocal.getOrganizationId());
		for(ForumPost post : posts){
			addIndex(post);
		}		
	}
	public synchronized void reIndex(Class entityType){
		if(!ForumPost.class.equals(entityType)) return;
		reIndex();
	}

	public void deleteIndex(Entity entity){
		if(!(entity instanceof ForumPost)) return;
		deleteIndex(entity,_TYPE_VALUE);
	}
	public void  updateIndex(Entity entity){
		if(!(entity instanceof ForumPost)) return;
		ForumPost post = (ForumPost)entity;
		try {
			deleteIndex(entity);
		}
		catch (Exception e) {
		}
	
		addIndex(post);
	}
	
	protected void addIndex(ForumPost post){
		try{
			File file = new File(SearcherUtil.getPath());
			boolean isNew = !file.exists();
			IndexWriter writer = new IndexWriter(SearcherUtil.getPath(), new StandardAnalyzer(), isNew, IndexWriter.MaxFieldLength.LIMITED);
			List<Document> docs = getEntryDocuments(post);
			for(Document doc : docs){
				if(doc != null)
					writer.addDocument(doc);
			}  	      	      
		      writer.optimize();
		      writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	private  List<Document> getEntryDocuments(ForumPost post) {
		List<Document> docs = new LinkedList<Document>();
		try{			
			docs.add(this.getPublicDocument(post));
		}catch(Exception e){
			
		}
		return docs;
	}	
		
	private  Document getPublicDocument(ForumPost post) {
		try{			
			Document doc = new Document();	
			String entryId = _TYPE_VALUE+String.valueOf(post.getId());	
			doc.add(new Field(_TYPE_ID,_TYPE_VALUE, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field(_ENTRY_ID,entryId, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("id",String.valueOf(post.getId()), Store.YES, Index.NOT_ANALYZED));			
			if(post.getTopic() != null)
				doc.add(new Field("subject",post.getTopic(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("content",post.getContent(), Store.YES, Index.NOT_ANALYZED));			
			doc.add(new Field("link","http://www."+OrganizationThreadLocal.getWebId()+"/viewtopic.do?id="+((post.getTopicId() > 0) ? post.getTopicId() : post.getId())+"p1", Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("userId",String.valueOf(post.getPostById()), Store.YES, Index.NOT_ANALYZED));			
						
			User user = this.getUserDao().getUserById(post.getPostById());
			doc.add(new Field("name",user.getName(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("uri",user.getUri(), Store.YES, Index.NOT_ANALYZED));
			if(user.getPhotoUrl() != null){
				doc.add(new Field("photoUrl",user.getPhotoUrl(), Store.YES, Index.NO));
				doc.add(new Field("photoWidth",String.valueOf(user.getPhotoWidth()), Store.YES, Index.NO));
				doc.add(new Field("photoHeight",String.valueOf(user.getPhotoHeight()), Store.YES, Index.NO));
			}
			if(post.getTopic() != null)
				doc.add(new Field("keyword",post.getTopic().toLowerCase(), Store.YES, Index.ANALYZED));			
			doc.add(new Field("keyword",post.getContent().toLowerCase(), Store.YES, Index.ANALYZED));
						
			return doc;
		}catch(Exception e){
			return null;
		}
	}
	
	private ForumDao getForumDao(){
		return (ForumDao)ServiceContext.getInstance().getContext().getBean("forumDao");
	}
}