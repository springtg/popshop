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
package org.light.portal.core.dao.hibernate;

import static org.light.portal.util.Constants._DEFAULT_FEMALE_THEME;
import static org.light.portal.util.Constants._DEFAULT_LANGUAGE;
import static org.light.portal.util.Constants._DEFAULT_MALE_THEME;
import static org.light.portal.util.Constants._DEFAULT_ORG_LOGO;
import static org.light.portal.util.Constants._DEFAULT_ORG_LOGOICON;
import static org.light.portal.util.Constants._DEFAULT_ORG_MX;
import static org.light.portal.util.Constants._DEFAULT_ORG_VIRTUALHOST;
import static org.light.portal.util.Constants._DEFAULT_ORG_WEBID;
import static org.light.portal.util.Constants._DEFAULT_ROLE;
import static org.light.portal.util.Constants._DEFAULT_THEME;
import static org.light.portal.util.Constants._LANGUAGE_EN;
import static org.light.portal.util.Constants._PORTAL_TITLE_LOGIN_KEY;
import static org.light.portal.util.Constants._ROLE_GROUP;
import static org.light.portal.util.Constants._ROLE_STORE;
import static org.light.portal.util.Constants._ROLE_USER;

import java.util.List;

import net.sf.acegisecurity.providers.encoding.Md5PasswordEncoder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.light.portal.core.dao.PortalDao;
import org.light.portal.layout.config.PortalLayout;
import org.light.portal.layout.config.PortalUser;
import org.light.portal.model.ChannelRef;
import org.light.portal.model.Entity;
import org.light.portal.model.FlashGame;
import org.light.portal.model.NotKeyword;
import org.light.portal.model.NotWord;
import org.light.portal.model.Organization;
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
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserKeyword;
import org.light.portal.model.UserPicture;
import org.light.portal.model.UserRole;
import org.light.portal.model.ViewedItem;
import org.light.portal.model.ViewedItemUser;
import org.light.portal.portlet.config.Parameter;
import org.light.portal.portlet.config.Portlets;
import org.light.portal.security.config.PortalSecurity;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.ChatStatusRef;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupCategory;
import org.light.portlets.internal.InternalNews;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 4, 2006
 **/
public class PortalDaoImpl extends BaseDaoImpl implements PortalDao {
	
	public void init(Portlets portlets,PortalLayout portalLayout, PortalSecurity portalSecurity) {			
		if(portalSecurity.getApplication().getReCreateTable()){
			Configuration config = new Configuration();
			SchemaExport s = new SchemaExport(config.configure());
			s.create(false,true);
		}
		this.createDefaultRef(_DEFAULT_ROLE,portlets);			
		this.createDefaultPortalByUser(portalLayout,portalSecurity);	
		this.createDefaultPortalSecurity(portalSecurity);
	}
    	
	public Portal getPortalByUser(String userId){
		Portal portal = getPortalByUserId(userId);		
 		if(portal == null){	
 			Organization org = OrganizationThreadLocal.getOrg();
			User user = this.getUserDao().getUserByUserId(userId,org.getId());
			String role = org.getRole();			
			List<PortalUserRole> userRoles = this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ? and userRole.roleId != ?", new Object[] {user.getId(),role});
			String title = null;
			String theme = null;
			boolean isMember = false;
			if(userRoles != null && userRoles.size() > 0){
				PortalRole portalRole = (PortalRole)this.getHibernateTemplate().get(PortalRole.class,userRoles.get(0).getRoleId());
				if(portalRole != null){					
					title = portalRole.getTitle();				
					if(user != null && user.getDisplayName() != null) title = user.getDisplayName()+"_"+_PORTAL_TITLE_LOGIN_KEY;
					theme = portalRole.getTheme();
					isMember = true;
				}
				
			}
			this.createDefaultPortalByUser(userId,title,theme,isMember);
			portal = getPortalByUserId(userId);
		}
		return portal;
	}
	
	public Portal getPortalByGroup(String portalId){
		Portal portal = getPortalByUserId(portalId);
		if(portal == null){				
			String[]id= portalId.split("_");
			int groupId = Integer.parseInt(id[1]);
			Group group = (Group)this.getHibernateTemplate().get(Group.class,groupId);
			this.createDefaultPortalByGroup(portalId,group.getDisplayName());
			portal = getPortalByUserId(portalId);
		}
		return portal;
	}
	
	public Portal createPortalByUser(String userId,String firstName,int showLocale,String language,String region){
		Portal portal = getPortalByUserId(userId);
		if(portal == null){	
			List<PortalRole> portalRoles = this.getHibernateTemplate().find("select pRole from PortalRole pRole where pRole.roleId= ?", _ROLE_USER);
			String title = null;
			String theme = null;
			boolean isMember = false;
			if(portalRoles != null && portalRoles.size() > 0){				
					title = firstName+"_"+_PORTAL_TITLE_LOGIN_KEY;
					theme = portalRoles.get(0).getTheme();
					isMember = true;			
			}
			User user =  this.getUserDao().getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());// (UserEntity)this.getHibernateTemplate().get(UserEntity.class,userId);
			if(user.getGender() != null && user.getGender().equals("male"))
				theme = _DEFAULT_MALE_THEME;
			else
				theme = _DEFAULT_FEMALE_THEME;
			this.createDefaultPortalByUser(userId,title,theme,isMember,showLocale,language,region);
			portal = getPortalByUserId(userId);
		}
		return portal;
	}
	
	public List<PortalRole> getPortalUserRoleByUser(long userId){
		List<PortalUserRole> listUserRole= this.getUserRole(userId);//getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ?", userId);
		List<PortalRole> listRole = null;
		if(listUserRole == null || listUserRole.size() == 0){
			listRole = this.getHibernateTemplate().find("select portalRole from PortalRole portalRole where portalRole.roleId= ?", _DEFAULT_ROLE);
		}else if(listUserRole.size() == 1){			
			listRole = this.getHibernateTemplate().find("select portalRole from PortalRole portalRole where portalRole.roleId= ?", listUserRole.get(0).getRoleId());
		}else{
			String group = "";
			for(PortalUserRole userRole : listUserRole){
				if(group.equals(""))
					group="'"+userRole.getRoleId()+"'";
				else
					group+=",'"+userRole.getRoleId()+"'";
			}
			listRole = this.getHibernateTemplate().find("select portalRole from PortalRole portalRole where portalRole.roleId in ("+group+")");
		}
		return listRole;
	}
	
	public List<PortalTab> getPortalTabByUser(String userId){		
		Organization org= OrganizationThreadLocal.getOrg();
		if(org == null) org = this.getUserDao().getOrganizations().get(0);
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", userId);		
		if(!userId.startsWith("role_")){
			User user = this.getUserDao().getUserByUserId(userId,org.getId());			
			String defaultRole = (userId.equals(org.getDefaultUserId())) ? org.getRole() : _DEFAULT_ROLE;			
			List<PortalUserRole> roles =this.getUserRole(user.getId(),defaultRole);
			Object[] params = new Object[2];
			params[0] = (roles != null && roles.size() > 0) ? defaultRole : _ROLE_USER;
			params[1] = user.getId();
			List<PortalUserRole> listRole= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.roleId != ? and userRole.userId= ?", params);		
			if(listRole != null && listRole.size()>0){	
				List<PortalTab> listsByRole	= null;	
				if(listRole.size() == 1){
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", listRole.get(0).getRoleId());
				}else{
					String group = "";					
					for(PortalUserRole userRole :listRole){
						String role= userRole.getRoleId();						
						if(role.startsWith("channel_") && !_LANGUAGE_EN.equals(user.getRegion())){
							String localeRole = role+"_"+user.getRegion();
							Portal channelPortal = getPortalByUserId(localeRole);
							if(channelPortal != null)
								role = localeRole;
						}
						if(group.equals(""))
							group+="'" + role +"'";
						else
							group+=",'" + role +"'";
					}
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId in ("+group+") and tab.parentId= 0 order by tab.id");
				}
				for(PortalTab tab : listsByRole){
					if(tab.getUserId().startsWith("channel_"))
						list.add(tab);	
					else
						list.add(0,tab);	
				}
							
			}
			/* existing system's Role*/
			List<UserRole> listUserRoles = this.getUserDao().getUserRole(user.getId());
			if(listUserRoles != null && listUserRoles.size()>0){	
				List<PortalTab> listsByRole	= null;	
				if(listUserRoles.size() == 1){
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", listUserRoles.get(0).getRoleId());
				}else{
					String group = "";
					for(UserRole userRole :listUserRoles){
						if(group.equals(""))
							group+="'" + userRole.getRoleId()+"'";
						else
							group+=",'" + userRole.getRoleId()+"'";
					}
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId in ("+group+") and tab.parentId= 0 order by tab.id");
				}
				list.addAll(listsByRole);			
			}
		}		
		return list;
	}
	
	public List<PortalTab> getPortalTabByUser(String userId, long orgId){	
		Organization org = this.getUserDao().getOrgById(orgId);
		if(org == null) org = this.getUserDao().getOrganizations().get(0);
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", userId);		
		if(! userId.startsWith("role_")){
			User user = this.getUserDao().getUserByUserId(userId,orgId);			
			String defaultRole = (userId.equals(org.getDefaultUserId())) ? org.getRole() : _DEFAULT_ROLE;
			List<PortalUserRole> roles =this.getUserRole(user.getId(),defaultRole);
			Object[] params = new Object[2];
			params[0] = (roles != null && roles.size() > 0) ? defaultRole : _ROLE_USER;
			params[1] = user.getId();
			List<PortalUserRole> listRole= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.roleId != ? and userRole.userId= ?", params);		
			if(listRole != null && listRole.size()>0){	
				List<PortalTab> listsByRole	= null;	
				if(listRole.size() == 1){
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", listRole.get(0).getRoleId());
				}else{
					String group = "";					
					for(PortalUserRole userRole :listRole){
						String role= userRole.getRoleId();						
						if(role.startsWith("channel_") && !_LANGUAGE_EN.equals(user.getRegion())){
							String localeRole = role+"_"+user.getRegion();
							Portal channelPortal = getPortalByUserId(localeRole);
							if(channelPortal != null)
								role = localeRole;
						}
						if(group.equals(""))
							group+="'" + role +"'";
						else
							group+=",'" + role +"'";
					}
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId in ("+group+") and tab.parentId= 0 order by tab.id");
				}
				for(PortalTab tab : listsByRole){
					if(tab.getUserId().startsWith("channel_"))
						list.add(tab);	
					else
						list.add(0,tab);	
				}			
			}
			/* existing system's Role*/
			List<UserRole> listUserRoles = this.getUserDao().getUserRole(user.getId());
			if(listUserRoles != null && listUserRoles.size()>0){	
				List<PortalTab> listsByRole	= null;	
				if(listUserRoles.size() == 1){
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.parentId= 0 order by tab.id", listUserRoles.get(0).getRoleId());
				}else{
					String group = "";
					for(UserRole userRole :listUserRoles){
						if(group.equals(""))
							group+="'" + userRole.getRoleId()+"'";
						else
							group+=",'" + userRole.getRoleId()+"'";
					}
					listsByRole= this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId in ("+group+") and tab.parentId= 0 order by tab.id");
				}
				list.addAll(0,listsByRole);			
			}
		}
		return list;
	}
	
	public List<PortalTab> getUserPersonalPortalTab(String userId){
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? order by tab.id", userId);				
		return list;
	}
	public List<PortalTab> getUserProfilePortalTab(String userId){
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.userId= ? and tab.status = 1 order by tab.id", userId);				
		return list;
	}
	
	public List<PortalTab> getPortalTabByNameAndUser(String name, String userId){		
		String[] params = new String[2];
		params[0] = name;
		params[1] = userId;
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.label =? and tab.userId= ? and tab.parentId= 0", params);		
		return list;
	}
	public List<PortalTab> getPortalTabByParent(long parentId){		
		List<PortalTab> list = this.getHibernateTemplate().find("select tab from PortalTab tab where tab.parentId= ?", parentId);		
		return list;
	}
	public PortalTab getPortalTabById(long id){
		return (PortalTab)this.getHibernateTemplate().get(PortalTab.class,id);
	}
	
	public List<PortletObject> getPortletsByTab(long tabId){
		List<PortletObject> list= this.getHibernateTemplate().find("select portlet from PortletObject portlet where portlet.tabId= ? order by portlet.column, portlet.row", tabId);		
		return list;
	}
	public int getTabPortletsMaxRowByColoumn(long tabId, int column){			
		String hql="select max(portlet.row) from PortletObject portlet where portlet.tabId= "+tabId+" and portlet.column="+column;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Object result = query.uniqueResult();
		int max=0;
		if(result != null)
			max = (Integer)result + 1;
		session.close();
		return max;
	}
	public PortletObject getPortletById(long id){
		PortletObject po = (PortletObject)this.getHibernateTemplate().get(PortletObject.class,id);		
		return  po;
	}
//	
//	public User getUserByUserId(String userId){
//		List<User> users =this.getHibernateTemplate().find("from UserEntity where userId=?",userId);
//		User user = null;
//		if(users != null && users.size() > 0) user = users.get(0);
//		return user;
//	}
	
	public List<PortletObjectRef> getPortletRefsByUser(String userId){
		User user =this.getUserDao().getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
		List<PortalUserRole> roles = this.getUserRoles(user.getId());		
		String language = user.getLanguage();		
		StringBuffer query = new StringBuffer();
		query.append("select ref from PortletObjectRef ref where ");
		long orgId = OrganizationThreadLocal.getOrganizationId();
		query.append("(ref.orgId= 0 or ref.orgId="+orgId+") and ");
		if(language == null) language = _DEFAULT_LANGUAGE;
		query.append("(ref.language= '"+language+"'");
		if(language.indexOf("_") > 0){
			String prefix = language.substring(0,language.indexOf("_"));
			query.append(" or ref.language= '"+prefix+"'");
		}
		query.append(" or ref.language= 'all') and (")
		     .append("ref.userId= '"+userId+"'")
		     .append(" or ref.userId= '" + _DEFAULT_ROLE+"'")
		     ;
		if(roles != null){
			for(PortalUserRole role : roles){
				query.append("or ref.userId= '"+role.getRoleId()+"'");
			}
		}
		query.append(")");
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());
		
		return list;
	}
	
	public List<PortletObjectRef> getPortletRefsByUserAndKeyword(String userId, String keyword){
		User user =this.getUserDao().getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
		List<PortalUserRole> roles = this.getUserRoles(user.getId());		
		String locale = user.getRegion();		
		long orgId = OrganizationThreadLocal.getOrganizationId();
		StringBuffer query = new StringBuffer();
		query.append("select ref from PortletObjectRef ref where ")
			 .append("(ref.orgId= 0 or ref.orgId="+orgId+") and ")
		     .append("(ref.language= '"+locale+"'")
		     ;
		if(locale.indexOf("_") > 0){
			String parentLocale = locale.substring(0,locale.indexOf("_"));
			query.append(" or ref.language= '"+parentLocale+"'");
		}
		query.append(" or ref.language= 'all') and (")
		     .append("ref.userId= '"+userId+"'")
		     .append(" or ref.userId= '" + _DEFAULT_ROLE+"'")
		     ;
		if(roles != null){
			for(PortalUserRole role : roles){
				query.append("or ref.userId= '"+role.getRoleId()+"'");
			}
		}
		query.append(")");
		query.append(" and ref.label like '%"+keyword+"%'");
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());
		
		return list;
	}
	
	public List<PortletObjectRef> getMyFeed(String userId){
		StringBuffer query = new StringBuffer();
		query.append("select ref from PortletObjectRef ref where ")
		     .append("ref.userId= '"+userId+"'")
		     ;		
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());
		
		return list;
	}
	
	public List<PortletObjectRef> getAllFeed(){
		StringBuffer query = new StringBuffer();
		query.append("select ref from PortletObjectRef ref where ")
		     .append("ref.parameter like 'feed=%'")
		     ;		
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());
		
		return list;
	}
	public PortletObjectRef getPortletRefByName(String name){
		return (PortletObjectRef)this.getHibernateTemplate().get(PortletObjectRef.class,name);
	}
	
	public PopularItem getPopularItemById(long id){
		return (PopularItem)this.getHibernateTemplate().get(PopularItem.class, id);
	}
	
	public List<PopularItem> getPopularItems(long orgId,int start, int max, String locale){
       String hql="select pop from PopularItem pop where pop.orgId="+orgId+" and pop.locale ='all' or pop.locale='"+locale+"' order by pop.popCount desc, pop.id desc";
       Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(start)
					.setMaxResults(max);
	   List<PopularItem> list = query.list();
	   session.close();
       return list;    
	}
	public int getPopularItemTotal(long orgId,String locale){
		String hql="select count(*) from PopularItem where orgId="+orgId+" and locale ='all' or locale='"+locale+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public PopularItem getPopularItemByLink(long orgId, String link){
	       PopularItem item = null;
	       List<PopularItem> popularItem=this.getHibernateTemplate().find("select pop from PopularItem pop where pop.orgId=? and pop.link= ?", new Object[]{orgId,link});
	       if(popularItem != null && popularItem.size() > 0)
	           item = popularItem.get(0);
	       return item;
	}
	public List<PopularItemComments> getPopularItemComments(long itemId){
		List<PopularItemComments> comments=this.getHibernateTemplate().find("select comm from PopularItemComments comm where comm.itemId= ?", itemId);
	    return comments;   
	}
	
	public ViewedItem getViewedItemById(long id){
		return (ViewedItem)this.getHibernateTemplate().get(ViewedItem.class, id);
	}
	
	public ViewedItem getViewedItemNext(long id, long userId, String locale){
	   StringBuffer hql=new StringBuffer();
       if(userId > 0){ 
    	   hql.append("select viewed from ViewedItem viewed, ViewedItemUser user where ")
    	      .append("user.postById="+userId)
			  .append(" and ")
			  .append("user.itemId=viewed.id")
			  .append(" and ")
			  .append("viewed.id >="+id)
			  ;
       }else{
    	   hql.append("select viewed from ViewedItem viewed where ")
    	   	  .append("viewed.locale='"+locale+"'")
    	   	  .append(" and ")
			  .append("viewed.id >="+id)
			  ;
       }
       hql.append(" order by viewed.id asc");
       Session session= this.getHibernateTemplate().getSessionFactory().openSession();
	   Query query =session.createQuery(hql.toString())
					.setFirstResult(0)
					.setMaxResults(1);
	   List<ViewedItem> list = query.list();
	   session.close();
	   ViewedItem item = null;
	   if(list != null && list.size() > 0) item = list.get(0);
       return item;       
	}
	
	public List<ViewedItem> getViewedItems(int start, int max, String locale, long userId){       
       StringBuffer hql=new StringBuffer();
       
       if(userId > 0){ 
    	   hql.append("select viewed from ViewedItem viewed, ViewedItemUser user where ")
    	      .append("user.postById='"+userId+"'")
			  .append(" and ")
			  .append("user.itemId=viewed.id")
			  ;
       }else{
    	   hql.append("select viewed from ViewedItem viewed where ");
    	   hql.append("viewed.locale='"+locale+"'");
       }
       hql.append(" order by viewed.viewedDate desc, viewed.id desc");
       Session session= this.getHibernateTemplate().getSessionFactory().openSession();
	   Query query =session.createQuery(hql.toString())
					.setFirstResult(start)
					.setMaxResults(max);
	   List<ViewedItem> list = query.list();
	   session.close();
       return list;       
	}
	public int getViewedItemTotal(String locale, long userId){
		StringBuffer hql=new StringBuffer();
	    
		if(userId > 0){ 
			hql.append("select count(item.id) from ViewedItem item, ViewedItemUser user where ")
			   .append("user.postById='"+userId+"'")
			   .append(" and ")
			   .append("user.itemId=item.id")
			   ;
		}else{
			hql.append("select count(*) from ViewedItem where ");
			hql.append("locale='"+locale+"'");
		}
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql.toString());
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
		
	public ViewedItem getViewedItemByLink(String link){
	   ViewedItem item = null;	  
       List<ViewedItem> viewedItem=this.getHibernateTemplate().find("select viewed from ViewedItem viewed where viewed.link= ?", link);
       if(viewedItem != null && viewedItem.size() > 0)
           item = viewedItem.get(0);
       return item;
	}
	public ViewedItemUser getViewedItemUser(long itemId, long userId){
	   ViewedItemUser user = null;
	   Object[] params = new Object[2];
	   params[0] = itemId;
	   params[1] = userId;
       List<ViewedItemUser> viewedUser=this.getHibernateTemplate().find("select viewed from ViewedItemUser viewed where viewed.itemId= ? and viewed.postById=?", params);
       if(viewedUser != null && viewedUser.size() > 0)
    	   user = viewedUser.get(0);
       return user;
	}
	public List<UserPicture> getPublicPictures(int start,int max){
		String hql="select picture from UserPicture picture where picture.status = 2 order by id desc";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
						.setFirstResult(start)
						.setMaxResults(max);
		   List<UserPicture> list = query.list();
		   session.close();
	       return list;   
	}
	public List<RecommendedItem> getRecommendedItems(int start,int max, long userId){
		String hql="select pop from RecommendedItem pop where pop.userId='"+userId+"' and pop.read=0 order by pop.id desc"; //pop.weight desc
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
						.setFirstResult(start)
						.setMaxResults(max);
	   List<RecommendedItem> list = query.list();
	   session.close();
       return list;   
	}
	public void deleteRecommendedItems(long userId){
		String hql="delete from RecommendedItem where userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		session.createQuery(hql)
			   .executeUpdate();
		session.close();
	}
	public int getRecommendedItemTotal( long userId){
		String hql="select count(*) from RecommendedItem where userId='"+userId+"' and read=0";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public RecommendedItem getRecommendedItemById(long id){
		return (RecommendedItem)this.getHibernateTemplate().get(RecommendedItem.class, id);
	}
	public RecommendedItem getRecommendedItemNext(long id, long userId, String locale){
	   StringBuffer hql=new StringBuffer();
	   hql.append("select viewed from RecommendedItem viewed where ")
	      .append("viewed.userId="+userId)
		  .append(" and ")				  
		  .append("viewed.id >="+id)
		  ;
       
       hql.append(" order by viewed.id asc");
       Session session= this.getHibernateTemplate().getSessionFactory().openSession();
	   Query query =session.createQuery(hql.toString())
					.setFirstResult(0)
					.setMaxResults(1);
	   List<RecommendedItem> list = query.list();
	   session.close();
	   RecommendedItem item = null;
	   if(list != null && list.size() > 0) item = list.get(0);
       return item;       
	}
	public RecommendedItem getRecommendedItemByLink(String link){
		RecommendedItem item = null;	  
	       List<RecommendedItem> recommendedItem=this.getHibernateTemplate().find("select viewed from RecommendedItem viewed where viewed.link= ?", link);
	       if(recommendedItem != null && recommendedItem.size() > 0)
	           item = recommendedItem.get(0);
	       return item;
	}
	
	public List<String> getFeedsByLanguage(String language){
		StringBuffer query = new StringBuffer();
		query.append("select distinct ref.parameter from PortletObjectRef ref where ")
		     .append("ref.language= '"+language+"'")
		     .append(" and ")
		     .append("ref.parameter like 'feed=%'")
		     ;		
		List<String> list= this.getHibernateTemplate().find(query.toString());	
		return list;
	}
	public List<PortletObjectRef> getFeedsByUrl(String url){
		StringBuffer query = new StringBuffer();
		query.append("select ref from PortletObjectRef ref where ")	
		     .append("ref.parameter = 'feed=")
		     .append(url)
		     .append("'")
		     ;		
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());	
		return list;
	}
	public List<ChannelRef> getChannelRef(){
	       List<ChannelRef> channels=this.getHibernateTemplate().find("select ref from ChannelRef ref order by ref.id asc");
	       
	       return channels;
	}
	
	public ChannelRef getChannelByName(String name){
		 List<ChannelRef> channels=this.getHibernateTemplate().find("select ref from ChannelRef ref where ref.name=?",name);
	     ChannelRef ref = null;
	     if(channels != null && channels.size() > 0) ref = channels.get(0);
		 return ref;
	}
	
	public List<FlashGame> getFlashGames(){
	       List<FlashGame> games=this.getHibernateTemplate().find("select game from FlashGame game order by game.popCount asc, game.id desc");	       
	       return games;
	}
	
	public Entity getEntityById(Class klass, long id){
		return (Entity)this.getHibernateTemplate().get(klass, id);
	}
	
	public List<PortletObjectRef>getPortletRefByRegion(String region){
		String locale = region;
		StringBuffer query = new StringBuffer();
		long orgId = OrganizationThreadLocal.getOrganizationId();
		query.append("select ref from PortletObjectRef ref where ")
			 .append("(ref.orgId= 0 or ref.orgId="+orgId+") and ")
		     .append("(ref.language= '"+locale+"'")
		     ;
		if(locale.indexOf("_") > 0){
			String parentLocale = locale.substring(0,locale.indexOf("_"));
			query.append(" or ref.language= '"+parentLocale+"'");
		}
		query.append(" or ref.language= 'all') and ")		    
		     .append(" ref.userId= '" + _DEFAULT_ROLE+"'")		     
		     ;		
		List<PortletObjectRef> list= this.getHibernateTemplate().find(query.toString());
		
		return list;
	}
	
	public void deletePortal(String userId){
		Portal portal = this.getPortalByUser(userId);
		if(portal != null){
			 List<PortalTab> tabs = this.getPortalTabByUser(userId);
			 for(PortalTab tab : tabs){
				 List<PortletObject> portlets=this.getPortletsByTab(tab.getId());
				 for(PortletObject portlet : portlets){
					 this.delete(portlet);
				 }
				 this.delete(tab);
			 }
			 User user =this.getUserDao().getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
			 List<PortalUserRole> roles = this.getUserRoles(user.getId());
			 for(PortalUserRole role : roles){
				 this.delete(role);
			 }
			 this.delete(portal);			
		}
	}
	
	private void createDefaultPortalByUser(PortalLayout portalLayout, PortalSecurity portalSecurity){
		PortalUser[] users = portalLayout.getPortalUser();
		for(int i=0;i<users.length;i++){
			String userId = users[i].getUser();
			if(userId == null || "".equals(userId))
				userId = users[i].getRole();
			if(userId == null || "".equals(userId))
				throw new RuntimeException("Portal-layout.xml configure error: user name and role name can not both null.");
			List<Portal> portals = this.getHibernateTemplate().find("from Portal where userId=?",userId);
			if(portals == null || portals.size() == 0){
				PortalRole portalRole = (PortalRole)this.getHibernateTemplate().get(PortalRole.class,userId);
				String title ="";
				String theme ="";
				if(portalRole != null){
					title = portalRole.getTitle();
					theme = portalRole.getTheme();
				}
				Portal portal = new Portal(userId,title,theme
									,portalSecurity.getApplication().getAllowChangeLocale() ? 1: 0
								    );
				this.save(portal);
			}
			for(int j=0;j<users[i].getPortalTab().length;j++){
				int closeable = 0;
				int editable = 0;
				int moveable = 0;
				int allowAddContent = 0;
				int defaulted = 0;
				if(users[i].getPortalTab()[j].getCloseable()) closeable = 1;
				if(users[i].getPortalTab()[j].getEditable()) editable = 1;
				if(users[i].getPortalTab()[j].getMoveable()) moveable = 1;
				if(users[i].getPortalTab()[j].getAllowAddContent()) allowAddContent = 1;
				if(users[i].getPortalTab()[j].getDefaulted()) defaulted = 1;
				List<PortalTab> tabs = this.getPortalTabByNameAndUser(users[i].getPortalTab()[j].getTitle(),userId);
				PortalTab tab=null;
				if(tabs == null || tabs.size() == 0){
					tab= new PortalTab(
								users[i].getPortalTab()[j].getTitle()
							   ,users[i].getPortalTab()[j].getUrl()
							   ,closeable
							   ,editable
							   ,moveable
							   ,allowAddContent
							   ,users[i].getPortalTab()[j].getColor()
							   ,defaulted
							   ,users[i].getPortalTab()[j].getBetween()
							   ,users[i].getPortalTab()[j].getWidths()
							   ,users[i].getPortalTab()[j].getPortletWindow()
							   ,userId
							   ,0);
					this.save(tab);
				}else{	
					tab = tabs.get(0);
					tab.setCloseable(closeable);
					tab.setEditable(editable);
					tab.setAllowAddContent(allowAddContent);
					tab.setDefaulted(defaulted);
					tab.setWidths(users[i].getPortalTab()[j].getWidths());
					tab.setBetween(users[i].getPortalTab()[j].getBetween());
					tab.setPortletWindowType(users[i].getPortalTab()[j].getPortletWindow());
					this.save(tab);
				}
				for(int k=0;k<users[i].getPortalTab()[j].getPortlets().getPortlet().length;k++){
					PortletObjectRef ref = this.getPortletRefByName(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getName());
					List<PortletObject> po = this.getPortletByTabAndName(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getName(),tab.getId());
					if(ref != null){
						if(po == null || po.size() == 0){
							PortletObject portletObject =new PortletObject(
										tab.getId()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getColumn()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getRow()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNotCloseable()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNoEditMode()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNoConfigMode()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getBarBgColor()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getBarFontColor()
									   ,users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getContentBgColor()
									   ,ref);
							this.save(portletObject);
						}else{
							PortletObject portletObject = po.get(0);
							portletObject.setColumn(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getColumn());
							portletObject.setRow(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getRow());
							portletObject.setCloseable(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNotCloseable()? 0:1);
							portletObject.setEditMode(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNoEditMode()? 0:1);
							portletObject.setConfigMode(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getNoConfigMode()? 0:1);
							portletObject.setBarBgColor(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getBarBgColor());
							portletObject.setBarFontColor(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getBarFontColor());
							portletObject.setContentBgColor(users[i].getPortalTab()[j].getPortlets().getPortlet()[k].getContentBgColor());
							this.save(portletObject);
						}
						
					}
				}			
			}			
		}		
	}
	private void createDefaultPortalByGroup(String portalId, String title){
		String defaultRole = _ROLE_GROUP;
		Portal defaultPortal = getPortalByUserId(defaultRole);
		if(defaultPortal != null){
			String portalTitle= title;
			String portalTheme = _DEFAULT_THEME;
			if(portalTitle == null || "".equals(portalTitle.trim())) portalTitle = defaultPortal.getTitle();
			if(portalTheme == null || "".equals(portalTheme.trim())) portalTheme = defaultPortal.getTheme();
			Portal existPortal = getPortalByUserId(portalId);
			if(existPortal != null) return;
			Portal portal = new Portal(portalId, portalTitle, portalTheme,defaultPortal.getShowLocaleBar());
			this.save(portal);		
		
			List<PortalTab> tabs = getPortalTabByUser(defaultRole);
			for(PortalTab tab : tabs){
				PortalTab newTab= new PortalTab(tab.getLabel()
											   ,tab.getUrl()
											   ,tab.getCloseable()
											   ,tab.getEditable()
											   ,tab.getMoveable()
											   ,tab.getAllowAddContent()
											   ,tab.getColor()
											   ,tab.getDefaulted()
											   ,tab.getBetween()
											   ,tab.getWidths()
											   ,tab.getPortletWindowType()
											   ,portalId
											   ,0);
				this.save(newTab);
				List<PortletObject> portletObjects = this.getPortletsByTab(tab.getId());
				for(PortletObject portletObject : portletObjects){
					PortletObject newPortletObject =new PortletObject(newTab.getId(), portletObject);
					this.save(newPortletObject);						   
				}
			}
		}			
	}
	public Portal getPortalByUserId(String userId){
		List<Portal> portals =this.getHibernateTemplate().find("from Portal where userId=?",userId);
		Portal portal = null;
		if(portals != null && portals.size() > 0) portal = portals.get(0);
		return portal;
	}
	
	private void createDefaultPortalByStore(String portalId, String title){
		String defaultRole = _ROLE_STORE;
		Portal defaultPortal = getPortalByUserId(defaultRole);
		if(defaultPortal != null){
			String portalTitle= title;
			String portalTheme = _DEFAULT_THEME;
			if(portalTitle == null || "".equals(portalTitle.trim())) portalTitle = defaultPortal.getTitle();
			if(portalTheme == null || "".equals(portalTheme.trim())) portalTheme = defaultPortal.getTheme();
			Portal existPortal = getPortalByUserId(portalId);
			if(existPortal != null) return;
			Portal portal = new Portal(portalId, portalTitle, portalTheme,defaultPortal.getShowLocaleBar());
			this.save(portal);		
		
			List<PortalTab> tabs = getPortalTabByUser(defaultRole);
			for(PortalTab tab : tabs){
				PortalTab newTab= new PortalTab(tab.getLabel()
											   ,tab.getUrl()
											   ,tab.getCloseable()
											   ,tab.getEditable()
											   ,tab.getMoveable()
											   ,tab.getAllowAddContent()
											   ,tab.getColor()
											   ,tab.getDefaulted()
											   ,tab.getBetween()
											   ,tab.getWidths()
											   ,tab.getPortletWindowType()
											   ,portalId
											   ,0);
				this.save(newTab);
				List<PortletObject> portletObjects = this.getPortletsByTab(tab.getId());
				for(PortletObject portletObject : portletObjects){
					PortletObject newPortletObject =new PortletObject(newTab.getId(), portletObject);
					this.save(newPortletObject);						   
				}
			}
		}			
	}
	private void createDefaultPortalByUser(String userId, String title, String theme, boolean isMember){
		Organization org = OrganizationThreadLocal.getOrg();
		if(org == null) org = this.getUserDao().getOrgById(1);
		String defaultRole = org.getRole();
		if(isMember) defaultRole = _ROLE_USER;			
		Portal defaultPortal = getPortalByUserId(defaultRole);
		if(defaultPortal != null){
			String portalTitle= title;
			String portalTheme = theme;
			if(portalTitle == null || "".equals(portalTitle.trim())) portalTitle = defaultPortal.getTitle();
			if(portalTheme == null || "".equals(portalTheme.trim())) portalTheme = defaultPortal.getTheme();
			Portal existPortal = getPortalByUserId(userId);
			if(existPortal != null) return;
			Portal portal = new Portal(userId, portalTitle, portalTheme,defaultPortal.getShowLocaleBar());
			this.save(portal);		
		
			List<PortalTab> tabs = getPortalTabByUser(defaultRole);
			for(PortalTab tab : tabs){
				PortalTab newTab= new PortalTab(tab.getLabel()
											   ,tab.getUrl()
											   ,tab.getCloseable()
											   ,tab.getEditable()
											   ,tab.getMoveable()
											   ,tab.getAllowAddContent()
											   ,tab.getColor()
											   ,0//tab.getDefaulted()
											   ,tab.getBetween()
											   ,tab.getWidths()
											   ,tab.getPortletWindowType()
											   ,userId
											   ,0);
				this.save(newTab);
				List<PortletObject> portletObjects = this.getPortletsByTab(tab.getId());
				for(PortletObject portletObject : portletObjects){
					PortletObject newPortletObject =new PortletObject(newTab.getId(), portletObject);
					this.save(newPortletObject);						   
				}
			}
			if(!isMember){
				//PortalUserRole userRole = new PortalUserRole(userId,_CHANNEL_FORUM);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_AD);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_SEARCH);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_CULTURE);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_RECIPE);
				//this.save(userRole);				
				//userRole = new PortalUserRole(userId,_CHANNEL_NEWS);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_ET);
				//this.save(userRole);
				//userRole = new PortalUserRole(userId,_CHANNEL_GAME);
				//this.save(userRole);
			}
		}			
	}
	
	private void createDefaultPortalByUser(String userId, String title, String theme, boolean isMember,int showLocale,String language, String region){
		String defaultRole = OrganizationThreadLocal.getOrg().getRole();
		if(isMember) defaultRole = _ROLE_USER;			
		Portal defaultPortal = getPortalByUserId(defaultRole);
		if(defaultPortal != null){
			String portalTitle= title;
			String portalTheme = theme;
			if(portalTitle == null || "".equals(portalTitle.trim())) portalTitle = defaultPortal.getTitle();
			if(portalTheme == null || "".equals(portalTheme.trim())) portalTheme = defaultPortal.getTheme();
			Portal existPortal = getPortalByUserId(userId);
			if(existPortal != null) return;
			Portal portal = new Portal(userId, portalTitle, portalTheme,showLocale);
			this.save(portal);		
			User user = this.getUserDao().getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
			//user.setPortalId(portal.getId());
			this.getUserDao().saveUser(user);
			List<PortalTab> tabs = getPortalTabByUser(defaultRole);
			for(PortalTab tab : tabs){
				PortalTab newTab= new PortalTab(tab.getLabel()
											   ,tab.getUrl()
											   ,tab.getCloseable()
											   ,tab.getEditable()
											   ,tab.getMoveable()
											   ,tab.getAllowAddContent()
											   ,tab.getColor()
											   ,0//.getDefaulted()
											   ,tab.getBetween()
											   ,tab.getWidths()
											   ,tab.getPortletWindowType()
											   ,userId
											   ,0);
				this.save(newTab);
				List<PortletObject> portletObjects = this.getPortletsByTab(tab.getId());
				for(PortletObject portletObject : portletObjects){
					PortletObject newPortletObject =new PortletObject(newTab.getId(), portletObject);
					this.save(newPortletObject);						   
				}
			}
		}			
	}
	
	private List<PortletObject> getPortletByTabAndName(String name, long tabId){
		Object[] params = new Object[2];
		params[0] = name;
		params[1] = tabId;
		List<PortletObject> list= this.getHibernateTemplate().find("select po from PortletObject po where po.name= ? and po.tabId= ?", params);		
		return list;
	}
		
	private void createDefaultRef(String userId, Portlets portlets){
		org.light.portal.portlet.config.Portlet[] portletArray = portlets.getPortlet();		
		for(int i=0;i<portletArray.length;i++){
			int refreshMode= 0;
			int editMode= 0;
			int helpMode= 0;
			int configMode= 0;
			int minimized = 1;
			int maximized = 1;
			int autoRefreshed= 0;
			int periodTime= 0;
			int allowJS= 0;
			int pageRefreshed= 0;
			int showNumber= 0;
			int showType= 0;
			int windowStatus =0;
			int mode = 0;
			int type = 0;
			String parameter= "";
			if(portletArray[i].getRefreshMode()) refreshMode = 1;
			if(portletArray[i].getEditMode()) editMode = 1;
			if(portletArray[i].getHelpMode()) helpMode = 1;
			if(portletArray[i].getConfigMode()) configMode = 1;
			if(portletArray[i].hasMinimized() && !portletArray[i].getMinimized()) minimized = 0;
			if(portletArray[i].hasMaximized() && !portletArray[i].getMaximized()) maximized = 0;
			if(portletArray[i].getAutoRefreshed()) autoRefreshed = 1;
			periodTime = portletArray[i].getPeriodTime();
			if(portletArray[i].getAllowJS()) allowJS = 1;
			if(portletArray[i].getPageRefreshed()) pageRefreshed = 1;
			showNumber = portletArray[i].getShowNumber();
			showType = portletArray[i].getShowType();
			windowStatus = portletArray[i].getWindowStatus();
			mode = portletArray[i].getMode();
			type = portletArray[i].getType();			
			if(portletArray[i].getParameter() != null){
				Parameter[] parameters = portletArray[i].getParameter();
				for(int p=0;p<parameters.length;p++){
					if(parameter.length() == 0)
						parameter= parameters[p].getName()+"="+parameters[p].getValue();
					else
						parameter+="&"+ parameters[p].getName()+"="+parameters[p].getValue();
				}				
			}
			
			if(portletArray[i].getRoles() != null && portletArray[i].getRoles().getRole() != null){
				for(int j=0;j<portletArray[i].getRoles().getRole().length;j++){
					String roleId = portletArray[i].getRoles().getRole()[j];
					PortletObjectRef roleBasedRef =this.getPortletRefByName(portletArray[i].getName());
					if(roleBasedRef == null){
						roleBasedRef = new PortletObjectRef(
															portletArray[i].getName()
														   ,portletArray[i].getPath()
														   ,portletArray[i].getTitle()
														   ,portletArray[i].getIcon()
														   ,portletArray[i].getUrl()
														   ,portletArray[i].getSubTag()
														   ,portletArray[i].getTag()
														   ,portletArray[i].getLanguage()
														   ,refreshMode
														   ,editMode
														   ,helpMode
														   ,configMode
														   ,minimized
														   ,maximized
														   ,portletArray[i].getWindowSkin()
														   ,autoRefreshed
														   ,periodTime
														   ,allowJS
														   ,pageRefreshed
														   ,showNumber
														   ,showType
														   ,windowStatus
														   ,mode
														   ,type
														   ,parameter
														   ,roleId);
					}else{
						roleBasedRef.setPath(portletArray[i].getPath());
						roleBasedRef.setLabel(portletArray[i].getTitle());
						roleBasedRef.setIcon(portletArray[i].getIcon());
						roleBasedRef.setUrl(portletArray[i].getUrl());
						roleBasedRef.setSubTag(portletArray[i].getSubTag());
						roleBasedRef.setTag(portletArray[i].getTag());
						roleBasedRef.setLanguage(portletArray[i].getLanguage());
						roleBasedRef.setRefreshMode(refreshMode);
						roleBasedRef.setEditMode(editMode);
						roleBasedRef.setHelpMode(helpMode);
						roleBasedRef.setConfigMode(configMode);
						roleBasedRef.setAutoRefreshed(autoRefreshed);
						roleBasedRef.setPeriodTime(periodTime);
						roleBasedRef.setAllowJS(allowJS);
						roleBasedRef.setPageRefreshed(pageRefreshed);
						roleBasedRef.setShowNumber(showNumber);
						roleBasedRef.setShowType(showType);
						roleBasedRef.setWindowStatus(windowStatus);
						roleBasedRef.setMode(mode);
						roleBasedRef.setType(type);
						roleBasedRef.setParameter(parameter);
						roleBasedRef.setUserId(roleId);
					}
					this.save(roleBasedRef);	
				}
			}else{
				PortletObjectRef ref =this.getPortletRefByName(portletArray[i].getName());
				if(ref == null){
					ref = new PortletObjectRef(
											portletArray[i].getName()
										   ,portletArray[i].getPath()
										   ,portletArray[i].getTitle()
										   ,portletArray[i].getIcon()
										   ,portletArray[i].getUrl()
										   ,portletArray[i].getSubTag()
										   ,portletArray[i].getTag()
										   ,portletArray[i].getLanguage()
										   ,refreshMode
										   ,editMode
										   ,helpMode
										   ,configMode
										   ,minimized
										   ,maximized
										   ,portletArray[i].getWindowSkin()
										   ,autoRefreshed
										   ,periodTime
										   ,allowJS
										   ,pageRefreshed
										   ,showNumber
										   ,showType
										   ,windowStatus
										   ,mode
										   ,type
										   ,parameter
										   ,userId);
				}else{
					ref.setPath(portletArray[i].getPath());
					ref.setLabel(portletArray[i].getTitle());
					ref.setIcon(portletArray[i].getIcon());
					ref.setUrl(portletArray[i].getUrl());
					ref.setSubTag(portletArray[i].getSubTag());
					ref.setTag(portletArray[i].getTag());
					ref.setLanguage(portletArray[i].getLanguage());
					ref.setRefreshMode(refreshMode);
					ref.setEditMode(editMode);
					ref.setHelpMode(helpMode);
					ref.setConfigMode(configMode);
					ref.setAutoRefreshed(autoRefreshed);
					ref.setPeriodTime(periodTime);
					ref.setAllowJS(allowJS);
					ref.setPageRefreshed(pageRefreshed);
					ref.setShowNumber(showNumber);
					ref.setShowType(showType);
					ref.setWindowStatus(windowStatus);
					ref.setMode(mode);
					ref.setType(type);
					ref.setParameter(parameter);
					ref.setUserId(userId);
				}   					
				this.save(ref);	
			}
		}
		
		List<ChannelRef> channelRefs  = this.getHibernateTemplate().find("from ChannelRef ref");
		if(channelRefs == null || channelRefs.size() == 0){	
			ChannelRef ref = new ChannelRef("channel_news","tab.title.news",0);
			this.save(ref);
			ref = new ChannelRef("channel_finance","tab.title.finance",0);
			this.save(ref);
			ref = new ChannelRef("channel_tech","tab.title.tech",0);
			this.save(ref);
			ref = new ChannelRef("channel_business","tab.title.business",0);
			this.save(ref);
			ref = new ChannelRef("channel_politics","tab.title.politics",0);
			this.save(ref);
			ref = new ChannelRef("channel_health","tab.title.health",0);
			this.save(ref);
			ref = new ChannelRef("channel_entertainment","tab.title.entertainment",0);
			this.save(ref);
			ref = new ChannelRef("channel_sports","tab.title.sports",0);
			this.save(ref);
			ref = new ChannelRef("channel_culture","tab.title.culture",0);
			this.save(ref);
			ref = new ChannelRef("channel_search","tab.title.search",0);
			this.save(ref);
			ref = new ChannelRef("channel_recipe","tab.title.recipe",0);
			this.save(ref);
			ref = new ChannelRef("channel_ad","tab.title.ad",0);
			this.save(ref);
			ref = new ChannelRef("channel_forum","tab.title.forum",1);
			this.save(ref);
			ref = new ChannelRef("channel_game","tab.title.game",0);
			this.save(ref);
		}
		
		List<ChatStatusRef> statusRefs  = this.getHibernateTemplate().find("from ChatStatusRef ref");
		if(statusRefs == null || statusRefs.size() == 0){			
			ChatStatusRef ref1 = new ChatStatusRef(1,"I am avaliable");
			this.save(ref1);
			ChatStatusRef ref2 = new ChatStatusRef(2,"I will be right back");
			this.save(ref2);
			ChatStatusRef ref3 = new ChatStatusRef(3,"I am busy");
			this.save(ref3);
			ChatStatusRef ref4 = new ChatStatusRef(4,"I am sleeping");
			this.save(ref4);
			ChatStatusRef ref5 = new ChatStatusRef(5,"I am away from my computer");
			this.save(ref5);
			ChatStatusRef ref6 = new ChatStatusRef(6,"I am invisible");
			this.save(ref6);
			ChatStatusRef ref0 = new ChatStatusRef(0,"I am sign off");
			this.save(ref0);
		}
				
		
		List<Organization> orgs  = this.getHibernateTemplate().find("from Organization ref");
		if(orgs == null || orgs.size() == 0){
			Organization org = new Organization(_DEFAULT_ORG_WEBID,_DEFAULT_ORG_VIRTUALHOST,_DEFAULT_ORG_MX,_DEFAULT_ORG_LOGO,_DEFAULT_ORG_LOGOICON,1);
			org.setType(0);
			this.save(org);
			List<ForumCategory> forumCategories  = this.getHibernateTemplate().find("from ForumCategory ref");
			if(forumCategories == null || forumCategories.size() == 0){
				ForumCategory ref = new ForumCategory("Light Portal","Light Portal Forum","en",org.getId(),0,1);
				ref.addForum(new Forum("general",false,1));
				this.save(ref);
			}	
			List<GroupCategory> categories  = this.getHibernateTemplate().find("from GroupCategory ref");
			if(categories == null || categories.size() == 0){
				GroupCategory ref0 = new GroupCategory("group.category.other",org.getId());
				this.save(ref0);
				GroupCategory ref1 = new GroupCategory("group.category.activities",org.getId());
				this.save(ref1);
				GroupCategory ref2 = new GroupCategory("group.category.automotive",org.getId());
				this.save(ref2);
				GroupCategory ref3 = new GroupCategory("group.category.business",org.getId());
				this.save(ref3);
				GroupCategory ref4 = new GroupCategory("group.category.cities",org.getId());
				this.save(ref4);
				GroupCategory ref5 = new GroupCategory("group.category.companies",org.getId());
				this.save(ref5);
				GroupCategory ref6 = new GroupCategory("group.category.computers",org.getId());
				this.save(ref6);
				GroupCategory ref7 = new GroupCategory("group.category.countries",org.getId());
				this.save(ref7);
				GroupCategory ref8 = new GroupCategory("group.category.cultures",org.getId());
				this.save(ref8);
				GroupCategory ref9 = new GroupCategory("group.category.entertainment",org.getId());
				this.save(ref9);
				GroupCategory ref10 = new GroupCategory("group.category.family",org.getId());
				this.save(ref10);
				GroupCategory ref11 = new GroupCategory("group.category.fun",org.getId());
				this.save(ref11);
				GroupCategory ref12 = new GroupCategory("group.category.fashion",org.getId());
				this.save(ref12);
				GroupCategory ref13 = new GroupCategory("group.category.film",org.getId());
				this.save(ref13);
				GroupCategory ref14 = new GroupCategory("group.category.food",org.getId());
				this.save(ref14);
				GroupCategory ref15 = new GroupCategory("group.category.games",org.getId());
				this.save(ref15);
				GroupCategory ref16 = new GroupCategory("group.category.gay",org.getId());
				this.save(ref16);
				GroupCategory ref17 = new GroupCategory("group.category.gov",org.getId());
				this.save(ref17);
				GroupCategory ref18 = new GroupCategory("group.category.health",org.getId());
				this.save(ref18);
				GroupCategory ref19 = new GroupCategory("group.category.hobbies",org.getId());
				this.save(ref19);
				GroupCategory ref20 = new GroupCategory("group.category.literature",org.getId());
				this.save(ref20);
				GroupCategory ref21 = new GroupCategory("group.category.money",org.getId());
				this.save(ref21);
				GroupCategory ref22 = new GroupCategory("group.category.music",org.getId());
				this.save(ref22);
				GroupCategory ref23 = new GroupCategory("group.category.nightlife",org.getId());
				this.save(ref23);
				GroupCategory ref24 = new GroupCategory("group.category.nonprofit",org.getId());
				this.save(ref24);
				
				GroupCategory ref26 = new GroupCategory("group.category.pets",org.getId());
				this.save(ref26);
				GroupCategory ref27 = new GroupCategory("group.category.places",org.getId());
				this.save(ref27);
				GroupCategory ref28 = new GroupCategory("group.category.prof",org.getId());
				this.save(ref28);
				GroupCategory ref29 = new GroupCategory("group.category.recreation",org.getId());
				this.save(ref29);
				GroupCategory ref30 = new GroupCategory("group.category.religion",org.getId());
				this.save(ref30);
				GroupCategory ref31 = new GroupCategory("group.category.schools",org.getId());
				this.save(ref31);
				GroupCategory ref32 = new GroupCategory("group.category.science",org.getId());
				this.save(ref32);
				GroupCategory ref33 = new GroupCategory("group.category.sorority",org.getId());
				this.save(ref33);
				
			}

		}
					
	}
		
	public List<PortalUserRole> getUserRole(long userId, String roleId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = roleId;
		List<PortalUserRole> list= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ? and userRole.roleId= ?", params);		
		return list;
	}
	
	public List<PortalUserRole> getUserRoles(long userId){
		List<PortalUserRole> list= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ? ", userId);		
		return list;
	}
	
	public List<PortalUserRole> getUserRole(long userId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = "role_%";
		List<PortalUserRole> list= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ? and userRole.roleId like ?", params);		
		return list;
	}
	public List<PortalUserRole> getUserChannel(long userId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = "channel_%";
		List<PortalUserRole> list= this.getHibernateTemplate().find("select userRole from PortalUserRole userRole where userRole.userId= ? and userRole.roleId like ?", params);		
		return list;
	}
	public List<UserKeyword> getUserKeywords(long userId){
		List<UserKeyword> list= this.getHibernateTemplate().find("select userKeyword from UserKeyword userKeyword where userKeyword.userId= ? and userKeyword.weight >= 100 order by userKeyword.weight asc", userId);		
		return list;
	}
	public UserKeyword getUserKeyword(String keyword,long userId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = keyword;
		List<UserKeyword> list= this.getHibernateTemplate().find("select userKeyword from UserKeyword userKeyword where userKeyword.userId= ? and userKeyword.keyword = ?", params);		
		UserKeyword userKeyword = null;
		if(list != null && list.size() > 0) userKeyword = list.get(0);
		return userKeyword;
	}
	public UserKeyword getUserKeywordById(long id){
		UserKeyword entity = (UserKeyword)this.getHibernateTemplate().get(UserKeyword.class,id);		
		return  entity;
	}
	public boolean isKeyword(String word){
		boolean keyword = true;		
		try{
			int number = Integer.parseInt(word);
			keyword = false;
		}catch(Exception e){}
		if(keyword){
			Object notKeyword = this.getHibernateTemplate().get(NotKeyword.class,word.toLowerCase());		
			if(notKeyword != null) keyword= false;			
		}
		if(keyword && word.toLowerCase().endsWith("s")){
			Object notKeyword = this.getHibernateTemplate().get(NotKeyword.class,word.toLowerCase().substring(0,word.length() - 1));		
			if(notKeyword != null) keyword= false;			
		}
		return keyword;
	}
	public NotKeyword getNotKeyword(String word){
		NotKeyword notKeyword = (NotKeyword)this.getHibernateTemplate().get(NotKeyword.class,word.toLowerCase());
		return notKeyword;
	}
	public List<NotKeyword> getNotKeywords(){
		List<NotKeyword> list= this.getHibernateTemplate().find("select notWord from NotKeyword notWord");
		return list;
	}
	public List<NotWord> getNotWords(){
		List<NotWord> list= this.getHibernateTemplate().find("select notWord from NotWord notWord");
		return list;
	}
	public NotWord getNotWord(String word){
		NotWord notKeyword = (NotWord)this.getHibernateTemplate().get(NotWord.class,word.toLowerCase());
		return notKeyword;
	}
	public InternalNews getInternalNewsById(long id){
		return (InternalNews)this.getHibernateTemplate().get(InternalNews.class,id);
	}
	public List<InternalNews> getInternalNews(long orgId){
		List<InternalNews> news = this.getHibernateTemplate().find("select news from InternalNews news where orgId=? order by id desc",orgId);
		return news;
	}
	private void createDefaultPortalSecurity(PortalSecurity portalSecurity){
		for(int i=0;i<portalSecurity.getRole().length;i++){
			int allowLookAndFeel = 0;
			int allowLayout = 0;
			int allowAddTab = 0;
			int allowAddContent = 0;
			int allowSignIn = 0;
			int allowTurnOff = 0;
			String title = "";
			String theme = "";
			if(portalSecurity.getRole(i).getAllowLookAndFeel()) allowLookAndFeel = 1;
			if(portalSecurity.getRole(i).getAllowLayout()) allowLayout = 1;
			if(portalSecurity.getRole(i).getAllowAddTab()) allowAddTab = 1;
			if(portalSecurity.getRole(i).getAllowAddContent()) allowAddContent = 1;
			if(portalSecurity.getRole(i).getAllowSignIn()) allowSignIn = 1;
			if(portalSecurity.getRole(i).getAllowTurnOff()) allowTurnOff = 1;
			if(portalSecurity.getRole(i).getTitle() != null) title = portalSecurity.getRole(i).getTitle();
			if(portalSecurity.getRole(i).getTheme() != null) theme = portalSecurity.getRole(i).getTheme();
			
			PortalRole portalRole = new PortalRole(portalSecurity.getRole(i).getName()
										,allowLookAndFeel
										,allowLayout
										,allowAddTab
										,allowAddContent
										,allowSignIn
										,allowTurnOff
										,title
										,theme);
			this.save(portalRole);
		    
			if(portalSecurity.getRole(i).getUsers() != null){
				for(int j=0;j<portalSecurity.getRole(i).getUsers().getUser().length;j++){
					String roleId = portalSecurity.getRole(i).getName();
					String userId = portalSecurity.getRole(i).getUsers().getUser(j).getName();
					User user = this.getUserDao().getUserByUserId(userId,1);
					if(user == null){
						String name = "";
						if(portalSecurity.getRole(i).getUsers().getUser(j).getFirstName() != null)
							name = portalSecurity.getRole(i).getUsers().getUser(j).getFirstName();
						if(portalSecurity.getRole(i).getUsers().getUser(j).getMiddleName() != null)
							name +=" "+ portalSecurity.getRole(i).getUsers().getUser(j).getMiddleName();
						if(portalSecurity.getRole(i).getUsers().getUser(j).getLastName() != null)
							name +=" "+ portalSecurity.getRole(i).getUsers().getUser(j).getLastName();
						User newUser = new UserEntity(portalSecurity.getRole(i).getUsers().getUser(j).getName()
										    ,portalSecurity.getRole(i).getUsers().getUser(j).getPassword()
										    ,name
										    ,portalSecurity.getRole(i).getUsers().getUser(j).getEmail()
										    ,1
										    );
						Md5PasswordEncoder encoder = new Md5PasswordEncoder();  
						String ePassword = encoder.encodePassword(newUser.getPassword(), null);		
						newUser.setPassword(ePassword);
						user = this.getUserDao().createUser(newUser);						
						String displayName = user.getDisplayName();
						Chat chat = new Chat(user.getId(),ChatStatusRef.ONLINE,ChatStatusRef.OFFLINE);
						this.save(chat);							
						this.createDefaultPortalByUser(user.getUserId(), title, theme,_DEFAULT_ROLE.equals(roleId) ? false : true);
					}
					
					List<PortalUserRole> userRoles = this.getUserRole(user.getId(),roleId);
					if(userRoles == null || userRoles.size() == 0){
						PortalUserRole userRole = new PortalUserRole(user.getId(),roleId);
						this.save(userRole);
					}
				}
			}
		}
	}
}