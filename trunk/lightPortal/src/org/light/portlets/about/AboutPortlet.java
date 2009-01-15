package org.light.portlets.about;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class AboutPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    //throw new PortletException("processAction method not implemented");
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/about/aboutPortletView.jsp").include(request,response);
//		StringBuffer resultBuffer = new StringBuffer();	
//		resultBuffer.append("<embed")
//      .append(" src=\"http://realtime.amazon.com/swf/wishlistwidget.swf\"")
//      .append(" allowScriptAccess=\"never\"")
//      .append(" quality='high'")
//		.append(" bgcolor='&#035;FFFFFF'")
//		.append(" width=\"225\"")
//		.append(" height=\"265\"")
//		.append(" name=\"_po_wishlistwidget\"")
//		.append(" align=\"\"")
//		.append(" type=\"application/x-shockwave-flash\"")
//		.append(" pluginspage=\"http://www.macromedia.com/go/getflashplayer\"")
//		.append(" FlashVars=\"wishlist_id=3ALACW9W4C56U&service_host=realtime.amazon.com\" />")
//		;
//		
//		response.getWriter().print(resultBuffer.toString());
	 }	


}

