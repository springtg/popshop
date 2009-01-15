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
package org.light.portal.tags;

import static org.light.portal.util.Constants._APPLICATION_CONFIG;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._CURRENT_TAB;
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_THEME;
import static org.light.portal.util.Constants._IS_SIGN_OUT;
import static org.light.portal.util.Constants._REMEMBER_LOCALE;
import static org.light.portal.util.Constants._REMEMBER_USER_ID;
import static org.light.portal.util.Constants._REMEMBER_USER_PASSWORD;
import static org.light.portal.util.Constants._DEFAULT_LANGUAGE;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.core.action.PortalConfigAction;
import org.light.portal.model.OrgProfile;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.User;
import org.light.portal.security.config.Application;
import org.light.portal.util.LabelBean;
import org.light.portal.util.OrganizationThreadLocal;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class PortalTag extends BaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		String theme =(String)pageContext.getSession().getAttribute("theme");
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();		
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		this.setVisitedUser(request,null);
		this.setVisitedPortal(request,null);
		this.setPortal(request,null);
		String browserInfo = request.getHeader("User-Agent");
		Cookie[] theCookies =((HttpServletRequest)pageContext.getRequest()).getCookies();
		String rememberId = null;
		String rememberPassword = null;
		String currentTab = "";
		String rememberLocale = null;
		if (theCookies != null) {
	        for (int i =0; i< theCookies.length; i++) {
	           Cookie aCookie = theCookies[i];
	           if(aCookie.getName().equals(_CURRENT_TAB)){
				   if(aCookie.getValue() != null){
					   currentTab =  aCookie.getValue();						   						  
				   }
	           }
	           if(aCookie.getName().equals(_REMEMBER_LOCALE)){
				   if(aCookie.getValue() != null) rememberLocale =  aCookie.getValue();
	           }
	           if(aCookie.getName().equals(_REMEMBER_USER_ID)){
				   if(aCookie.getValue() != null){
					   rememberId =  aCookie.getValue();						   						  
				   }
	           }
	           if(aCookie.getName().equals(_REMEMBER_USER_PASSWORD)){
				   if(aCookie.getValue() != null){
					   rememberPassword =  aCookie.getValue();						   						  
				   }
	           }
	           if(aCookie.getName().equals(_IS_SIGN_OUT)){
				   if(aCookie.getValue() != null){
					   rememberId = null;
					   rememberPassword =  null;
					   currentTab = "0";
				   }
	           }
	        }
	    }

		User user = this.getUser(request);
		if(user == null){			
			if(rememberId != null){
				int value = this.getUserService(request).login(rememberId,rememberPassword,OrganizationThreadLocal.getOrganizationId());
				if(value == 1){
					user = this.getUserService(request).getUserByUserId(rememberId,OrganizationThreadLocal.getOrganizationId());
					if(user != null){
						this.setUser(request,user);
					}
						
				}
			}
		}
		if(user == null){
			user = this.getUserService(request).getUserByUserId(OrganizationThreadLocal.getDefaultUserId(),OrganizationThreadLocal.getOrganizationId());//_DEFAULT_USER);
			this.setUser(request,user);
		}
		Portal portal = this.getPortal(request);		
		if(portal != null) theme = portal.getTheme();		
		if( theme == null) theme = _DEFAULT_THEME;
		if(browserInfo.indexOf("MSIE") > 0 ){
			theme+="/MSIE";
		}
		pageContext.getSession().setAttribute("theme",theme);
		
		Locale currentLocale = (Locale) Config.get(pageContext.getSession(),Config.FMT_LOCALE);
		if(currentLocale == null){
			String locale = _DEFAULT_LOCALE;
			if(user != null) 
				locale = user.getLanguage();
			else{
				Application appConfig = (Application)pageContext.getSession().getServletContext().getAttribute(_APPLICATION_CONFIG);
				if(appConfig.getDefaultLocale() != null) locale = appConfig.getDefaultLocale();			
				if(rememberLocale != null) locale = rememberLocale;	
			}
			String[] localeParams = locale.split("_");
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
			Config.set(pageContext.getSession(), Config.FMT_LOCALE, currentLocale);	
		}
		pageContext.getSession().setAttribute(_CURRENT_LOCALE,currentLocale.toString());	
	    PortalConfigAction action = new PortalConfigAction();	    
	    try{
	    	List<LabelBean> list = new LinkedList<LabelBean>();
	    	if(user != null && !user.getUserId().equals(OrganizationThreadLocal.getDefaultUserId()))//_DEFAULT_USER)) 
	    		list.add(new LabelBean("loginUserId",user.getUserId()));
	    	else
	    		list.add(new LabelBean("loginUserId","0"));
	    	String portalString = action.getPortal(request,response).toString();
	    	String pageRoot = action.getPortalTabsByUser(request,response).toString();	    	
	    	list.add(new LabelBean("portalString",portalString));
	    	list.add(new LabelBean("pageRoot",pageRoot));
	    	
	    	String[] currentTabIds = currentTab.split("-");
	    	PortalTab defaultTab = null;
	    	List<PortalTab> tabs = this.getPortalService(request).getPortalTabByUser(user.getUserId());
	    	if(tabs != null && tabs.size() > 0){
	    		for(int i=0;i<currentTabIds.length;i++){
	    			int tabId = -1;
		    		try{
		    			tabId = Integer.parseInt(currentTabIds[i]);
		    		}catch(Exception e){}
		    		if(tabId >= 0 && tabs.size() > tabId){
		    			defaultTab = tabs.get(tabId);
		    		}else{
			    		for(PortalTab tab : tabs){	    		
				    		if(tab.getDefaulted() == 1)
				    			defaultTab = tab;
				    	}
		    		}
		    		if(defaultTab == null) defaultTab = tabs.get(0);
		    		request.setAttribute("parentId",String.valueOf(defaultTab.getId()));
		    		list.add(new LabelBean("page"+defaultTab.getId(),action.getPortalTabsByParent(request,response).toString()));
			    	
		    		tabs = this.getPortalService(request).getPortalTabByParent(defaultTab.getId());
		    		if(tabs == null || tabs.size() == 0) break;
	    		}
	    		request.setAttribute("tabId",String.valueOf(defaultTab.getId()));
		    	String portletsString= action.getPortletsByTab(request,response).toString();		    	
		    	list.add(new LabelBean("page"+defaultTab.getId()+"Portlets",portletsString));	
	    	}	  
	    	request.setAttribute("list",list);
	    	readOrganization(request);
	    }catch(Exception e){
	    	throw new RuntimeException(e);
	    }
		return SKIP_BODY;
	}	
	private void readOrganization(HttpServletRequest request){	   
       request.setAttribute("orgTitle",OrganizationThreadLocal.getWebId());
       String logoIcon = OrganizationThreadLocal.getLogoIcon();       
       if(!logoIcon.startsWith("http")) logoIcon = request.getContextPath() + logoIcon;
       request.setAttribute("orgIcon",logoIcon);
	   long orgId = OrganizationThreadLocal.getOrganizationId();
	   OrgProfile orgProfile =this.getUserService(request).getOrgProfileByOrgId(orgId,(String)request.getSession().getAttribute(_CURRENT_LOCALE));	   
	   if(orgProfile == null){
		   orgProfile =this.getUserService(request).getOrgProfileByOrgId(orgId, _DEFAULT_LANGUAGE);
	   }
	   if(orgProfile != null){		  
		   request.setAttribute("orgView", orgProfile.getView());
		   request.setAttribute("orgMaxView", orgProfile.getMaxView());
	   }
	}
}



