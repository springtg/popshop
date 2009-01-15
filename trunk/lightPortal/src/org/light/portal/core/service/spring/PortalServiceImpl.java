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
package org.light.portal.core.service.spring;

import java.util.List;

import org.light.portal.core.dao.PortalDao;
import org.light.portal.core.service.PortalService;
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
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 22, 2006
 **/
public class PortalServiceImpl extends BaseServiceImpl implements PortalService {
	private PortalDao portalDao;
	private MailSender mailSender;
	private SimpleMailMessage welcomeMessage;
	private SimpleMailMessage inviteMessage;
	private List<NotWord> notWords;
	private List<NotKeyword> notKeywords;
	
	public void init(Portlets portlets,PortalLayout portalLayout, PortalSecurity portalSecurity){
		portalDao.init(portlets,portalLayout,portalSecurity);
	}
	
	public Portal getPortalByUser(String userId){
		return portalDao.getPortalByUser(userId);
	}
	public Portal getPortalByGroup(String portalId){
		return portalDao.getPortalByGroup(portalId);
	}

	public Portal createPortalByUser(String userId,String firstName,int showLocale,String language,String region){
		return portalDao.createPortalByUser(userId,firstName,showLocale,language,region);
	}
	
	public List<PortalRole> getPortalUserRoleByUser(long userId){
		return portalDao.getPortalUserRoleByUser(userId);
	}
	public List<PortalTab> getPortalTabByUser(String userId){
		return portalDao.getPortalTabByUser(userId);
	}
	public List<PortalTab> getPortalTabByUser(String userId, long orgId){
		return portalDao.getPortalTabByUser(userId,orgId);
	}
	public List<PortalTab> getUserPersonalPortalTab(String userId){
		return portalDao.getUserPersonalPortalTab(userId);
	}
	public List<PortalTab> getUserProfilePortalTab(String userId){
		return portalDao.getUserProfilePortalTab(userId);
	}
	public List<PortalTab> getPortalTabByNameAndUser(String name, String userId){
		return portalDao.getPortalTabByNameAndUser(name,userId);
	}
	public List<PortalTab> getPortalTabByParent(long parentId){
		return portalDao.getPortalTabByParent(parentId);
	}
	public PortalTab getPortalTabById(long id){
		return portalDao.getPortalTabById(id);
	}
	public List<PortletObject> getPortletsByTab(long tabId){
		return portalDao.getPortletsByTab(tabId);
	}
	public int getTabPortletsMaxRowByColoumn(long tabId, int column){
		return portalDao.getTabPortletsMaxRowByColoumn(tabId,column);
	}
	public List<PortletObjectRef> getPortletRefsByUser(String userId){
		return portalDao.getPortletRefsByUser(userId);
	}
	public List<PortletObjectRef> getPortletRefsByUserAndKeyword(String userId, String keyword){
		return portalDao.getPortletRefsByUserAndKeyword(userId,keyword);
	}
	public List<PortletObjectRef> getMyFeed(String userId){
		return portalDao.getMyFeed(userId);
	}
	public List<PortletObjectRef> getAllFeed(){
		return portalDao.getAllFeed();
	}
	public PortletObject getPortletById(long id){
		return portalDao.getPortletById(id);
	}
	public PortletObjectRef getPortletRefByName(String name){
		return portalDao.getPortletRefByName(name);
	}				
	
	public List<PortalUserRole> getUserRole(long userId, String roleId){
		return portalDao.getUserRole(userId,roleId);
	}
	
	public List<PortalUserRole> getUserChannel(long userId){
		return portalDao.getUserChannel(userId);
	}
		
	public PopularItem getPopularItemById(long id){
		return portalDao.getPopularItemById(id);
	}
	
	public List<PopularItem> getPopularItems(long orgId, int start, int max, String locale){
	    return portalDao.getPopularItems(orgId, start, max, locale);
	}
	public int getPopularItemTotal(long orgId, String locale){
		return portalDao.getPopularItemTotal(orgId, locale);
	}
	public PopularItem getPopularItemByLink(long orgId, String link){
		return portalDao.getPopularItemByLink(orgId, link);
	}
	public List<PopularItemComments> getPopularItemComments(long itemId){
		return portalDao.getPopularItemComments(itemId);
	}
	public List<ViewedItem> getViewedItems(int start, int max,String locale, long userId){
		return portalDao.getViewedItems(start,max,locale,userId);
	}
	public int getViewedItemTotal(String locale, long userId){
		return portalDao.getViewedItemTotal(locale,userId);
	}
	public ViewedItem getViewedItemNext(long id, long userId, String locale){
		return portalDao.getViewedItemNext(id,userId,locale);
	}
	public ViewedItem getViewedItemById(long id){
		return portalDao.getViewedItemById(id);
	}
	public ViewedItem getViewedItemByLink(String link){
		return portalDao.getViewedItemByLink(link);
	}
	public ViewedItemUser getViewedItemUser(long itemId, long userId){
		return portalDao.getViewedItemUser(itemId,userId);
	}
	public List<ChannelRef> getChannelRef(){
		return portalDao.getChannelRef();
	}
	
	public ChannelRef getChannelByName(String name){
		return portalDao.getChannelByName(name);
	}
	
	public List<PortletObjectRef>getPortletRefByRegion(String region){
		return portalDao.getPortletRefByRegion(region);
	}
	public List<UserKeyword> getUserKeywords(long userId){
		return portalDao.getUserKeywords(userId);
	}
	public UserKeyword getUserKeyword(String keyword,long userId){
		return portalDao.getUserKeyword(keyword,userId);
	}
	public UserKeyword getUserKeywordById(long id){
		return portalDao.getUserKeywordById(id);
	}
	public boolean isKeyword(String word){
		return portalDao.isKeyword(word);
	}
	public NotKeyword getNotKeyword(String word){
		return portalDao.getNotKeyword(word);
	}
	public List<NotKeyword> getNotKeywords(){
		if(this.notKeywords == null){
			this.notKeywords = portalDao.getNotKeywords();
		}
		return this.notKeywords;
	}
	public List<NotWord> getNotWords(){
		if(this.notWords == null){
			this.notWords = portalDao.getNotWords();
		}
		return this.notWords;
	}
	public NotWord getNotWord(String word){
		return portalDao.getNotWord(word);
	}
	public List<RecommendedItem> getRecommendedItems(int start,int max, long userId){
		return portalDao.getRecommendedItems(start,max,userId);
	}
	public void deleteRecommendedItems(long userId){
		portalDao.deleteRecommendedItems(userId);
	}
	public int getRecommendedItemTotal(long userId){
		return portalDao.getRecommendedItemTotal(userId);
	}
	public RecommendedItem getRecommendedItemNext(long id, long userId, String locale){
		return portalDao.getRecommendedItemNext(id, userId, locale);
	}
	public RecommendedItem getRecommendedItemById(long id){
		return portalDao.getRecommendedItemById(id);
	}
	public RecommendedItem getRecommendedItemByLink(String link){
		return portalDao.getRecommendedItemByLink(link);
	}
	public List<PortletObjectRef> getFeedsByUrl(String url){
		return portalDao.getFeedsByUrl(url);
	}
	public List<String> getFeedsByLanguage(String language){
		return portalDao.getFeedsByLanguage(language);
	}
	public List<FlashGame> getFlashGames(){
		return portalDao.getFlashGames();
	}
	public List<UserPicture> getPublicPictures(int start,int max){
		return portalDao.getPublicPictures(start,max);
	}
	public Entity getEntityById(Class klass, long id){
		return portalDao.getEntityById(klass,id);
	}
	public InternalNews getInternalNewsById(long id){
		return portalDao.getInternalNewsById(id);
	}
	public List<InternalNews> getInternalNews(long orgId){
		return portalDao.getInternalNews(orgId);
	}
	public void deletePortal(String userId){
		portalDao.deletePortal(userId);
	}
	
	public Entity create(Entity entity){
		return portalDao.create(entity);
	}
	public void saveNotKeyword(NotKeyword notKeyword){
		if(this.notKeywords != null){
			this.notKeywords.add(notKeyword);
		}
		portalDao.save(notKeyword);
	}
	
	public void saveNotWord(NotWord notWord){
		if(this.notWords != null){
			this.notWords.add(notWord);
		}
		portalDao.save(notWord);
	}
	
	public void save(Entity entity){
		portalDao.save(entity);
	}
	
	public void delete(Entity entity){
		portalDao.delete(entity);
	}
		
	public PortalDao getPortalDao() {
		return portalDao;
	}

	public void setPortalDao(PortalDao portalDao) {
		this.portalDao = portalDao;
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
	
}
