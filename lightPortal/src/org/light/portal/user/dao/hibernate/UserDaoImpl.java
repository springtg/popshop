/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.user.dao.hibernate;

import static org.light.portal.util.Constants._DEFAULT_ORG_ADMIN_PREFIX;
import static org.light.portal.util.Constants._DEFAULT_ORG_USER_PREFIX;
import static org.light.portal.util.Constants._DEFAULT_ROLE;
import static org.light.portal.util.Constants._ROLE_ADMIN;
import static org.light.portal.util.Constants._ROLE_MEMBER;
import static org.light.portal.util.Constants._ROLE_USER;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import net.sf.acegisecurity.providers.encoding.Md5PasswordEncoder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portal.model.OrgProfile;
import org.light.portal.model.Organization;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.User;
import org.light.portal.model.UserBlock;
import org.light.portal.model.UserComments;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserFavourite;
import org.light.portal.model.UserFile;
import org.light.portal.model.UserFriendRequest;
import org.light.portal.model.UserInvite;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserPicture;
import org.light.portal.model.UserProfile;
import org.light.portal.model.UserRole;
import org.light.portal.user.dao.UserDao;
import org.light.portal.util.MessageUtil;
import org.light.portlets.addressbook.AddressBook;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.ChatStatusRef;
import org.light.portlets.connection.Connection;
import org.light.portlets.feedback.Feedback;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.group.GroupCategory;
import org.light.portlets.horoscope.Horoscope;
import org.light.portlets.message.Message;
import org.light.portlets.note.Note;
import org.light.portlets.todolist.ToDoBean;

/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Aug 12, 2006
 **/
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	public Organization getOrgByVirtualHost(String host){
		String hql="select org from Organization org where org.virtualHost='"+host+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Organization org = (Organization)query.uniqueResult();
		session.close();
		return org;
	}
	public Organization getOrgById(long id){
		return (Organization)this.getHibernateTemplate().get(Organization.class,id);
	}
	public List<Organization> getOrganizations(){
		List<Organization> orgs = this.getHibernateTemplate().find("select org from Organization org order by org.id");
		return orgs;
	}
	public OrgProfile getOrgProfileByOrgId(long orgId, String language){
		Object[] params = new Object[2];
		params[0] = orgId;
		params[1] = language;
		List<OrgProfile> orgs = this.getHibernateTemplate().find("select org from OrgProfile org where org.orgId=? and org.language=?", params);
//		if((orgs == null || orgs.size() <= 0) && !_DEFAULT_LANGUAGE.equals(language)){
//			params[1] = _DEFAULT_LANGUAGE;
//			orgs = this.getHibernateTemplate().find("select org from OrgProfile org where org.orgId=? and org.language=?", params);
//		}
		OrgProfile org = null;
		if(orgs != null && orgs.size() > 0) org = orgs.get(0);
		return org;
	}
	public List<User> getUsersByOrgId(long orgId){
		List<User> users = this.getHibernateTemplate().find("select user from UserEntity user where user.orgId=?",orgId);
		return users;
	}
	public List<User> getAllUsers(){
		List<User> users = this.getHibernateTemplate().find("select user from UserEntity user");
		return users;
	}
	public User getUserByUserIdAndOrgId(String userId, long orgId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = orgId;
		List<User> users =this.getHibernateTemplate().find("from UserEntity where userId=? and orgId=?",params);
		User user = null;
		if(users != null && users.size() > 0) user = users.get(0);
		return user;
	}
	public void createOrganization(Organization org,OrgProfile profile){
		this.save(org);
		profile.setOrgId(org.getId());
		this.save(profile);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
		String ePassword = encoder.encodePassword(_DEFAULT_ORG_USER_PREFIX, null);	
		//default user
		User user = new UserEntity(_DEFAULT_ORG_USER_PREFIX+"@"+org.getWebId(),ePassword,_DEFAULT_ORG_USER_PREFIX,_DEFAULT_ORG_USER_PREFIX+"@"+org.getWebId(),org.getId());
		this.saveUser(user);
		org.setUserId(user.getId());
		this.save(org);
		PortalUserRole userRole1 = new PortalUserRole(user.getId(),_DEFAULT_ROLE);
		this.save(userRole1);
	 	Chat chat = new Chat(user.getId(),ChatStatusRef.ONLINE,ChatStatusRef.OFFLINE);
	 	this.save(chat);
	 	//admin user
	 	ePassword = encoder.encodePassword(_DEFAULT_ORG_ADMIN_PREFIX, null);
	 	User admin = new UserEntity(_DEFAULT_ORG_ADMIN_PREFIX+"@"+org.getWebId(),ePassword,_DEFAULT_ORG_ADMIN_PREFIX,_DEFAULT_ORG_ADMIN_PREFIX+"@"+org.getWebId(),org.getId());
		this.saveUser(admin);
		PortalUserRole adminRole1 = new PortalUserRole(admin.getId(),_ROLE_ADMIN);		
	 	this.save(adminRole1);	
	 	PortalUserRole adminRole2 = new PortalUserRole(admin.getId(),_ROLE_USER);		
	 	this.save(adminRole2);	
	 	PortalUserRole adminRole3 = new PortalUserRole(admin.getId(),_ROLE_MEMBER);		
	 	this.save(adminRole3);	
	 	Chat adminChat = new Chat(admin.getId(),ChatStatusRef.ONLINE,ChatStatusRef.OFFLINE);
	 	this.save(adminChat);
	 	
	 	//create organization references
	 	createOrgRef(org);
	}
	
	private void createOrgRef(Organization org){
		if(org.getType() == 2){
			ForumCategory ref = new ForumCategory(org.getWebId(),org.getWebId(),"en",org.getId(),0,1);
			ref.addForum(new Forum("general",false,org.getId()));
			this.save(ref);
		}else{
		ForumCategory ref0 = new ForumCategory("automotive","en",org.getId());
		ref0.addForum(new Forum("chinese",false,org.getId()));
		ref0.addForum(new Forum("european",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("japanese",false,org.getId()));
		ref0.addForum(new Forum("northAmerican",false,org.getId()));
		ref0.addForum(new Forum("racing",false,org.getId()));
		ref0.addForum(new Forum("southKorean",false,org.getId()));
		ref0.addForum(new Forum("skill",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("business","en",org.getId());
		ref0.addForum(new Forum("business",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("money",false,org.getId()));
		ref0.addForum(new Forum("start",false,org.getId()));
		ref0.addForum(new Forum("stocks",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("campus","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("gradSchool",false,org.getId()));
		ref0.addForum(new Forum("highSchool",false,org.getId()));
		ref0.addForum(new Forum("undergrad",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("career","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("comedy","en",org.getId());
		ref0.addForum(new Forum("comedian",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("computer","en",org.getId());
		ref0.addForum(new Forum("computers",false,org.getId()));
		ref0.addForum(new Forum("electronics",false,org.getId()));
		ref0.addForum(new Forum("gadgets",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("culture","en",org.getId());
		ref0.addForum(new Forum("arts",false,org.getId()));
		ref0.addForum(new Forum("cultue",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("literature",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("filmmaker","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("food","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("recipes",false,org.getId()));
		ref0.addForum(new Forum("restaurants",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("games","en",org.getId());
		ref0.addForum(new Forum("boardGames",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("other",false,org.getId()));
		ref0.addForum(new Forum("roleGames",false,org.getId()));
		ref0.addForum(new Forum("videoGames",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("general","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("health","en",org.getId());
		ref0.addForum(new Forum("exercise",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("nutrition",false,org.getId()));
		this.save(ref0);

		ref0 = new ForumCategory("system","en",org.getId());
		ref0.addForum(new Forum("custom",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("movies","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("music","en",org.getId());
		ref0.addForum(new Forum("acoustic",false,org.getId()));
		ref0.addForum(new Forum("alternative",false,org.getId()));
		ref0.addForum(new Forum("dance",false,org.getId()));
		ref0.addForum(new Forum("emo",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("hardcore",false,org.getId()));
		ref0.addForum(new Forum("hip",false,org.getId()));
		ref0.addForum(new Forum("metal",false,org.getId()));
		ref0.addForum(new Forum("punk",false,org.getId()));
		ref0.addForum(new Forum("rock",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("news","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("religion","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("philosophy",false,org.getId()));	
		ref0.addForum(new Forum("religion",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("science","en",org.getId());
		ref0.addForum(new Forum("biology",false,org.getId()));	
		ref0.addForum(new Forum("engineer",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("physics",false,org.getId()));	
		ref0.addForum(new Forum("spaces",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("sports","en",org.getId());
		ref0.addForum(new Forum("extremeSports",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("profSports",false,org.getId()));	
		ref0.addForum(new Forum("teamSports",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("tv","en",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("series",false,org.getId()));	
		ref0.addForum(new Forum("shows",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("travel","en",org.getId());
		ref0.addForum(new Forum("china",false,org.getId()));	
		ref0.addForum(new Forum("asia",false,org.getId()));
		ref0.addForum(new Forum("canada",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("us",false,org.getId()));	
		this.save(ref0);
		
		//-------------------
		ref0 = new ForumCategory("automotive","zh_CN",org.getId());
		ref0.addForum(new Forum("chinese",false,org.getId()));
		ref0.addForum(new Forum("european",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("japanese",false,org.getId()));
		ref0.addForum(new Forum("northAmerican",false,org.getId()));
		ref0.addForum(new Forum("racing",false,org.getId()));
		ref0.addForum(new Forum("southKorean",false,org.getId()));
		ref0.addForum(new Forum("skill",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("business","zh_CN",org.getId());
		ref0.addForum(new Forum("business",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("money",false,org.getId()));
		ref0.addForum(new Forum("start",false,org.getId()));
		ref0.addForum(new Forum("stocks",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("campus","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("highSchool",false,org.getId()));
		ref0.addForum(new Forum("undergrad",false,org.getId()));
		ref0.addForum(new Forum("gradSchool",false,org.getId()));						
		this.save(ref0);
		
		ref0 = new ForumCategory("career","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		
		ref0 = new ForumCategory("emotion","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("city","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("pop","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("computer","zh_CN",org.getId());
		ref0.addForum(new Forum("computers",false,org.getId()));
		ref0.addForum(new Forum("electronics",false,org.getId()));
		ref0.addForum(new Forum("gadgets",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("culture","zh_CN",org.getId());
		ref0.addForum(new Forum("arts",false,org.getId()));
		ref0.addForum(new Forum("cultue",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("literature",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("filmmaker","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("food","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("recipes",false,org.getId()));
		ref0.addForum(new Forum("restaurants",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("games","zh_CN",org.getId());
		ref0.addForum(new Forum("boardGames",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("other",false,org.getId()));
		ref0.addForum(new Forum("roleGames",false,org.getId()));
		ref0.addForum(new Forum("videoGames",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("general","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("health","zh_CN",org.getId());
		ref0.addForum(new Forum("exercise",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("nutrition",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("system","zh_CN",org.getId());
		ref0.addForum(new Forum("custom",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("movies","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("music","zh_CN",org.getId());
		ref0.addForum(new Forum("acoustic",false,org.getId()));
		ref0.addForum(new Forum("alternative",false,org.getId()));
		ref0.addForum(new Forum("dance",false,org.getId()));
		ref0.addForum(new Forum("emo",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));
		ref0.addForum(new Forum("hardcore",false,org.getId()));
		ref0.addForum(new Forum("hip",false,org.getId()));
		ref0.addForum(new Forum("metal",false,org.getId()));
		ref0.addForum(new Forum("punk",false,org.getId()));
		ref0.addForum(new Forum("rock",false,org.getId()));
		this.save(ref0);
		
		ref0 = new ForumCategory("news","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("religion","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("philosophy",false,org.getId()));	
		ref0.addForum(new Forum("religion",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("science","zh_CN",org.getId());
		ref0.addForum(new Forum("biology",false,org.getId()));	
		ref0.addForum(new Forum("engineer",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("physics",false,org.getId()));	
		ref0.addForum(new Forum("spaces",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("sports","zh_CN",org.getId());
		ref0.addForum(new Forum("extremeSports",false,org.getId()));	
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("profSports",false,org.getId()));	
		ref0.addForum(new Forum("teamSports",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("tv","zh_CN",org.getId());
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("series",false,org.getId()));	
		ref0.addForum(new Forum("shows",false,org.getId()));	
		this.save(ref0);
		
		ref0 = new ForumCategory("travel","zh_CN",org.getId());
		ref0.addForum(new Forum("china",false,org.getId()));	
		ref0.addForum(new Forum("asia",false,org.getId()));
		ref0.addForum(new Forum("canada",false,org.getId()));
		ref0.addForum(new Forum("general",false,org.getId()));	
		ref0.addForum(new Forum("us",false,org.getId()));	
		this.save(ref0);		
		}

		GroupCategory ref1 = new GroupCategory("group.category.other",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.activities",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.automotive",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.business",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.cities",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.companies",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.computers",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.countries",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.cultures",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.entertainment",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.family",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.fun",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.fashion",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.film",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.food",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.games",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.gay",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.gov",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.health",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.hobbies",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.literature",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.money",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.music",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.nightlife",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.nonprofit",org.getId());
		this.save(ref1);		
		ref1 = new GroupCategory("group.category.pets",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.places",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.prof",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.recreation",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.religion",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.schools",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.science",org.getId());
		this.save(ref1);
		ref1 = new GroupCategory("group.category.sorority",org.getId());
		this.save(ref1);

	}
	
	public User createUser(User newUser){		
		this.saveUser(newUser);
		return newUser;
	}		
	public void deleteUser(long userId){
		User user = this.getUserById(userId);
		if(user != null){
			 List<UserBlock> blocks = this.getUserBlocks(userId);
			 if(blocks != null){
				 for(UserBlock block : blocks){
					 this.delete(block);
				 }
			 }
			 List<UserComments> comments = this.getUserComments(userId);
			 if(comments != null){
				 for(UserComments comment : comments){
					 this.delete(comment);
				 }
			 }
			 List<UserMusic> musics = this.getUserMusics(userId);
			 if(musics != null){
				 for(UserMusic music : musics){
					 this.delete(music);
				 }
			 }
			 List<UserPicture> pictures = this.getUserPictures(userId);
			 if(pictures != null){
				 for(UserPicture picture : pictures){
					 this.delete(picture);
				 }
			 }
			 List<UserFavourite> favourites = this.getUserFavourites(userId);
			 if(favourites != null){
				 for(UserFavourite favourite : favourites){
					 this.delete(favourite);
				 }
			 }
			 List<AddressBook> addressBooks = getAddressBooksByUser(userId);
			 if(addressBooks != null){
				 for(AddressBook addressBook : addressBooks){
					 this.delete(addressBook);
				 }
			 }
			 List<Bookmark> bookmarks = getBookmarksByUser(userId);
			 if(bookmarks != null){
				 for(Bookmark bookmark : bookmarks){
					 this.delete(bookmark);
				 }
			 }
			 List<ToDoBean> todos = getToDosByUser(userId);
			 if(todos != null){
				 for(ToDoBean todo : todos){
					 this.delete(todo);
				 }
			 }
			 Note note = getNoteByUser(userId);
			 if(note != null)
				 this.delete(note);
			 this.delete(this.getUserProfileById(userId));
			 this.deleteUser(user);
		}
	}
	
	public User getUserById(long id){
		return (User)this.getHibernateTemplate().get(UserEntity.class,id);
	}
	
	public User getUserByUserId(String userId, long orgId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = orgId;
		List<User> users =this.getHibernateTemplate().find("from UserEntity where userId=? and orgId=?",params);
		User user = null;
		if(users != null && users.size() > 0) user = users.get(0);
		return user;
	}
//	public User getUserByUserId(String userId){
//		long orgId = OrganizationThreadLocal.getOrganizationId();
//		Object[] params = new Object[2];
//		params[0] = orgId;
//		params[1] = userId;
//		List<User> users =this.getHibernateTemplate().find("from UserEntity where orgId=? and userId=?",params);
//		User user = null;
//		if(users != null && users.size() > 0) user = users.get(0);
//		return user;
//	}
	public User getUserByUri(String uri,long orgId){
		String[] params = new String[2];
		params[0] = uri;
		params[1] = uri;
		List<User> users = this.getHibernateTemplate().find("select user from UserEntity user where (user.assignedUri =? or user.chosedUri=?) and orgId="+orgId, params);
		User user = null;
		if(users != null && users.size() > 0) user = users.get(0);
		return user;
	}
	
	public User getUserByEmail(String email){
		List<User> users = this.getHibernateTemplate().find("select user from UserEntity user where user.email =? ", email);
		User user = null;
		if(users != null && users.size() > 0) user = users.get(0);
		return user;
	}
	public List<UserProfile> getUserByName(String fullName){
		String hql="select new UserProfile(user.userId,user.photoUrl,user.photoWidth,user.photoHeight,user.assignedUri,user.chosedUri,user.displayName,user.userCurrentStatusId) from UserProfile user where user.firstName like '%"+fullName+"%' or user.userId = '"+fullName+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		List<UserProfile> users = query.list();
		session.close();
		return users;
	}
	public List<UserProfile> getUserByName(String firstName,String lastName){
		String hql="select new UserProfile(user.userId,user.photoUrl,user.photoWidth,user.photoHeight,user.assignedUri,user.chosedUri,user.displayName,user.userCurrentStatusId) from UserProfile user where user.firstName like '%"+firstName+"%' and user.lastName like '%"+lastName+"%'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		List<UserProfile> users = query.list();
		session.close();
		return users;
	}
	
	public UserProfile getUserProfileById(long userId){
		return (UserProfile)this.getHibernateTemplate().get(UserProfile.class,userId);
	}
	public List<User> getCoolNewPeople(int start, int max){				
		String hql="select user from UserEntity user where user.photoUrl is not null order by createDate desc";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(start)
					.setMaxResults(max);
		List<User> list = query.list();
		session.close();
		return list;
	}
	public int getCoolNewPeopleTotal(){
		String hql="select count(*) from UserEntity user where user.photoUrl is not null";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<User> getOnlinePeople(int start, int max){		
		String hql="select user from UserEntity user where user.userCurrentStatusId = 1 order by lastLoginDate desc";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(start)
					.setMaxResults(max);
		List<User> list = query.list();
		session.close();
		return list;
	}
	public int getOnlinePeopleTotal(){
		String hql="select count(*) from UserEntity user where user.userCurrentStatusId = 1";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public UserInvite getUserInviteByEmail(String email){
		List<UserInvite> invites = this.getHibernateTemplate().find("select invite from UserInvite invite where invite.inviteEmail=? and invite.status = 0 order by id asc", email);
		UserInvite invite = null;
		if(invites != null && invites.size() > 0) invite = invites.get(0);
		return invite;
	}
	
	public List<UserComments> getUserComments(long userId){
		List<UserComments> userComments = this.getHibernateTemplate().find("select comments from UserComments comments where comments.userId=? and comments.status = 1 order by id desc", userId);
		return userComments;
	}
	public List<UserComments> getUserComments(long userId, int showNumber){
	   String hql="select comments from UserComments comments where comments.userId'"+userId+"' and comments.status = 1 order by id desc"; 
	   Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(0)
					.setMaxResults(showNumber);
	   List<UserComments> list = query.list();
	   session.close();
       return list;   
	}
	public int getUserCommentsCount(long userId){			
		String hql="select count(*) from UserComments where userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public UserComments getUserCommentsById(long id){
		return (UserComments)this.getHibernateTemplate().get(UserComments.class,id);
	}
	public int getUserPictureCount(long userId){			
		String hql="select count(*) from UserPicture where userId='"+userId+"' and status >= 0";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<UserPicture> getUserPictures(long userId){
		List<UserPicture> userPictures = this.getHibernateTemplate().find("select userPictures from UserPicture userPictures where userPictures.userId=? and userPictures.status >= 0 order by id desc", userId);
		return userPictures;
	}
	
	public List<UserPicture> getUserPicturesByStatus(long userId, int status){		
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = status;
		List<UserPicture> userPictures = this.getHibernateTemplate().find("select userPictures from UserPicture userPictures where userPictures.userId=? and userPictures.status >=? order by id desc", params);
		return userPictures;
	}
	
	public List<UserPicture> getUserRankPictures(long userId){		
		List<UserPicture> userPictures = this.getHibernateTemplate().find("select userPictures from UserPicture userPictures where userPictures.userId=? and userPictures.rankable=1 order by id desc", userId);
		return userPictures;
	}
	
	public UserPicture getUserPictureById(long id){
		return (UserPicture)this.getHibernateTemplate().get(UserPicture.class,id);
	}	
	public int getUserMusicCount(long userId){			
		String hql="select count(*) from UserMusic where userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<UserMusic> getUserMusics(long userId){
		List<UserMusic> userMusics = this.getHibernateTemplate().find("select userMusics from UserMusic userMusics where userMusics.userId=? order by id desc", userId);
		return userMusics;
	}
	
	public List<UserMusic> getUserMusicsByStatus(long userId, int status){		
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = status;
		List<UserMusic> userMusics = this.getHibernateTemplate().find("select userMusics from UserMusic userMusics where userMusics.userId=? and userMusics.status >=? order by id desc", params);
		return userMusics;
	}
	public List<UserMusic> getUserRankMusics(long userId){		
		List<UserMusic> userMusics = this.getHibernateTemplate().find("select userMusics from UserMusic userMusics where userMusics.userId=? and userMusics.rankable=1 order by id desc", userId);
		return userMusics;
	}
	
	public UserMusic getUserMusicById(long id){
		return (UserMusic)this.getHibernateTemplate().get(UserMusic.class,id);
	}
	public int getUserFileCount(long userId){			
		String hql="select count(*) from UserFile where userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<UserFile> getUserFiles(long userId){
		List<UserFile> userFiles = this.getHibernateTemplate().find("select userFiles from UserFile userFiles where userFiles.userId=? order by id desc", userId);
		return userFiles;
	}
	public List<UserFile> getUserFilesByStatus(long userId, int status){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = status;
		List<UserFile> userFiles = this.getHibernateTemplate().find("select userFiles from UserFile userFiles where userFiles.userId=? and userFiles.status >=? order by id desc", params);
		return userFiles;
	}
	public UserFile getUserFileById(long id){
		return (UserFile)this.getHibernateTemplate().get(UserFile.class,id);
	}
	public List<UserFavourite> getUserFavourites(long userId){
		List<UserFavourite> userFavourites = this.getHibernateTemplate().find("select favourite from UserFavourite favourite where favourite.userId=? order by id asc", userId);
		return userFavourites;
	}
	
	public List<UserBlock> getUserBlocks(long userId){
		List<UserBlock> userBlocks = this.getHibernateTemplate().find("select userBlocks from UserBlock userBlocks where userBlocks.userId=? order by id asc", userId);
		return userBlocks;
	}
	
	public List<UserInvite> getUserInvites(long userId){
		List<UserInvite> userInvites = this.getHibernateTemplate().find("select userInvites from UserInvite userInvites where userInvites.userId=? order by id asc", userId);
		return userInvites;
	}
	public int getUserBulletinCount(long userId){			
		String hql="select count(*) from Bulletin where userId='"+userId+"' and status=0";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<Bulletin> getBulletinsByUser(long userId){
		List<Bulletin> bulletins = this.getHibernateTemplate().find("select bulletin from Bulletin bulletin where bulletin.userId=? order by id desc", userId);
		return bulletins;
	}
	
	public Bulletin getBulletinById(long id){
		Bulletin bulletin =(Bulletin)this.getHibernateTemplate().get(Bulletin.class,id);
		if(bulletin != null){
			bulletin.setStatus(1);
			this.save(bulletin);
		}
		return bulletin;
	}
	
	public UserBlock getUserBlockById(long id){
		return (UserBlock)this.getHibernateTemplate().get(UserBlock.class,id);
	}	
	
	public UserBlock getUserBlockByUser(long userId, long blockId){
		long[] params = new long[2];
		params[0] = userId;
		params[1] = blockId;
		List<UserBlock> userBlocks = this.getHibernateTemplate().find("select userBlock from UserBlock userBlock where userBlock.userId="+userId+" and userBlock.blockId="+blockId+" order by id desc");
		//List<UserBlock> userBlocks = this.getHibernateTemplate().find("select userBlock from UserBlock userBlock where userBlock.userId=? and userBlock.blockId=? order by id desc", params);
		UserBlock userBlock = null;
		if(userBlocks != null && userBlocks.size() > 0)
			userBlock = userBlocks.get(0);
		return userBlock;
	}	
	
	public Message getMessageById(long id){
		Message message = (Message)this.getHibernateTemplate().get(Message.class,id);
		if(message.getStatus().equals("0")){
			message.setStatus("1");
			this.save(message);
		}
		return message;
	}
	
	public List<Message> getMessagesBySender(long userId){
		List<Message> messages = this.getHibernateTemplate().find("select message from Message message where message.postById=? order by id desc", userId);
		return messages;
	}
	
	public List<Message> getMessagesByUser(long userId){
		List<Message> messages = this.getHibernateTemplate().find("select message from Message message where message.userId=? order by id desc", userId);
		return messages;
	}
	
	public int getNewMessageCountByUser(long userId){
		List<Message> messages = this.getHibernateTemplate().find("select message from Message message where message.userId=? and message.status= '0' order by id desc", userId);
		int count = 0;
		if(messages != null) count = messages.size();
		return count;
	}
	
	public List<UserFriendRequest> getFriendRequestsByUser(long userId){
		List<UserFriendRequest> friendRequests = this.getHibernateTemplate().find("select friendRequest from UserFriendRequest friendRequest where friendRequest.userId=? and friendRequest.status= '0' order by id desc", userId);
		return friendRequests;
	}
	
	public int getNewFriendRequestCountByUser(long userId){
		List<UserFriendRequest> friendRequests = this.getHibernateTemplate().find("select friendRequest from UserFriendRequest friendRequest where friendRequest.userId=? and friendRequest.status= '0' order by id desc", userId);
		int count = 0;
		if(friendRequests != null) count = friendRequests.size();
		return count;
	}
	
	public UserFriendRequest getUserFriendRequestById(long id){
		return (UserFriendRequest)this.getHibernateTemplate().get(UserFriendRequest.class,id);
	}
	
	public boolean approveFriend(UserFriendRequest friendRequest){
		friendRequest.setStatus("1");
		Connection myFriend = new Connection(friendRequest.getUserId(), friendRequest.getPostById());
		Connection friendToYou = new Connection(friendRequest.getPostById(), friendRequest.getUserId());
		this.save(friendRequest);
		this.save(myFriend);
		this.save(friendToYou);
		return true;
	}
	
	public List<UserRole> getUserRole(long userId){
		List<UserRole> listRole = null;
		//listRole= this.getHibernateTemplate().find("select userRole from UserRoleEntity userRole where userRole.userId= ?", userId);
		return listRole;
	}
		
	public AddressBook getAddressBookById(long id){
		return (AddressBook)this.getHibernateTemplate().get(AddressBook.class,id);
	}
	public List<AddressBook> getAddressBooksByUser(long userId){
		List<AddressBook> addressBooks = this.getHibernateTemplate().find("select addressBook from AddressBook addressBook where addressBook.userId= ? order by id asc", userId);
		return addressBooks;
	}
	public List<AddressBook> getAddressBooksByUser(long userId, String group){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = group;
		List<AddressBook> addressBooks = this.getHibernateTemplate().find("select addressBook from AddressBook addressBook where addressBook.userId= ? and addressBook.group= ? order by id asc", params);
		return addressBooks;
	}
	public List<String> getAddressBookGroupByUser(long userId){
		List<String> groups  = this.getHibernateTemplate().find("select distinct addressBook.group from AddressBook addressBook where addressBook.userId= ? order by id asc", userId);
		return groups;
	}
	public Note getNoteByUser(long userId){
		Note note = (Note)this.getHibernateTemplate().get(Note.class,userId);
		if(note == null){
			User user =  this.getUserById(userId);
			Locale locale = Locale.ENGLISH;
			if(user != null){
				String[] localeParams = user.getLanguage().split("_");
				if(localeParams.length > 1)
					locale = new Locale(localeParams[0],localeParams[1]);
				else
					locale = new Locale(localeParams[0]);
			}
			String content = MessageUtil.getMessage("noteTemplate",locale);
			int width = 45;
			int height = 7;
			try{
				width =Integer.parseInt(MessageUtil.getMessage("noteWidth",locale));
				height =Integer.parseInt(MessageUtil.getMessage("noteHeight",locale));
			}catch(Exception e){}
			note = new Note(userId,content,width,height);
			this.save(note);
		}
		return note;
	}
	
	public List<Feedback> getFeedback(){
		List<Feedback> list= this.getHibernateTemplate().find("select feedback from Feedback feedback order by id desc");		
		return list;
	}
	
	public Feedback getFeedbackById(long id){
		return (Feedback)this.getHibernateTemplate().get(Feedback.class, id);
	}
	
	public Bookmark getBookmarkById(long id){
		return (Bookmark)this.getHibernateTemplate().get(Bookmark.class, id);
	}
	
	public List<Bookmark> getBookmarksByUser(long userId){
		List<Bookmark> list = this.getHibernateTemplate().find("select bookmark from Bookmark bookmark where bookmark.userId=? order by bookmark.id asc",userId);  
		return list;
	}
	
	public List<Bookmark> getBookmarksByTag(long userId, String tag){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = tag;
		List<Bookmark> list = this.getHibernateTemplate().find("select bookmark from Bookmark bookmark where bookmark.userId=? and bookmark.tagId=? order by bookmark.id asc",params);  
		return list;
	}
	public int getUserToDoCount(long userId){			
		String hql="select count(*) from ToDoBean where userId='"+userId+"' and status=0";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<ToDoBean> getToDosByUser(long userId){
		List<ToDoBean> list = this.getHibernateTemplate().find("select todo from ToDoBean todo where todo.userId=? order by todo.status asc, todo.priority desc, todo.id desc",userId);  
		return list;
	}
	
	public ToDoBean getToDoById(long id){
	  return (ToDoBean)this.getHibernateTemplate().get(ToDoBean.class, id);
	}
	
	public Horoscope getUserHoroscope(int month, int day){
		Integer[] params = new Integer[4];
		params[0] = month;
		params[1] = day;
		params[2] = month;
		params[3] = day;
		List<Horoscope> list = this.getHibernateTemplate().find("select horoscope from Horoscope horoscope where (horoscope.endMonth = ? and horoscope.endDay >= ?) or (horoscope.startMonth = ? and horoscope.startDay <= ?) order by horoscope.id asc",params);  		
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}
	
	public String getUserHoroscopeWeeklyInfo(long horoscopeId, String language){
		String lan = "en";//language
		Calendar current = Calendar.getInstance();
		current.setTimeInMillis(System.currentTimeMillis());
		current.setFirstDayOfWeek(Calendar.MONDAY);
		current.setMinimalDaysInFirstWeek(4);
		int weekNumber =current.get(Calendar.WEEK_OF_YEAR);
		if(weekNumber <1 || weekNumber > 52) weekNumber = 1;
		String hql="select description from HoroscopeWeekly where horoscopeId="+horoscopeId+" and language='"+lan+"' and weekNumber="+weekNumber;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		String desc = (String)query.uniqueResult();
		session.close();
		return desc;
	}
	
	public List<Horoscope> getHoroscopes(){
		List<Horoscope> list = this.getHibernateTemplate().find("select horoscope from Horoscope horoscope order by horoscope.id asc");  
		return list;
	}
	public void saveUser(User user){
		this.save((UserEntity)user); 
	}
	public void deleteUser(User user){
		this.delete((UserEntity)user);
	}
}
