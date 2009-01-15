package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PopularItem;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class PeopleOnlinePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
        if("config".equals(action)){
           String items = request.getParameter("items");
           PortletObject portlet =getPortlet(request);
           if(portlet != null){
               portlet.setShowNumber(Integer.parseInt(items));
               this.getPortalService(request).save(portlet);
           }
           String max = request.getParameter("maxItems");
           PortletPreferences portletPreferences = request.getPreferences();		 
   		   portletPreferences.setValue("maxViewed",max);
   		   portletPreferences.store();
           //request.setAttribute("mode",PortletMode.VIEW.toString());
           response.setPortletMode(PortletMode.VIEW);
       }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	 
		 int showNumber = 0;		 	 			
		 int start = 1;
		 int page = 1;	 
		 int total = this.getUserService(request).getOnlinePeopleTotal();
		 PortletPreferences portletPreferences = request.getPreferences();	
		 if(request.getWindowState().equals(WindowState.MAXIMIZED)){		   
		   String pageParam = request.getParameter("page"); 
		   String  max= portletPreferences.getValue("maxOnlineShow","100");
		   showNumber = Integer.parseInt(max);
		   if(pageParam != null) page = Integer.parseInt(pageParam);			   	       
	       int pages  = total / showNumber;
		   if(total % showNumber != 0) pages++;
		   if(page > pages) page = pages;
		   start = (page - 1) *  showNumber + 1;
		   if(start < 1)start = 1;
		   int end = start + showNumber - 1;
		   if(end > total) end = total;
		   request.setAttribute("page",page);
		   request.setAttribute("start",start);		   
		   request.setAttribute("end",end);
		   request.setAttribute("total",total);
		   request.setAttribute("pages",pages);
		 }else{
			 String normal= portletPreferences.getValue("normalOnlineShow","30");
			 showNumber = Integer.parseInt(normal);
		 }
		 List<User> users = this.getUserService(request).getOnlinePeople(start - 1,showNumber);		 
		 if(total > showNumber)
			 request.setAttribute("showMore",true);	 
		 request.setAttribute("onlinePeople",users);
		 request.setAttribute("userCount",users.size());
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/peopleOnlinePortletMaxView.jsp").include(request,response);
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/peopleOnlinePortletView.jsp").include(request,response);  
	 
	 }	

	 protected void doEdit (RenderRequest request, RenderResponse response)
     throws PortletException, java.io.IOException
   {

       PortletObject portlet = this.getPortlet(request);
       int showNumber = portlet.getShowNumber();
       if(showNumber <=0) showNumber = 6;
       request.setAttribute("showNumber",showNumber);
       PortletPreferences portletPreferences = request.getPreferences();		 
		String  max= portletPreferences.getValue("maxViewed","100");
		request.setAttribute("maxNumber",max);
       this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/peopleOnlinePortletEdit.jsp").include(request,response);

   }
}
