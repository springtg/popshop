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
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserPicture;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class MyMusicPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");		
		if("background".equals(action)){
		   String musicId = request.getParameter("musicId");
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){				   
				   User user = this.getUser(request);
				   user.setMusicUrl(music.getMusicUrl());
				   this.getUserService(request).saveUser(user);
				   request.setAttribute("success", "Your background Music has been set successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }else
			   request.setAttribute("error", "Please pick a music first.");	
	   }
		if("ring".equals(action)){
			   String musicId = request.getParameter("musicId");
			   if(musicId != null){
				   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
				   if(music != null){				   
					   User user = this.getUser(request);
					   user.setRingToneUrl(music.getMusicUrl());
					   this.getUserService(request).saveUser(user);
					   request.setAttribute("success", "Your Instant Message Ring Tone has been set successfully.");
				   }else
					   request.setAttribute("error", "System cannot find this music.");		 
			   }else
				   request.setAttribute("error", "Please pick a music first.");	
		   }
	   if("select".equals(action)){
		   String musicId = request.getParameter("musicId");
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){				   
				   request.setAttribute("music",music);
				   response.setPortletMode(PortletMode.EDIT);
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }else
			   request.setAttribute("error", "Please pick a music first.");	
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
		   String musicId = request.getParameter("musicId");
		   String caption = request.getParameter("caption");
		   String status = request.getParameter("status");
		   String rankable = request.getParameter("rankable");
		   if(caption != null) caption = URLDecoder.decode(caption,_CHARSET_UTF);		   
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){		
				   if(rankable != null && "1".equals(rankable))
					   music.setRankable(1);
				   else
					   music.setRankable(0);
				   music.setCaption(caption);
				   music.setStatus(Integer.parseInt(status));
				   this.getPortalService(request).save(music);				   			  
				   request.setAttribute("success", "This music's caption has been saved successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }
	   }
		if("rank".equals(action)){
			String musicId = request.getParameter("musicId");
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){				   
				   music.setRankable(1);
				   this.getPortalService(request).save(music);
				   request.setAttribute("success", "This music has been set to rank successfully, it's ready for public to rank.");
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }else
			   request.setAttribute("error", "Please pick a music first.");	
	   }
		if("play".equals(action)){
			String musicId = request.getParameter("parameter");
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){				   
				   request.setAttribute("musicUrl",music.getMusicUrl());
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }else
			   request.setAttribute("error", "Please pick a music first.");	
	   }
		if("stop".equals(action)){
			request.removeAttribute("musicUrl");	
	   }
		if("delete".equals(action)){
			String musicId = request.getParameter("musicId");
		   if(musicId != null){
			   UserMusic music= this.getUserService(request).getUserMusicById(Integer.parseInt(musicId));
			   if(music != null){
				   User user = this.getUser(request);
				   if(music.getMusicUrl().equals(user.getMusicUrl())){
					   user.setMusicUrl(null);
					   this.getUserService(request).saveUser(user);
				   }
				   if(music.getMusicUrl().equals(user.getRingToneUrl())){
					   user.setRingToneUrl(null);
					   this.getUserService(request).saveUser(user);
				   }
				   this.deleteFile(request,music.getMusicUrl());
				   this.getPortalService(request).delete(music);
				   request.setAttribute("success", "This music has been delete successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this music.");		 
		   }else
			   request.setAttribute("error", "Please pick a music first.");	
	   }
		if("addUrl".equals(action)){
			String musicUrl = request.getParameter("musicUrl");
			if(musicUrl == null ||"".equals(musicUrl) ){
				request.setAttribute("error", "Please input music URL.");
				request.setAttribute("add","true");
				response.setPortletMode(PortletMode.EDIT);
				return;
	        }
			if(musicUrl != null) musicUrl = URLDecoder.decode(musicUrl,_CHARSET_UTF);
			String musicCaption = request.getParameter("musicCaption");
			if(musicCaption != null) 
				musicCaption = URLDecoder.decode(musicCaption,_CHARSET_UTF);
			else
				musicCaption = musicUrl;
			User user = this.getUser(request);
			int status = 0;			
			if(user != null) status = user.getDefaultMusicStatus();
			UserMusic music = new UserMusic(user.getId(),musicUrl,musicCaption,status);			
			this.getPortalService(request).save(music);	
	   }
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
		 long userId=0;
		 if(user != null) userId= user.getId();
		 List<UserMusic> userMusics = null;
	     if(this.getVisitedUser(request) != null)
	    	 userMusics = this.getUserService(request).getVisitedUserMusics(userId,this.getVisitedUser(request).getId());
		 else
			 userMusics = this.getUserService(request).getUserMusics(userId);
		 int musicCount =userMusics.size();
		 
		 if(!request.getWindowState().equals(WindowState.MAXIMIZED)){
			 PortletObject portlet =getPortlet(request);		 
			 int showNumber = 4;
			 List<UserMusic> showMusics = new ArrayList<UserMusic>();
			 if(portlet != null && portlet.getShowNumber() > 0){
				 showNumber = portlet.getShowNumber();
			 }
			 if(musicCount > showNumber)
				 request.setAttribute("showMore",true);
			 for(int i=0;i<userMusics.size();i++){
				 if(i>=showNumber) break;
				 showMusics.add(userMusics.get(i));
			 }			 
			 request.setAttribute("userMusics",showMusics);
		 }else{
			 request.setAttribute("userMusics",userMusics);
		 }
		 request.setAttribute("musicCount",musicCount);
		 
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMusicPortletMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMusicPortletView.jsp").include(request,response);  
			
	 }	
    
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 if(request.getParameter("add") != null || request.getAttribute("add") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMusicPortletAdd.jsp").include(request,response);  		 
		 else if(request.getAttribute("music") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMusicPortletEdit.jsp").include(request,response);
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
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMusicPortletConfig.jsp").include(request,response);
		 }		
			
	 }	


}
