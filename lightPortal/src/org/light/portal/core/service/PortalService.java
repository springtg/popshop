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
package org.light.portal.core.service;

import java.util.List;

import org.light.portal.layout.config.PortalLayout;
import org.light.portal.model.ChannelRef;
import org.light.portal.model.Entity;
import org.light.portal.model.FlashGame;
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
import org.light.portal.model.UserKeyword;
import org.light.portal.model.UserPicture;
import org.light.portal.model.ViewedItem;
import org.light.portal.model.ViewedItemUser;
import org.light.portal.portlet.config.Portlets;
import org.light.portal.security.config.PortalSecurity;
import org.light.portlets.internal.InternalNews;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public interface PortalService extends BaseService {
	public void init(Portlets portlets,PortalLayout portalLayout, PortalSecurity portalSecurity);
	public Portal getPortalByUser(String userId);
	public Portal createPortalByUser(String userId,String firstName,int showLocale,String language,String region);
	public List<PortalRole> getPortalUserRoleByUser(long userId);
	public List<PortalTab> getPortalTabByUser(String userId);
	public List<PortalTab> getPortalTabByUser(String userId, long orgId);
	public List<PortalTab> getPortalTabByNameAndUser(String name, String userId);
	public List<PortalTab> getPortalTabByParent(long parentId);
	public PortalTab getPortalTabById(long id);
	public List<PortletObject> getPortletsByTab(long tabId);
	public PortletObject getPortletById(long id);
	public List<PortletObjectRef> getPortletRefsByUser(String userId);
	public List<PortletObjectRef> getPortletRefsByUserAndKeyword(String userId, String keyword);
	public List<PortletObjectRef> getMyFeed(String userId);
	public List<PortletObjectRef> getAllFeed();
	public PortletObjectRef getPortletRefByName(String name);	
	public List<PortalUserRole> getUserRole(long userId, String roleId);
	public List<PortalUserRole> getUserChannel(long userId);	
	public Portal getPortalByGroup(String portalId);
	public List<PopularItem> getPopularItems(long orgId, int start,int max,String locale);	
	public int getPopularItemTotal(long orgId, String locale);	
	public PopularItem getPopularItemById(long id);	
	public PopularItem getPopularItemByLink(long orgId, String link);
	public List<PopularItemComments> getPopularItemComments(long itemId);
	public List<ViewedItem> getViewedItems(int start,int max,String locale, long userId);
	public int getViewedItemTotal(String locale, long userId);	
	public ViewedItem getViewedItemById(long id);	
	public ViewedItem getViewedItemNext(long id, long userId, String locale);	
	public ViewedItem getViewedItemByLink(String link);
	public ViewedItemUser getViewedItemUser(long itemId, long userId);	
	public int getTabPortletsMaxRowByColoumn(long tabId, int column);
	public List<ChannelRef> getChannelRef();
	public ChannelRef getChannelByName(String name);
	public List<PortletObjectRef>getPortletRefByRegion(String region);
	public void deletePortal(String userId);
	public List<UserKeyword> getUserKeywords(long userId);
	public UserKeyword getUserKeyword(String keyword,long userId);
	public UserKeyword getUserKeywordById(long id);
	public boolean isKeyword(String word);
	public InternalNews getInternalNewsById(long id);
	public List<InternalNews> getInternalNews(long orgId);
	public List<RecommendedItem> getRecommendedItems(int start,int max, long userId);
	public void deleteRecommendedItems(long userId);
	public int getRecommendedItemTotal(long userId);	
	public RecommendedItem getRecommendedItemById(long id);
	public RecommendedItem getRecommendedItemNext(long id, long userId, String locale);
	public RecommendedItem getRecommendedItemByLink(String link);
	public List<String> getFeedsByLanguage(String language);
	public List<PortletObjectRef> getFeedsByUrl(String url);
	public List<NotKeyword> getNotKeywords();
	public NotKeyword getNotKeyword(String word);
	public NotWord getNotWord(String word);
	public List<NotWord> getNotWords();
	public List<FlashGame> getFlashGames();
	public List<UserPicture> getPublicPictures(int start,int max);
	public Entity getEntityById(Class klass, long id);
	public List<PortalTab> getUserPersonalPortalTab(String userId);
	public List<PortalTab> getUserProfilePortalTab(String userId);
	public void saveNotKeyword(NotKeyword notKeyword);
	public void saveNotWord(NotWord notWord);
}
