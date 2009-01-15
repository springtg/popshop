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
package org.light.portlets.todolist;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.light.portal.portlet.core.impl.LightGenericPortlet;

/**
* 
* @author Jianmin Liu
* @version 1.0.0
* Creation date: April 14, 2006
**/
public class ToDoPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
   throws PortletException, java.io.IOException {
		String action = request.getParameter("action");		
		if("delete".equals(action)){
			String id = request.getParameter("parameter");
			ToDoBean todo = this.getUserService(request).getToDoById(Integer.parseInt(id));
			if(todo != null){
				this.getPortalService(request).delete(todo);	
			}
		}		
		if("edit".equals(action)){			
			request.setAttribute("edit", true);			
		}
		if("cancel".equals(action)){			
			response.setPortletMode(PortletMode.VIEW);
		}
		if("save".equals(action)){
		   String ids = request.getParameter("id");	
		   String name = request.getParameter("name");		   
		   if(name == null ||"".equals(name) ){
			   request.setAttribute("missingField",true);
			   return;
		   }	
		   name = URLDecoder.decode(name,_CHARSET_UTF);		  
		   String desc = request.getParameter("description");				   
		   if(desc == null ||"".equals(desc.trim()) ){
			   request.setAttribute("missingField",true);
			   return;
		   }
		   desc = URLDecoder.decode(desc,_CHARSET_UTF);
		   String priority = request.getParameter("priority");
		   ToDoBean todo = null;
		   int id = 0;
		   if(ids != null) id = Integer.parseInt(ids);
		   if(id >0)
			   todo = this.getUserService(request).getToDoById(id);
		   if(todo == null) todo = new ToDoBean();
		   todo.setName(name);
		   todo.setDescription(desc.trim());
		   todo.setUserId(this.getUser(request).getId());
		   todo.setPriority(Integer.parseInt(priority));
		   this.getPortalService(request).save(todo);
		}
		if("changeStatus".equals(action)){
			String id = request.getParameter("name");
			ToDoBean todo = this.getUserService(request).getToDoById(Integer.parseInt(id));
			if(todo != null){
			   int status = todo.getStatus();
			   if(status == 0){
				   status = 1;
			   }else{
				   status = 0;
			   }
			   todo.setStatus(status);
			   this.getPortalService(request).save(todo);		
			}
		}
		else if("config".equals(action)){
			String showFinished = request.getParameter("showFinished");
			String items = request.getParameter("items");
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){				
				portlet.setShowNumber(Integer.parseInt(items));
				this.getPortalService(request).save(portlet);
			}
			PortletPreferences portletPreferences = request.getPreferences();
			if(showFinished != null){
				portletPreferences.setValue("showFinished","1");
			}else{
				portletPreferences.setValue("showFinished","0");
			}			
			portletPreferences.store();			
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		List<ToDoBean> lists = this.getUserService(request).getToDosByUser(this.getUser(request).getId());
		List<ToDoBean> todoLists = new ArrayList<ToDoBean>();
		PortletObject todoPortlet =getPortlet(request);
		int number =0;
		PortletPreferences portletPreferences = request.getPreferences();
		String showFinished = portletPreferences.getValue("showFinished","0");
		if(todoPortlet != null
			//&& todoPortlet.getShowNumber() > 0
			//&& lists != null
			//&& lists.size() > todoPortlet.getShowNumber()
			&& request.getWindowState().equals(WindowState.NORMAL)){						
			for(ToDoBean todo : lists )
            {
				if(todoPortlet.getShowNumber() > 0 &&  number >= todoPortlet.getShowNumber()){
					request.setAttribute("showMore",true);
					break;	
				}					
				if(showFinished.equals("1") || todo.getStatus() == 0){						 
					todoLists.add(todo);
					number++;
				}	
            }	
    	}else{
    		todoLists = lists;
    	}
		request.setAttribute("todoLists", todoLists);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/todo/todoPortletView.jsp").include(request,response);  
				
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {   
		 if(request.getParameter("add") != null){
			 String name = request.getParameter("name");		   
			 if(name != null)
			   name = URLDecoder.decode(name,_CHARSET_UTF);		  
			 String desc = request.getParameter("description");				   
			 if(desc!= null )
			   desc = URLDecoder.decode(desc,_CHARSET_UTF);
			 if(desc == null)
			   desc = "New to do description...";
			 String prioritys = request.getParameter("priority");
			 int priority = 0;
			 if(prioritys != null)
				 priority = Integer.parseInt(prioritys);
			 ToDoBean todo = new ToDoBean(name,desc,this.getUser(request).getId(),priority);							
			 request.setAttribute("todo", todo);	
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/todo/todoPortletEdit.jsp").include(request,response);
		 }else{
			String id = request.getParameter("parameter");
			if(id != null){
				ToDoBean todo = this.getUserService(request).getToDoById(Integer.parseInt(id));							
				request.setAttribute("todo", todo);				
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/todo/todoPortletEdit.jsp").include(request,response);
			}else{
				PortletObject portlet = this.getPortlet(request);
				int showNumber = portlet.getShowNumber();
				if(showNumber <=0) showNumber = 6;
				request.setAttribute("showNumber",showNumber);
				PortletPreferences portletPreferences = request.getPreferences();
				String showFinished = portletPreferences.getValue("showFinished","0");
				request.setAttribute("showFinished",showFinished);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/todo/todoPortletConfig.jsp").include(request,response);	 
			}	
		 }
		 
	 }	
	 	 
}

