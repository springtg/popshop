package org.light.portlets.profile;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserFile;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserPicture;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class MyFilePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");				
		if("select".equals(action)){
			   String fileId = request.getParameter("fileId");
			   if(fileId != null){
				   UserFile file= this.getUserService(request).getUserFileById(Integer.parseInt(fileId));
				   if(file != null){				   
					   request.setAttribute("file",file);
					   response.setPortletMode(PortletMode.EDIT);
				   }else
					   request.setAttribute("error", "System cannot find this file.");		 
			   }else
				   request.setAttribute("error", "Please pick a file first.");	
		}
	   if("config".equals(action)){
			String items = request.getParameter("items");
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){			
				portlet.setShowNumber(Integer.parseInt(items));
				this.getPortalService(request).save(portlet);
			}			
			String status = request.getParameter("status");
			User user = this.getUser(request);
			if(user != null){
				user.setDefaultMusicStatus(Integer.parseInt(status));
				this.getUserService(request).saveUser(user);
			}

			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
	   if("save".equals(action)){
		   String fileId = request.getParameter("fileId");
		   String caption = request.getParameter("caption");
		   String status = request.getParameter("status");
		   if(caption != null) caption = URLDecoder.decode(caption,_CHARSET_UTF);		   
		   if(fileId != null){
			   UserFile file= this.getUserService(request).getUserFileById(Integer.parseInt(fileId));
			   if(file != null){				   
				   file.setCaption(caption);
				   file.setStatus(Integer.parseInt(status));
				   this.getPortalService(request).save(file);				   			  
				   request.setAttribute("success", "This file's caption has been saved successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this file.");		 
		   }
	   }
		
		if("delete".equals(action)){
			String fileId = request.getParameter("fileId");
		   if(fileId != null){
			   UserFile file= this.getUserService(request).getUserFileById(Integer.parseInt(fileId));
			   if(file != null){				  
				   this.deleteFile(request,file.getFileUrl());
				   this.getPortalService(request).delete(file);
				   request.setAttribute("success", "This file has been delete successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this file.");		 
		   }else
			   request.setAttribute("error", "Please pick a file first.");	
	   }
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
		 long userId=0;
		 if(user != null) userId= user.getId();
		 List<UserFile> userFiles = null;
	     if(this.getVisitedUser(request) != null)
	    	 userFiles = this.getUserService(request).getVisitedUserFiles(userId,this.getVisitedUser(request).getId());
		 else
			 userFiles = this.getUserService(request).getUserFiles(userId);
		 int fileCount =userFiles.size();
		 
		 if(!request.getWindowState().equals(WindowState.MAXIMIZED)){
			 PortletObject portlet =getPortlet(request);		 
			 int showNumber = 4;
			 List<UserFile> showFiles = new ArrayList<UserFile>();
			 if(portlet != null && portlet.getShowNumber() > 0){
				 showNumber = portlet.getShowNumber();
			 }
			 for(int i=0;i<userFiles.size();i++){
				 if(i>=showNumber) break;
				 showFiles.add(userFiles.get(i));
			 }

			 request.setAttribute("userFiles",showFiles);
		 }else{
			 request.setAttribute("userFiles",userFiles);
		 }
		 request.setAttribute("fileCount",fileCount);
		 
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletView.jsp").include(request,response);  
			
	 }	
    
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		 
		 if(request.getParameter("add") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletEdit.jsp").include(request,response);  		 
		 else if(request.getAttribute("file") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletEdit.jsp").include(request,response);
		 else{
			 PortletObject portlet = this.getPortlet(request);
			 int showNumber = 0;
			 if(portlet != null)
			    showNumber = portlet.getShowNumber();
			 if(showNumber <=0) showNumber = 6;
			 request.setAttribute("showNumber",showNumber);
			 String defaultPicStatus = "0";
			 User user = this.getUser(request);
			 if(user != null) defaultPicStatus = String.valueOf(user.getDefaultPictureStatus());
			 request.setAttribute("defaultPicStatus",Integer.parseInt(defaultPicStatus));
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletConfig.jsp").include(request,response);
		 }	
	 }	


}
