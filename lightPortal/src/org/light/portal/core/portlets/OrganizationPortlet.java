package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._ROLE_STORE;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.OrgProfile;
import org.light.portal.model.Organization;
import org.light.portal.model.PortalTab;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.StringUtils;


public class OrganizationPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {	
		 String action = request.getParameter("action");
		 if("add".equals(action)){
			 String webId = request.getParameter("webId");
			 String virtualHost = request.getParameter("virtualHost");
			 String mx = request.getParameter("mx");	
			 String logoUrl = request.getParameter("logoUrl");	
			 String logoIcon = request.getParameter("logoIcon");
			 String view= request.getParameter("view");
			 String maxView = request.getParameter("maxView");
			 if(webId == null ||"".equals(webId) 
			   || virtualHost == null ||"".equals(virtualHost) 
			   || mx == null ||"".equals(mx)){
	        	  request.setAttribute("error", "Please input required fields.");
	              return;
	          }
			 if(!StringUtils.isEmpty(view)) view = URLDecoder.decode(view,_CHARSET_UTF);
			 if(!StringUtils.isEmpty(maxView)) maxView = URLDecoder.decode(maxView,_CHARSET_UTF);	
			 if(!StringUtils.isEmpty(logoUrl)) logoUrl = URLDecoder.decode(logoUrl,_CHARSET_UTF);
			 if(!StringUtils.isEmpty(logoIcon)) logoIcon = URLDecoder.decode(logoIcon,_CHARSET_UTF);
			 Organization org = new Organization(webId,virtualHost,mx,logoUrl,logoIcon);
			 OrgProfile profile = new OrgProfile((String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE),view,maxView);
			 this.getUserService(request).createOrganization(org,profile);
			 request.setAttribute("success", String.format("Organizaation %s have been added successfully.",org.getWebId()));
			 response.setPortletMode(PortletMode.VIEW);
		 } else if("modify".equals(action)){
			 String id = request.getParameter("orgId");
			 String webId = request.getParameter("webId");
			 String virtualHost = request.getParameter("virtualHost");
			 String mx = request.getParameter("mx");
			 String logoUrl = request.getParameter("logoUrl");	
			 String logoIcon = request.getParameter("logoIcon");
			 String view= request.getParameter("view");
			 String maxView = request.getParameter("maxView");
			 if(webId == null ||"".equals(webId) 
			   || virtualHost == null ||"".equals(virtualHost) 
			   || mx == null ||"".equals(mx)
			   ){
	        	  request.setAttribute("error", "Please input required fields.");
	              return;
	          }
			 if(!StringUtils.isEmpty(view)) view = URLDecoder.decode(view,_CHARSET_UTF);
			 if(!StringUtils.isEmpty(maxView)) maxView = URLDecoder.decode(maxView,_CHARSET_UTF);	
			 if(!StringUtils.isEmpty(logoUrl)) logoUrl = URLDecoder.decode(logoUrl,_CHARSET_UTF);
			 if(!StringUtils.isEmpty(logoIcon)) logoIcon = URLDecoder.decode(logoIcon,_CHARSET_UTF);
			 long orgId = Long.parseLong(id);
			 Organization org = this.getUserService(request).getOrgById(orgId);
			 org.setWebId(webId);
			 org.setVirtualHost(virtualHost);
			 org.setMx(mx);
			 org.setLogoUrl(logoUrl);
			 org.setLogoIcon(logoIcon);
			 this.getPortalService(request).save(org);
			 OrgProfile profile = this.getUserService(request).getOrgProfileByOrgId(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE));
			 if(profile == null){
				 profile = new OrgProfile(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE),view,maxView);				 
			 }else{				 
				 profile.setView(view);
				 profile.setMaxView(maxView);
			 }
			 this.getPortalService(request).save(profile);
			 request.setAttribute("success", String.format("Organizaation %s have been modified successfully.",org.getWebId()));
			 response.setPortletMode(PortletMode.VIEW);
		 }else if("addStore".equals(action)){
			 String webId = request.getParameter("webId");
			 String virtualHost = request.getParameter("virtualHost");
			 String mx = request.getParameter("mx");	
			 String logoUrl = request.getParameter("logoUrl");	
			 String logoIcon = request.getParameter("logoIcon");
			 String view= request.getParameter("view");
			 String maxView = request.getParameter("maxView");
			 if(webId == null ||"".equals(webId) 
			   || virtualHost == null ||"".equals(virtualHost) 
			   || mx == null ||"".equals(mx)
			   ){
	        	  request.setAttribute("error", "Please input required fields.");
	              return;
	          }
			 if(view != null) view = URLDecoder.decode(view,_CHARSET_UTF);
			 if(maxView != null) maxView = URLDecoder.decode(maxView,_CHARSET_UTF);	
			 if(logoUrl != null) logoUrl = URLDecoder.decode(logoUrl,_CHARSET_UTF);
			 if(logoIcon != null) logoIcon = URLDecoder.decode(logoIcon,_CHARSET_UTF);
			 Organization org = new Organization(webId,virtualHost,mx,logoUrl,logoIcon);
			 org.setType(2);
			 org.setRole(_ROLE_STORE);
			 OrgProfile profile = new OrgProfile((String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE),view,maxView);
			 this.getUserService(request).createOrganization(org,profile);
			 request.setAttribute("success", String.format("Organizaation %s have been added successfully.",org.getWebId()));
			 response.setPortletMode(PortletMode.VIEW);
		 } else if("modifyStore".equals(action)){
			 String id = request.getParameter("orgId");
			 String webId = request.getParameter("webId");
			 String virtualHost = request.getParameter("virtualHost");
			 String mx = request.getParameter("mx");
			 String logoUrl = request.getParameter("logoUrl");	
			 String logoIcon = request.getParameter("logoIcon");
			 String view= request.getParameter("view");
			 String maxView = request.getParameter("maxView");
			 if(webId == null ||"".equals(webId) 
			   || virtualHost == null ||"".equals(virtualHost) 
			   || mx == null ||"".equals(mx)
			   ){
	        	  request.setAttribute("error", "Please input required fields.");
	              return;
	          }
			 if(view != null) view = URLDecoder.decode(view,_CHARSET_UTF);
			 if(maxView != null) maxView = URLDecoder.decode(maxView,_CHARSET_UTF);	
			 if(logoUrl != null) logoUrl = URLDecoder.decode(logoUrl,_CHARSET_UTF);
			 if(logoIcon != null) logoIcon = URLDecoder.decode(logoIcon,_CHARSET_UTF);
			 long orgId = Long.parseLong(id);
			 Organization org = this.getUserService(request).getOrgById(orgId);
			 org.setWebId(webId);
			 org.setVirtualHost(virtualHost);
			 org.setMx(mx);
			 org.setLogoUrl(logoUrl);
			 org.setLogoIcon(logoIcon);
			 this.getPortalService(request).save(org);
			 OrgProfile profile = this.getUserService(request).getOrgProfileByOrgId(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE));
			 if(profile == null){
				 profile = new OrgProfile(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE),view,maxView);				 
			 }else{				 
				 profile.setView(view);
				 profile.setMaxView(maxView);
			 }
			 this.getPortalService(request).save(profile);
			 request.setAttribute("success", String.format("Organizaation %s have been modified successfully.",org.getWebId()));
			 response.setPortletMode(PortletMode.VIEW);
		 }else if("delete".equals(action)){
			 String id = request.getParameter("orgId");
			 Organization org = this.getUserService(request).getOrgById(Long.parseLong(id));
			 org.setStatus(-1);
			 this.getPortalService(request).save(org); 
		 }
	 }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 request.setAttribute("orgs",this.getUserService(request).getOrganizations());
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/orgManage.jsp").include(request,response);
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String id = request.getParameter("orgId");
		 if(id != null){
			 long orgId = Long.parseLong(id);
			 Organization org = this.getUserService(request).getOrgById(orgId);
			 request.setAttribute("org",org);
			 OrgProfile profile = this.getUserService(request).getOrgProfileByOrgId(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE));			 
			 request.setAttribute("org",org);
			 request.setAttribute("orgProfile",profile);
			 List<PortalTab> tabs = this.getPortalService(request).getPortalTabByUser(org.getDefaultUserId(),org.getId());
			 request.setAttribute("tabs",tabs);
		 }
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/orgDetail.jsp").include(request,response);  
	 }
}