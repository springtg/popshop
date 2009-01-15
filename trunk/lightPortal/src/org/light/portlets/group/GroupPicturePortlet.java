package org.light.portlets.group;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

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
import org.light.portal.model.UserPicture;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class GroupPicturePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("profile".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
			   GroupPicture picture= this.getGroupService(request).getGroupPictureById(Integer.parseInt(pictureId));
			   if(picture != null){
				   Group group = this.getVisitedGroup(request);
				   if(group != null){
					   group.setPhotoUrl(picture.getPictureUrl());
					   group.setPhotoWidth(picture.getPictureWidth());
					   group.setPhotoHeight(picture.getPictureHeight());
					   group.setCaption(picture.getCaption());
					   this.getPortalService(request).save(group);
					   request.setAttribute("success", "This Group profile's defalut photo has been set successfully, please refresh Profile window to see the new setting.");
				   }else
					   request.setAttribute("error", "System cannot find this group.");	
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		   
		   }else
			   request.setAttribute("error", "Please pick a picture first.");				   
		}
		if("background".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
			   GroupPicture picture= this.getGroupService(request).getGroupPictureById(Integer.parseInt(pictureId));
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
	   if("caption".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
			   GroupPicture picture= this.getGroupService(request).getGroupPictureById(Integer.parseInt(pictureId));
			   if(picture != null){				   
				   request.setAttribute("picture",picture);
				   response.setPortletMode(PortletMode.EDIT);
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		 
		   }else
			   request.setAttribute("error", "Please pick a picture first.");	
		}
	   if("save".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   String caption = request.getParameter("caption");
		   if(pictureId != null){
			   GroupPicture picture= this.getGroupService(request).getGroupPictureById(Integer.parseInt(pictureId));
			   if(picture != null){				   
				   picture.setCaption(caption);
				   this.getPortalService(request).save(picture);
				   Group group = this.getVisitedGroup(request);
				   if(group != null && picture.getPictureUrl().equals(group.getPhotoUrl())){
					   group.setCaption(caption);
					   this.getPortalService(request).save(group);
				   }					   
				   request.setAttribute("success", "This picture's caption has been saved successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		 
		   }
	   }
	   if("delete".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   if(pictureId != null){
		   GroupPicture picture= this.getGroupService(request).getGroupPictureById(Integer.parseInt(pictureId));
		   if(picture != null){	
			   this.deleteFile(request,picture.getPictureUrl());
			   this.getPortalService(request).delete(picture);			   
			   request.setAttribute("success", "This picture has been deleted successfully.");
		   }else
			   request.setAttribute("error", "System cannot find this picture.");		 
	   }else
		   request.setAttribute("error", "Please pick a picture first.");
		}
	   if("config".equals(action)){
			String items = request.getParameter("items");
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){			
				portlet.setShowNumber(Integer.parseInt(items));
				this.getPortalService(request).save(portlet);
			}
			String columns = request.getParameter("columns");
			PortletPreferences portletPreferences = request.getPreferences();
			portletPreferences.reset("columns");
			portletPreferences.setValue("columns",columns);		   
			portletPreferences.store();

			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String clientWidth = request.getParameter("portletClientWidth");		 
		 String groupId = request.getParameter("groupId");
		 if(groupId != null){
			 //check user is group member or not
			 int id = Integer.parseInt(groupId);
			 if(this.getGroupService(request).getUserGroup(this.getUser(request).getId(),id) != null){
				 List<GroupPicture> groupPictures = (List<GroupPicture>)request.getPortletSession().getAttribute("groupPictures",PortletSession.APPLICATION_SCOPE);
				 int index = 0;
				 if(groupPictures == null){
					 groupPictures = this.getGroupService(request).getGroupPictures(id);
					 request.getPortletSession().setAttribute("groupPictures", groupPictures, PortletSession.APPLICATION_SCOPE);
					 request.getPortletSession().setAttribute("groupPicturesIndex", 0, PortletSession.APPLICATION_SCOPE);
				 }else{
					 index = (Integer)request.getPortletSession().getAttribute("groupPicturesIndex", PortletSession.APPLICATION_SCOPE);
					 index++;
					 if(index >= groupPictures.size()) index=0;
					 request.getPortletSession().setAttribute("groupPicturesIndex", index, PortletSession.APPLICATION_SCOPE);
				 }

				 int pictureCount =0;				 
				 List<GroupPicture> showPictures = new ArrayList<GroupPicture>();
				 String pictureId = request.getParameter("pictureId");
				 PortletPreferences portletPreferences = request.getPreferences();
				 String columns = portletPreferences.getValue("columns","4");
				 int column=Integer.parseInt(columns);
				 int showNumber = column;
				 if(groupPictures != null && groupPictures.size() > 0) {
					 pictureCount=groupPictures.size();
					 if(pictureId == null){
						 request.setAttribute("currentPictureUrl",groupPictures.get(0).getPictureUrl());
						 request.setAttribute("currentCaption",groupPictures.get(0).getCaption());
						 request.setAttribute("currentPictureId",groupPictures.get(0).getId());
						 request.setAttribute("currentPictureWidth",groupPictures.get(0).getLargeWidth());
						 request.setAttribute("currentPictureHeight",groupPictures.get(0).getLargeHeight());
					 }else{
						 int id2= Integer.parseInt(pictureId);
						 for(GroupPicture up : groupPictures){
							 if(up.getId() == id2){
								 request.setAttribute("currentPictureUrl",up.getPictureUrl());
								 request.setAttribute("currentCaption",up.getCaption());
								 request.setAttribute("currentPictureId",up.getId());
								 request.setAttribute("currentPictureWidth",up.getLargeWidth());
								 request.setAttribute("currentPictureHeight",up.getLargeHeight());
								 break;
							 }					
						 }
					 }
					 
					 PortletObject portlet =getPortlet(request);
					 int width =0;
					 if(clientWidth != null && !request.getWindowState().equals(WindowState.MAXIMIZED)) width =Integer.parseInt(clientWidth);
					 if(portlet == null){
						 for(int i=0;i<groupPictures.size();i++){
							 GroupPicture pic = groupPictures.get(i);					 
							 pic.setStandardSmallWidth(width,Integer.parseInt(columns));
							 showPictures.add(pic);
						 }
					 }else{
						 if(portlet.getAutoRefreshed() == 0 && portlet.getShowNumber() > 0){
							 showNumber = portlet.getShowNumber();
							 for(int i=0;i<groupPictures.size();i++){
								 if(i>=showNumber) break;
								 GroupPicture pic = groupPictures.get(i);					 
								 pic.setStandardSmallWidth(width,Integer.parseInt(columns));
								 showPictures.add(pic);
							 }
						 }
						 else{
							 GroupPicture pic = groupPictures.get(index);
							 if(clientWidth != null && !request.getWindowState().equals(WindowState.MAXIMIZED))
								 pic.setStandardSmallWidth(width);
							 showPictures.add(pic);
						 }
					 }
				 }
				 Group group = this.getGroupService(request).getGroupById(id);
				 request.setAttribute("group",group);
				 if(pictureCount > showNumber)
					 request.setAttribute("showMore",true);
				 request.setAttribute("pictureCount",pictureCount);
				 request.setAttribute("showPictures",showPictures);
				 request.setAttribute("groupPictures",groupPictures);				 
				 request.setAttribute("columnNumber",column);
				 if(request.getWindowState().equals(WindowState.MAXIMIZED))
					 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPicturePortletMaxView.jsp").include(request,response);  
				 else
					 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPicturePortletView.jsp").include(request,response);  						
			 }else{
				 request.setAttribute("error", "The Group Pictures are only available for group members to view.");	
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/error/error.jsp").include(request,response);  					
			 }
		 }else{
			 request.setAttribute("error", "System cannot find this group.");	
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/error/error.jsp").include(request,response);
		 }
		
	 }	
    
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPicturePortletEdit.jsp").include(request,response);  
		 	
	 }	
	 
	 protected void doConfig (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 PortletPreferences portletPreferences = request.getPreferences();
		 String columns = portletPreferences.getValue("columns","2");
		 int column=Integer.parseInt(columns);
		 int showNumber = column;
		 PortletObject portlet = this.getPortlet(request);
		 if(portlet != null && portlet.getShowNumber() > showNumber)
			 showNumber = portlet.getShowNumber();		
		 request.setAttribute("showNumber",showNumber);			 
		 request.setAttribute("columnNumber",column);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPicturePortletConfig.jsp").include(request,response);		 		
	 }	
}
