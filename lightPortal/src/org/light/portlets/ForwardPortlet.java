package org.light.portlets;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class ForwardPortlet extends LightGenericPortlet {
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		String url = request.getParameter("url");
		if(url != null){
			if(url != null) url = URLDecoder.decode(url,_CHARSET_UTF);	
			request.setAttribute("url",url);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/docViewer.jsp").include(request,response);  			  
			return;
		}
		PortletPreferences portletPreferences = request.getPreferences();
		String viewJSP = portletPreferences.getValue("view","");
		if(request.getWindowState().equals(WindowState.MAXIMIZED)){
			viewJSP =  portletPreferences.getValue("maximizedView",viewJSP);
		}
		this.getPortletContext().getRequestDispatcher(viewJSP).include(request,response);  
				
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		PortletPreferences portletPreferences = request.getPreferences();
		String editJSP = portletPreferences.getValue("edit","");
		this.getPortletContext().getRequestDispatcher(editJSP).include(request,response); 	
	 }	
	 
}

