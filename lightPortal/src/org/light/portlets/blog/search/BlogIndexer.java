package org.light.portlets.blog.search;

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
import org.light.portal.model.UserEntity;
import org.light.portal.search.GenericIndexer;
import org.light.portal.search.Indexer;
import org.light.portal.search.SearcherUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;
import org.light.portlets.blog.dao.BlogDao;

public class BlogIndexer extends GenericIndexer implements Indexer{
	
	public final static String _TYPE_VALUE = "blog";
	public final static String _TYPE_DESC = "Blog";
	
	public synchronized void reIndex(){
		deleteAllIndex(_TYPE_VALUE);
		List<Blog> blogs = getBlogDao().getBlogs(OrganizationThreadLocal.getOrganizationId());
		for(Blog blog : blogs){
			addIndex(blog);
		}		
	}
	public synchronized void reIndex(Class entityType){
		if(!Blog.class.equals(entityType)) return;
		reIndex();
	}

	public void deleteIndex(Entity entity){
		if(!(entity instanceof Blog)) return;
		deleteIndex(entity,_TYPE_VALUE);
	}
	public void  updateIndex(Entity entity){
		if(!(entity instanceof Blog)) return;
		Blog blog = (Blog)entity;
		try {
			deleteIndex(entity);
		}
		catch (Exception e) {
		}
	
		addIndex(blog);
	}
	
	protected void addIndex(Blog blog){
		try{
			File file = new File(SearcherUtil.getPath());
			boolean isNew = !file.exists();
			IndexWriter writer = new IndexWriter(SearcherUtil.getPath(), new StandardAnalyzer(), isNew, IndexWriter.MaxFieldLength.LIMITED);
			List<Document> docs = getEntryDocuments(blog);
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
		
	private  List<Document> getEntryDocuments(Blog blog) {
		List<Document> docs = new LinkedList<Document>();
		try{			
			docs.add(this.getPublicDocument(blog));
		}catch(Exception e){
			
		}
		return docs;
	}	
		
	private  Document getPublicDocument(Blog blog) {
		try{			
			Document doc = new Document();	
			String entryId = _TYPE_VALUE+String.valueOf(blog.getId());	
			doc.add(new Field(_TYPE_ID,_TYPE_VALUE, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field(_ENTRY_ID,entryId, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("id",String.valueOf(blog.getId()), Store.YES, Index.NOT_ANALYZED));			
			doc.add(new Field("subject",blog.getTitle(), Store.YES, Index.NOT_ANALYZED));			
			if(blog.getSummary() != null)
				doc.add(new Field("summary",blog.getSummary(), Store.YES, Index.NOT_ANALYZED));			
			if(blog.getContent() != null)
				doc.add(new Field("content",blog.getContent(), Store.YES, Index.NOT_ANALYZED));			
			doc.add(new Field("userId",String.valueOf(blog.getPostedById()), Store.YES, Index.NOT_ANALYZED));			
			doc.add(new Field("link","http://www."+OrganizationThreadLocal.getWebId()+"/viewblog.do?id="+blog.getId(), Store.YES, Index.NOT_ANALYZED));
						
			User user = this.getUserDao().getUserById(blog.getPostedById());
			doc.add(new Field("name",user.getName(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("uri",user.getUri(), Store.YES, Index.NOT_ANALYZED));
			if(user.getPhotoUrl() != null){
				doc.add(new Field("photoUrl",user.getPhotoUrl(), Store.YES, Index.NO));
				doc.add(new Field("photoWidth",String.valueOf(user.getPhotoWidth()), Store.YES, Index.NO));
				doc.add(new Field("photoHeight",String.valueOf(user.getPhotoHeight()), Store.YES, Index.NO));
			}
			
			doc.add(new Field("keyword",blog.getTitle().toLowerCase(), Store.YES, Index.ANALYZED));
			if(blog.getSummary() != null)
				doc.add(new Field("keyword",blog.getSummary().toLowerCase(), Store.YES, Index.ANALYZED));
			if(blog.getContent() != null)
				doc.add(new Field("keyword",blog.getContent().toLowerCase(), Store.YES, Index.ANALYZED));
			
			List<BlogComment> comments = this.getBlogDao().getBlogCommentsById(blog.getId());	
			for(BlogComment comment : comments){
				doc.add(new Field("keyword",comment.getComment().toLowerCase(), Store.YES, Index.ANALYZED));
			}
			
			return doc;
		}catch(Exception e){
			return null;
		}
		
		
	}
	
	protected BlogDao getBlogDao(){
		return (BlogDao)ServiceContext.getInstance().getContext().getBean("blogDao");
	}
	
	
}