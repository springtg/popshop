/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;
import static org.light.portal.util.Constants._ROLE_MEMBER;
import static org.light.portal.util.Constants._ROLE_USER;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.ChannelRef;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.User;
import org.light.portal.model.UserEntity;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.CalendarUtil;
import org.light.portal.util.LocaleUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.ChatStatusRef;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class UserPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {	
		 String action = request.getParameter("action");
		 if("request".equals(action)){
			 String userId = request.getParameter("email");
			 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);		   				  
			 if( userId == null || userId.length() <= 0){
				   request.setAttribute("error","Please input your Email address.");
				   response.setPortletMode(PortletMode.EDIT);
				   return;
			   }	
			 User user = this.getUserService(request).getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
			 if(user == null){
				 request.setAttribute("error","System didn't find your account,please input Email address and birthday correctly.");
				 response.setPortletMode(PortletMode.EDIT);
				 return;
			 }
//			 String birth = request.getParameter("birthY")+"/"+
//			 				request.getParameter("birthM")+"/"+
//			 				request.getParameter("birthD");
//			 if( birth.length() < 10){
//				   request.setAttribute("error","Please input your date of birth.");
//				   response.setPortletMode(PortletMode.EDIT);
//				   return;
//			   }
//			 if(user != null && !user.getBirth().equals(birth)){
//				 request.setAttribute("error","System didn't find your account,please input Email address and birthday correctly.");
//				 response.setPortletMode(PortletMode.EDIT);
//				 return;
//			 }
			this.getUserService(request).sendNewPassword(user);
			request.setAttribute("success","your new temporary password has been sent to your email account successfully.");			 
		 } 
		 else if("step1".equals(action)){
			 String userId = request.getParameter("email");
			 String password = request.getParameter("password");
			 String displayName = request.getParameter("displayName");		 		
			 String chosedUri=  request.getParameter("myUri"); 
			
			 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);		   	
			 if(password != null) password = URLDecoder.decode(password,_CHARSET_UTF);  
			 if(displayName != null) displayName = URLDecoder.decode(displayName,_CHARSET_UTF);		   	
			 if(chosedUri != null) chosedUri = URLDecoder.decode(chosedUri,_CHARSET_UTF);  
			 int showLocale = 0;		 
			 User newUser = new UserEntity(userId,password,displayName,userId,chosedUri,OrganizationThreadLocal.getOrganizationId());
			 User user = this.getUserService(request).signUp(newUser,OrganizationThreadLocal.getOrganizationId());
			 if(user != null){			 			
				 this.setUser(request,user);
				 UserProfile userProfile = new UserProfile(user.getId());
				 this.getPortalService(request).save(userProfile);
				 Chat chat = new Chat(user.getId(),ChatStatusRef.ONLINE,ChatStatusRef.ONLINE);
				 this.getPortalService(request).save(chat);	
				 List<PortalUserRole> userRoles = this.getPortalService(request).getUserRole(user.getId(),_ROLE_USER);
				 if(userRoles == null || userRoles.size() == 0){
					PortalUserRole userRole1 = new PortalUserRole(user.getId(),_ROLE_USER);
				 	this.getPortalService(request).save(userRole1);	
					PortalUserRole userRole2 = new PortalUserRole(user.getId(),_ROLE_MEMBER);
					this.getPortalService(request).save(userRole2);				
				 }
				 request.setAttribute("step", "2");
			 }else{
				 request.setAttribute("step", "0");
			 }			
		 }
		 else if("step2".equals(action)){
			 String language = request.getParameter("language");
			 String region = language;
			 String timeZone=  request.getParameter("timeZone");
			 String birthM = request.getParameter("birthM");
			 String birthD = request.getParameter("birthD");
			 String birthY = request.getParameter("birthY");
			 String gender = request.getParameter("gender");
			 String country = request.getParameter("country");
			 String province = request.getParameter("province");
			 String city = request.getParameter("city");
			 String postalCode = request.getParameter("postalCode");
			 if(timeZone != null) timeZone = URLDecoder.decode(timeZone,_CHARSET_UTF);
			 if(country != null) country = URLDecoder.decode(country,_CHARSET_UTF);
			 if(province != null) province = URLDecoder.decode(province,_CHARSET_UTF);
			 if(city != null) city = URLDecoder.decode(city,_CHARSET_UTF);
			 if(postalCode != null) postalCode = URLDecoder.decode(postalCode,_CHARSET_UTF);
			 int showLocale = 0;
			 User user = this.getUser(request);
			 user.setLanguage(language);
			 user.setRegion(region);
			 user.setTimeZone(timeZone);
			 String birth = birthY+"/"+birthM+"/"+birthD;
			 if(birth.length() == 10)
				 user.setBirth(birthY+"/"+birthM+"/"+birthD);
			 user.setGender(gender);
			 user.setCountry(country);
			 user.setProvince(province);
			 user.setCity(city);
			 user.setPostalCode(postalCode);
			 this.getUserService(request).saveUser(user);
			 this.getPortalService(request).createPortalByUser(user.getUserId(),user.getDisplayName(),showLocale,language,region);
			 request.setAttribute("step", "3");
		 }
		 else if("step3".equals(action)){
			 String channels = request.getParameter("channels");
			 if(channels != null) channels = URLDecoder.decode(channels,_CHARSET_UTF);
			 if(channels != null){
				 String[] channel = channels.split(",");
				 for(int i=0;i<channel.length;i++){
					 if(channel != null && !"".equals(channel)){
						 List<PortalUserRole> userChannels = this.getPortalService(request).getUserRole(this.getUser(request).getId(),channel[i]);
						 if(userChannels == null || userChannels.size() == 0){
							PortalUserRole userRole = new PortalUserRole(this.getUser(request).getId(),channel[i]);
							this.getPortalService(request).save(userRole);
						 } 
					 }
				 }
			 }
			 request.setAttribute("step", "4");
		 }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 if(this.getVisitedUser(request) != null || this.getVisitedGroup(request) != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/visitorSignIn.jsp").include(request,response);
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/signIn.jsp").include(request,response); 		
	 }	
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		request.setAttribute("months", CalendarUtil.getMonths());
		request.setAttribute("days", CalendarUtil.getDays());
		request.setAttribute("years", CalendarUtil.getYears());
		String type = request.getParameter("type");
		if("forgot".equals(type)){			
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/forgotPassword.jsp").include(request,response);  

		}else{
	        List<ChannelRef> channels = this.getPortalService(request).getChannelRef();		 						
			String step = (String)request.getAttribute("step");
			if(step == null || step.equals("1"))
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register1.jsp").include(request,response);
			else if( step.equals("2")){
				request.setAttribute("languages", LocaleUtil.getSupportedLanguages());
				request.setAttribute("countries", LocaleUtil.getSupportedCountry());
				//request.setAttribute("provinces", LocaleUtils.getSupportedProvince());
				request.setAttribute("timeZones", LocaleUtil.getSupportedTimeZone());
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register2.jsp").include(request,response);
			}else if( step.equals("3")){
				request.setAttribute("channels", channels);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register3.jsp").include(request,response);
			}else if(step.equals("4")){
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register4.jsp").include(request,response);
			}
			else if(step.equals("0")){
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register0.jsp").include(request,response);
			}
		}
	 }	
}



