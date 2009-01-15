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
package org.light.portal.core.action;

import static org.light.portal.util.Constants._APPLICATION_CONFIG;
import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._FILE_PATH;
import static org.light.portal.util.Constants._JAVASCRIPT_LIBRARYS;
import static org.light.portal.util.Constants._LANGUAGE_ALL;
import static org.light.portal.util.Constants._MESSAGE_EVENT_COMMENT;
import static org.light.portal.util.Constants._MESSAGE_EVENT_TYPE_REQUEST;
import static org.light.portal.util.Constants._MY_FEED;
import static org.light.portal.util.Constants._MY_FILE_PATH;
import static org.light.portal.util.Constants._MY_IMAGE_PATH;
import static org.light.portal.util.Constants._MY_MUSIC_PATH;
import static org.light.portal.util.Constants._PORTLET_WINDOW_TRADITIONAL;
import static org.light.portal.util.Constants._ROLE_GUEST;
import static org.light.portal.util.Constants._ROLE_MEMBER;
import static org.light.portal.util.Constants._ROLE_NO_PROFILE;
import static org.light.portal.util.Constants._ROLE_PROFILE;
import static org.light.portal.util.Constants._ROLE_USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_STORE;
import static org.light.portal.util.Constants._VISITED_USER;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.light.portal.core.service.PortalService;
import org.light.portal.model.NotKeyword;
import org.light.portal.model.NotWord;
import org.light.portal.model.PopularItem;
import org.light.portal.model.PopularItemComments;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalRole;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.PortletObject;
import org.light.portal.model.PortletObjectRef;
import org.light.portal.model.RecommendedItem;
import org.light.portal.model.User;
import org.light.portal.model.UserComments;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserFile;
import org.light.portal.model.UserKeyword;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserPicture;
import org.light.portal.model.UserProfile;
import org.light.portal.model.ViewedItem;
import org.light.portal.model.ViewedItemUser;
import org.light.portal.security.config.Application;
import org.light.portal.util.MessageUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.StringUtils;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.bookmark.BookmarkTag;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.ChatStatusRef;
import org.light.portlets.connection.Connection;
import org.light.portlets.feedback.Feedback;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupPicture;
import org.light.portlets.internal.InternalNews;
import org.light.portlets.message.Message;
import org.light.portlets.note.Note;
import org.light.portlets.rss.RssBean;
import org.light.portlets.rss.RssCacheFactory;
import org.light.portlets.todolist.ToDoBean;
import org.light.portlets.youtube.VideoBean;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 4, 2006
 **/
public class PortalConfigAction extends BaseAction{
	
	public Object checkLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		String result = "-2";
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		this.removeVisitedUser(request);
		this.removeVisitedGroup(request);		
		User user = this.getUser(request);
		if(user != null)
			result = (user.getUserId().equals(OrganizationThreadLocal.getDefaultUserId())) ? "0" : user.getUserId()+"|"+this.getPortal(request,response).toString()+"|"+this.getPortalTabsByUser(request,response).toString();
		else{
			if(userId != null && password != null){
				this.login(request,response);			
			}
			user = this.getUser(request);
			userId =(user != null) ? user.getUserId() : "0";
			result = userId+"|"+this.getPortal(request,response).toString()+"|"+this.getPortalTabsByUser(request,response).toString();
		}
		
		return result;
	}
	
	public Object checkVisit(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		String result = "-1";
		User user = this.getVisitedUser(request);
		if(user != null) result = "1";
		return result;
	}
	
	public Object checkPage(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		String result = "-1";
		PortalTab tab = this.getVisitedPage(request);
		if(tab != null) result = "1";
		return result;
	}
	
	public Object checkGroup(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		String result = "-1";
		Group group = this.getVisitedGroup(request);
		if(group != null) result = "group_"+group.getId();
		return result;
	}
	
	public Object getPortal(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		PortalService service = getPortalService(request);			
		User user = this.getUser(request);
		if(user == null){
			user = this.getUserService(request).getUserByUserId(OrganizationThreadLocal.getDefaultUserId(),OrganizationThreadLocal.getOrganizationId() );
			this.setUser(request,user);
		}
		Portal portal = this.getPortal(request);		
		List<PortalRole> portalRoles = service.getPortalUserRoleByUser(user.getId());					
		int allowLookAndFeel = 0;
		int allowLayout = 0;
		int allowAddTab = 0;
		int allowAddContent = 0;
		int allowSignIn = 0;
		int allowTurnOff = 0;
		for(PortalRole portalRole : portalRoles){
			if(allowLookAndFeel == 0 && portalRole.getAllowLookAndFeel() == 1) allowLookAndFeel = 1;
			if(allowLayout == 0 && portalRole.getAllowLayout() == 1) allowLayout = 1;
			if(allowAddTab == 0 && portalRole.getAllowAddTab() == 1) allowAddTab = 1;
			if(allowAddContent == 0 && portalRole.getAllowAddContent() == 1) allowAddContent = 1;
			if(allowSignIn == 0 && portalRole.getAllowSignIn() == 1) allowSignIn = 1;
			if(allowTurnOff == 0 && portalRole.getAllowTurnOff() == 1) allowTurnOff = 1;
		}
		int allowChangeLocale = 0;
		Application appConfig = (Application)request.getSession().getServletContext().getAttribute(_APPLICATION_CONFIG);
		if(portal.isShowLocale() && appConfig.getAllowChangeLocale()) allowChangeLocale = 1;	
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		return request.getContextPath()+","+portal.getPortalTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme()+","+OrganizationThreadLocal.getLogo()+","+portal.getMaxShowTabs();
	}		
	
	public Object mobilePortal(HttpServletRequest request, HttpServletResponse response) throws Exception{				
		User user = this.getUser(request);
		if(user == null){
			user = this.getUserService(request).getUserByUserId(OrganizationThreadLocal.getDefaultUserId(),OrganizationThreadLocal.getOrganizationId());
			this.setUser(request,user);
		}
		Portal portal = this.getPortal(request);		
		int allowLookAndFeel = 0;
		int allowLayout = 0;
		int allowAddTab = 0;
		int allowAddContent = 0;
		int allowSignIn = 1;
		int allowTurnOff = 0;
		int allowChangeLocale = 0;
		Application appConfig = (Application)request.getSession().getServletContext().getAttribute(_APPLICATION_CONFIG);
		if(portal.isShowLocale() && appConfig.getAllowChangeLocale()) allowChangeLocale = 1;	
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		return request.getContextPath()+","+portal.getPortalTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme();
	}		
	public Object visitPortal(HttpServletRequest request, HttpServletResponse response) throws Exception{				
		User user =this.getVisitedUser(request);
		user.setVisitCount(user.getVisitCount() + 1);
		this.getUserService(request).saveUser(user);
		Portal portal = this.getVisitedPortal(request);			
		
		int allowLookAndFeel = 0;
		int allowLayout = 0;
		int allowAddTab = 0;
		int allowAddContent = 0;
		int allowSignIn = 1;
		int allowTurnOff = 0;		
		int allowChangeLocale = 0;		
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		String bgMusic="none";
	    if(user.getMyMusicAutoPlay() != 0 && user.getMusicUrl() != null){
	    	User owner = this.getUser(request);
	    	if(owner == null || owner.getOtherMusucAutoPlay() == 1)
	    		bgMusic = user.getMusicUrl();
	    }
		return request.getContextPath()+","+portal.getPortalTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme()+","+bgMusic;
	}	
	public Object pagePortal(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		PortalTab tab = this.getVisitedPage(request);
		Portal portal = getPortalService(request).getPortalByUser(tab.getUserId());	
		boolean authorized =isAdmin(request);
		int allowLookAndFeel = (authorized) ? 1 : 0;
		int allowLayout = (authorized) ? 1 : 0;
		int allowAddTab = (authorized) ? 1 : 0;
		int allowAddContent = (authorized) ? 1 : 0;
		int allowSignIn = 1;
		int allowTurnOff = 0;		
		int allowChangeLocale = 0;		
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		
		return request.getContextPath()+","+tab.getTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme();
	}	
	public Object groupPortal(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		Group group =this.getVisitedGroup(request);
		group.setViewCount(group.getViewCount() + 1);
		this.getPortalService(request).save(group);
		Portal portal = this.getPortal(request);
		
		int allowLookAndFeel = 0;
		int allowLayout = 0;
		int allowAddTab = 0;
		int allowAddContent = 0;
		int allowSignIn = 1;
		int allowTurnOff = 0;		
		int allowChangeLocale = 0;		
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		if(group.getLeaderId()==this.getUser(request).getId()){
			allowLookAndFeel = 1;
			allowLayout = 1;
			allowAddTab = 1;
			allowAddContent = 1;
		}		
		return request.getContextPath()+","+portal.getPortalTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme();
	}	
	
	public Object businessPortal(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		Group group =this.getVisitedGroup(request);
		group.setViewCount(group.getViewCount() + 1);
		this.getPortalService(request).save(group);
		Portal portal = this.getVisitedPortal(request);
		
		int allowLookAndFeel = 0;
		int allowLayout = 0;
		int allowAddTab = 0;
		int allowAddContent = 0;
		int allowSignIn = 1;
		int allowTurnOff = 0;		
		int allowChangeLocale = 0;		
		String bgImage = portal.getBgImage();
		if(bgImage == null) bgImage = "";
		String bgPosition = portal.getBgPosition();
		if(bgPosition == null) bgPosition = "";
		String headerImage = portal.getHeaderImage();
		if(headerImage == null) headerImage = "";
		String headerPosition = portal.getHeaderPosition();
		if(headerPosition == null) headerPosition = "";
		if(group.getLeaderId()==this.getUser(request).getId()){
			allowLookAndFeel = 1;
			allowLayout = 1;
			allowAddTab = 1;
			allowAddContent = 1;
		}				
		return request.getContextPath()+","+portal.getPortalTitle()+","+allowLookAndFeel+","+allowLayout+","+allowAddTab+","+allowAddContent+","+allowSignIn+","+allowTurnOff+","+allowChangeLocale+","+portal.getTransparent()+","+this.getLocale(request)+","+bgImage+","+bgPosition+","+portal.getBgRepeat()+","+headerImage+","+headerPosition+","+portal.getHeaderRepeat()+","+portal.getHeaderHeight()+","+portal.getFontSize()+","+portal.getShowSearchBar()+","+portal.getDefaultSearchEngine()+","+portal.getTextColor()+","+portal.getTextFont()+","+portal.getTheme();
	}	
	public Object getPortalTabsByUser(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		User user = this.getUser(request);
		StringBuffer resultBuffer = new StringBuffer();		
		PortalService service = getPortalService(request);
		List<PortalTab> tabs = service.getPortalTabByUser(user.getUserId());
		if(tabs != null){
			int i=0;
			for(PortalTab tab : tabs){
				String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";					
				resultBuffer.append("new LightPortalTab(")
							.append(i)
							.append(",\"tab_page").append(tab.getId())
							.append("\",")
							.append(tab.getId())
							.append(",\"")
							.append(tab.getTitle())
							.append("\",\"")
							.append(tab.getUrl())
							.append("\",")
							.append(tab.isTabCloseable())
							.append(",")
							.append(tab.isTabEditable())
							.append(",")
							.append(tab.isTabMoveable())
							.append(",")
							.append(tab.isTabAllowAddContent())
							.append(",'")							
							.append(tab.getColor())
							.append("',")
							.append(tab.isTabDefaulted())
							.append(",")
							.append(tab.getBetween())
							.append(",")
							.append(widths)
							.append(",")
							.append(tab.getFitScreen())
							.append(",\"")
							.append(tab.getPortletWindowType())
							.append("\",")
							.append(tab.getParentId())
							.append(")")
							;				
				if(i < tabs.size() - 1)
					resultBuffer.append(";");
				i++;
			}
		}
		return resultBuffer.toString();		
	}	
	public Object getPortalTabsByVisit(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		User user = this.getVisitedUser(request);		
		StringBuffer resultBuffer = new StringBuffer();		
		PortalService service = getPortalService(request);
		if(user.getProfileFriendViewOnly() == 1){
			User visitor = this.getUser(request);
			if(this.getChatService(request).getChatBuddy(user.getId(),visitor.getId()) == null){				
				List<PortalTab> profileTab = service.getPortalTabByUser(_ROLE_NO_PROFILE);
				int i = 0;
				if(profileTab != null){
					Iterator<PortalTab> tabs = profileTab.iterator();
					while(tabs.hasNext()){				
						PortalTab tab = tabs.next();	
						String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";					
						resultBuffer.append("new LightPortalTab(")
									.append(i)
									.append(",\"tab_page").append(tab.getId())
									.append("\",")
									.append(tab.getId())
									.append(",\"")
									.append(tab.getTitle())
									.append("\",\"")
									.append(tab.getUrl())
									.append("\",")
									.append(false)
									.append(",")
									.append(false)
									.append(",")
									.append(false)
									.append(",")
									.append(false)
									.append(",'")							
									.append(tab.getColor())
									.append("',")
									.append(true)
									.append(",")
									.append(tab.getBetween())
									.append(",")
									.append(widths)
									.append(",")
									.append(tab.getFitScreen())
									.append(",\"")
									.append(tab.getPortletWindowType())
									.append("\",")
									.append(tab.getParentId())
									.append(")")
									.append(";")
									;
						i++;				
					}
				}
				return resultBuffer.toString().substring(0,resultBuffer.length() - 1);	
			}			
		}
		List<PortalTab> profileTab = service.getUserProfilePortalTab(user.getUserId());
		if(profileTab == null || profileTab.size() == 0)
			profileTab = service.getPortalTabByUser(_ROLE_PROFILE);
		int i = 0;
		if(profileTab != null){
			Iterator<PortalTab> tabs = profileTab.iterator();
			while(tabs.hasNext()){				
				PortalTab tab = tabs.next();	
				String widths ="";
				if(tab.getWidths().indexOf(",") > 0)
					widths = "new Array("+tab.getWidths()+")";
				else
					widths = "new Array('"+tab.getWidths()+"')";				
				resultBuffer.append("new LightPortalTab(")
							.append(i)
							.append(",\"tab_page").append(tab.getId())
							.append("\",")
							.append(tab.getId())
							.append(",\"")
							.append(tab.getTitle())
							.append("\",\"")
							.append(tab.getUrl())
							.append("\",")
							.append(false)
							.append(",")
							.append(false)
							.append(",")
							.append(false)
							.append(",")
							.append(false)
							.append(",'")							
							.append(tab.getColor())
							.append("',")
							.append(true)
							.append(",")
							.append(tab.getBetween())
							.append(",")
							.append(widths)
							.append(",")
							.append(tab.getFitScreen())
							.append(",\"")
							.append(tab.getPortletWindowType())
							.append("\",")
							.append(tab.getParentId())
							.append(")")
							.append(";")
							;
				i++;				
			}
		}
		return resultBuffer.toString().substring(0,resultBuffer.length() - 1);		
	}	
	public Object getPortalTabsByPage(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		StringBuffer resultBuffer = new StringBuffer();		
		PortalTab tab = this.getVisitedPage(request);	
		String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";	
		boolean authorized =isAdmin(request);
		resultBuffer.append("new LightPortalTab(")
					.append(0)
					.append(",\"tab_page").append(tab.getId())
					.append("\",")
					.append(tab.getId())
					.append(",\"")
					.append(tab.getTitle())
					.append("\",\"")
					.append(tab.getUrl())
					.append("\",")
					.append(authorized ? true : false)
					.append(",")
					.append(authorized ? true : false)
					.append(",")
					.append(authorized ? true : false)
					.append(",")
					.append(authorized ? true : false)
					.append(",'")							
					.append(tab.getColor())
					.append("',")
					.append(true)
					.append(",")
					.append(tab.getBetween())
					.append(",")
					.append(widths)
					.append(",")
					.append(tab.getFitScreen())
					.append(",\"")
					.append(authorized ? _PORTLET_WINDOW_TRADITIONAL : tab.getPortletWindowType())
					.append("\",")
					.append(tab.getParentId())
					.append(")")	
					;
		return resultBuffer.toString();	
	}	
	public Object getPortalTabsByGroup(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		Group group = this.getVisitedGroup(request);
		StringBuffer resultBuffer = new StringBuffer();		
		List<PortalTab> tabList = getPortalService(request).getPortalTabByUser("group_"+group.getId());
		if(tabList != null){
			Iterator<PortalTab> tabs = tabList.iterator();
			int i = 0;
			while(tabs.hasNext()){				
				PortalTab tab = tabs.next();	
				String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";					
				resultBuffer.append("new LightPortalTab(")
							.append(i)
							.append(",\"tab_page").append(tab.getId())
							.append("\",")
							.append(tab.getId())
							.append(",\"")
							.append(tab.getTitle())
							.append("\",\"")
							.append(tab.getUrl())
							.append("\",")
							.append(tab.isTabCloseable())
							.append(",")
							.append(tab.isTabEditable())
							.append(",")
							.append(tab.isTabMoveable())
							.append(",")
							.append(tab.isTabAllowAddContent())
							.append(",'")							
							.append(tab.getColor())
							.append("',")
							.append(tab.isTabDefaulted())
							.append(",")
							.append(tab.getBetween())
							.append(",")
							.append(widths)
							.append(",")
							.append(tab.getFitScreen())
							.append(",\"")
							.append(tab.getPortletWindowType())
							.append("\",")
							.append(tab.getParentId())
							.append(")")
							;
				if(i == 0 && this.getUser(request) == null) break;
				if(i < tabList.size() - 1)
					resultBuffer.append(";");
				i++;				
			}
		}
		return resultBuffer.toString();		
	}
	
	public Object getPortalTabsByBusiness(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		Group group = this.getVisitedGroup(request);
		StringBuffer resultBuffer = new StringBuffer();		
		List<PortalTab> tabList = getPortalService(request).getPortalTabByUser("biz_"+group.getId());
		if(tabList != null){
			Iterator<PortalTab> tabs = tabList.iterator();
			int i = 0;
			while(tabs.hasNext()){				
				PortalTab tab = tabs.next();	
				String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";					
				resultBuffer.append("new LightPortalTab(")
							.append(i)
							.append(",\"tab_page").append(tab.getId())
							.append("\",")
							.append(tab.getId())
							.append(",\"")
							.append(tab.getTitle())
							.append("\",\"")
							.append(tab.getUrl())
							.append("\",")
							.append(tab.isTabCloseable())
							.append(",")
							.append(tab.isTabEditable())
							.append(",")
							.append(tab.isTabMoveable())
							.append(",")
							.append(tab.isTabAllowAddContent())
							.append(",'")							
							.append(tab.getColor())
							.append("',")
							.append(tab.isTabDefaulted())
							.append(",")
							.append(tab.getBetween())
							.append(",")
							.append(widths)
							.append(",")
							.append(tab.getFitScreen())
							.append(",\"")
							.append(tab.getPortletWindowType())
							.append("\",")
							.append(tab.getParentId())
							.append(")")
							;
				if(i < tabList.size() - 1)
					resultBuffer.append(";");
				i++;				
			}
		}
		return resultBuffer.toString();		
	}
	public Object getPortalTabsByParent(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String parentId = request.getParameter("parentId");
		if(parentId == null) parentId = (String)request.getAttribute("parentId");
		StringBuffer resultBuffer = new StringBuffer();		
		PortalService service = getPortalService(request);
		List<PortalTab> tabList = service.getPortalTabByParent(Integer.parseInt(parentId));
		if(tabList != null){
			Iterator<PortalTab> tabs = tabList.iterator();
			int i = 0;
			while(tabs.hasNext()){				
				PortalTab tab = tabs.next();	
				String widths = "new Array("+((tab.getWidths().indexOf(",") >0) ? tab.getWidths() : tab.getWidths()+",0")+")";					
				resultBuffer.append("new LightPortalTab(")
							.append(i)
							.append(",\"tab_page").append(tab.getId())
							.append("\",")
							.append(tab.getId())
							.append(",\"")
							.append(tab.getTitle())
							.append("\",\"")
							.append(tab.getUrl())
							.append("\",")
							.append(tab.isTabCloseable())
							.append(",")
							.append(tab.isTabEditable())
							.append(",")
							.append(tab.isTabMoveable())
							.append(",")
							.append(tab.isTabAllowAddContent())
							.append(",'")							
							.append(tab.getColor())
							.append("',")
							.append(tab.isTabDefaulted())
							.append(",")
							.append(tab.getBetween())
							.append(",")
							.append(widths)
							.append(",")
							.append(tab.getFitScreen())
							.append(",\"")
							.append(tab.getPortletWindowType())
							.append("\",")
							.append(tab.getParentId())
							.append(")")
							;
				if(i < tabList.size() - 1)
					resultBuffer.append(";");
				i++;				
			}
		}
		if(resultBuffer.length() == 0) resultBuffer.append(0);
		return resultBuffer.toString();		
	}
	public Object getPortletsByTab(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String path = request.getContextPath();		
		String tabId = (String)request.getParameter("tabId");
		if(tabId == null) tabId = (String)request.getAttribute("tabId");
		StringBuffer resultBuffer = new StringBuffer();
        User user = this.getUser(request);
		if(tabId != null){
			PortalService service = getPortalService(request);
			List<PortletObject> portletList = service.getPortletsByTab(Integer.parseInt(tabId));			
			if(portletList != null){
				Iterator<PortletObject> portlets = portletList.iterator();
				int i = 0;
				while(portlets.hasNext()){
					PortletObject p = portlets.next();	
					String title = p.getTitle();
					if(user != null){
						if(p.getPath().equals("/profilePortlet.lp")){
							title = user.getDisplayName();						
						}
//						else if(p.getPath().equals("/friendsPortlet.lp")){
//							int count = getChatService(request).getBuddyCount(user.getUserId());
//							if(count > 0) title = title+"("+count+")";
//						}else if(p.getPath().equals("/myPicturePortlet.lp")){
//							int count = getUserService(request).getUserPictureCount(user.getUserId());
//							if(count > 0) title = title+"("+count+")";
//						}else if(p.getPath().equals("/myMusicPortlet.lp")){
//							int count = getUserService(request).getUserMusicCount(user.getUserId());
//							if(count > 0) title = title+"("+count+")";
//						}else if(p.getPath().equals("/myFilePortlet.lp")){
//							int count = getUserService(request).getUserFileCount(user.getUserId());
//							if(count > 0) title = title+"("+count+")";
//						}
					}
					resultBuffer.append(p.getWindowSkin())
								.append(",")
								.append(p.getId())
								.append(",")
								.append(p.getColumn())
								.append(",\"")
								.append(title)
								.append("\",\"")
								.append(p.getIcon())
								.append("\",\"")
								.append(p.getUrl())
								.append("\",\"")
								.append(p.getName())
								.append("\",\"")
								.append(path+p.getPath())
								.append("\",")
								.append(p.isSupportCloseable())
								.append(",")
								.append(p.isSupportRefreshMode())
								.append(",")
								.append(p.isSupportEditMode())
								.append(",")
								.append(p.isSupportHelpMode())
								.append(",")
								.append(p.isSupportConfigMode())
								.append(",")
								.append(p.isSupportMinimized())
								.append(",")
								.append(p.isSupportMaximized())
								.append(",")							
								.append(p.isSupportAutoRefreshed())							
								.append(",")
								.append(p.isSupportRefreshAtClient())							
								.append(",")
								.append(p.getPeriodTime())
								.append(",")
								.append(p.isSupportJS())
								.append(",\"")
								.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
								.append("\",\"")
								.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
								.append("\",\"")
								.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
								.append("\",\"")
								.append((p.getTextColor()== null ? "" : p.getTextColor()))
								.append("\",\"")
								.append((p.getParameter()== null ? "" : p.getParameter()))
								.append("\",")
								.append(p.getWindowStatus())
								.append(",")
								.append(p.getMode())
								.append(",")
								.append(p.getTransparent())								
								;
					if(i < portletList.size() - 1)
						resultBuffer.append(";");
					i++;
				}
			}
		}
	    return resultBuffer.toString();					
	}	
	public Object getPortletsByVisitTab(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String path = request.getContextPath();		
		String tabId = (String)request.getParameter("tabId");
		if(tabId == null) tabId = (String)request.getAttribute("tabId");
		StringBuffer resultBuffer = new StringBuffer();
		if(tabId != null){
			PortalService service = getPortalService(request);
			List<PortletObject> portletList = service.getPortletsByTab(Integer.parseInt(tabId));			
			if(portletList != null){
				Iterator<PortletObject> portlets = portletList.iterator();
				int i = 0;
				while(portlets.hasNext()){
					PortletObject p = portlets.next();	
					String title = p.getTitle();
					User user = this.getVisitedUser(request);
					if(user != null){
						if(p.getPath().equals("/profilePortlet.lp")){
							title = user.getDisplayName();
						}
//						if(p.getPath().equals("/friendsPortlet.lp")){
//							int count = getChatService(request).getBuddyCount(user.getUserId());
//							if(count > 0) title = title+"("+count+")";
//						}
					}
					boolean authorized =isAdmin(request);
					resultBuffer.append(authorized ? null : p.getWindowSkin())
								.append(",")
								.append(p.getId())
								.append(",")
								.append(p.getColumn())
								.append(",\"")
								.append(title)
								.append("\",\"")
								.append(p.getIcon())
								.append("\",\"")
								.append(p.getUrl())
								.append("\",\"")
								.append(p.getName())
								.append("\",\"")
								.append(path+p.getPath())
								.append("\",")
								.append(authorized ? true : false)
								.append(",")
								.append(true)
								.append(",")
								.append(authorized ? true : false)
								.append(",")
								.append(authorized ? true : false)
								.append(",")
								.append(authorized ? true : false)
								.append(",")
								.append(p.isSupportMinimized())
								.append(",")
								.append(p.isSupportMaximized())
								.append(",")
								.append(p.isSupportAutoRefreshed())	
								.append(",")
								.append(p.isSupportRefreshAtClient())		
								.append(",")
								.append(p.getPeriodTime())
								.append(",")
								.append(p.isSupportJS())
								.append(",\"")
								.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
								.append("\",\"")
								.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
								.append("\",\"")
								.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
								.append("\",\"")
								.append((p.getTextColor()== null ? "" : p.getTextColor()))
								.append("\",\"")
								.append((p.getParameter()== null ? "" : p.getParameter()))
								.append("\",")
								.append(p.getWindowStatus())
								.append(",")
								.append(p.getMode())
								.append(",")
								.append(p.getTransparent())
								;
					if(i < portletList.size() - 1)
						resultBuffer.append(";");
					i++;
				}
			}
		}
	    return resultBuffer.toString();					
	}
	public Object getMobilePortletsByUser(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		StringBuffer resultBuffer = new StringBuffer();
		String path = request.getContextPath();	
		User user = this.getUser(request);
		if(user != null){
			List<PortalTab> tabs = this.getPortalService(request).getUserPersonalPortalTab(user.getUserId());
	    	if(tabs != null){
	    		for(PortalTab tab : tabs){
    				List<PortletObject> portlets = this.getPortalService(request).getPortletsByTab(tab.getId());               
    		    	for(PortletObject p : portlets){
    		    		if(p.getMobile() == 0) continue;
						String title = p.getTitle();
						if(user != null){
							if(p.getPath().equals("/profilePortlet.lp")){
								title = user.getDisplayName();						
							}
						}
						resultBuffer.append("w2")
									.append(",")
									.append(p.getId())
									.append(",")
									.append(0)
									.append(",\"")
									.append(title)
									.append("\",\"")
									.append(p.getIcon())
									.append("\",\"")
									.append(p.getUrl())
									.append("\",\"")
									.append(p.getName())
									.append("\",\"")
									.append(path+p.getPath())
									.append("\",")
									.append(p.isSupportCloseable())
									.append(",")
									.append(p.isSupportRefreshMode())
									.append(",")
									.append(p.isSupportEditMode())
									.append(",")
									.append(p.isSupportHelpMode())
									.append(",")
									.append(p.isSupportConfigMode())
									.append(",")
									.append(false)
									.append(",")
									.append(false)
									.append(",")							
									.append(p.isSupportAutoRefreshed())							
									.append(",")
									.append(p.isSupportRefreshAtClient())							
									.append(",")
									.append(p.getPeriodTime())
									.append(",")
									.append(p.isSupportJS())
									.append(",\"")
									.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
									.append("\",\"")
									.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
									.append("\",\"")
									.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
									.append("\",\"")
									.append((p.getTextColor()== null ? "" : p.getTextColor()))
									.append("\",\"")
									.append((p.getParameter()== null ? "" : p.getParameter()))
									.append("\",")
									.append(p.getWindowStatus())
									.append(",")
									.append(p.getMode())
									.append(",")
									.append(p.getTransparent())								
									.append(";");
    		    	}
				}
			}
		}
		String result = resultBuffer.toString();
		if(result != null && result.length() > 1)
			result = result.substring(0, result.length() - 1);
	    return result;					
	}	
	public Object getPortletTitle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String path = request.getParameter("path");
		String title=request.getParameter("responseId");
		User user = this.getUser(request);
		if(this.getVisitedUser(request) != null)
			user = this.getVisitedUser(request);
		if(user != null){
			if(("/friendsPortlet.lp").equals(path)){
				int count = getChatService(request).getBuddyCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/myPicturePortlet.lp").equals(path)){
				int count = getUserService(request).getUserPictureCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/myMusicPortlet.lp").equals(path)){
				int count = getUserService(request).getUserMusicCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/myFilePortlet.lp").equals(path)){
				int count = getUserService(request).getUserFileCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/myMessagePortlet.lp").equals(path)){
				int count=this.getUserService(request).getNewMessageCountByUser(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/bulletinPortlet.lp").equals(path)){
				int count=this.getUserService(request).getUserBulletinCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/groupPortlet.lp").equals(path)){
				int count=this.getGroupService(request).getUserGroupCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/todoListPortlet.lp").equals(path)){
				int count = getUserService(request).getUserToDoCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}else if(("/myCommentsPortlet.lp").equals(path)){
				int count = getUserService(request).getUserCommentsCount(user.getId());
				if(count > 0) title = title+",("+count+")";
			}
		}
		return title;
	}
	public Object getPortletsByGroupTab(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String path = request.getContextPath();		
		String tabId = (String)request.getParameter("tabId");
		if(tabId == null) tabId = (String)request.getAttribute("tabId");
		StringBuffer resultBuffer = new StringBuffer();
		if(tabId != null){
			List<PortletObject> portletList = getPortalService(request).getPortletsByTab(Integer.parseInt(tabId));			
			if(portletList != null){
				Iterator<PortletObject> portlets = portletList.iterator();
				int i = 0;
				while(portlets.hasNext()){
					PortletObject p = portlets.next();	
					resultBuffer.append(p.getWindowSkin())
								.append(",")
								.append(p.getId())
								.append(",")
								.append(p.getColumn())
								.append(",\"")
								.append( p.getTitle())
								.append("\",\"")
								.append(p.getIcon())
								.append("\",\"")
								.append(p.getUrl())
								.append("\",\"")
								.append(p.getName())
								.append("\",\"")
								.append(path+p.getPath())
								.append("\",")
								.append(p.isSupportCloseable())
								.append(",")
								.append(p.isSupportRefreshMode())
								.append(",")
								.append(p.isSupportEditMode())
								.append(",")
								.append(p.isSupportHelpMode())
								.append(",")
								.append(p.isSupportConfigMode())
								.append(",")
								.append(p.isSupportMinimized())
								.append(",")
								.append(p.isSupportMaximized())
								.append(",")
								.append(p.isSupportAutoRefreshed())							
								.append(",")
								.append(p.isSupportRefreshAtClient())	
								.append(",")
								.append(p.getPeriodTime())
								.append(",")
								.append(p.isSupportJS())
								.append(",\"")
								.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
								.append("\",\"")
								.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
								.append("\",\"")
								.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
								.append("\",\"")
								.append((p.getTextColor()== null ? "" : p.getTextColor()))
								.append("\",\"")
								.append((p.getParameter()== null ? "" : p.getParameter()))
								.append("\",")
								.append(p.getWindowStatus())
								.append(",")
								.append(p.getMode())
								.append(",")
								.append(p.getTransparent())
								;
					if(i < portletList.size() - 1)
						resultBuffer.append(";");
					i++;
				}
			}
		}
	    return resultBuffer.toString();					
	}
	public Object getPortletsByStoreTab(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String path = request.getContextPath();		
		String tabId = (String)request.getParameter("tabId");
		if(tabId == null) tabId = (String)request.getAttribute("tabId");
		StringBuffer resultBuffer = new StringBuffer();
		if(tabId != null){
			List<PortletObject> portletList = getPortalService(request).getPortletsByTab(Integer.parseInt(tabId));			
			if(portletList != null){
				Iterator<PortletObject> portlets = portletList.iterator();
				int i = 0;
				while(portlets.hasNext()){
					PortletObject p = portlets.next();	
					resultBuffer.append(p.getWindowSkin())
								.append(",")
								.append(p.getId())
								.append(",")
								.append(p.getColumn())
								.append(",\"")
								.append( p.getTitle())
								.append("\",\"")
								.append(p.getIcon())
								.append("\",\"")
								.append(p.getUrl())
								.append("\",\"")
								.append(p.getName())
								.append("\",\"")
								.append(path+p.getPath())
								.append("\",")
								.append(p.isSupportCloseable())
								.append(",")
								.append(p.isSupportRefreshMode())
								.append(",")
								.append(p.isSupportEditMode())
								.append(",")
								.append(p.isSupportHelpMode())
								.append(",")
								.append(p.isSupportConfigMode())
								.append(",")
								.append(p.isSupportMinimized())
								.append(",")
								.append(p.isSupportMaximized())
								.append(",")
								.append(p.isSupportAutoRefreshed())							
								.append(",")
								.append(p.isSupportRefreshAtClient())	
								.append(",")
								.append(p.getPeriodTime())
								.append(",")
								.append(p.isSupportJS())
								.append(",\"")
								.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
								.append("\",\"")
								.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
								.append("\",\"")
								.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
								.append("\",\"")
								.append((p.getTextColor()== null ? "" : p.getTextColor()))
								.append("\",\"")
								.append((p.getParameter()== null ? "" : p.getParameter()))
								.append("\",")
								.append(p.getWindowStatus())
								.append(",")
								.append(p.getMode())
								.append(",")
								.append(p.getTransparent())
								;
					if(i < portletList.size() - 1)
						resultBuffer.append(";");
					i++;
				}
			}
		}
	    return resultBuffer.toString();					
	}
	public Object getScripts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return _JAVASCRIPT_LIBRARYS;
	}
	public Object changeMode(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		String responseId = (String)request.getParameter("responseId");		
		String title = request.getParameter("title");
		if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);				
		String barBgColor = request.getParameter("barBgColor");
		String barFontColor = request.getParameter("barFontColor");
		String contentBgColor = request.getParameter("contentBgColor");	
		String textColor = request.getParameter("textColor");	
		String transparent = request.getParameter("transparent");	
		String windowSkin = request.getParameter("windowSkin");	
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){
			portlet.setLabel(title);
			portlet.setBarBgColor(barBgColor);
			portlet.setBarFontColor(barFontColor);
			portlet.setContentBgColor(contentBgColor);
			portlet.setTextColor(textColor);
			portlet.setTransparent(Integer.parseInt(transparent));
			portlet.setWindowSkin(windowSkin);
			this.getPortalService(request).save(portlet);
		}
		return responseId;
	}
	public Object rememberState(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		if(this.getVisitedUser(request) == null){
			String state = request.getParameter("state");				
			PortletObject portlet = this.getPortlet(request);
			if(portlet != null && state != null){
				if(!_ROLE_GUEST.equals(this.getPortalService(request).getPortalTabById(portlet.getTabId()).getUserId())){										
					int s = Integer.parseInt(state);
					if(s == 0){
						portlet.setWindowStatus(s);
						this.getPortalService(request).save(portlet);
					}
					if(s == 1 && portlet.isSupportEditMode()){
						portlet.setWindowStatus(s);
						this.getPortalService(request).save(portlet);
					}
				}
			}
		}
		return null;
	}
	
	public Object rememberMode(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		if(this.getVisitedUser(request) == null){
			String mode = request.getParameter("mode");				
			PortletObject portlet = this.getPortlet(request);
			if(portlet != null && mode != null){
				if(!_ROLE_GUEST.equals(this.getPortalService(request).getPortalTabById(portlet.getTabId()).getUserId())){
					int m = Integer.parseInt(mode);
					if(m == 0){
						portlet.setMode(m);
						this.getPortalService(request).save(portlet);
					}
					if(m == 1 && portlet.isSupportEditMode()){
						portlet.setMode(m);
						this.getPortalService(request).save(portlet);
					}
				}
			}
		}
		return null;
	}
	
	public Object changeTitle (HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String title = request.getParameter("title");	
		 if(title != null){
			 if(this.getUser(request) != null){
				 Portal portal = this.getPortal(request);
				 portal.setTitle(title);
				 this.getPortalService(request).save(portal);
				 this.setPortal(request,portal);
			 }
				 
		 }
		 return null;
    }
	
	public Object changeLanguage(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String language = request.getParameter("language");
		String returnValue="0";
		if(language != null && this.setLocale(request,language)){
			if(this.getUser(request) != null ){				
				User user = this.getUser(request);
				if(user != null){
					user.setLanguage(language);
					this.getUserService(request).saveUser(user);
				}
				returnValue = "1";
			}
		}
		return returnValue;
	}
	
	public Object changeRegion (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String region = request.getParameter("region");
		String returnValue="0";
		User user = this.getUser(request);
		if(region != null && user != null){				
			user.setRegion(region);
			this.getUserService(request).saveUser(user);
			request.getSession().removeAttribute("defaultLists");
			returnValue = "1";
		}
		return returnValue;
	}
	
	public Object changeTimeZone (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String timeZone = request.getParameter("timeZone");
		String returnValue=request.getParameter("responseId");
		User user = this.getUser(request);
		if(timeZone != null && user != null){				
			user.setTimeZone(timeZone);
			this.getUserService(request).saveUser(user);

			request.getSession().removeAttribute("defaultLists");
			returnValue = "1";
		}
		return returnValue;
	}
	
	public Object changeGeneral (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		 String showSearchBar = request.getParameter("showSearchBar");
		 String headerHeight = request.getParameter("headerHeight");
		 String textFont = request.getParameter("textFont");
		 String fontSize = request.getParameter("fontSize");
		 String textColor = request.getParameter("textColor");
		 String transparent = request.getParameter("transparent");
		 String returnValue=request.getParameter("responseId");
		 String maxShowTabs=request.getParameter("maxShowTabs");
		 User user = this.getUser(request);
		 if(user != null){
			 Portal portal = this.getPortal(request);
			 if(isAdmin(request) && this.getVisitedPortal(request) !=null) portal = this.getVisitedPortal(request);
			 if(headerHeight != null && Integer.parseInt(headerHeight) != portal.getHeaderHeight()){
				 portal.setHeaderHeight(Integer.parseInt(headerHeight));				 
			 }
			 if(fontSize != null && Integer.parseInt(fontSize) != portal.getFontSize()){
				 portal.setFontSize(Integer.parseInt(fontSize));
			 }
			 portal.setTextFont(textFont); 
			 portal.setTextColor(textColor);
			 if(showSearchBar != null && "1".endsWith(showSearchBar))
				 portal.setShowSearchBar(1);
			 else
				 portal.setShowSearchBar(0);
			 if(transparent != null){				 
				 portal.setTransparent(Integer.parseInt(transparent));
			 }
			 if(!StringUtils.isEmpty(maxShowTabs))
				 portal.setMaxShowTabs(Integer.parseInt(maxShowTabs));
			 this.getPortalService(request).save(portal);
			 returnValue = "1";
		 }				 
		 return returnValue;
	}
		
	public Object changeTheme (HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String theme = request.getParameter("theme");	
		 String bgImage = request.getParameter("bgImage");
		 String bgRepeat = request.getParameter("bgRepeat");
		 String headerImage = request.getParameter("headerImage");
		 String headerRepeat = request.getParameter("headerRepeat");
		 String headerHeight = request.getParameter("headerHeight");
		 String transparent = request.getParameter("transparent");
		 int returnValue=1;
		 try{
			 if(theme != null){
				 request.getSession().setAttribute("theme",theme);
				 User user = this.getUser(request);
				 if(user != null){
					 Portal portal = this.getPortal(request);
					 if(isAdmin(request) && this.getVisitedPortal(request) !=null) portal = this.getVisitedPortal(request);
					 if(!theme.equals(portal.getTheme())){
						 portal.setTheme(theme);
					 }
					 if(bgImage != null && !bgImage.equals(portal.getBgImage())){
						 portal.setBgImage(bgImage);				 
					 }
					 if(bgRepeat != null && Integer.parseInt(bgRepeat) != portal.getBgRepeat() ){
						 portal.setBgRepeat(Integer.parseInt(bgRepeat));
					 }	
					 if(headerImage != null && !headerImage.equals(portal.getHeaderImage())){
						 portal.setHeaderImage(headerImage);					 
					 }
					 if(headerRepeat != null && Integer.parseInt(headerRepeat) != portal.getHeaderRepeat() ){
						 portal.setHeaderRepeat(Integer.parseInt(headerRepeat));				
					 }
					 if(headerHeight != null)
						 portal.setHeaderHeight(Integer.parseInt(headerHeight));
					 if(transparent != null){
						 portal.setTransparent(1);
					 }else{
						 portal.setTransparent(0);
					 }				 
					 this.getPortalService(request).save(portal);
				 }
					 
			 }
		 }catch(Exception e){
			 returnValue = 0;
			 throw e;
		 }
		 return returnValue;
    }
		
	
	public Object editTabTitle (HttpServletRequest request,	HttpServletResponse response) throws Exception{
		String title = request.getParameter("title");
		if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);
		PortalTab tab = getPortalTab(request);
		if(tab.getUserId().equals(this.getUser(request).getUserId())
				|| this.isAdmin(request)){
			tab.setLabel(title);
			this.getPortalService(request).save(tab);
		}
		return 1;
	}
	
	public Object manageTab (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		 String title = request.getParameter("title");
		 if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);
		 int columns = Integer.parseInt(request.getParameter("columns"));
		 String widths= request.getParameter("widths");			 
		 String close = request.getParameter("closeable");
		 int closeable = Integer.parseInt(close);
		 String defaultedStr = request.getParameter("defaulted");
		 int defaulted = Integer.parseInt(defaultedStr);
		 String statusStr = request.getParameter("status");
		 int status = Integer.parseInt(statusStr);
		 String fitScreenStr = request.getParameter("fitScreen");
		 int fitScreen = Integer.parseInt(fitScreenStr);
		 int between = Integer.parseInt(request.getParameter("between"));		 
		 String portletWindowType = request.getParameter("windowType");
		 if(portletWindowType ==null)
			 portletWindowType= "WindowAppearance2";
		 boolean resetWidths = false;
		 if(widths != null){
			 String[] widthArray = widths.split(",");
			 if(widthArray.length != columns)
				 resetWidths = true;				 
		 }else
			 resetWidths = true;	
		 int width = 1;
		 if(fitScreen == 0) width = 300;
		 if(resetWidths){
			 widths = "";
			 for(int i=0;i<columns;i++){
				 widths+=width+",";
			 }
			 widths = widths.substring(0,widths.length() - 1);
		 }
       PortalTab tab = getPortalTab(request);
       tab.setLabel(title);
       tab.setBetween(between);
       tab.setCloseable(closeable);
       tab.setDefaulted(defaulted);
       tab.setStatus(status);
       tab.setFitScreen(fitScreen);
       tab.setWidths(widths);
       tab.setPortletWindowType(portletWindowType);
       this.getPortalService(request).save(tab);
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append(tab.getId())
					.append("-")
					.append(tab.getTitle())
					.append("-")
					.append(tab.getUrl())
					.append("-")
					.append(tab.getCloseable())
					.append("-")							
					.append(tab.getColor())
					.append("-")
					.append(tab.getDefaulted())
					.append("-")
					.append(tab.getBetween())
					.append("-")
					.append(tab.getWidths())
					.append("-")
					.append(tab.getPortletWindowType())
					;
			
		return resultBuffer.toString();		
	}
	public Object addSubPage (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		 String tabId = request.getParameter("tabId");
		 int id = 0;
		 try{
			 id = Integer.parseInt(tabId);
		 }catch(Exception e){}
		 if(id > 0){
			 PortalTab tab = this.getPortalService(request).getPortalTabById(id);
			 PortalTab sub = new PortalTab(tab);
			 this.getPortalService(request).save(sub);
			 List<PortletObject> portlets = this.getPortalService(request).getPortletsByTab(tab.getId());
			 for(PortletObject portlet : portlets){
				 portlet.setTabId(sub.getId());
				 this.getPortalService(request).save(portlet);
			 }
		 }
		 return 1;
	}
	public Object editTab (HttpServletRequest request, HttpServletResponse response) throws Exception{		
		 String title = request.getParameter("title");
		 if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);
		 int columns = Integer.parseInt(request.getParameter("columns"));
		 String widths= "";
		 for(int i=0;i<columns;i++){
			if(i < columns - 1)
				widths+=request.getParameter("width"+i)+",";
			else
				widths+=request.getParameter("width"+i);
		 }			 
		 String close = request.getParameter("closeable");
		 int closeable = Integer.parseInt(close);
		 String defaultedStr = request.getParameter("defaulted");
		 int defaulted = Integer.parseInt(defaultedStr);
		 String statusStr = request.getParameter("status");
		 int status = Integer.parseInt(statusStr);
		 String fitScreenStr = request.getParameter("fitScreen");
		 int fitScreen = Integer.parseInt(fitScreenStr);
		 int between = Integer.parseInt(request.getParameter("between"));		 
		 String portletWindowType = request.getParameter("windowType");
		 if(portletWindowType ==null)
			 portletWindowType= "WindowAppearance2";
        PortalTab tab = getPortalTab(request);
        tab.setLabel(title);
        tab.setBetween(between);
        tab.setCloseable(closeable);
        tab.setDefaulted(defaulted);
        tab.setStatus(status);
        tab.setFitScreen(fitScreen);
        tab.setWidths(widths);
        tab.setPortletWindowType(portletWindowType);
        this.getPortalService(request).save(tab);
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append(tab.getId())
					.append("-")
					.append(tab.getTitle())
					.append("-")
					.append(tab.getUrl())
					.append("-")
					.append(tab.getCloseable())
					.append("-")							
					.append(tab.getColor())
					.append("-")
					.append(tab.getDefaulted())
					.append("-")
					.append(tab.getBetween())
					.append("-")
					.append(tab.getWidths())
					.append("-")
					.append(tab.getPortletWindowType())
					;
			
		return resultBuffer.toString();		
	}
	
	public Object addTab (HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String title = request.getParameter("title");
		 if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);		 
		 int columns = Integer.parseInt(request.getParameter("columns"));
		 String widths= "";
		 for(int i=0;i<columns;i++){
			if(i < columns - 1)
				widths+=request.getParameter("width"+i)+",";
			else
				widths+=request.getParameter("width"+i);
		 }			 
		 String close = request.getParameter("closeable");
		 int closeable = Integer.parseInt(close);
		 int editable = 1;
		 int moveable = 1;
		 int allowAddContent = 1;
		 if(isAdmin(request) && this.getVisitedPortal(request) != null){
			 closeable = 0;
			 editable = 0;
			 moveable = 0;
			 allowAddContent = 0;
		 }
		 String defaultedStr = request.getParameter("defaulted");
		 int defaulted = Integer.parseInt(defaultedStr);
		 int between = Integer.parseInt(request.getParameter("between"));
		 String portletWindowType = request.getParameter("windowType");
		 if(portletWindowType ==null)
			 portletWindowType= "WindowAppearance2";
		 int parentId = Integer.parseInt(request.getParameter("parentId"));
		 Portal portal = this.getPortal(request);
		 String userId = portal.getUserId();
		 if(this.getVisitedPage(request) != null) userId = this.getVisitedPage(request).getUserId();
		 PortalTab tab =new PortalTab(title,"",closeable,editable,moveable,allowAddContent,"",defaulted,between,widths,portletWindowType,userId,parentId);
		 this.getPortalService(request).save(tab);	 
		 if(tab.getWidths().indexOf(",") > 0)
			widths = "new Array("+tab.getWidths()+")";
		 else
			widths = "new Array("+tab.getWidths()+",0)";
		 List<PortalTab> tabList = null;
		 if(parentId > 0)
			 tabList = this.getPortalService(request).getPortalTabByParent(parentId);
		 else
			 tabList = this.getPortalService(request).getPortalTabByUser(this.getUser(request).getUserId());
		 int i = tabList.size() - 1;
		 StringBuffer resultBuffer = new StringBuffer();
		 resultBuffer.append("new LightPortalTab(")
			.append(i)
			.append(",\"tab_page").append(i)
			.append("\",")
			.append(tab.getId())
			.append(",\"")
			.append(tab.getTitle())
			.append("\",\"")
			.append(tab.getUrl())
			.append("\",")
			.append(isAdmin(request) ? true : tab.isTabCloseable())
			.append(",")
			.append(isAdmin(request) ? true : tab.isTabEditable())
			.append(",")
			.append(isAdmin(request) ? true : tab.isTabMoveable())
			.append(",")
			.append(isAdmin(request) ? true : tab.isTabAllowAddContent())							
			.append(",\"")							
			.append(tab.getColor())
			.append("\",")
			.append(tab.isTabDefaulted())
			.append(",")
			.append(tab.getBetween())
			.append(",")
			.append(widths)
			.append(",")
			.append(tab.getFitScreen())
			.append(",\"")
			.append(tab.getPortletWindowType())
			.append("\",")
			.append(tab.getParentId())
			.append(")")
			;
		return resultBuffer.toString();		
	}
	
	public Object addContent (HttpServletRequest request, HttpServletResponse response) throws Exception{	
		 String portletObjectRefName = request.getParameter("portletObjectRefName");
		 int column = Integer.parseInt(request.getParameter("column"));
		 PortletObjectRef pRef = this.getPortalService(request).getPortletRefByName(portletObjectRefName);
		 PortalTab tab = this.getPortalTab(request);
		 int row = this.getPortalService(request).getTabPortletsMaxRowByColoumn(tab.getId(),column - 1);
		 
		 PortletObject p = new PortletObject(tab.getId(), column - 1, row, pRef,tab.getUserId().equals(this.getUser(request).getUserId()),false);		
		 this.getPortalService(request).save(p);
		 boolean authorized =isAdmin(request);
		 StringBuffer resultBuffer = new StringBuffer();
		 resultBuffer.append(p.getId())
			.append(",")
			.append(column - 1)
			.append(",\"")
			.append(p.getTitle())
			.append("\",\"")
			.append(p.getIcon())
			.append("\",\"")
			.append(p.getUrl())
			.append("\",\"")
			.append(p.getName())
			.append("\",\"")
			.append(request.getContextPath()+p.getPath())
			.append("\",")
			.append(authorized ? true : p.isSupportCloseable())
			.append(",")
			.append(p.isSupportRefreshMode())
			.append(",")
			.append(authorized ? true : p.isSupportEditMode())
			.append(",")
			.append(authorized ? true : p.isSupportHelpMode())
			.append(",")
			.append(authorized ? true : p.isSupportConfigMode())
			.append(",")
			.append(p.isSupportMinimized())
			.append(",")
			.append(p.isSupportMaximized())
			.append(",")							
			.append(p.isSupportAutoRefreshed())							
			.append(",")
			.append(p.isSupportRefreshAtClient())							
			.append(",")
			.append(p.getPeriodTime())
			.append(",")
			.append(p.isSupportJS())
			.append(",\"")
			.append((p.getBarBgColor() == null ? "" : p.getBarBgColor()))
			.append("\",\"")
			.append((p.getBarFontColor() == null ? "" : p.getBarFontColor()))
			.append("\",\"")
			.append((p.getContentBgColor()== null ? "" : p.getContentBgColor()))
			.append("\",\"")
			.append((p.getTextColor()== null ? "" : p.getTextColor()))
			.append("\",\"")
			.append((p.getParameter()== null ? "" : p.getParameter()))
			.append("\",")
			.append(p.getWindowStatus())
			.append(",")
			.append(p.getMode())
			.append(",")
			.append(p.getTransparent())
			;
		 
		return resultBuffer.toString();		
	}
	
	public Object login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("password");	
		 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);		   	
		 if(password != null) password = URLDecoder.decode(password,_CHARSET_UTF);  
		 int result = this.getUserService(request).login(userId,password,OrganizationThreadLocal.getOrganizationId());
		 if(result == 1){
			 //String remoteAddress = request.getRemoteAddr();
			 //if(remoteAddress != null){
			 //	 this.getPortalService(request).save(new UserLogin(userId,remoteAddress));
			 //}
				 
			 Enumeration attributes=request.getSession().getAttributeNames();
			 while (attributes.hasMoreElements()){
	              String attribute = (String)attributes.nextElement();
	              if(!_VISITED_USER.equals(attribute)         	  
	            	  && !_VISITED_GROUP.equals(attribute) 
	            	  && !_VISITED_STORE.equals(attribute))
	            	  request.getSession().removeAttribute(attribute); 
			 }
			 User user = this.getUserService(request).getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
			 user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
			 this.getUserService(request).saveUser(user);
			 this.setUser(request ,user);			 
			 this.setLocale(request, user.getLanguage());
			 Chat chat = this.getChatService(request).getChatByUser(user.getId());
			 if(chat != null){
				 chat.setCurrentStatus(chat.getDefaultStatus());
				 this.getChatService(request).save(chat);
			 }
			 //search recommended news after user login
			 SearchRecommendedNewAction task = new SearchRecommendedNewAction(user,this.getPortalService(request));
			 task.start();
		 }else{
			 userId = String.valueOf(result);
		 }
		 
//		 StringBuffer resultBuffer = new StringBuffer();
//		 resultBuffer.append(userId);
//		 return resultBuffer.toString();
		 return String.valueOf(result);
	}
	
	public Object turnToMyAccount(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		request.getSession().setAttribute(_VISITED_USER,null);
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}
	
	public Object checkMyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String uri = request.getParameter("uri");
		 String id = request.getParameter("id");		 
		 User user = this.getUserService(request).getUserByUri(uri,OrganizationThreadLocal.getOrganizationId());
		 if(user != null)
			 id = "-1";
		 return id;	
	}
	
	public Object saveMyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String uri = request.getParameter("uri");
		 String id = request.getParameter("id");		 
		 User user = this.getUser(request);
		 user.setChosedUri(uri);
		 this.getUserService(request).saveUser(user);
		 return id;	
	}
	
	public Object logout(HttpServletRequest request, HttpServletResponse response) throws Exception{		 
		 Chat chat = this.getChatService(request).getChatByUser(this.getUser(request).getId());
		 if(chat != null){
			 chat.setCurrentStatus(ChatStatusRef.OFFLINE);
			 this.getChatService(request).save(chat);
		 }
		 this.getChatService(request).deleteChattingByUser(this.getUser(request).getId());
		 PortalTab page = this.getVisitedPage(request);
		 User user = this.getVisitedUser(request);
		 Group group = this.getVisitedGroup(request);
		 Locale locale = this.getLocale(request);
		 request.getSession().invalidate();
		 this.setLocale(request,locale.toString());
		 if(page != null) this.setVisitedPage(request, page);
		 if(user != null) this.setVisitedUser(request, user);
		 if(group != null) this.setVisitedGroup(request, group);
		 return null;	
	}
	
	public Object validateUserId(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String email = request.getParameter("email");	
		 String responseId = request.getParameter("responseId");
		 User user = this.getUserService(request).getUserByUserId(email,OrganizationThreadLocal.getOrganizationId());
		 if(user != null){			
			return responseId;			 
		 }			 
		 return 1;	
	}
	
	public Object validateMyUri(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String uri = request.getParameter("uri");	
		 String responseId = request.getParameter("responseId");
		 User user = this.getUserService(request).getUserByUri(uri,OrganizationThreadLocal.getOrganizationId());
		 if(user != null){			
			return responseId;			 
		 }			 
		 return 1;	
	}
	
	public Object signUp(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("password");
		 String displayName = request.getParameter("displayName");		 		
		 String email = request.getParameter("email");
		 String language = request.getParameter("language");
		 String region = language;
		 String timeZone=  request.getParameter("timeZone");
		 String chosedUri=  request.getParameter("chosedUri"); 
		 String birth = request.getParameter("birth");
		 String gender = request.getParameter("gender");
		 String country = request.getParameter("country");
		 String province = request.getParameter("province");
		 String city = request.getParameter("city");
		 String postalCode = request.getParameter("postalCode");
		 String channels = request.getParameter("channels");
		 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);		   	
		 if(password != null) password = URLDecoder.decode(password,_CHARSET_UTF);  
		 if(displayName != null) displayName = URLDecoder.decode(displayName,_CHARSET_UTF);		   	
		 if(email != null) email = URLDecoder.decode(email,_CHARSET_UTF);  
		 int showLocale = 0;		 
		 User newUser = new UserEntity(userId,password,displayName,email,birth,gender,language,region,timeZone,chosedUri,country,province,city,postalCode,OrganizationThreadLocal.getOrganizationId());
		 User user = this.getUserService(request).signUp(newUser,OrganizationThreadLocal.getOrganizationId());
		 if(user != null){			 			 
			 UserProfile userProfile = new UserProfile(user.getId());
			 this.getPortalService(request).save(userProfile);
			 Chat chat = new Chat(user.getId(),ChatStatusRef.ONLINE,ChatStatusRef.ONLINE);
			 this.getPortalService(request).save(chat);	
			 List<PortalUserRole> userRoles = this.getPortalService(request).getUserRole(user.getId(),_ROLE_USER);
			 if(userRoles == null || userRoles.size() == 0){
				PortalUserRole userRole1 = new PortalUserRole(user.getId(),_ROLE_USER);
			 	this.getPortalService(request).save(userRole1);	
				PortalUserRole userRole2 = new PortalUserRole(user.getId(),_ROLE_MEMBER);
				this.getPortalService(request).save(userRole2);		
				if(OrganizationThreadLocal.getOrg().getType() > 1){
					PortalUserRole userRole3 = new PortalUserRole(user.getId(),OrganizationThreadLocal.getOrg().getRole());
					this.getPortalService(request).save(userRole3);
				}
			 }
			 if(channels != null){
				 String[] channel = channels.split(",");
				 for(int i=0;i<channel.length;i++){
					 if(channel != null && !"".equals(channel)){
						 List<PortalUserRole> userChannels = this.getPortalService(request).getUserRole(user.getId(),channel[i]);
						 if(userChannels == null || userChannels.size() == 0){
							PortalUserRole userRole = new PortalUserRole(user.getId(),channel[i]);
							this.getPortalService(request).save(userRole);
						 } 
					 }
				 }
			 }
			 this.getPortalService(request).createPortalByUser(userId,displayName,showLocale,language,region);
			 this.setUser(request ,user);		
			 if(this.setLocale(request,language)){			
				Portal portal = this.getPortal(request);
				if(portal != null){ 
					this.setPortal(request,portal);
				}
			}
		 }else{
			 userId= "-1";
		 }
		 StringBuffer resultBuffer = new StringBuffer();
		 resultBuffer.append(userId);
		 return resultBuffer.toString();	
	}
	
	public Object profile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String password = request.getParameter("password");
		 String firstName = request.getParameter("firstName");
		 String middleName = request.getParameter("middleName");
		 String lastName = request.getParameter("lastName");
		 String email = request.getParameter("email");
		 String channels = request.getParameter("channels");
		 int showLocale = 0;
		 if(request.getParameter("showLocale") != null) showLocale = 1;
		 User user = this.getUser(request);
		 if(user != null){
//			 user.setFirstName(firstName);
//			 user.setMiddleName(middleName);
//			 user.setLastName(lastName);
			 user.setEmail(email);			 
			 user.setPassword(password);
			 this.getUserService(request).saveUser(user);	
			 
			 Portal portal = this.getPortal(request);
			 portal.setShowLocaleBar(showLocale);
			 this.getPortalService(request).save(portal);
			 this.setPortal(request,portal);
			 
			 List<PortalUserRole> userChannels = this.getPortalService(request).getUserChannel(user.getId());
			 if(userChannels != null){
				for(PortalUserRole ur : userChannels){
					this.getPortalService(request).delete(ur);
				}
			 }
			 if(channels != null){
				 String[] channel = channels.split(",");
				 for(int i=0;i<channel.length;i++){
					 if(channel != null && !"".equals(channel)){
						PortalUserRole userRole = new PortalUserRole(user.getId(),channel[i]);
						this.getPortalService(request).save(userRole);
					 } 
				 }
			 }	
			 return user.getUserId();
		 }else{
			 return "-1";	
		 }
	}
	
	public Object deletePortlet(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String portletId = request.getParameter("portletId");
		 if(portletId != null){
			 PortletObject portletObject = this.getPortalService(request).getPortletById(Integer.parseInt(portletId));	 
			 if(portletObject != null) this.getPortalService(request).delete(portletObject);
		 }
		 return null;	
	}
	
	public Object deleteTab(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String tabId = request.getParameter("tabId");
		 if(tabId != null){
			 PortalTab  tab = this.getPortalService(request).getPortalTabById(Integer.parseInt(tabId));
			 List<PortletObject> portletObjects = this.getPortalService(request).getPortletsByTab(Integer.parseInt(tabId));
			 for(PortletObject portletObject : portletObjects){
				 this.getPortalService(request).delete(portletObject);
			 }
			 this.getPortalService(request).delete(tab);
		 }
		 return null;	
	}
	
	public Object changePosition(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String responseId = request.getParameter("responseId");
		String portletId = request.getParameter("portletId");
		String column = request.getParameter("column");
		String row = request.getParameter("row");			
		PortletObject portlet =this.getPortalService(request).getPortletById(Integer.parseInt(portletId));		
		if(portlet != null){
			portlet.setColumn(Integer.parseInt(column));
			portlet.setRow(Integer.parseInt(row));			
			this.getPortalService(request).save(portlet);			
		}
		return null;	
	}
			
	public Object getRssDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{		 
		 String index = request.getParameter("index");
		 int indx = Integer.parseInt(index);
		 String feed = request.getParameter("feed");
		 if(feed != null) feed = URLDecoder.decode(feed,_CHARSET_UTF);
		 System.out.println(feed+": "+index) ;
		 StringBuilder desc= new StringBuilder();
		 List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
		 for(RssBean rss : lists){         
	         if(rss.getIndex() == indx){
	        	 desc.append(rss.getTitle())
	        	 	 .append("<br/>")
	        	 	 .append("<span class='portlet-note' style='margin-left:0px;'>")
	        	 	 .append(!StringUtils.isEmpty(rss.getAuthor()) ? MessageUtil.getMessage("portlet.label.postedBy",this.getLocale(request))+": "+rss.getAuthor()+" " : "")
	        	 	 .append(MessageUtil.getMessage("portlet.label.date",this.getLocale(request))+": "+rss.getDate())
	        	 	 .append("</span>")
	        	 	 .append("<br/><br/>")
	        	 	 .append(rss.getDesc())
	        	 	 ;
		        break;
	         }
        }
		 return desc.toString();
	}
	
	public Object getFeedbackDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String desc= null;
		 Feedback feedback = this.getUserService(request).getFeedbackById(id);
		 if(feedback != null) desc = feedback.getContent();
		 if(desc == null || desc.equals("")) desc="this feedback's content is unavaliable.";
		 return desc;	
	}
	
	public Object saveComment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String comment = request.getParameter("comment");		
		String responseId = request.getParameter("responseId");
		
		if(comment != null && comment.trim().length() > 0){
			User postBy = this.getUser(request);
			User user = this.getVisitedUser(request);
			if(user == null) user = this.getUser(request);

			UserComments c = new UserComments(user.getId(),postBy.getId(),comment);
			if(user.getCommentNeedApprove() == 1){
				this.getPortalService(request).save(c);
				Message message = new Message(
						  postBy.getDisplayName()+" add a new comment to you."
						 ,postBy.getDisplayName()+" add a new comment to you:<br/>"+c.getComments()
						 ,user.getId()
						 ,postBy.getId()
						 ,_MESSAGE_EVENT_COMMENT
						 ,_MESSAGE_EVENT_TYPE_REQUEST
						 ,c.getId());
				 this.getUserService(request).sendMessage(message);
			}else{
				c.setStatus(1);
				this.getPortalService(request).save(c);
			}			
		}
		return responseId;
	}
	public Object saveItemComment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String comment = request.getParameter("comment");	
		String itemId = request.getParameter("itemId");			
		String responseId = request.getParameter("responseId");
		User user = this.getUser(request);
		if(user != null && comment != null && comment.trim().length() > 0 && itemId != null){
			long postById = user.getId();		
			PopularItemComments c = new PopularItemComments(Long.parseLong(itemId),postById,comment);
			this.getPortalService(request).save(c);						
		}
		return responseId;
	}
	
	public Object configMyPicture(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String pictureId = request.getParameter("pictureId");	
		String name = request.getParameter("name");			
		String value = request.getParameter("value");
		//System.out.println(pictureId+name+value);
		String responseId = request.getParameter("responseId");
		if(pictureId != null){
			UserPicture pic =this.getUserService(request).getUserPictureById(Integer.parseInt(pictureId));
			if(name.startsWith("caption")) pic.setCaption(value);
			if(name.startsWith("tag")) pic.setTag(value);
			if(name.startsWith("status")) pic.setStatus(Integer.parseInt(value));
			this.getPortalService(request).save(pic);
			List<UserPicture> userPictures = (List<UserPicture>)request.getSession().getAttribute("myPictures");
		    if(userPictures != null)
		    {
		    	userPictures.remove(pic);
		    	userPictures.add(pic);
			    request.getSession().setAttribute("myPictures", userPictures);
		    }			
		}
		return responseId;
	}
	public Object uploadAllOpml(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			StringBuffer buffer = new  StringBuffer();
			ServletInputStream in = request.getInputStream();			
			int i;
			boolean added = false;
			while ((i = in.read()) != -1){
					buffer.append((char) i);
			}
			String text = buffer.toString();
			int index = text.indexOf("<?xml");
			int endIndex = text.indexOf("</opml>");
			if(endIndex <= 0) return false;
			String result = text.substring(index,endIndex + 7);

			Document document = DocumentHelper.parseText(result);
			List list1 = document.selectNodes( "//opml/body/outline" );
			for (Iterator iter = list1.iterator(); iter.hasNext(); ) {
				Node node = (Node) iter.next();
				String title = node.valueOf("@title");
	            String feed = node.valueOf("@xmlUrl");
	            String name = node.valueOf("@name");
	            String userId = node.valueOf("@userId");
	            String tag = node.valueOf("@tag");
	            String subTag = node.valueOf("@subTag");
	            String language = node.valueOf("@language");
				if(feed != null && feed.trim().length() > 0)
					addFeedFromOpml(request,title,feed,name,userId,tag,subTag,language);
			}
			List list = document.selectNodes( "//opml/body/outline/outline" );
	        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
				Node node = (Node) iter.next();
				String title = node.valueOf("@title");
	            String feed = node.valueOf("@xmlUrl");
	            String name = node.valueOf("@name");
	            String userId = node.valueOf("@userId");
	            String tag = node.valueOf("@tag");
	            String subTag = node.valueOf("@subTag");
	            String language = node.valueOf("@language");
				if(feed != null && feed.trim().length() > 0)
					addFeedFromOpml(request,title,feed,name,userId,tag,subTag,language);
	        }
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	private void addFeedFromOpml(HttpServletRequest request, String title, String feed,String name, String userId, String tag, String subTag, String language){
		if(feed != null && !"".equals(feed)){
			List<PortletObjectRef> refs = this.getPortalService(request).getFeedsByUrl(feed);
			if(refs != null && refs.size() > 0){
				for(PortletObjectRef ref : refs){
					if(ref.getTag() != null && ref.getTag().equals(tag)) return;
				}
			}
			String proxySet = request.getSession().getServletContext().getInitParameter("proxySet");
			if("true".equals(proxySet)){
				String proxyHost = request.getSession().getServletContext().getInitParameter("proxyHost");
				String proxyPort = request.getSession().getServletContext().getInitParameter("proxyPort");
				System.getProperties().put( "proxySet", proxySet );
				System.getProperties().put( "proxyHost", proxyHost );
				System.getProperties().put( "proxyPort", proxyPort );
			}
			try{
				Portal portal = this.getPortal(request);
				URL feedUrl = new URL(feed);
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed rss = input.build(new XmlReader(feedUrl));
			    String imageUrl="";
				String feedTitle = rss.getTitle();
				if(title != null && title.trim().length() > 0) feedTitle = title;
			    if(rss.getImage() != null && rss.getImage().getUrl() != null)
			    	imageUrl = rss.getImage().getUrl().toString();
			    String feedName = StringUtils.isEmpty(name) ? String.valueOf(System.currentTimeMillis()) : name;
			    PortletObjectRef ref = new PortletObjectRef(
				    							feedName
				    						   ,"/rssPortlet.lp"
				    						   ,feedTitle
				    						   ,imageUrl
											   ,rss.getLink()
											   ,subTag
				    						   ,tag
				    						   ,language
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,userId);
			    this.getPortalService(request).save(ref);
			
				List<PortletObjectRef> myFeedLists =(List<PortletObjectRef>)request.getSession().getAttribute("myFeedLists");
				if(myFeedLists != null){
					myFeedLists.add(ref);
					request.getSession().setAttribute("myFeedLists",myFeedLists);
				}
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("addFeedError",e.getMessage());
			}
		}
	}
	public Object uploadOpml(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			StringBuffer buffer = new  StringBuffer();
			ServletInputStream in = request.getInputStream();			
			int i;
			boolean added = false;
			while ((i = in.read()) != -1){
					buffer.append((char) i);
			}
			String text = buffer.toString();
			int index = text.indexOf("<?xml");
			int endIndex = text.indexOf("</opml>");
			if(endIndex <= 0) return false;
			String result = text.substring(index,endIndex + 7);

			Document document = DocumentHelper.parseText(result);
			List list1 = document.selectNodes( "//opml/body/outline" );
			for (Iterator iter = list1.iterator(); iter.hasNext(); ) {
				Node node = (Node) iter.next();
				String title = node.valueOf("@title");
	            String feed = node.valueOf("@xmlUrl");
				if(feed != null && feed.trim().length() > 0)
				   addMyFeedFromOpml(request,title,feed);
			}
			List list = document.selectNodes( "//opml/body/outline/outline" );
	        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
				Node node = (Node) iter.next();
				String title = node.valueOf("@title");
	            String feed = node.valueOf("@xmlUrl");
				if(feed != null && feed.trim().length() > 0)
					addMyFeedFromOpml(request,title,feed);
	        }
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	
	private void addMyFeedFromOpml(HttpServletRequest request, String title, String feed){
		if(feed != null && !"".equals(feed)){
			String proxySet = request.getSession().getServletContext().getInitParameter("proxySet");
			if("true".equals(proxySet)){
				String proxyHost = request.getSession().getServletContext().getInitParameter("proxyHost");
				String proxyPort = request.getSession().getServletContext().getInitParameter("proxyPort");
				System.getProperties().put( "proxySet", proxySet );
				System.getProperties().put( "proxyHost", proxyHost );
				System.getProperties().put( "proxyPort", proxyPort );
			}
			try{
				Portal portal = this.getPortal(request);
				URL feedUrl = new URL(feed);
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed rss = input.build(new XmlReader(feedUrl));
			    String imageUrl="";
				String feedTitle = rss.getTitle();
				if(title != null && title.trim().length() > 0) feedTitle = title;
			    if(rss.getImage() != null && rss.getImage().getUrl() != null)
			    	imageUrl = rss.getImage().getUrl().toString();
			    String feedName = String.valueOf(System.currentTimeMillis());
			    PortletObjectRef ref = new PortletObjectRef(
				    							feedName
				    						   ,"/rssPortlet.lp"
				    						   ,feedTitle
				    						   ,imageUrl
											   ,rss.getLink()
											   ,null
				    						   ,_MY_FEED
				    						   ,_LANGUAGE_ALL
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,this.getUser(request).getUserId());
			    this.getPortalService(request).save(ref);
			
				List<PortletObjectRef> myFeedLists =(List<PortletObjectRef>)request.getSession().getAttribute("myFeedLists");
				if(myFeedLists != null){
					myFeedLists.add(ref);
					request.getSession().setAttribute("myFeedLists",myFeedLists);
				}
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("addFeedError",e.getMessage());
			}
		}
	}
	private String getPath(long userId, String prefix){
		String separator = System.getProperty("file.separator");
		return _FILE_PATH+OrganizationThreadLocal.getOrganizationId()+separator+"user"+separator+userId+separator+prefix+separator;
	}	
	public Object uploadProfilePhoto(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();

			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes,"Cp1250");
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			String fileSaveName = saveFile;//String.valueOf(System.currentTimeMillis()) + saveFile.substring(saveFile.indexOf("."));
			String contentType = request.getContentType();
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;			
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes("Cp1250")).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes("Cp1250")).length;
			User user = getUser(request);
			
			String dirName = getPath(user.getId(),_MY_IMAGE_PATH);//_FILE_PATH+"/user/"+uri+"/images/";
//			String uri = user.getUri();
//			if(uri != null && uri.length() >0){
//				String firstLetter = uri.substring(0,1);			
//				dirName = _FILE_PATH+"/user/"+firstLetter+"/"+firstLetter+"/"+uri+"/images/";
//			}
//			if(uri != null && uri.length() >1){
//				String firstLetter = uri.substring(0,1);
//				String secondLetter = uri.substring(1,2);
//				dirName = _FILE_PATH+"/user/"+firstLetter+"/"+secondLetter+"/"+uri+"/images/";			
//			}
			(new File(dirName)).mkdirs();
			FileOutputStream fileOut = new FileOutputStream(new File(dirName+fileSaveName));
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			File from_file=new File(dirName+fileSaveName);
			java.awt.image.BufferedImage image=javax.imageio.ImageIO.read(from_file);
			int width = image.getWidth();
			int height= image.getHeight();
//			int newWidth = width;
//			int newHeight = height;
//			int rate = 9;
//			while(newWidth > 200){
//				newWidth = width * rate / 10;
//				newHeight= height * rate / 10;
//				rate--;
//			}
			//String photoUrl = "/user/"+user.getUri()+"/images/"+saveFile;
			String photoUrl = "/user/"+user.getId()+"/"+_MY_IMAGE_PATH+"/"+fileSaveName;//dirName.substring(dirName.indexOf("/user/"))+fileSaveName;
			user.setPhotoUrl(photoUrl);
			user.setCaption(null);
			user.setPhotoWidth(width);
			user.setPhotoHeight(height);
			this.getUserService(request).saveUser(user);
			this.setUser(request,user);
			UserPicture pic = new UserPicture(user.getId(),photoUrl,-1,width,height);
			this.getPortalService(request).save(pic);
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	public Object uploadMusics(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String upload = "SUCCESS\n";
		User user = getUser(request);
		if(user == null) return String.format("ERROR: %s\n","Please login first.");
		try{   
			doUploadMusic(request,response);
		}catch (Exception e){
			e.printStackTrace();
			upload = String.format("ERROR: %s\n",e.getMessage());
		}
		return upload;
		
	}
	public Object uploadMusic(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			doUploadMusic(request,response);
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	private void doUploadMusic(HttpServletRequest request, HttpServletResponse response) throws Exception{				 
		DataInputStream in = new DataInputStream(request.getInputStream());
		int formDataLength = request.getContentLength();

		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}
		String file = new String(dataBytes,"Cp1250");
		String fileName = new String(dataBytes,"UTF-8");
		String saveFile = fileName.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
		String fileSaveName = saveFile.replace("'","");//String.valueOf(System.currentTimeMillis()) + saveFile.substring(saveFile.indexOf("."));		
		String contentType = request.getContentType();
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,contentType.length());
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;			
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes("Cp1250")).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes("Cp1250")).length;
		User user = getUser(request);
		//String dirName = request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/user/"+user.getUri()+"/musics/";
		String dirName = getPath(user.getId(),_MY_MUSIC_PATH);//
//		String uri = user.getUri();
//		String dirName = _FILE_PATH+"/user/"+uri+"/musics/";
//		if(uri != null && uri.length() >0){
//			String firstLetter = uri.substring(0,1);			
//			dirName = _FILE_PATH+"/user/"+firstLetter+"/"+firstLetter+"/"+uri+"/musics/";
//		}
//		if(uri != null && uri.length() >1){
//			String firstLetter = uri.substring(0,1);
//			String secondLetter = uri.substring(1,2);
//			dirName = _FILE_PATH+"/user/"+firstLetter+"/"+secondLetter+"/"+uri+"/musics/";			
//		}
		(new File(dirName)).mkdirs();
		FileOutputStream fileOut = new FileOutputStream(new File(dirName+fileSaveName));
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();
		
		//String musicUrl = "/user/"+user.getUri()+"/musics/"+fileSaveName;
		String musicUrl = "/user/"+user.getId()+"/"+_MY_MUSIC_PATH+"/"+fileSaveName;//dirName.substring(dirName.indexOf("/user/"))+fileSaveName;
		int status = 0;			
		if(user != null) status = user.getDefaultMusicStatus();
		UserMusic music = new UserMusic(user.getId(),musicUrl,saveFile,status);			
		this.getPortalService(request).save(music);			
	}
	public Object uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();

			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes,"Cp1250");
			String fileName = new String(dataBytes,"UTF-8");
			String saveFile = fileName.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			String fileSaveName = saveFile;//String.valueOf(System.currentTimeMillis()) + saveFile.substring(saveFile.indexOf("."));		
			String contentType = request.getContentType();
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;			
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes("Cp1250")).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes("Cp1250")).length;
			User user = getUser(request);
			String dirName = getPath(user.getId(),_MY_FILE_PATH);
//			String uri = user.getUri();
//			//String dirName = request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/user/"+uri+"/files/";
//			String dirName = _FILE_PATH+"/user/"+uri+"/files/";
//			if(uri != null && uri.length() >0){
//				String firstLetter = uri.substring(0,1);			
//				dirName = _FILE_PATH+"/user/"+firstLetter+"/"+firstLetter+"/"+uri+"/files/";
//			}
//			if(uri != null && uri.length() >1){
//				String firstLetter = uri.substring(0,1);
//				String secondLetter = uri.substring(1,2);
//				dirName = _FILE_PATH+"/user/"+firstLetter+"/"+secondLetter+"/"+uri+"/files/";			
//			}
			(new File(dirName)).mkdirs();
			FileOutputStream fileOut = new FileOutputStream(new File(dirName+fileSaveName));
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			String fileUrl = "/user/"+user.getId()+"/"+_MY_FILE_PATH+"/"+fileSaveName;;//dirName.substring(dirName.indexOf("/user/"))+fileSaveName;
			int status = 0;			
			if(user != null) status = user.getDefaultMusicStatus();
			UserFile ufile = new UserFile(user.getId(),fileUrl,saveFile,status);			
			this.getPortalService(request).save(ufile);
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	public Object uploadPictures(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String upload = "SUCCESS\n";
		User user = getUser(request);
		if(user == null) return String.format("ERROR: %s\n","Please login first.");
		try{   
			doUploadPicture(request,response);
		}catch (Exception e){			
			e.printStackTrace();
			upload = String.format("ERROR: %s\n",e.getMessage());
		}
		return upload;
		
	}
	
	public Object uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			doUploadPicture(request,response);		
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	private void doUploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception{				
		DataInputStream in = new DataInputStream(request.getInputStream());
		int formDataLength = request.getContentLength();
		if(formDataLength < 0) return;
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}
		String file = new String(dataBytes,"Cp1250");
		String saveFile = file.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
		String fileSaveName = saveFile;//String.valueOf(System.currentTimeMillis()) + saveFile.substring(saveFile.indexOf("."));	
		String contentType = request.getContentType();
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,contentType.length());
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;			
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes("Cp1250")).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes("Cp1250")).length;
		User user = getUser(request);
		String dirName = getPath(user.getId(),_MY_IMAGE_PATH);
//		String uri = user.getUri();
//		//String dirName = request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/user/"+uri+"/images/";
//		String dirName = _FILE_PATH+"/user/"+uri+"/images/";
//		if(uri != null && uri.length() >0){
//			String firstLetter = uri.substring(0,1);			
//			dirName = _FILE_PATH+"/user/"+firstLetter+"/"+firstLetter+"/"+uri+"/images/";
//		}
//		if(uri != null && uri.length() >1){
//			String firstLetter = uri.substring(0,1);
//			String secondLetter = uri.substring(1,2);
//			dirName = _FILE_PATH+"/user/"+firstLetter+"/"+secondLetter+"/"+uri+"/images/";			
//		}
		(new File(dirName)).mkdirs();
		FileOutputStream fileOut = new FileOutputStream(new File(dirName+fileSaveName));
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();
		
		File from_file=new File(dirName+fileSaveName);
		java.awt.image.BufferedImage image=javax.imageio.ImageIO.read(from_file);
		int width = image.getWidth();
		int height= image.getHeight();
		Date takenDate = null;
		try{
			Metadata metadata = JpegMetadataReader.readMetadata(from_file);
			Iterator directories = metadata.getDirectoryIterator(); 
			while (directories.hasNext()) { 
				Directory directory = (Directory)directories.next(); 
				//36867 corresponds to the Date Taken
				takenDate = directory.getDate(36867);
			    if(takenDate != null) break;
			}
		}catch(Exception e){
			//ignore reading image meta data exception
		}
		String photoUrl = "/user/"+user.getId()+"/"+_MY_IMAGE_PATH+"/"+fileSaveName;
		int status = 0;			
		if(user != null) status = user.getDefaultMusicStatus();
		UserPicture picture = new UserPicture(user.getId(),photoUrl,status,width,height,takenDate);			
		this.getPortalService(request).save(picture);
		List<UserPicture> userPictures = (List<UserPicture>)request.getSession().getAttribute("myPictures");
	    if(userPictures != null)
	    {
	    	userPictures.add(picture);
		    request.getSession().setAttribute("myPictures", userPictures);
	    }			
	}
	public Object uploadGroupPicture(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		boolean upload = true;
		try{   
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			if(formDataLength < 0) return false;
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes,"Cp1250");
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			String fileSaveName = saveFile;//String.valueOf(System.currentTimeMillis()) + saveFile.substring(saveFile.indexOf("."));
			String contentType = request.getContentType();
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;			
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes("Cp1250")).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes("Cp1250")).length;
			Group group = getVisitedGroup(request);
			if(group == null) return 0;
			//String dirName = request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/grp/"+group.getUri()+"/images/";
			String uri = group.getUri();
			String dirName = _FILE_PATH+"/grp/"+uri+"/images/";
			if(uri != null && uri.length() >0){
				String firstLetter = uri.substring(0,1);			
				dirName = _FILE_PATH+"/grp/"+firstLetter+"/"+firstLetter+"/"+uri+"/images/";
			}
			if(uri != null && uri.length() >1){
				String firstLetter = uri.substring(0,1);
				String secondLetter = uri.substring(1,2);
				dirName = _FILE_PATH+"/grp/"+firstLetter+"/"+secondLetter+"/"+uri+"/images/";			
			}
			(new File(dirName)).mkdirs();
			FileOutputStream fileOut = new FileOutputStream(new File(dirName+fileSaveName));
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			File from_file=new File(dirName+fileSaveName);
			java.awt.image.BufferedImage image=javax.imageio.ImageIO.read(from_file);
			int width = image.getWidth();
			int height= image.getHeight();
//			int newWidth = width;
//			int newHeight = height;
//			int rate = 9;
//			while(newWidth > 200){
//				newWidth = width * rate / 10;
//				newHeight= height * rate / 10;
//				rate--;
//			}
			//String photoUrl = "/grp/"+group.getUri()+"/images/"+saveFile;
			String photoUrl = dirName.substring(dirName.indexOf("/grp/"))+fileSaveName;			
			GroupPicture picture = new GroupPicture(group.getId(),photoUrl,width,height,this.getUser(request).getId());			
			this.getPortalService(request).save(picture);
			List<GroupPicture> groupPictures = (List<GroupPicture>)request.getSession().getAttribute("groupPictures");
		    if(groupPictures != null)
		    {
		    	groupPictures.add(picture);
			    request.getSession().setAttribute("groupPictures", groupPictures);
		    }		    
		}catch (Exception e){
			e.printStackTrace();
			upload = false;
		}
		return upload;
		
	}
	
	public Object getTodoDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String desc= null;
		 ToDoBean todo = this.getUserService(request).getToDoById(id);
		 if(todo != null) desc = todo.getDescription();
		 if(desc == null || desc.equals("")) desc="this To Do's discription is unavaliable.";
		 return desc;	
	}
	
	public Object saveNote(HttpServletRequest request, HttpServletResponse
			response) throws Exception{
       String content = request.getParameter("content");
       if(content != null){
           content = URLDecoder.decode(content,_CHARSET_UTF);
       }
       Note note = this.getUserService(request).getNoteByUser(this.getUser(request).getId());
       if(note != null){
           note.setContent(content);
           this.getPortalService(request).save(note);
       }
       return null;
   }
	
	public Object trackRssItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int indx = Integer.parseInt(index);
        String feed = request.getParameter("feed");
        String link = feed;
        String title = null;
        String desc= null;
        PortletObject po= this.getPortlet(request);
        if(po != null){ 	        	  
        	 String parameter = po.getParameter();
        	 int ind = parameter.indexOf("=");
     		 feed = parameter.substring(ind + 1);
        }
        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
        for(RssBean rss : lists){         
	         if(rss.getIndex() == indx){
	        	 title = rss.getTitle();
	        	 desc = rss.getDesc();
	        	 if(rss.getLink() != null) link = rss.getLink();
	        	 break;
	         }    
        }        
//        List<RssBean> lists=(List<RssBean>)request.getSession().getAttribute(feed);
//        if(lists == null){
//            try{
//               URL feedUrl = new URL(feed);
//               SyndFeedInput input = new SyndFeedInput();
//               SyndFeed rss = input.build(new XmlReader(feedUrl));
//               Collection items = rss.getEntries();
//               if(items != null && !items.isEmpty()){
//                   int number =0;
//                   for(Iterator i = items.iterator(); i.hasNext(); ){
//                       SyndEntry item = (SyndEntry)i.next();
//
//                       if(number == indx){
//                           if(item.getLink() != null) link =item.getLink();
//                           title = item.getTitle();
//                           desc = item.getDescription().getValue();
//                           break;
//                       }
//                       number++;
//                   }
//               }
//            }catch(Exception e){
//                
//            }
//        }else{
//            RssBean rssBean = lists.get(indx);
//            if(rssBean.getLink() != null) link = rssBean.getLink();
//            title = rssBean.getTitle();
//            desc = rssBean.getDesc();
//        }
        if(title != null && this.getUser(request) != null){        			
        	ViewedItem item= this.getPortalService(request).getViewedItemByLink(link);
            if(item == null){
            	String tag = "portlet.tag.title.news";
            	String locale = "en";
	            if(po != null){ 	        	  
	        	  PortletObjectRef ref=this.getPortalService(request).getPortletRefByName(po.getName());
	        	  tag = ref.getTag();
	        	  locale = ref.getLanguage();
	            }
                item = new ViewedItem(link,title,desc,tag,locale);                
            }else
                item.popIt();
            this.getPortalService(request).save(item);
            ViewedItemUser user = this.getPortalService(request).getViewedItemUser(item.getId(),this.getUser(request).getId());
            if(user == null){
            	user = new ViewedItemUser(item.getId(),this.getUser(request).getId());
            }else{
            	user.popIt();
            }
            this.getPortalService(request).save(user);
            
            trackUserKeywords(request,title);            
        }
        return 1;
   }
	
	private void trackUserKeywords(HttpServletRequest request, String title){
		if(this.getUser(request) != null && this.getUser(request).getGrowKeyword() == 1){
			String[] keywords = title.split(" ");
	        for(int i=0;i<keywords.length;i++){
	        	String keyword = keywords[i].trim();
	        	if(keyword.length() > 0){
		        	keyword = keepWordOnly(keyword,request);		        	
		        	if(this.getPortalService(request).isKeyword(keyword)){
		        		UserKeyword userKeyword = this.getPortalService(request).getUserKeyword(keyword,this.getUser(request).getId());
		                if(userKeyword == null){
		                	userKeyword = new UserKeyword(keyword,this.getUser(request).getId());                    	
		                }else{
		                	userKeyword.weighIt();
		                }
		                this.getPortalService(request).save(userKeyword);
		        	}
	        	}
	        }
		}
	}
	
	public Object readPopItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String itemId = request.getParameter("itemId");
        if(itemId != null){
	        int id = Integer.parseInt(itemId);
	        PopularItem item = this.getPortalService(request).getPopularItemById(id);
	        if(item != null && this.getUser(request) != null){	        	
	        	ViewedItem vitem= this.getPortalService(request).getViewedItemByLink(item.getLink());
	            if(vitem == null){
	                vitem = new ViewedItem(item.getLink(),item.getTitle(),item.getDesc(),item.getTag(),item.getLocale());                
	            }else
	                vitem.popIt();
	            this.getPortalService(request).save(vitem);
	            ViewedItemUser user = this.getPortalService(request).getViewedItemUser(vitem.getId(),this.getUser(request).getId());
	            if(user == null){
	            	user = new ViewedItemUser(vitem.getId(),this.getUser(request).getId());
	            }else{
	            	user.popIt();
	            }
	            this.getPortalService(request).save(user);
	            
	            trackUserKeywords(request,item.getTitle());    
	        }
        }
        return 1;
	}
	public Object readViewedItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String itemId = request.getParameter("itemId");
        if(itemId != null){
	        int id = Integer.parseInt(itemId);
	        ViewedItem item = this.getPortalService(request).getViewedItemById(id);
	        if(item != null && this.getUser(request) != null){	 
	            ViewedItemUser user = this.getPortalService(request).getViewedItemUser(item.getId(),this.getUser(request).getId());
	            if(user == null){
	            	user = new ViewedItemUser(item.getId(),this.getUser(request).getId());
	            }else{
	            	user.popIt();
	            }
	            this.getPortalService(request).save(user);
	            
	            trackUserKeywords(request,item.getTitle());   
	        }
        }
        return 1;
	}
	public Object readRecommendedItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String itemId = request.getParameter("itemId");
        if(itemId != null){
	        int id = Integer.parseInt(itemId);
	        RecommendedItem item = this.getPortalService(request).getRecommendedItemById(id);
	        if(item != null){
	        	if(this.getUser(request) != null){
		        	item.setRead(1);
		        	this.getPortalService(request).save(item);
		        }
	        	if(this.getUser(request) != null){
		        	ViewedItem vitem= this.getPortalService(request).getViewedItemByLink(item.getLink());
		            if(vitem == null){
		            	String tag = "portlet.title.recommendedItem";
		            	String locale = "en";
		            	if(this.getUser(request) != null) locale = this.getUser(request).getLanguage();
		                vitem = new ViewedItem(item.getLink(),item.getTitle(),item.getDesc(),tag,locale);                
		            }else
		                vitem.popIt();
		            this.getPortalService(request).save(vitem);
		            ViewedItemUser user = this.getPortalService(request).getViewedItemUser(vitem.getId(),this.getUser(request).getId());
		            if(user == null){
		            	user = new ViewedItemUser(vitem.getId(),this.getUser(request).getId());
		            }else{
		            	user.popIt();
		            }
		            this.getPortalService(request).save(user);
		            
		            trackUserKeywords(request,item.getTitle());   
	        	}
	        }
        }
        return 1;
	}
	private String keepWordOnly(String keyword,HttpServletRequest request){
		if(keyword.startsWith("(")) keyword = keyword.substring(1,keyword.length());
		if(keyword.endsWith(")")) keyword = keyword.substring(0,keyword.length() - 1);
		List<NotWord> notWords= this.getPortalService(request).getNotWords();
		for(NotWord notWord : notWords){
			if(keyword.endsWith(notWord.getWord()) || keyword.startsWith(notWord.getWord())) keyword= keyword.replaceAll(notWord.getWord(),"");
		}
		return keyword;
	}
	public Object popRssItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int indx = Integer.parseInt(index);
        String feed = request.getParameter("feed");
        String link = feed;
        String title = null;
        String desc= null;
        PortletObject po= this.getPortlet(request);
        if(po != null){ 	        	  
        	 String parameter = po.getParameter();
        	 int ind = parameter.indexOf("=");
     		 feed = parameter.substring(ind + 1);
        }
        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
        for(RssBean rss : lists){         
	         if(rss.getIndex() == indx){
	        	 title = rss.getTitle();
	        	 desc = rss.getDesc();
	        	 if(rss.getLink() != null) link = rss.getLink();
	        	 break;
	         }    
       }
        if(title != null){
            PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),link);
            if(item == null){
               String tag = "portlet.tag.title.news";
               String locale = "en"; 	          
 	           if(po != null){ 	        	  
 	        	  PortletObjectRef ref=this.getPortalService(request).getPortletRefByName(po.getName());
 	        	  tag = ref.getTag();
 	        	  locale = ref.getLanguage();
 	           }
               item = new PopularItem(link,title,desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
            }else
                item.popIt();
            this.getPortalService(request).save(item);
        }
        return request.getParameter("responseId");
   }
	
	public Object popDeliItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String index = request.getParameter("index");
        int id = Integer.parseInt(index);
		List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getSession().getAttribute("deliciousTags");
		List<Bookmark> delicious= (List<Bookmark>)request.getSession().getAttribute("delicious");
		String name=null;
		String desc=null;
		String url = null;
		String tagName = null;
		for(BookmarkTag tag : deliciousTags){
			for(Bookmark bm : tag.getBookmarks()){
	            if(bm.getId() == id){
	                name = bm.getName();
					url = bm.getUrl();
					desc = bm.getDesc();
					tagName = bm.getTagName();
	                break;
	            }
			}
        }
		if(name == null){
			for(Bookmark bm : delicious){
				if(bm.getId() == id){
	                name = bm.getName();
					desc = bm.getDesc();
					url = bm.getUrl();
					tagName = bm.getTagName();
	                break;
	            }
			}
		}
		if(name != null){
            PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),url);
            if(item == null){
               String tag = "portlet.title.delicious";
               String locale = this.getUser(request).getRegion();   	          
               item = new PopularItem(url,name,desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
            }else
                item.popIt();
            this.getPortalService(request).save(item);
        }
        return request.getParameter("responseId");
   }
	
	public Object popBookmarkItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        Bookmark bookmark = this.getUserService(request).getBookmarkById(id);
		if(bookmark != null){
			String desc = bookmark.getDesc();
            PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),bookmark.getUrl());
            if(item == null){
            	String tag = "portlet.title.bookmark";
                String locale = this.getUser(request).getRegion();   	
                item = new PopularItem(bookmark.getUrl(),bookmark.getName(),desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
            }else
                item.popIt();
            this.getPortalService(request).save(item);
        }
        return request.getParameter("responseId");
   }
	
	public Object popYouTubeItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        List<VideoBean> videos =(List<VideoBean>)request.getSession().getAttribute("youTubes");        
		if(videos != null){
			for(VideoBean video : videos){
				if(video.getId().equals(id)){
					PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),video.getVideoUrl());
					if(item == null){
						String tag = "YouTube";
			            String locale = this.getUser(request).getRegion();   	
						String desc = video.getDesc()+"<br/><img src='"+video.getPicUrl()+"' style='border: 0px;' />";
		                item = new PopularItem(video.getVideoUrl(),video.getTitle(),desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
					}else
		                item.popIt();
					this.getPortalService(request).save(item);
					break;
				}
			}           

        }
        return request.getParameter("responseId");
   }
	public Object forwardRssToFriend(HttpServletRequest request,
		HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int indx = Integer.parseInt(index);
        String feed = request.getParameter("feed");
        String link = feed;
        String title = null;
        String desc= null;
        PortletObject po= this.getPortlet(request);
        if(po != null){ 	        	  
        	 String parameter = po.getParameter();
        	 int ind = parameter.indexOf("=");
     		 feed = parameter.substring(ind + 1);
        }
        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
        for(RssBean rss : lists){         
	         if(rss.getIndex() == indx){
	        	 title = rss.getTitle();
	        	 desc = rss.getDesc();
	        	 if(rss.getLink() != null) link = rss.getLink();
	        	 break;
	         }    
       }
//        List<RssBean> lists=(List<RssBean>)request.getSession().getAttribute(feed);
//        if(lists == null){
//            try{
//               URL feedUrl = new URL(feed);
//               SyndFeedInput input = new SyndFeedInput();
//               SyndFeed rss = input.build(new XmlReader(feedUrl));
//               Collection items = rss.getEntries();
//               if(items != null && !items.isEmpty()){
//                   int number =0;
//                   for(Iterator i = items.iterator(); i.hasNext(); ){
//                       SyndEntry item = (SyndEntry)i.next();
//
//                       if(number == indx){
//                           if(item.getLink() != null) link = item.getLink();
//                           title = item.getTitle();
//                           desc = item.getDescription().getValue();
//                           break;
//                       }
//                       number++;
//                   }
//               }
//            }catch(Exception e){
//            }
//        }else{
//            RssBean rssBean = lists.get(indx);
//            if(rssBean.getLink() != null) link = rssBean.getLink();
//            title = rssBean.getTitle();
//            desc = rssBean.getDesc();
//        }
        if(title != null){
           User user = this.getUser(request);
           if(user != null){
               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
               for(Connection friend : userFriends){
                   Message message = new Message(
                		   user.getDisplayName()+" send you a news link.",
                           "<a href='"+link+"' target='_blank'>"+title+"</a><br/><br/>"+desc
                           ,friend.getBuddyUserId()
                           ,user.getId());
                   this.getUserService(request).sendMessage(message);
               }
           }
        }
        return request.getParameter("responseId");
   }
	
	public Object forwardDeliToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String index = request.getParameter("index");
        int id = Integer.parseInt(index);
		List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getSession().getAttribute("deliciousTags");
		List<Bookmark> delicious= (List<Bookmark>)request.getSession().getAttribute("delicious");
		String name=null;
		String desc=null;
		String url=null;
		for(BookmarkTag tag : deliciousTags){
			for(Bookmark bm : tag.getBookmarks()){
	            if(bm.getId() == id){
	                name = bm.getName();
					desc = bm.getDesc();
					url = bm.getUrl();
	                break;
	            }
			}
        }
		if(name == null){
			for(Bookmark bm : delicious){
				if(bm.getId() == id){
	                name = bm.getName();
					desc = bm.getDesc();
					url = bm.getUrl();
	                break;
	            }
			}
		}
		if(name != null){
			if(desc == null) desc="";
			User user = this.getUser(request);
	           if(user != null){
	               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
	               for(Connection friend : userFriends){
	                   Message message = new Message(user.getDisplayName()+" send you a news link.",
	                           "<a href='"+url+"' target='_blank'>"+name+"</a><br/><br/>"+desc
	                           ,friend.getBuddyUserId()
	                           ,user.getId());
	                   this.getUserService(request).sendMessage(message);
	               }
	           }
        }
        return request.getParameter("responseId");
   }
	
	public Object forwardBookmarkToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        Bookmark bookmark = this.getUserService(request).getBookmarkById(id);
		if(bookmark != null){
		   String desc = bookmark.getDesc();
		   if(desc == null) desc="";
		   User user = this.getUser(request);
           if(user != null){
               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
               for(Connection friend : userFriends){
                   Message message = new Message(user.getDisplayName()+" send you a link.",
                           "<a href='"+bookmark.getUrl()+"' target='_blank'>"+bookmark.getName()+"</a><br/><br/>"+desc
                           ,friend.getBuddyUserId()
                           ,user.getId());
                   this.getUserService(request).sendMessage(message);
               }
           }
        }
        return request.getParameter("responseId");
   }
	
	public Object forwardYouTubeToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        List<VideoBean> videos =(List<VideoBean>)request.getSession().getAttribute("youTubes");        
		if(videos != null){
			for(VideoBean video : videos){
				if(video.getId().equals(id)){
				   User user = this.getUser(request);
		           if(user != null){
		               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
		               for(Connection friend : userFriends){
		                   Message message = new Message(user.getDisplayName()+" send you a link.",
		                		   video.getTitle()+"<br><a href='"+video.getVideoUrl()+"' target='_blank'><img src='"+video.getPicUrl()+"' style='border: 0px;' title='"+video.getDesc()+"' /></a><br/><br/>"
		                		   ,friend.getBuddyUserId()
		                		   ,user.getId());
		                   this.getUserService(request).sendMessage(message);
		               }
		           }
					break;
				}
			}           

        }
        return request.getParameter("responseId");
   }
	
	public Object saveYouTubeToBookmark(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        List<VideoBean> videos =(List<VideoBean>)request.getSession().getAttribute("youTubes");        
		if(videos != null){
			for(VideoBean video : videos){
				if(video.getId().equals(id)){
					String desc = video.getDesc()+"<br/><img src='"+video.getPicUrl()+"' style='border: 0px;' />";	                
					 Bookmark bookmark = new Bookmark(video.getTitle(),video.getVideoUrl(),video.getTags(),video.getTags(),desc,this.getUser(request).getId());
			         this.getPortalService(request).save(bookmark);
			         request.getSession().removeAttribute("bookmarkTags");
 				     request.getSession().removeAttribute("defaultBookmarks");	
					break;
				}
			}           

        }
        return request.getParameter("responseId");
   }
	
	public Object saveToHeader(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	        String index = request.getParameter("index");
	        int indx = Integer.parseInt(index);
	        String feed = request.getParameter("feed");
	        String desc= null;
	        PortletObject po= this.getPortlet(request);
	        if(po != null){ 	        	  
	        	 String parameter = po.getParameter();
	        	 int ind = parameter.indexOf("=");
	     		 feed = parameter.substring(ind + 1);
	        }
	        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	        for(RssBean rss : lists){         
		         if(rss.getIndex() == indx){
		        	 desc = rss.getDesc();
		        	 break;
		         }    
	        }
	        String value = request.getParameter("responseId");
	        if(desc != null){
	        	if(desc.indexOf("img") > 0){
	        		String temp = desc.substring(desc.indexOf("img"));
	        		if(temp.indexOf("http") > 0){
	        			temp = temp.substring(temp.indexOf("http"));
	        			temp = temp.substring(0,temp.indexOf("\""));
	        			if(this.getPortal(request) != null){
	        				Portal portal = this.getPortal(request);
	        				portal.setHeaderImage(temp);
	        				this.getPortalService(request).save(portal);
	        				value= temp;
	        			}
	        		}
	        	}
	        }
	        return  value;
	}
	
	public Object saveToBackground(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	        String index = request.getParameter("index");
	        int indx = Integer.parseInt(index);
	        String feed = request.getParameter("feed");
	        String desc= null;
	        PortletObject po= this.getPortlet(request);
	        if(po != null){ 	        	  
	        	 String parameter = po.getParameter();
	        	 int ind = parameter.indexOf("=");
	     		 feed = parameter.substring(ind + 1);
	        }
	        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	        for(RssBean rss : lists){         
		         if(rss.getIndex() == indx){
		        	 desc = rss.getDesc();
		        	 break;
		         }    
	        }
	        String value = request.getParameter("responseId");
	        if(desc != null){
	        	if(desc.indexOf("img") > 0){
	        		String temp = desc.substring(desc.indexOf("img"));
	        		if(temp.indexOf("http") > 0){
	        			temp = temp.substring(temp.indexOf("http"));
	        			temp = temp.substring(0,temp.indexOf("\""));
	        			if(this.getPortal(request) != null){
	        				Portal portal = this.getPortal(request);
	        				portal.setBgImage(temp);
	        				portal.setBgRepeat(0);
	        				this.getPortalService(request).save(portal);
	        				value= temp;
	        			}
	        		}
	        	}
	        }
	        return  value;
	}
	
	public Object saveToBookmark(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	        String index = request.getParameter("index");
	        int indx = Integer.parseInt(index);
	        String feed = request.getParameter("feed");
	        String link = feed;
	        String title = null;
	        String desc= null;
	        PortletObject po= this.getPortlet(request);
	        if(po != null){ 	        	  
	        	 String parameter = po.getParameter();
	        	 int ind = parameter.indexOf("=");
	     		 feed = parameter.substring(ind + 1);
	        }
	        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	        for(RssBean rss : lists){         
		         if(rss.getIndex() == indx){
		        	 title = rss.getTitle();
		        	 desc = rss.getDesc();
		        	 if(rss.getLink() != null) link = rss.getLink();
		        	 break;
		         }    
	        }
	        if(desc == null) desc="news description is unavaliable.";
	        if(title != null){
	           String tag = "portlet.tag.title.news";	           
	           if(po != null)
	        	   tag = po.getLabel();
	           Bookmark bookmark = new Bookmark(title,link,tag,tag,desc,this.getUser(request).getId());
	           this.getPortalService(request).save(bookmark);
	           request.getSession().removeAttribute("bookmarkTags");
			   request.getSession().removeAttribute("defaultBookmarks");			   
	        }
	        return request.getParameter("responseId");
	   }
	
	public Object saveToMyPicture(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	        String index = request.getParameter("index");
	        int indx = Integer.parseInt(index);
	        String feed = request.getParameter("feed");
	        String link = feed;
	        String title = null;
	        String desc= null;
	        PortletObject po= this.getPortlet(request);
	        if(po != null){ 	        	  
	        	 String parameter = po.getParameter();
	        	 int ind = parameter.indexOf("=");
	     		 feed = parameter.substring(ind + 1);
	        }
	        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	        for(RssBean rss : lists){         
		         if(rss.getIndex() == indx){
		        	 title = rss.getTitle();
		        	 desc = rss.getDesc();
		        	 if(rss.getLink() != null) link = rss.getLink();
		        	 break;
		         }    
	        }
	        if(title != null){
	        	User user = this.getUser(request);
     			if(user != null){
     				int i = desc.indexOf("<img");
     				String img = desc.substring(i);
     				i = img.indexOf("src=");
     				img = img.substring(i+5);
     				i =img.indexOf("\"");
     				String image = img.substring(0,i);     				
	    			int width = 300;
	    			int height= 280;
	    			i = img.indexOf("width");
	    			if( i > 0){
	    				String wid = img.substring(i+7);
	    				i = wid.indexOf("\"");
	    				width = Integer.parseInt(wid.substring(0, i));
	    			}
	    			i = img.indexOf("height");
	    			if( i > 0){
	    				String wid = img.substring(i+8);
	    				i = wid.indexOf("\"");
	    				height = Integer.parseInt(wid.substring(0, i));
	    			}
	    			int status = user.getDefaultPictureStatus();
	    			UserPicture picture = new UserPicture(user.getId(),image,status,width,height,title);			
	    			this.getPortalService(request).save(picture);	
	    			List<UserPicture> userPictures = (List<UserPicture>)request.getSession().getAttribute("myPictures");
	    		    if(userPictures == null)
	    		    {
	    		    	userPictures= new ArrayList<UserPicture>();
	    		    }
	    			userPictures.add(picture);
	    			request.getSession().setAttribute("myPictures", userPictures);		     					     		
		            request.setAttribute("success", "You have saved this picture to your pictures successfully.");
     			}
	        }
	        return request.getParameter("responseId");
	   }
	public Object getRecommendedItemDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        RecommendedItem item = this.getPortalService(request).getRecommendedItemById(id);
        String desc = null;
        if(item != null)
        	desc = item.getDesc();
		if(desc == null)
			desc = "No description available";
        return desc;
	}
	
	public Object getViewedItemDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        ViewedItem item = this.getPortalService(request).getViewedItemById(id);
        String desc = null;
        if(item != null)
        	desc = item.getDesc();
		if(desc == null)
			desc = "No description available";
        return desc;
	}
		
	public Object getPopItemDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        PopularItem item = this.getPortalService(request).getPopularItemById(id);
        String desc = null;
        if(item != null)
        	desc = item.getDesc();
		if(desc == null)
			desc = "No description available";
        return desc;
	}
	
	public Object getBookmarkDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        Bookmark item = this.getUserService(request).getBookmarkById(id);
        String desc = null;
        if(item != null)
        	desc = item.getDesc();
		if(desc == null)
			desc = "No description available";
        return desc;
	}
	
	public Object getInternalNewsDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        InternalNews news = this.getPortalService(request).getInternalNewsById(id);
		String desc = null;
        if(news != null)
        	desc = news.getContent();
		if(desc == null)
			desc = "No description available";
        return desc;
	}
	public Object getDeliDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String index = request.getParameter("index");
        int id = Integer.parseInt(index);
		List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getSession().getAttribute("deliciousTags");
		List<Bookmark> delicious= (List<Bookmark>)request.getSession().getAttribute("delicious");
		String name=null;
		String desc=null;
		for(BookmarkTag tag : deliciousTags){
			for(Bookmark bm : tag.getBookmarks()){
	            if(bm.getId() == id){
	                name = bm.getName();
					desc = bm.getDesc();
	                break;
	            }
			}
        }
		if(name == null){
			for(Bookmark bm : delicious){
				if(bm.getId() == id){
					desc = bm.getDesc();
	                break;
	            }
			}
		}
		if(desc == null)
			desc = "No description available";
        return desc;
	}
	
	public Object sendMessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String responseId = request.getParameter("responseId");
		String toUserId = request.getParameter("toUserId");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		if(this.getUser(request) != null 
		  && ! StringUtils.isEmpty(toUserId)){
			try{
				toUserId = URLDecoder.decode(toUserId,_CHARSET_UTF);	
				if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
				if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF).replaceAll("\n","").trim();;
				Message message = new Message(subject,content,Long.parseLong(toUserId),this.getUser(request).getId());
				this.getUserService(request).sendMessage(message);
				return responseId;
			}catch(Exception e){
				return -1;
			}
		}else{
			return 0;
		}
		
	}
	
	public Object deleteKeywords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] ids = words.split(",");
		for(int i=0;i<ids.length;i++){
			if(ids[i].trim().length() > 0){
				int id = Integer.parseInt(ids[i]);
				UserKeyword word = this.getPortalService(request).getUserKeywordById(id);
				this.getPortalService(request).delete(word);
			}
		}
		return responseId;
	}
	
	public Object addKeywords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] keywords = words.split(",");
		for(int i=0;i<keywords.length;i++){
			if(keywords[i].trim().length() > 0){				
				UserKeyword word = this.getPortalService(request).getUserKeyword(keywords[i],this.getUser(request).getId());
				if(word == null)
					word = new UserKeyword(keywords[i],this.getUser(request).getId(),100);
				else
					word.weighIt(100);				
				this.getPortalService(request).save(word);
			}
		}
		return responseId;
	}
	
	public Object deleteNotKeywords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] ids = words.split(",");
		for(int i=0;i<ids.length;i++){
			if(ids[i].trim().length() > 0){
				int id = Integer.parseInt(ids[i]);
				NotKeyword word = this.getPortalService(request).getNotKeyword(ids[i]);
				this.getPortalService(request).delete(word);
			}
		}
		return responseId;
	}
	
	public Object addNotKeywords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] keywords = words.split(",");
		for(int i=0;i<keywords.length;i++){
			if(keywords[i].trim().length() > 0){				
				NotKeyword word = this.getPortalService(request).getNotKeyword(keywords[i]);
				if(word == null){
					word = new NotKeyword(keywords[i]);
					this.getPortalService(request).saveNotKeyword(word);
				}								
			}
		}
		return responseId;
	}
	
	public Object deleteNotWords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] ids = words.split("A");
		for(int i=0;i<ids.length;i++){
			if(ids[i].trim().length() > 0){
				int id = Integer.parseInt(ids[i]);
				NotWord word = this.getPortalService(request).getNotWord(ids[i]);
				this.getPortalService(request).delete(word);
			}
		}
		return responseId;
	}
	
	public Object addNotWords(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String words = request.getParameter("words");
		String responseId = request.getParameter("responseId");
		String[] keywords = words.split("A");
		for(int i=0;i<keywords.length;i++){
			if(keywords[i].trim().length() > 0){				
				NotWord word = this.getPortalService(request).getNotWord(keywords[i]);
				if(word == null){
					word = new NotWord(keywords[i]);
					this.getPortalService(request).saveNotWord(word);
				}								
			}
		}
		return responseId;
	}
		
}

