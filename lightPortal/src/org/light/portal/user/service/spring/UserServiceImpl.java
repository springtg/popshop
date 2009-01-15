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
package org.light.portal.user.service.spring;

import java.util.List;

import net.sf.acegisecurity.providers.encoding.Md5PasswordEncoder;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portal.model.OrgProfile;
import org.light.portal.model.Organization;
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
import org.light.portal.search.Indexer;
import org.light.portal.search.Searcher;
import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;
import org.light.portal.user.dao.UserDao;
import org.light.portal.user.service.UserService;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.addressbook.AddressBook;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.chat.dao.ChatDao;
import org.light.portlets.connection.Connection;
import org.light.portlets.feedback.Feedback;
import org.light.portlets.horoscope.Horoscope;
import org.light.portlets.message.Message;
import org.light.portlets.note.Note;
import org.light.portlets.todolist.ToDoBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Aug 12, 2006
 **/
public class UserServiceImpl  extends BaseServiceImpl implements UserService{
	private UserDao userDao;
	private ChatDao chatDao;	
	private MailSender mailSender;
	private SimpleMailMessage welcomeMessage;
	private SimpleMailMessage inviteMessage;
	private SimpleMailMessage newPasswordMessage;
	private Indexer indexer;
	private Searcher searcher;
	
	public Organization getOrgByVirtualHost(String host){
		return userDao.getOrgByVirtualHost(host);
	}
	public Organization getOrgById(long id){
		return userDao.getOrgById(id);
	}
	public List<Organization> getOrganizations(){
		return userDao.getOrganizations();
	}
	public OrgProfile getOrgProfileByOrgId(long orgId, String language){
		return userDao.getOrgProfileByOrgId(orgId,language);
	}
	public void createOrganization(Organization org,OrgProfile profile){
		userDao.createOrganization(org,profile);
	}
	public User createUser(User newUser){
		User user = userDao.createUser(newUser);		
		return user;
	}    		
	public void deleteUser(long userId){	
		User user = this.getUserById(userId);
		if(user != null){
			userDao.deleteUser(userId);
			chatDao.deleteUser(userId);
		}
	}
	public void reIndex(){		
		indexer.reIndex();
		
	}
	public void reIndex(Class klass){		
		indexer.reIndex(klass);
		
	}
	public SearchResult searchUser(SearchCriteria criteria ) throws Exception{
		return searcher.search(UserEntity.class,criteria);
	}
	
	public User getUserByUserIdAndOrgId(String userId, long orgId){
		return userDao.getUserByUserIdAndOrgId(userId,orgId);
	}
	
	public User getUserById(long id){
		return userDao.getUserById(id);
	}
	
	public User getUserByUserId(String userId, long orgId){
		return userDao.getUserByUserId(userId, orgId);
	}
	
	public User getUserByUri(String uri,long orgId){
		return userDao.getUserByUri(uri,orgId);
	}
	
	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}
	public int getUserPictureCount(long userId){
		return userDao.getUserPictureCount(userId);
	}
	public int getUserMusicCount(long userId){
		return userDao.getUserMusicCount(userId);
	}
	public int getUserFileCount(long userId){
		return userDao.getUserFileCount(userId);
	}
	public boolean inviteFriends(String mailList,String desc,User user){
	   String name = "";
	   UserProfile prof = this.getUserProfileById(user.getId());
	   if(prof != null){
		   name=prof.getName();
	   }else
		   name = user.getDisplayName();
	   String subject = name+ " invite you to join us.";
	   String[] mails = mailList.split(",");
	   for(int i=0;i<mails.length;i++){
		UserInvite invite = new UserInvite(user.getId(),mails[i]);
		this.save(invite);
	    SimpleMailMessage message = new SimpleMailMessage(this.inviteMessage);
		message.setTo(mails[i]);	
		message.setSubject(subject);
		StringBuffer content = new StringBuffer();
		content.append(name)					   
			   .append(" invite you to join <a href='http://www.")
			   .append(OrganizationThreadLocal.getWebId())
			   .append("' target='_blank'>http://www.")
			   .append(OrganizationThreadLocal.getWebId())	   
			   .append("</a>")
			   .append("\n")
			   .append(desc)
			   ;		
		message.setText(content.toString());
		mailSender.send(message);
	   }
	   return true;
	}
	
	public boolean sendNewPassword(User user){		
		if(user != null){			
			user.setPassword(user.getUri());
			this.saveUser(user);
			SimpleMailMessage message = new SimpleMailMessage(this.newPasswordMessage);
			message.setTo(user.getEmail());		
			StringBuffer content = new StringBuffer();
			content.append(user.getDisplayName());
			content.append(", ");		
			content.append(" your new temporary password is:");
			content.append(user.getBirth());
			content.append("\n");		
			message.setText(content.toString());
			mailSender.send(message);		
		}
		return true;
	}
	public List<UserProfile> getUserByName(String fullName){
		return userDao.getUserByName(fullName);
	}
	public List<UserProfile> getUserByName(String firstName,String lastName){
		return userDao.getUserByName(firstName,lastName);
	}
	
	public List<User> getCoolNewPeople(int start, int max){
		return userDao.getCoolNewPeople(start, max);
	}
	
	public List<User> getOnlinePeople(int start, int max){
		return userDao.getOnlinePeople(start, max);
	}
	public int getOnlinePeopleTotal(){
		return userDao.getOnlinePeopleTotal();
	}
	public int getCoolNewPeopleTotal(){
		return userDao.getCoolNewPeopleTotal();
	}
	public UserProfile getUserProfileById(long userId){
		return userDao.getUserProfileById(userId);
	}
	
	public List<UserComments> getUserComments(long userId){
		return userDao.getUserComments(userId);
	}
	public List<UserComments> getUserComments(long userId, int showNumber){
		return userDao.getUserComments(userId,showNumber);
	}
	public int getUserCommentsCount(long userId){
		return userDao.getUserCommentsCount(userId);
	}
	public UserComments getUserCommentsById(long id){
		return userDao.getUserCommentsById(id);
	}
	
	public List<UserPicture> getUserPictures(long userId){
		return userDao.getUserPictures(userId);
	}
	
	public List<UserBlock> getUserBlocks(long userId){
		return userDao.getUserBlocks(userId);
	}
	public List<UserInvite> getUserInvites(long userId){
		return userDao.getUserInvites(userId);
	}
	public UserBlock getUserBlockById(long id){
		return userDao.getUserBlockById(id);
	}
	
	public UserBlock getUserBlockByUser(long userId, long blockId){
		return userDao.getUserBlockByUser(userId,blockId);
	}
	
	public List<UserPicture> getVisitedUserPictures(long userId,long visitedId){
		if(visitedId == userId)
			return userDao.getUserPictures(userId);
		int status = 2;//pictures for pubic
		if(chatDao.getChatBuddy(userId,visitedId) != null)
			status = 1;//picutres for friends
		
		return userDao.getUserPicturesByStatus(visitedId,status);			
	}
	
	public List<UserPicture> getUserRankPictures(long userId){
		return userDao.getUserRankPictures(userId);
	}
	
	public UserPicture getUserPictureById(long id){
		return userDao.getUserPictureById(id);
	}
	
	public List<Bulletin> getBulletinsByUser(long userId){
		return userDao.getBulletinsByUser(userId);
	}
	
	public Bulletin getBulletinById(long id){
		return userDao.getBulletinById(id);
	}
	public int getUserBulletinCount(long userId){
		return userDao.getUserBulletinCount(userId);
	}
	public void sendBulletin(Bulletin bulletin){
		List<Connection> userFriends = chatDao.getBuddysByUser(bulletin.getUserId());
		for(Connection friend : userFriends){
			Bulletin sendToFriend = new Bulletin(bulletin.getSubject(),bulletin.getContent(),friend.getBuddyUserId(),bulletin.getUserId());
			chatDao.save(sendToFriend);			
		}
		chatDao.save(bulletin);
	}
	
	public void sendMessage(Message message){
		User user = this.getUserById(message.getUserId());
		if(user.getNotification() == 1){
			SimpleMailMessage email = new SimpleMailMessage(this.newPasswordMessage);
			email.setTo(user.getEmail());		
			email.setSubject(message.getSubject());
			email.setText(message.getContent());
			mailSender.send(email);
		}
		this.save(message);
	}
	public Message getMessageById(long id){
		return userDao.getMessageById(id);
	}
	
	public List<Message> getMessagesBySender(long userId){
		return userDao.getMessagesBySender(userId);
	}
	
	public List<Message> getMessagesByUser(long userId){
		return userDao.getMessagesByUser(userId);
	}
	
	public int getNewMessageCountByUser(long userId){
		return userDao.getNewMessageCountByUser(userId);
	}
	
	public List<UserFriendRequest> getFriendRequestsByUser(long userId){
		return userDao.getFriendRequestsByUser(userId);
	}
	
	public int getNewFriendRequestCountByUser(long userId){
		return userDao.getNewFriendRequestCountByUser(userId);
	}
	
	public UserFriendRequest getUserFriendRequestById(long id){
		return userDao.getUserFriendRequestById(id);
	}
	
	public List<UserFavourite> getUserFavourites(long userId){
		return userDao.getUserFavourites(userId);
	}
	public boolean approveFriend(UserFriendRequest friendRequest){
		return userDao.approveFriend(friendRequest);
	}
	public List<UserMusic> getUserMusics(long userId){
		return userDao.getUserMusics(userId);
	}
	
	public List<UserMusic> getUserRankMusics(long userId){		
		return userDao.getUserRankMusics(userId);
	}
	public List<UserMusic> getVisitedUserMusics(long userId,long visitedId){		
		if(visitedId == userId)
			return userDao.getUserMusics(userId);
		int status = 2;//pictures for pubic
		if(chatDao.getChatBuddy(userId,visitedId) != null)
			status = 1;//picutres for friends
		
		return userDao.getUserMusicsByStatus(visitedId,status);
			
	}
	public UserMusic getUserMusicById(long id){
		return userDao.getUserMusicById(id);
	}
	
	public List<UserFile> getUserFiles(long userId){
		return userDao.getUserFiles(userId);
	}
	public List<UserFile> getVisitedUserFiles(long userId,long visitedId){		
		if(visitedId == userId)
			return userDao.getUserFiles(userId);
		int status = 2;//pictures for pubic
		if(chatDao.getChatBuddy(userId,visitedId) != null)
			status = 1;//picutres for friends
		
		return userDao.getUserFilesByStatus(visitedId,status);
			
	}
	public UserFile getUserFileById(long id){
		return userDao.getUserFileById(id);
	}
		
	public AddressBook getAddressBookById(long id){
		return userDao.getAddressBookById(id);
	}
	public List<AddressBook> getAddressBooksByUser(long userId){
		return userDao.getAddressBooksByUser(userId);
	}
	public List<String> getAddressBookGroupByUser(long userId){
		return userDao.getAddressBookGroupByUser(userId);
	}
	public List<AddressBook> getAddressBooksByUser(long userId, String group){
		return userDao.getAddressBooksByUser(userId, group);
	}
	public List<Feedback> getFeedback(){
		return userDao.getFeedback();
	}
	
	public Feedback getFeedbackById(long id){
		return userDao.getFeedbackById(id);
	}
	public Bookmark getBookmarkById(long id){
		return userDao.getBookmarkById(id);
	}
	public List<Bookmark> getBookmarksByUser(long userId){
		return userDao.getBookmarksByUser(userId);
	}
	public List<Bookmark> getBookmarksByTag(long userId, String tag){
		return userDao.getBookmarksByTag(userId,tag);
	}
	public int getUserToDoCount(long userId){
		return userDao.getUserToDoCount(userId);
	}
	public List<ToDoBean> getToDosByUser(long userId){
		return userDao.getToDosByUser(userId);
	}	
	public ToDoBean getToDoById(long id){
		return userDao.getToDoById(id);
	}
	public Note getNoteByUser(long userId){
		return userDao.getNoteByUser(userId);
	}
	
	public int login(String userId, String password,long orgId ){		 
		int result; 
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
		String ePassword = encoder.encodePassword(password, null);
		User user = this.getUserByUserIdAndOrgId(userId,orgId);
		if(user == null){
			 result= -1;			 
		}else if(user.userDisabled()){
			 result= -3;
		}else if(user.userLocked()){
			 result= -4;
		}else if(!user.getPassword().equals(ePassword)){
			 result= -2;
		}else{			 
			 result = 1;
		}
		 		 
		 return result;	
	}
	
	public User signUp(User newUser, long orgId) {		
		User user = this.getUserByUserId(newUser.getUserId(),orgId);
		User result = null;
		if(user == null){	
			Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
			String ePassword = encoder.encodePassword(newUser.getPassword(), null);		
			newUser.setPassword(ePassword);
			result = this.createUser(newUser);
			try{
				SimpleMailMessage message = new SimpleMailMessage(this.welcomeMessage);
				message.setTo(newUser.getEmail());		
				StringBuffer content = new StringBuffer();
				content.append(newUser.getDisplayName());
				content.append(", ");		
				content.append(" welcome to :");			
				content.append("\n");
				message.setText(content.toString());
				mailSender.send(message);	
			}catch(Exception e){}
			UserInvite invite = userDao.getUserInviteByEmail(newUser.getUserId());
			if(invite != null){
				invite.setStatus(1);
				this.save(invite);
				Message acceptMessage = new Message(newUser.getDisplayName()+" has accepted your invitation."
						,"<a href='http://www."+OrganizationThreadLocal.getOrg().getSpace()+newUser.getUri()+"'>"+newUser.getDisplayName()+"</a> has accepted your invitation."
						,invite.getId(),newUser.getId());
				this.save(acceptMessage);
			}
		}		
		return result;	
	}
	
	public void saveUser(User user){
		User originalUser= this.getUserById(user.getId());
		 if(!user.getPassword().equals(originalUser.getPassword())){
			 Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
			 String password = encoder.encodePassword(user.getPassword(), null);
			 user.setPassword(password);
		 }
		userDao.saveUser(user);
	}
	
	public Horoscope getUserHoroscope(int month, int day){
		return userDao.getUserHoroscope(month,day);
	}
	public String getUserHoroscopeWeeklyInfo(long horoscopeId, String language){
		return userDao.getUserHoroscopeWeeklyInfo(horoscopeId, language);
	}
	public List<Horoscope> getHoroscopes(){
		return userDao.getHoroscopes();
	}
	
	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ChatDao getChatDao() {
		return chatDao;
	}
	

	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	public SimpleMailMessage getInviteMessage() {
		return inviteMessage;
	}

	public void setInviteMessage(SimpleMailMessage inviteMessage) {
		this.inviteMessage = inviteMessage;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(SimpleMailMessage welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public SimpleMailMessage getNewPasswordMessage() {
		return newPasswordMessage;
	}

	public void setNewPasswordMessage(SimpleMailMessage newPasswordMessage) {
		this.newPasswordMessage = newPasswordMessage;
	}

	public Indexer getIndexer() {
		return indexer;
	}
	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}
	public Searcher getSearcher() {
		return searcher;
	}
	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
	
}
