package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._CURRENT_LOCALE;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.OrgProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;

public class InfoPortlet  extends LightGenericPortlet  {
	
	protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		long orgId = OrganizationThreadLocal.getOrganizationId();			
		if(request.getPortletSession().getAttribute("orgId",PortletSession.APPLICATION_SCOPE) != null){
			orgId = (Long)request.getPortletSession().getAttribute("orgId",PortletSession.APPLICATION_SCOPE);
		}
		OrgProfile profile = this.getUserService(request).getOrgProfileByOrgId(orgId,(String)request.getPortletSession().getAttribute(_CURRENT_LOCALE, PortletSession.APPLICATION_SCOPE));			 
		if(profile != null){
			if(request.getWindowState().equals(WindowState.NORMAL))
				response.getWriter().print(profile.getView());
			if(request.getWindowState().equals(WindowState.MAXIMIZED))
				response.getWriter().print(profile.getMaxView());
		}
		
	 }

}
