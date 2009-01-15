package org.light.portal.user.search;

import org.light.portal.model.Entity;
import org.light.portal.model.User;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserProfile;
import org.light.portal.search.Indexer;

public class UserProfileIndexer extends UserIndexer implements Indexer{
		
	public synchronized void reIndex(){
				
	}
	public synchronized void reIndex(Class entityType){

	}
	public void  updateIndex(Entity entity){
		if(!(entity instanceof UserProfile)) return;
		UserProfile profile = (UserProfile)entity;
		User user = null;
		try {
			user =this.getUserDao().getUserById(profile.getUserId());
			deleteIndex((UserEntity)user);
		}
		catch (Exception e) {
		}		
		if(user != null)
			addIndex(user);
	}
	

}
