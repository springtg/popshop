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
package org.light.portal.user.service;

import java.util.List;

import org.light.portal.model.OrgProfile;
import org.light.portal.model.Organization;
import org.light.portal.model.User;
import org.light.portal.model.UserBlock;
import org.light.portal.model.UserComments;
import org.light.portal.model.UserFavourite;
import org.light.portal.model.UserFile;
import org.light.portal.model.UserFriendRequest;
import org.light.portal.model.UserInvite;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserPicture;
import org.light.portal.model.UserProfile;
import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;
import org.light.portlets.addressbook.AddressBook;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.feedback.Feedback;
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
public interface UserService {
	public Organization getOrgByVirtualHost(String host);
	public Organization getOrgById(long id);
	public List<Organization> getOrganizations();
	public OrgProfile getOrgProfileByOrgId(long orgId, String language);
	public void createOrganization(Organization org,OrgProfile profile);
	public SearchResult searchUser(SearchCriteria criteria) throws Exception;
	public void reIndex();
	public void reIndex(Class klass);
	public User createUser(User newUser);	
	public void deleteUser(long userId);
	public User getUserByUserIdAndOrgId(String userId, long orgId);
	public User getUserById(long id);
	public User getUserByUserId(String userId, long orgId);	
	public User getUserByUri(String uri,long orgId);	
	public User getUserByEmail(String email);
	public boolean sendNewPassword(User user);
	public List<UserProfile> getUserByName(String fullName);
	public List<UserProfile> getUserByName(String firstName,String lastName);
	public UserProfile getUserProfileById(long userId);	
	public List<User> getCoolNewPeople(int start, int max);
	public List<User> getOnlinePeople(int start, int max);
	public int getOnlinePeopleTotal();
	public int getCoolNewPeopleTotal();
	public List<UserComments> getUserComments(long userId);
	public UserComments getUserCommentsById(long id);
	public List<UserPicture> getUserPictures(long userId);
	public List<UserPicture> getVisitedUserPictures(long userId,long visitedId);
	public List<UserPicture> getUserRankPictures(long userId);
	public UserPicture getUserPictureById(long id);
	public List<UserFile> getUserFiles(long userId);
	public List<UserFile> getVisitedUserFiles(long userId,long visitedId);
	public UserFile getUserFileById(long id);
	public List<Bulletin> getBulletinsByUser(long userId);
	public Bulletin getBulletinById(long id);
	public int login(String userId, String password,long orgId);
	public User signUp(User newUser,long orgId);
	public boolean inviteFriends(String mailList,String desc,User user);
	public void saveUser(User user);
	public void deleteUser(User user);
	public void sendBulletin(Bulletin bulletin);
	public void sendMessage(Message message);
	public Message getMessageById(long id);
	public List<Message> getMessagesBySender(long userId);
	public List<Message> getMessagesByUser(long userId);
	public int getNewMessageCountByUser(long userId);
	public List<UserFriendRequest> getFriendRequestsByUser(long userId);
	public int getNewFriendRequestCountByUser(long userId);
	public UserFriendRequest getUserFriendRequestById(long id);
	public boolean approveFriend(UserFriendRequest friendRequest);
	public List<UserFavourite> getUserFavourites(long userId);
	public List<UserBlock> getUserBlocks(long userId);
	public List<UserInvite> getUserInvites(long userId);	
	public UserBlock getUserBlockById(long id);
	public UserBlock getUserBlockByUser(long userId, long blockId);
	public UserMusic getUserMusicById(long id);
	public List<UserMusic> getUserMusics(long userId);
	public List<UserMusic> getUserRankMusics(long userId);
	public List<UserMusic> getVisitedUserMusics(long userId,long visitedId);
	public AddressBook getAddressBookById(long id);
	public List<AddressBook> getAddressBooksByUser(long userId);
	public List<AddressBook> getAddressBooksByUser(long userId, String group);
	public List<String> getAddressBookGroupByUser(long userId);
	public List<Feedback> getFeedback();
	public Feedback getFeedbackById(long id);	
	public Bookmark getBookmarkById(long id);	
	public List<Bookmark> getBookmarksByUser(long userId);
	public List<Bookmark> getBookmarksByTag(long userId, String tag);
	public List<ToDoBean> getToDosByUser(long userId);
	public ToDoBean getToDoById(long id);
	public Note getNoteByUser(long userId);
	public int getUserPictureCount(long userId);
	public int getUserMusicCount(long userId);
	public int getUserFileCount(long userId);
	public int getUserToDoCount(long userId);
	public int getUserBulletinCount(long userId);
	public Horoscope getUserHoroscope(int month, int day);
	public List<Horoscope> getHoroscopes();
	public String getUserHoroscopeWeeklyInfo(long horoscopeId, String language);
	public int getUserCommentsCount(long userId);
	public List<UserComments> getUserComments(long userId, int showNumber);
}
