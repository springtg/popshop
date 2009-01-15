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
package org.light.portal.core;

import java.util.HashMap;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class PortalCommandFactory {
	private static PortalCommandFactory instance = new PortalCommandFactory();
	private HashMap<String, PortalCommand> commandMaps;
	
	private PortalCommandFactory(){		

		commandMaps = new HashMap<String, PortalCommand>();
		
		commandMaps.put("checkLogin", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"checkLogin"
											  ));
		commandMaps.put("checkVisit", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"checkVisit"
											  ));
		commandMaps.put("checkPage", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"checkPage"
											  ));
		commandMaps.put("checkGroup", new PortalSimpleCommand(
										   "org.light.portal.core.action.PortalConfigAction"											  
										  ,"checkGroup"
										  ));
		commandMaps.put("checkStore", new PortalSimpleCommand(
										   "org.light.portal.core.action.PortalConfigAction"											  
										  ,"checkStore"
										  ));
		commandMaps.put("getPortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortal"
											  ));
		commandMaps.put("visitPortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"visitPortal"
											  ));
		commandMaps.put("pagePortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"pagePortal"
											  ));
		commandMaps.put("groupPortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"groupPortal"
											  ));
		commandMaps.put("storePortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"storePortal"
											  ));
		commandMaps.put("businessPortal", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"businessPortal"
											  ));
		commandMaps.put("getPortalTabsByUser", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByUser"
											  ));
		commandMaps.put("getPortalTabsByVisit", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByVisit"
											  ));	
		commandMaps.put("getPortalTabsByPage", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByPage"
											  ));
		commandMaps.put("getPortalTabsByGroup", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByGroup"
											  ));
		commandMaps.put("getPortalTabsByStore", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByStore"
											  ));
		commandMaps.put("getPortalTabsByBusiness", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByBusiness"
											  ));
		commandMaps.put("getPortalTabsByParent", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortalTabsByParent"
											  ));
		commandMaps.put("getPortletsByTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortletsByTab"
											  ));
		commandMaps.put("getPortletsByVisitTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortletsByVisitTab"
											  ));
		commandMaps.put("getPortletsByGroupTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortletsByGroupTab"
											  ));
		commandMaps.put("getPortletsByStoreTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortletsByStoreTab"
											  ));
		commandMaps.put("getPortletTitle", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPortletTitle"
											  ));		
		commandMaps.put("getScripts", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getScripts"
											  ));
		commandMaps.put("changeMode", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeMode"
											  ));
		commandMaps.put("rememberState", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"rememberState"
											  ));
		commandMaps.put("rememberMode", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"rememberMode"
											  ));
		commandMaps.put("addSubPage", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"addSubPage"
											  ));
		commandMaps.put("changeTitle", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeTitle"
											  ));				
		commandMaps.put("changeLanguage", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeLanguage"
											  ));
		commandMaps.put("changeRegion", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeRegion"
											  ));
		commandMaps.put("changeTimeZone", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeTimeZone"
											  ));
		commandMaps.put("changeGeneral", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeGeneral"
											  ));
		commandMaps.put("changeTheme", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changeTheme"
											  ));
		commandMaps.put("addTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"addTab"
											  ));
		commandMaps.put("editTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"editTab"
											  ));
		commandMaps.put("manageTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"manageTab"
											  ));
		commandMaps.put("editTabTitle", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"editTabTitle"
								               ));
		commandMaps.put("addContent", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"addContent"
											  ));
		commandMaps.put("login", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"login"
											  ));
		commandMaps.put("logout", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"logout"
											  ));
		commandMaps.put("validateUserId", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"validateUserId"
											  ));
		commandMaps.put("validateMyUri", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"validateMyUri"
											  ));
		commandMaps.put("validateMyStoreUri", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"validateMyStoreUri"
											  ));
		commandMaps.put("signUp", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"signUp"
											  ));
		commandMaps.put("profile", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"profile"
											  ));
		commandMaps.put("checkMyUrl", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"checkMyUrl"
											  ));
		commandMaps.put("saveMyUrl", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"saveMyUrl"
											  ));
		commandMaps.put("deletePortlet", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"deletePortlet"
											  ));
		commandMaps.put("deleteTab", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"deleteTab"
											  ));
		commandMaps.put("changePosition", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"changePosition"
											  ));
		commandMaps.put("saveNote", new PortalSimpleCommand(
										       "org.light.portal.core.action.PortalConfigAction"             
										      ,"saveNote"
										      ));		
		commandMaps.put("getRssDesc", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getRssDesc"
											  ));
		commandMaps.put("trackRssItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"trackRssItem"
								               ));	
		commandMaps.put("readPopItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"readPopItem"
								               ));
		commandMaps.put("readViewedItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"readViewedItem"
								               ));
		commandMaps.put("readRecommendedItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"readRecommendedItem"
								               ));
		commandMaps.put("getRecommendedItemDesc", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"getRecommendedItemDesc"
								               ));
		commandMaps.put("getViewedItemDesc", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"getViewedItemDesc"
								               ));
		commandMaps.put("popRssItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"popRssItem"
								               ));
		commandMaps.put("popYouTubeItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"popYouTubeItem"
								               ));
		commandMaps.put("popBlogItem", new PortalSimpleCommand(
								                "org.light.portlets.blog.action.BlogAction"
								               ,"popBlogItem"
								               ));
		commandMaps.put("popForumItem", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"popForumItem"
								               ));
		commandMaps.put("popTopicItem", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"popTopicItem"
								               ));
		commandMaps.put("popGroupForumItem", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"popGroupForumItem"
								               ));
		commandMaps.put("popGroupTopicItem", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"popGroupTopicItem"
								               ));
		commandMaps.put("popDeliItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"popDeliItem"
								               ));
		commandMaps.put("popBookmarkItem", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"popBookmarkItem"
								               ));
		commandMaps.put("forwardRssToFriend", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"forwardRssToFriend"
								               ));
		commandMaps.put("forwardYouTubeToFriend", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"forwardYouTubeToFriend"
								               ));
		commandMaps.put("forwardBlogToFriend", new PortalSimpleCommand(
								                "org.light.portlets.blog.action.BlogAction"
								               ,"forwardBlogToFriend"
								               ));
		commandMaps.put("forwardForumToFriend", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"forwardForumToFriend"
								               ));
		commandMaps.put("forwardTopicToFriend", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"forwardTopicToFriend"
								               ));
		commandMaps.put("forwardGroupForumToFriend", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"forwardGroupForumToFriend"
								               ));
		commandMaps.put("forwardGroupTopicToFriend", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"forwardGroupTopicToFriend"
								               ));
		commandMaps.put("forwardDeliToFriend", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"forwardDeliToFriend"
								               ));
		commandMaps.put("forwardBookmarkToFriend", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"forwardBookmarkToFriend"
								               ));
		commandMaps.put("saveToBackground", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"saveToBackground"
								               ));
		commandMaps.put("saveToHeader", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"saveToHeader"
								               ));
		commandMaps.put("saveToBookmark", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"saveToBookmark"
								               ));
		commandMaps.put("saveToMyPicture", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"saveToMyPicture"
								               ));		
		commandMaps.put("saveYouTubeToBookmark", new PortalSimpleCommand(
								                "org.light.portal.core.action.PortalConfigAction"
								               ,"saveYouTubeToBookmark"
								               ));
		commandMaps.put("saveBlogToBookmark", new PortalSimpleCommand(
								                "org.light.portlets.blog.action.BlogAction"
								               ,"saveBlogToBookmark"
								               ));
		commandMaps.put("saveForumToBookmark", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"saveForumToBookmark"
								               ));
		commandMaps.put("saveTopicToBookmark", new PortalSimpleCommand(
								                "org.light.portlets.forum.action.ForumAction"
								               ,"saveTopicToBookmark"
								               ));
		commandMaps.put("saveGroupForumToBookmark", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"saveGroupForumToBookmark"
								               ));
		commandMaps.put("saveGroupTopicToBookmark", new PortalSimpleCommand(
								                "org.light.portlets.group.action.GroupAction"
								               ,"saveGroupTopicToBookmark"
								               ));
		commandMaps.put("getBookmarkDesc", new PortalSimpleCommand(
							                "org.light.portal.core.action.PortalConfigAction"
							               ,"getBookmarkDesc"
							               ));	
		commandMaps.put("getDeliDesc", new PortalSimpleCommand(
							                "org.light.portal.core.action.PortalConfigAction"
							               ,"getDeliDesc"
							               ));	
		commandMaps.put("getInternalNewsDesc", new PortalSimpleCommand(
							                "org.light.portal.core.action.PortalConfigAction"
							               ,"getInternalNewsDesc"
							               ));			
		commandMaps.put("getFeedbackDesc", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getFeedbackDesc"
											  ));
		commandMaps.put("getPopItemDesc", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"getPopItemDesc"
											  ));		
		commandMaps.put("getUserDetail", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"getUserDetail"
											  ));
		
		commandMaps.put("saveBuddyType", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"saveBuddyType"
											  ));
		commandMaps.put("deleteBuddy", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"deleteBuddy"
											  ));
		commandMaps.put("chatWithBuddy", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"chatWithBuddy"
											  ));
		commandMaps.put("listenServer", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"listenServer"
											  ));
		commandMaps.put("uploadAllOpml", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadAllOpml"
											  ));
		commandMaps.put("uploadOpml", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadOpml"
											  ));
		commandMaps.put("uploadProfilePhoto", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadProfilePhoto"
											  ));
		commandMaps.put("uploadPicture", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadPicture"
											  ));
		commandMaps.put("uploadPictures", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadPictures"
											  ));
		commandMaps.put("uploadMusic", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadMusic"
											  ));
		commandMaps.put("uploadMusics", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadMusics"
											  ));
		commandMaps.put("uploadFile", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadFile"
											  ));
		commandMaps.put("uploadGroupPicture", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"uploadGroupPicture"
											  ));
		commandMaps.put("getForumDesc", new PortalSimpleCommand(
											   "org.light.portlets.forum.action.ForumAction"											  
											  ,"getForumDesc"
											  ));
		commandMaps.put("getForumDetail", new PortalSimpleCommand(
											   "org.light.portlets.forum.action.ForumAction"											  
											  ,"getForumDetail"
											  ));
		commandMaps.put("saveForumReply", new PortalSimpleCommand(
											   "org.light.portlets.forum.action.ForumAction"											  
											  ,"saveForumReply"
											  ));
		commandMaps.put("getTodoDesc", new PortalSimpleCommand(
												"org.light.portal.core.action.PortalConfigAction"											  
											  ,"getTodoDesc"
											  ));		
		commandMaps.put("getProductDesc", new PortalSimpleCommand(
												"org.light.portal.core.action.PortalConfigAction"											  
											  ,"getProductDesc"
											  ));
		commandMaps.put("saveComment", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"saveComment"
											  ));
		commandMaps.put("saveItemComment", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"saveItemComment"
											  ));
		commandMaps.put("turnToMyAccount", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"turnToMyAccount"
											  ));
		commandMaps.put("addKeywords", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"addKeywords"
											  ));
		commandMaps.put("deleteKeywords", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"deleteKeywords"
											  ));
		commandMaps.put("addNotKeywords", new PortalSimpleCommand(
				   "org.light.portal.core.action.PortalConfigAction"											  
				  ,"addNotKeywords"
				  ));
		commandMaps.put("deleteNotKeywords", new PortalSimpleCommand(
				   "org.light.portal.core.action.PortalConfigAction"											  
				  ,"deleteNotKeywords"
				  ));
		commandMaps.put("addNotWords", new PortalSimpleCommand(
				   "org.light.portal.core.action.PortalConfigAction"											  
				  ,"addNotWords"
				  ));
		commandMaps.put("deleteNotWords", new PortalSimpleCommand(
				   "org.light.portal.core.action.PortalConfigAction"											  
				  ,"deleteNotWords"
				  ));
		commandMaps.put("configMyPicture", new PortalSimpleCommand(
				   "org.light.portal.core.action.PortalConfigAction"											  
				  ,"configMyPicture"
				  ));
		
		commandMaps.put("chatWithProfile", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"chatWithProfile"
											  ));		
		commandMaps.put("chatWithMember", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"chatWithMember"
											  ));
		commandMaps.put("acceptChat", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"acceptChat"
											  ));
		commandMaps.put("refuseChat", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"refuseChat"
											  ));
		commandMaps.put("closeChat", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"closeChat"
											  ));
		
		commandMaps.put("sendMessage", new PortalSimpleCommand(
											   "org.light.portal.core.action.PortalConfigAction"											  
											  ,"sendMessage"
											  ));
		commandMaps.put("addFriendRequest", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"addFriendRequest"
											  ));
		commandMaps.put("forwardToFriends", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"forwardToFriends"
											  ));
		commandMaps.put("addToFavorites", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"addToFavorites"
											  ));
		commandMaps.put("blockUser", new PortalSimpleCommand(
											   "org.light.portlets.chat.action.ChatAction"											  
											  ,"blockUser"
											  ));			
		commandMaps.put("getBlogDesc", new PortalSimpleCommand(
										   "org.light.portlets.blog.action.BlogAction"											  
										  ,"getBlogDesc"
										  ));
		commandMaps.put("getBlogDetail", new PortalSimpleCommand(
										   "org.light.portlets.blog.action.BlogAction"											  
										  ,"getBlogDetail"
										  ));
		commandMaps.put("getBlogComments", new PortalSimpleCommand(
										   "org.light.portlets.blog.action.BlogAction"											  
										  ,"getBlogComments"
										  ));
		commandMaps.put("saveBlogComment", new PortalSimpleCommand(
										   "org.light.portlets.blog.action.BlogAction"											  
										  ,"saveBlogComment"
										  ));
		commandMaps.put("popBlog", new PortalSimpleCommand(
										   "org.light.portlets.blog.action.BlogAction"											  
										  ,"popBlog"
										  ));
		commandMaps.put("joinToGroup", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"joinToGroup"
										  ));
		commandMaps.put("inviteToGroup", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"inviteToGroup"
										  ));
		commandMaps.put("validateGroupUri", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"validateGroupUri"
										  ));			
		commandMaps.put("resignGroup", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"resignGroup"
										  ));
		commandMaps.put("getGroupPrivacy", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"getGroupPrivacy"
										  ));
		commandMaps.put("saveGroupPrivacy", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"saveGroupPrivacy"
										  ));
		commandMaps.put("deleteGroupProfile", new PortalSimpleCommand(
										   "org.light.portlets.group.action.GroupAction"											  
										  ,"deleteGroupProfile"
										  ));
		commandMaps.put("getAdDesc", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"getAdDesc"
									  ));
		commandMaps.put("getAdComments", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"getAdComments"
									  ));
		commandMaps.put("saveAdComment", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"saveAdComment"
									  ));
		commandMaps.put("popAd", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"popAd"
									  ));
		commandMaps.put("forwardAdToFriend", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"forwardAdToFriend"
									  ));
		commandMaps.put("saveAdToBookmark", new PortalSimpleCommand(
									   "org.light.portlets.ad.action.AdAction"											  
									  ,"saveAdToBookmark"
									  ));
	}
	
	public static PortalCommandFactory getInstance(){
		return instance;
	}
	
	public PortalCommand getCommand(String path){
		return commandMaps.get(path);
	}

	
}
