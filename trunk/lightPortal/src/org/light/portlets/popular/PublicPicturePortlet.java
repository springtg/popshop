package org.light.portlets.popular;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserPicture;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class PublicPicturePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("background".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
			   UserPicture picture= this.getUserService(request).getUserPictureById(Integer.parseInt(pictureId));
			   if(picture != null){				   
				   Portal portal = this.getPortal(request);
				   portal.setBgImage(picture.getPictureUrl());
				   portal.setHeaderImage("no");
				   portal.setTransparent(0);
				   this.getPortalService(request).save(portal);
				   request.setAttribute("success", "Your portal's background has been set successfully, please refresh portal to see the new setting.");
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		 
		   }else
			   request.setAttribute("error", "Please pick a picture first.");	
	   }
		else if("header".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
			   UserPicture picture= this.getUserService(request).getUserPictureById(Integer.parseInt(pictureId));
			   if(picture != null){				   
				   Portal portal = this.getPortal(request);
				   portal.setHeaderImage(picture.getPictureUrl());
				   this.getPortalService(request).save(portal);
				   request.setAttribute("success", "Your portal's header picture has been set successfully, please refresh portal to see the new setting.");
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		 
		   }else
			   request.setAttribute("error", "Please pick a picture first.");	
	   }
		
		else if("config".equals(action)){
			String autoRefresh = request.getParameter("autoRefresh");
			String seconds = request.getParameter("seconds");
			String items = request.getParameter("items");
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){
				portlet.setAutoRefreshed(Integer.parseInt(autoRefresh));
				portlet.setPeriodTime(Integer.parseInt(seconds) * 1000);
				portlet.setShowNumber(Integer.parseInt(items));
				this.getPortalService(request).save(portlet);
			}
			String columns = request.getParameter("columns");			
			PortletPreferences portletPreferences = request.getPreferences();
			portletPreferences.reset("columns");
			portletPreferences.setValue("columns",columns);				
			portletPreferences.store();
			
			String status = request.getParameter("status");
			User user = this.getUser(request);
			if(user != null){
				user.setDefaultMusicStatus(Integer.parseInt(status));
				this.getUserService(request).saveUser(user);
			}
			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
		
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String clientWidth = request.getParameter("portletClientWidth");		 
		 User user = this.getUser(request);
		 List<UserPicture> publicPictures = (List<UserPicture>)request.getPortletSession().getAttribute("publicPictures",PortletSession.APPLICATION_SCOPE);
		 int index = 0;
		 int start = 0;
		 int max = 20;
		 if(publicPictures == null){
			 publicPictures = this.getPortalService(request).getPublicPictures(start,max);
			 request.getPortletSession().setAttribute("publicPictures", publicPictures, PortletSession.APPLICATION_SCOPE);
			 request.getPortletSession().setAttribute("publicPicturesIndex", 0, PortletSession.APPLICATION_SCOPE);
		 }else{
			 index = (Integer)request.getPortletSession().getAttribute("publicPicturesIndex", PortletSession.APPLICATION_SCOPE);
			 index++;
			 if(index >= publicPictures.size()) index=0;
			 request.getPortletSession().setAttribute("publicPicturesIndex", index, PortletSession.APPLICATION_SCOPE);
		 }

	     int pictureCount =0;
		 int showNumber = 1;
		 List<UserPicture> showPictures = new ArrayList<UserPicture>();
		 String pictureId = request.getParameter("pictureId");
		 if(publicPictures != null && publicPictures.size() > 0) {
			 pictureCount=publicPictures.size();
			 boolean found = false;
			 if(pictureId != null){
				 int id= Integer.parseInt(pictureId);				 
				 for(UserPicture up : publicPictures){
					 if(up.getId() == id){
						 if(up.isHttpUrl())
							 request.setAttribute("currentPictureUrl",up.getPictureUrl());
						 else
							 request.setAttribute("currentPictureUrl",request.getContextPath()+up.getPictureUrl());
						 request.setAttribute("currentCaption",up.getCaption());
						 request.setAttribute("currentPictureId",up.getId());
						 request.setAttribute("currentPictureWidth",up.getLargeWidth());
						 request.setAttribute("currentPictureHeight",up.getLargeHeight());
						 found = true;
						 break;
					 }					
				 }
			 }
			 if(!found){
				 if(publicPictures.get(index).isHttpUrl())
					 request.setAttribute("currentPictureUrl",publicPictures.get(index).getPictureUrl());
				 else
					 request.setAttribute("currentPictureUrl",request.getContextPath()+publicPictures.get(index).getPictureUrl());
				 request.setAttribute("currentCaption",publicPictures.get(index).getCaption());
				 request.setAttribute("currentPictureId",publicPictures.get(index).getId());
				 request.setAttribute("currentPictureWidth",publicPictures.get(index).getLargeWidth());
				 request.setAttribute("currentPictureHeight",publicPictures.get(index).getLargeHeight());
			 }

			 PortletObject portlet =getPortlet(request);	
			 if(portlet != null && portlet.getAutoRefreshed() == 0 && portlet.getShowNumber() > 0){
				 showNumber = portlet.getShowNumber();
				 start = 0;
				 if(request.getPortletSession().getAttribute("start",PortletSession.PORTLET_SCOPE) != null)
					 start = (Integer)request.getPortletSession().getAttribute("start",PortletSession.PORTLET_SCOPE);
				 if(request.getParameter("next") != null) start+=showNumber;
				 if(request.getParameter("previous") != null) start-=showNumber;
				 if(start < 0) start = publicPictures.size() - 1;
				 if(start > publicPictures.size() - 1) start = 0;
				 request.getPortletSession().setAttribute("start",start,PortletSession.PORTLET_SCOPE);
				 PortletPreferences portletPreferences = request.getPreferences();
				 String columns = portletPreferences.getValue("columns","1");
				 int width =0;
				 if(clientWidth != null && !request.getWindowState().equals(WindowState.MAXIMIZED)) width =new Double(clientWidth).intValue();
				 for(int i=start;i<publicPictures.size();i++){
					 if(i>=start + showNumber) break;
					 UserPicture pic = publicPictures.get(i);
					 pic.setStandardSmallWidth(width,Integer.parseInt(columns));
					 showPictures.add(pic);
				 }
			 }
			 else{
				 UserPicture pic = publicPictures.get(index);
				 if(clientWidth != null && !request.getWindowState().equals(WindowState.MAXIMIZED))					 
					 pic.setStandardSmallWidth(new Double(clientWidth).intValue());
				 showPictures.add(pic);
			 }
				 
		 }
		 if(pictureCount > showNumber)
			 request.setAttribute("showMore",true);
		 request.setAttribute("pictureCount",pictureCount);
		 request.setAttribute("showNumber",showNumber);
		 request.setAttribute("showPictures",showPictures);
		 request.setAttribute("userPictures",publicPictures);
		 PortletPreferences portletPreferences = request.getPreferences();
		 String columns = portletPreferences.getValue("columns","1");
		 request.setAttribute("columnNumber",Integer.parseInt(columns));
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/publicPicturePortletMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/publicPicturePortletView.jsp").include(request,response);  			
	 }	
    
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 PortletObject portlet = this.getPortlet(request);
		 request.setAttribute("portlet",portlet);
		 request.setAttribute("seconds",portlet.getPeriodTime() / 1000);
		 int showNumber = 0;
		 if(portlet != null)
		    showNumber = portlet.getShowNumber();
		 if(showNumber <=0) showNumber = 6;
		 request.setAttribute("showNumber",showNumber);
		 PortletPreferences portletPreferences = request.getPreferences();
		 String columns = portletPreferences.getValue("columns","1");
		 request.setAttribute("columnNumber",Integer.parseInt(columns));
		 String defaultPicStatus = "0";
		 User user = this.getUser(request);
		 if(user != null) defaultPicStatus = String.valueOf(user.getDefaultPictureStatus());
		 request.setAttribute("defaultPicStatus",Integer.parseInt(defaultPicStatus));
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/publicPicturePortletConfig.jsp").include(request,response);		
	 }	


}

