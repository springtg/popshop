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
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_THEME;
//import static org.light.portal.util.Constants._DEFAULT_USER;
import static org.light.portal.util.Constants._REMEMBER_LOCALE;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.core.action.PortalConfigAction;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.User;
import org.light.portal.security.config.Application;
import org.light.portal.util.LabelBean;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.group.Group;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class PortalGroupTag extends BaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {		
		String theme =(String)pageContext.getSession().getAttribute("theme");
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();		
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		String browserInfo = request.getHeader("User-Agent");
		Group group = this.getVisitedGroup(request);
		Portal portal = this.getPortal(request);		
		User user = this.getUser(request);
		if(portal != null) theme = portal.getTheme();		
		if(theme == null) theme = _DEFAULT_THEME;
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
				Cookie[] theCookies =((HttpServletRequest)pageContext.getRequest()).getCookies();
				if (theCookies != null) {
			        for (int i =0; i< theCookies.length; i++) {
			           Cookie aCookie = theCookies[i];
			           if(aCookie.getName().equals(_REMEMBER_LOCALE)){
						   if(aCookie.getValue() != null) locale =  aCookie.getValue();
						   break;
			           }
			        }
			    }	
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
	    	if(user != null && !user.getUserId().equals(OrganizationThreadLocal.getDefaultUserId())) 
	    		list.add(new LabelBean("loginUserId",this.getUser(request).getUserId()));
	    	else
	    		list.add(new LabelBean("loginUserId","0"));
	    	list.add(new LabelBean("portalString",action.groupPortal(request,response).toString()));
	    	list.add(new LabelBean("pageRoot",action.getPortalTabsByGroup(request,response).toString()));
	    	List<PortalTab> tabs = getPortalService(request).getPortalTabByUser("group_"+group.getId());
	    	PortalTab defaultTab = null;
	    	while(tabs != null && tabs.size() > 0){
	    		defaultTab = tabs.get(0);
	    		request.setAttribute("parentId",String.valueOf(defaultTab.getId()));
	    		list.add(new LabelBean("page"+defaultTab.getId(),action.getPortalTabsByParent(request,response).toString()));
    			tabs = this.getPortalService(request).getPortalTabByParent(defaultTab.getId());
			}
	    	request.setAttribute("tabId",String.valueOf(defaultTab.getId()));
	    	list.add(new LabelBean("page"+defaultTab.getId()+"Portlets",action.getPortletsByGroupTab(request,response).toString()));
	    	request.setAttribute("list",list);
	    }catch(Exception e){
	    	throw new RuntimeException(e);
	    }
		return SKIP_BODY;
	}
}



