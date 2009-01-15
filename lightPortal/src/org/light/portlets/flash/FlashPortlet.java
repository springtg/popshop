package org.light.portlets.flash;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Jun 2, 2007
 **/
public class FlashPortlet extends LightGenericPortlet {
	
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
	 String action = request.getParameter("action");
	 if("edit".equals(action)){	
  	   String name = request.getParameter("name");
  	   String width = request.getParameter("width");
  	   String height = request.getParameter("height");  	   
  	   if( name == null || name.length() <= 0){
			   request.setAttribute("error","Please input all required fields.");
			   request.setAttribute("mode","edit");
			   return;
		   }
  	   if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);	    	    	  
  	   PortletPreferences portletPreferences = request.getPreferences();
  	   portletPreferences.setValue("name",name);	
		   portletPreferences.setValue("width",width);	
		   portletPreferences.setValue("height",height);
		   portletPreferences.store();		 
     }
	}
	
	protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		PortletPreferences portletPreferences = request.getPreferences();
		String name = portletPreferences.getValue("name",null);
		String width = portletPreferences.getValue("width","300");
		String height = portletPreferences.getValue("height","300");
		request.setAttribute("name",name);
		request.setAttribute("width",width);
		request.setAttribute("height",height);
		if(name != null)
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashPortletView.jsp").include(request,response);
		else
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashPortletEdit.jsp").include(request,response);
	 }
	
	protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		PortletPreferences portletPreferences = request.getPreferences();
		String name = portletPreferences.getValue("name",null);
		String width = portletPreferences.getValue("width",null);
		String height = portletPreferences.getValue("height",null);
		request.setAttribute("name",name);
		request.setAttribute("width",width);
		request.setAttribute("height",height);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashPortletEdit.jsp").include(request,response);
	 }
}
