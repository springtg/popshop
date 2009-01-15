package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.ConfigurationUtil;
import org.light.portal.util.LabelBean;
import org.light.portal.util.Language;
import org.light.portal.util.LocaleUtil;
import org.light.portal.util.Region;

public class OptionsPortlet  extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
		
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
        User user = this.getUser(request);      
        request.setAttribute("user", user);
		String part = request.getParameter("action");
		request.setAttribute("current",part);		
		if(part == null) part= "general";
			
		if(part.equals("language")){
			List<Language> languages = LocaleUtil.getSupportedLanguages();
			int languageCount = languages.size();
			request.setAttribute("languageCount",languageCount);
			request.setAttribute("languages",languages);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsLanguage.jsp").include(request,response);
		}else if(part.equals("localContent")){
			List<Region> regions = LocaleUtil.getSupportedRegions();
			int regionCount = regions.size();
			request.setAttribute("regionCount",regionCount);
			request.setAttribute("regions",regions);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsLocalContent.jsp").include(request,response);
		}else if(part.equals("timeZone")){
			List<LabelBean> timeZones = LocaleUtil.getSupportedTimeZone();
			int timeZoneCount = timeZones.size();
			request.setAttribute("timeZoneCount",timeZoneCount);
			request.setAttribute("timeZones",timeZones);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsTimeZone.jsp").include(request,response);
		}else if(part.equals("theme")){	
			List<LabelBean> themes = ConfigurationUtil.getSupportedThemes();
			String locale = (String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE);
			String[] localeParams = locale.split("_");
			Locale currentLocale = null;
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
			for(LabelBean bean : themes){
				bean.setDesc(org.light.portal.util.MessageUtil.getMessage(bean.getDesc(),currentLocale));
			}
			request.setAttribute("themes",themes);
			Portal portal = this.getPortal(request);
			if(isAdmin(request,user) && this.getVisitedPortal(request) !=null) portal = this.getVisitedPortal(request);
			request.setAttribute("portal",portal); 
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsTheme.jsp").include(request,response);
	 	}else if(part.equals("page")){
	 		PortalTab portalTab = getPortalTab(request);
			request.setAttribute("tab",portalTab);
			List<LabelBean> windowSkins = ConfigurationUtil.getSupportedWindowSkins();
			String locale = (String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE);
			String[] localeParams = locale.split("_");
			Locale currentLocale = null;
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);for(org.light.portal.util.LabelBean bean : windowSkins){
			bean.setDesc(org.light.portal.util.MessageUtil.getMessage(bean.getDesc(),currentLocale));
			}
			request.setAttribute("windowSkins",windowSkins);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsPage.jsp").include(request,response);
	 	}else{	 		
	 		request.setAttribute("current","general");
	 		Portal portal = this.getPortal(request);
			if(isAdmin(request,user) && this.getVisitedPortal(request) !=null) portal = this.getVisitedPortal(request);
			request.setAttribute("portal",portal); 
			request.setAttribute("fonts",ConfigurationUtil.getSupportedFonts());
			request.setAttribute("fontSizes",ConfigurationUtil.getSupportedFontSizes());
			request.setAttribute("headerHeights",ConfigurationUtil.getSupportedHeaderHeights());
			request.setAttribute("maxShowTabsNumber",ConfigurationUtil.getMaxShowTabsNumber());
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/optionsGeneral.jsp").include(request,response);  
	 	}
			
	 }	

}

