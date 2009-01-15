package org.light.portlets.ad;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.blog.Blog;
import org.light.portlets.forum.ForumPost;

public class AdViewPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
	String action = request.getParameter("action");	
	if("delete".equals(action)){
		String id = request.getParameter("parameter");
		ForumPost forum = this.getForumService(request).getPostById(Integer.parseInt(id));
		if(forum != null){
			this.getPortalService(request).delete(forum);	
		}
	}
	if("config".equals(action)){
		String items = request.getParameter("items");
		String type = request.getParameter("newType");
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){			
			portlet.setShowNumber(Integer.parseInt(items));
			portlet.setParameter("type="+type);
			this.getPortalService(request).save(portlet);
		}
		//request.setAttribute("mode",PortletMode.VIEW.toString());
		response.setPortletMode(PortletMode.VIEW);
	}
  }
 
 protected void doView (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {
	 String adId = request.getParameter("adId");
	 if(adId == null){
		 PortletObject portlet = this.getPortlet(request);
		 String type = portlet.getParameter();
		 if(type != null && type.trim().length() > 0) type = type.substring(type.length() - 1);
		 if(type == null || type.trim().length() <= 0) type ="1";
		 int showNumber = portlet.getShowNumber();
		 if(showNumber <=0) showNumber = 6;
		 
		 List<CategoryAd> list = this.getAdService(request).getAdsByType(type,showNumber);
		 request.setAttribute("type",type);
		 request.setAttribute("showNumber",showNumber);
		 request.setAttribute("adLists",list);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/ad/adViewPortletView.jsp").include(request,response);
	 }else{		 
		 CategoryAd ad = this.getAdService(request).getAdById(Integer.parseInt(adId));
		 request.setAttribute("ad",ad);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/ad/adPortletDetail.jsp").include(request,response);
	 }
 }	
 
 protected void doEdit (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {  		 	 	
	 PortletObject portlet = this.getPortlet(request);
	 String type = portlet.getParameter();
	 if(type != null && type.trim().length() > 0) type = type.substring(type.length() - 1);
	 int showNumber = portlet.getShowNumber();
	 if(showNumber <=0) showNumber = 6;
	 request.setAttribute("type",type);
	 request.setAttribute("showNumber",showNumber);
	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/ad/adViewPortletEdit.jsp").include(request,response);		
 }

}

