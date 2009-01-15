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
package org.light.portlets.connection;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.LabelBean;
import org.light.portlets.chat.Chat;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ConnectionPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");
	    if("search".equals(action)){
	    	String email = request.getParameter("buddyEmail");
	    	if(email != null) {
		    	email = URLDecoder.decode(email,_CHARSET_UTF);
		    	User user = this.getUserService(request).getUserByEmail(email);
		    	if(user != null){
			    	if(this.getChatService(request).getChatBuddy(this.getUser(request).getId(),user.getId())== null){
				    	List<User> buddys = new ArrayList<User>();
				    	buddys.add(user);
				    	request.setAttribute("buddys", buddys);
				    	request.setAttribute("buddyCount", 1);
			    	}else
			    		request.setAttribute("existBuddy",true);
		    	}else
			    	request.setAttribute("notFoundBuddy",true);
	    	}else{
		    	String firstName = request.getParameter("firstName");
		    	String lastName = request.getParameter("lastName");
		    	if(firstName != null && lastName != null){
			    	firstName = URLDecoder.decode(firstName,_CHARSET_UTF);
			    	lastName = URLDecoder.decode(lastName,_CHARSET_UTF);
			    	List<UserProfile> buddys =this.getUserService(request).getUserByName(firstName,lastName);
			    	int buddyCount = 0;
			    	if(buddys != null) buddyCount = buddys.size();
			    	request.setAttribute("buddys", buddys);
			    	request.setAttribute("buddyCount", buddyCount);
		    	}else
		    		request.setAttribute("missingField",true);
	    	}
	    	request.setAttribute("add",true);
	    }
	    else if("add".equals(action)){
			   String email = request.getParameter("buddyEmail");
			   if(email != null) {
				   email = URLDecoder.decode(email,_CHARSET_UTF);
				   User user = this.getUserService(request).getUserByEmail(email);
				   if(user != null){
					   if(this.getChatService(request).getChatBuddy(this.getUser(request).getId(),user.getId()) == null){
						   Connection buddy = new Connection(this.getUser(request).getId(),user.getId());
						   this.getChatService(request).save(buddy);
						   request.setAttribute("addBuddy",true);	
					   }else
						   request.setAttribute("existBuddy",true);	
				   }else
					   request.setAttribute("notFoundBuddy",true);	
			   }else
				   request.setAttribute("missingField",true);	
		}		
	    else if("delete".equals(action)){
			
		}
	    else if("cancel".equals(action)){
			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
	    else if("config".equals(action)){			
			String items = request.getParameter("items");
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){				
				portlet.setShowNumber(Integer.parseInt(items));
				this.getPortalService(request).save(portlet);
			}
			String columns = request.getParameter("columns");
			String currentShowType = request.getParameter("showType");
			String currentFriendType = request.getParameter("friendType");
			PortletPreferences portletPreferences = request.getPreferences();
			portletPreferences.reset("columns");
			portletPreferences.setValue("columns",columns);	
			portletPreferences.setValue("currentShowType",currentShowType);
			if("3".equals(currentShowType)) portletPreferences.reset("currentLocation");
			portletPreferences.setValue("currentFriendType",currentFriendType);
			portletPreferences.store();
			
			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
	    else if("location".equals(action)){	
	    	String showLocation = request.getParameter("location");
	    	PortletPreferences portletPreferences = request.getPreferences();
	    	portletPreferences.setValue("currentLocation",showLocation);
			portletPreferences.store();
		}
	    else if("type".equals(action)){	
	    	String friendType = request.getParameter("friendType");
	    	PortletPreferences portletPreferences = request.getPreferences();
	    	portletPreferences.setValue("currentShowType","5");
			portletPreferences.setValue("currentFriendType",friendType);
			portletPreferences.store();
		}
	    else if("back".equals(action)){	
	    	PortletPreferences portletPreferences = request.getPreferences();
	    	String currentShowType = portletPreferences.getValue("currentShowType",null);
	    	if("3".equals(currentShowType)){
				portletPreferences.reset("currentLocation");
				portletPreferences.store();
	    	}else if("5".equals(currentShowType)){
	    		portletPreferences.setValue("currentShowType","4");
				portletPreferences.store();
	    	}
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		User user = this.getUser(request);
	    if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
	    if(user == null) return;
		Chat chat = this.getChatService(request).getChatByUser(user.getId());
		
		PortletPreferences portletPreferences = request.getPreferences();
		String columns = portletPreferences.getValue("columns","1");
		request.setAttribute("columnNumber",Integer.parseInt(columns));
		String currentShowType = portletPreferences.getValue("currentShowType","0");
		request.setAttribute("currentShowType",currentShowType);
		String currentFriendType = portletPreferences.getValue("currentFriendType","0");
		request.setAttribute("currentFriendType",currentFriendType);
		String currentLocation = portletPreferences.getValue("currentLocation",null);
		
		List<Connection> buddys =null;
		if("0".equals(currentShowType))
			buddys = this.getChatService(request).getBuddysByUser(user.getId());
		else if("1".equals(currentShowType))
			buddys = this.getChatService(request).getOnlineBuddysByUser(user.getId());
		else if("2".equals(currentShowType))
			buddys = this.getChatService(request).getUpdatedBuddysByUser(user.getId());
		else if("3".equals(currentShowType)){			
			if(currentLocation == null){
				buddys = this.getChatService(request).getBuddysByUser(user.getId());
				Map<String, LabelBean> maps = new HashMap<String, LabelBean>();
				for(Connection buddy : buddys){
					String location = null;
					if(buddy.getCity() != null) location=buddy.getCity();
					if(buddy.getProvince() != null){
						if(location == null)
							location = buddy.getProvince();
						else
							location+=", "+buddy.getProvince();					
					}
					if(location == null) location ="Unknown";
					if(maps.containsKey(location)){
						LabelBean bean = maps.get(location);
						bean.setDesc(String.valueOf(Integer.parseInt(bean.getDesc())+1));
					}else{
						LabelBean bean = new LabelBean(location,"1");
						maps.put(location, bean);
					}				
				}
				if(buddys.size() > 0)
					request.setAttribute("buddyLocations",maps.values());
			}else{
				String city=null;
				String province=null;
				if(!currentLocation.equals("Unknown")){
					city= currentLocation.substring(0, currentLocation.indexOf(","));
					province = currentLocation.substring(currentLocation.indexOf(",")+2, currentLocation.length());
				}			
				buddys = this.getChatService(request).getBuddysByUser(user.getId(),city,province);
				request.setAttribute("currentDesc",currentLocation+"("+buddys.size()+")");
			}
		}else if("4".equals(currentShowType)){
			buddys = this.getChatService(request).getBuddysByUser(user.getId());
			Map<Integer, ConnectionType> maps = new HashMap<Integer, ConnectionType>();
			for(Connection buddy : buddys){
				Integer type = buddy.getType();				
				if(maps.containsKey(type)){
					ConnectionType bean = maps.get(type);
					bean.add();
				}else{					
					ConnectionType bean = new ConnectionType(type,1);
					maps.put(type, bean);
				}				
			}
			if(buddys.size() > 0)
				request.setAttribute("buddyTypes",maps.values());			
		}else if("5".equals(currentShowType)){
			int type = Integer.parseInt(currentFriendType);
			buddys = this.getChatService(request).getBuddysByUserAndType(user.getId(), type);
			request.setAttribute("currentDesc",ConnectionType.getTitle(type)+"("+buddys.size()+")");
		}
		int buddyCount =0;
		if(buddys != null) buddyCount=buddys.size();
		int showNumber = buddyCount;
		PortletObject portlet =getPortlet(request);	
		if(portlet != null && portlet.getShowNumber() > 0 && portlet.getShowNumber() < buddyCount && !request.getWindowState().equals(WindowState.MAXIMIZED)){
			showNumber = portlet.getShowNumber();
			List<Connection> showBuddys = new ArrayList<Connection>();
			for(int i=0;i<buddys.size();i++){
				 if(i>=showNumber) break;
				 Connection buddy = buddys.get(i);				 
				 showBuddys.add(buddy);
			 }
			request.setAttribute("buddys", showBuddys);
			request.setAttribute("showMore", true);
			request.setAttribute("showNumber", showNumber);
		}else{
			request.setAttribute("buddys", buddys);
			request.setAttribute("showNumber", buddyCount);
		}
		request.setAttribute("chat",chat);		
		request.setAttribute("buddyCount", buddyCount);		
		
		if(this.getVisitedUser(request) != null){
			if(request.getWindowState().equals(WindowState.MAXIMIZED))
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/visitedFriendPortletMaxView.jsp").include(request,response);
			else
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/visitedFriendPortletView.jsp").include(request,response);
		}			  
		else{
			if(request.getWindowState().equals(WindowState.MAXIMIZED))
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chatPortletMaxView.jsp").include(request,response);
			else
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chatPortletView.jsp").include(request,response);
		}
			
		
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {			
//		Chat chat = this.getChatService(request).getChatByUser(this.getUser(request).getId());
//		List<ChatBuddy> buddys = this.getChatService(request).getBuddysByUser(this.getUser(request).getId());
//		PortletObject notePortlet =getPortlet(request);
//		request.setAttribute("chat",chat);
//		request.setAttribute("buddys", buddys);
		if(request.getParameter("add") != null || request.getAttribute("add") != null)
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chatPortletEdit.jsp").include(request,response);  
		else{
			List<LabelBean> showType= new ArrayList<LabelBean>();
			showType.add(new LabelBean("0", "Show all friends"));			
			showType.add(new LabelBean("1", "Show friends who is online now"));
			showType.add(new LabelBean("2", "Show recently updated friends"));
			showType.add(new LabelBean("3", "Show friends based on location"));
			showType.add(new LabelBean("4", "Show friends based on type"));
			showType.add(new LabelBean("5", "Show type is"));
			List<LabelBean> friendType= new ArrayList<LabelBean>();
			friendType.add(new LabelBean("0", "Friend"));			
			friendType.add(new LabelBean("1", "Family"));
			friendType.add(new LabelBean("2", "Close friend"));
			friendType.add(new LabelBean("3", "Classmate"));
			friendType.add(new LabelBean("4", "Colleague"));
			request.setAttribute("showType",showType);
			request.setAttribute("friendType",friendType);
			
			int showNumber = 0;
			PortletObject portlet =getPortlet(request);	
			if(portlet != null && portlet.getShowNumber() > 0)
				showNumber = portlet.getShowNumber();
			request.setAttribute("showNumber",showNumber);
			PortletPreferences portletPreferences = request.getPreferences();
			String columns = portletPreferences.getValue("columns","1");
			request.setAttribute("columnNumber",Integer.parseInt(columns));
			String currentShowType = portletPreferences.getValue("currentShowType","0");
			request.setAttribute("currentShowType",currentShowType);
			String currentFriendType = portletPreferences.getValue("currentFriendType","0");
			request.setAttribute("currentFriendType",currentFriendType);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chatPortletConfig.jsp").include(request,response);  
		}
			
		
	 }	
	 
	 protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chatPortletHelp.jsp").include(request,response);
	 }
}
