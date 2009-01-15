package org.light.portal.user.search;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.light.portal.model.Entity;
import org.light.portal.model.User;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserProfile;
import org.light.portal.search.GenericIndexer;
import org.light.portal.search.Indexer;
import org.light.portal.search.SearcherUtil;
import org.light.portal.util.OrganizationThreadLocal;

public class UserIndexer extends GenericIndexer implements Indexer{
	
	public final static String _TYPE = "user";
	
	public synchronized void reIndex(){
		deleteAllIndex(_TYPE);
		List<User> users = getUserDao().getUsersByOrgId(OrganizationThreadLocal.getOrganizationId());
		for(User user : users){
			addIndex(user);
		}		
	}
	public synchronized void reIndex(Class entityType){
		if(!UserEntity.class.equals(entityType)) return;
		reIndex();
	}
	public void deleteIndex(Entity entity){
		if(!(entity instanceof UserEntity)) return;
		User user = (UserEntity)entity;
		try {
			File file = new File(SearcherUtil.getPath());
			if(!file.exists()) return;
			IndexReader reader = IndexReader.open(SearcherUtil.getPath());
			Term term = new Term("entryId", _TYPE+String.valueOf(user.getId()));
			int deleted = reader.deleteDocuments(term);

			reader.close();

	    } catch (Exception e) {
	     
	    }
	}
	public void  updateIndex(Entity entity){
		if(!(entity instanceof UserEntity)) return;
		User user = (UserEntity)entity;
		try {
			deleteIndex(entity);
		}
		catch (Exception e) {
		}
	
		addIndex(user);
	}
	
	protected void addIndex(User user){
		if(user.getUserId().equals(OrganizationThreadLocal.getDefaultUserId())) return;
		try{
			File file = new File(SearcherUtil.getPath());
			boolean isNew = !file.exists();
			IndexWriter writer = new IndexWriter(SearcherUtil.getPath(), new StandardAnalyzer(), isNew, IndexWriter.MaxFieldLength.LIMITED);
			List<Document> docs = getEntryDocuments(user);
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
		
	private  List<Document> getEntryDocuments(User user) {
		List<Document> docs = new LinkedList<Document>();
		try{			
			docs.add(this.getPublicDocument(user));
		}catch(Exception e){
			
		}
		return docs;
	}	
		
	private  Document getPublicDocument(User user) {
		try{			
			Document doc = new Document();	
			String entryId = _TYPE+String.valueOf(user.getId());	
			doc.add(new Field(_TYPE_ID,_TYPE, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field(_ENTRY_ID,entryId, Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("id",String.valueOf(user.getId()), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("userId",user.getUserId(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("email",user.getEmail(), Store.YES, Index.NOT_ANALYZED));			
			doc.add(new Field("uri",user.getUri(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("displayName",user.getName(), Store.YES, Index.NOT_ANALYZED));
			UserProfile profile = getUserDao().getUserProfileById(user.getId());
			if(profile != null && StringUtils.isNotEmpty(profile.getName()))
				doc.add(new Field("name",profile.getName(), Store.YES, Index.NOT_ANALYZED));
			else
				doc.add(new Field("name",user.getName(), Store.YES, Index.NOT_ANALYZED));
			if(user.getPhotoUrl() != null){
				doc.add(new Field("photoUrl",user.getPhotoUrl(), Store.YES, Index.NO));
				doc.add(new Field("photoWidth",String.valueOf(user.getPhotoWidth()), Store.YES, Index.NO));
				doc.add(new Field("photoHeight",String.valueOf(user.getPhotoHeight()), Store.YES, Index.NO));
			}
			
			doc.add(new Field("keyword",user.getUserId().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("keyword",user.getName().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("keyword",user.getEmail().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("keyword",user.getUri().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
			if(profile != null){
				if(StringUtils.isNotEmpty(profile.getName()))
					doc.add(new Field("keyword",profile.getName().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getAboutMe()))
					doc.add(new Field("keyword",profile.getAboutMe().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getHeadline()))
					doc.add(new Field("keyword",profile.getHeadline().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getHometown()))
					doc.add(new Field("keyword",profile.getHometown().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getInterests()))
					doc.add(new Field("keyword",profile.getInterests().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getLikeToMeet()))
					doc.add(new Field("keyword",profile.getLikeToMeet().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getOccupation()))
					doc.add(new Field("keyword",profile.getOccupation().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getReligion()))
					doc.add(new Field("keyword",profile.getReligion().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getMovies()))
					doc.add(new Field("keyword",profile.getMovies().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getMusic()))
					doc.add(new Field("keyword",profile.getMusic().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getTelevision()))
					doc.add(new Field("keyword",profile.getTelevision().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getBooks()))
					doc.add(new Field("keyword",profile.getBooks().toLowerCase(), Store.YES, Index.NOT_ANALYZED));
				if(StringUtils.isNotEmpty(profile.getHeroes()))
					doc.add(new Field("keyword",profile.getHeroes().toLowerCase(), Store.YES, Index.NOT_ANALYZED));			
			}
			return doc;
		}catch(Exception e){
			return null;
		}
	}
	
}
