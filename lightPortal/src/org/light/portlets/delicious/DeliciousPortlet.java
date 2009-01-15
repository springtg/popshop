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
package org.light.portlets.delicious;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.ActionRequestImpl;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.portlet.core.impl.PortletPreference;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.bookmark.BookmarkTag;

import del.icio.us.Delicious;
import del.icio.us.beans.Post;
import del.icio.us.beans.Tag;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: July 15, 2006
 **/
public class DeliciousPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("login".equals(action)){
			   String userName = request.getParameter("userName");
			   String password = request.getParameter("password");	
			   Delicious d= new Delicious(userName,password);
				 try{
					 d.getAllPosts();
					 PortletPreferences portletPreferences = request.getPreferences();
					 portletPreferences.setValue("userName",userName);		
					 portletPreferences.setValue("password",password);		
					 portletPreferences.store();
					 request.setAttribute("firstTime", true);
				 }catch(Exception e){
					 request.setAttribute("userName", userName);
					 request.setAttribute("password", password);
					 request.setAttribute("loginError",true);	
					 request.setAttribute("mode","edit");
				 }
			   
			}
		if("add".equals(action)){
		   String name = request.getParameter("name");
		   String url = request.getParameter("url");
		   String desc = request.getParameter("desc");
		   String tag = request.getParameter("tag");
		   PortletPreferences portletPreferences = request.getPreferences();
		   String userName = portletPreferences.getValue("userName",null);
		   String password = portletPreferences.getValue("password",null);
		   if(name == null ||"".equals(name) || url == null || "".equals(url)){
			   request.setAttribute("missingField",true);	
			   request.setAttribute("mode","edit");
		   }else{
			   try{		  
				   Delicious d= new Delicious(userName,password);
				   if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);		   	
				   if(url != null) url = URLDecoder.decode(url,_CHARSET_UTF);
				   if(desc != null) desc = URLDecoder.decode(desc,_CHARSET_UTF);
				   if(tag != null) tag = URLDecoder.decode(tag,_CHARSET_UTF);	
//				   if(tag != null && !"".equals(tag))
					   d.addPost(url, name, desc,tag, new Date(System.currentTimeMillis()));
//				   else
//					   d.addPost(url, name);
				   request.setAttribute("success", "You have add a bookmark successfully.");
				   request.setAttribute("doView", true);
				   response.setRenderParameter("refresh", "refresh");
			   }catch(Exception e){					
					 request.setAttribute("error", "You have failed to add a bookmark.");
					 request.setAttribute("mode","edit");
			   }
		   }
		}
		if("delete".equals(action)){
			String parameter = request.getParameter("parameter");						
			PortletPreferences portletPreferences = request.getPreferences();
			String userName = portletPreferences.getValue("userName",null);
			String password = portletPreferences.getValue("password",null);
		    Delicious d= new Delicious(userName,password);	
		    d.deletePost(parameter);
			List<BookmarkTag> deliciousBookmarkTags=(List<BookmarkTag>)request.getPortletSession().getAttribute("deliciousTags",PortletSession.APPLICATION_SCOPE);
		    List<Bookmark> deliciousBookmark = (List<Bookmark>)request.getPortletSession().getAttribute("delicious",PortletSession.APPLICATION_SCOPE);
			boolean isRemoved = false;
			for(BookmarkTag tag : deliciousBookmarkTags){
               for(Bookmark bookmark : tag.getBookmarks()){
                 if(bookmark.getUrl().equals(parameter)){
				     tag.removeBookmark(bookmark);
					 isRemoved = true;
                     break;
                 }
               }
			}
			if(!isRemoved){
				for(Bookmark bookmark : deliciousBookmark){
	                 if(bookmark.getUrl().equals(parameter)){
						 deliciousBookmark.remove(bookmark);
						 isRemoved = true;
	                     break;
	                 }
	               }
            }
			request.setAttribute("success", "You have deleted a bookmark successfully.");
		}		
		if("edit".equals(action)){			
			request.setAttribute("edit", true);			
		}
		if("cancel".equals(action)){			
			request.setAttribute("doView", true);			
		}
		if("save".equals(action)){
			   String name = request.getParameter("name");
			   String url = request.getParameter("url");
			   String desc = request.getParameter("desc");
			   String tag = request.getParameter("tag");			   
			   PortletPreferences portletPreferences = request.getPreferences();
			   String userName = portletPreferences.getValue("userName",null);
			   String password = portletPreferences.getValue("password",null);
			   if(name == null ||"".equals(name) || url == null || "".equals(url)){
				   request.setAttribute("missingField",true);	
			   }else{
				   try{	
					   if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);		   	
					   if(url != null) url = URLDecoder.decode(url,_CHARSET_UTF);	
					   if(desc != null) desc = URLDecoder.decode(desc,_CHARSET_UTF);
					   if(tag != null) tag = URLDecoder.decode(tag,_CHARSET_UTF);		   						   
					   Delicious d= new Delicious(userName,password);	
					   d.deletePost(url);
//					   if(tag != null && !"".equals(tag))
						   d.addPost(url, name, desc,tag, new Date(System.currentTimeMillis()));
//					   else
//						   d.addPost(url, name);
					   request.setAttribute("success", "You have modified a bookmark successfully.");
					   request.setAttribute("doView", true);
					   response.setRenderParameter("refresh", "refresh");
				   }catch(Exception e){				
						 request.setAttribute("editError",true);				 
				   }				  	
			   }			   	
			}
		if("expand".equals(action)){
	           String tagId = request.getParameter("parameter");
	           List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getPortletSession().getAttribute("deliciousTags",PortletSession.APPLICATION_SCOPE);
	           for(BookmarkTag tag : deliciousTags){
	               if(tag.getTagId().equals(tagId)){
	                   tag.setExpanded(true);
	                   break;
	               }
	           }
	       }
	       if("close".equals(action)){
	           String tagId = request.getParameter("parameter");
	           List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getPortletSession().getAttribute("deliciousTags",PortletSession.APPLICATION_SCOPE);
	           for(BookmarkTag tag : deliciousTags){
	               if(tag.getTagId().equals(tagId)){
	                   tag.setExpanded(false);
	                   break;
	               }
	           }
	       }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
	   List<BookmarkTag> deliciousBookmarkTags=(List<BookmarkTag>)request.getPortletSession().getAttribute("deliciousTags",PortletSession.APPLICATION_SCOPE);
	   List<Bookmark> deliciousBookmark = (List<Bookmark>)request.getPortletSession().getAttribute("delicious",PortletSession.APPLICATION_SCOPE);
	   String refresh = request.getParameter("refresh");
	   if(refresh != null || (deliciousBookmarkTags == null && deliciousBookmark == null)){
		    PortletPreferences portletPreferences = request.getPreferences();
			String userName = portletPreferences.getValue("userName",null);
			String password = portletPreferences.getValue("password",null);
			if(userName != null){			
				List<Bookmark> delicious =  new ArrayList<Bookmark>();
				List<BookmarkTag> deliciousTags = new ArrayList<BookmarkTag>();   
				Delicious d= new Delicious(userName,password);
				List<Post> lists = d.getAllPosts();
				List<Tag> tags = d.getTags();
				if(tags != null){
					for(Tag tag : tags){
						deliciousTags.add(new BookmarkTag(tag.getTag(),tag.getTag()));
					}
				}
				long id = 1;
				for(Post post : lists){
					Bookmark bookmark = new Bookmark(id++,post.getDescription(),post.getHref(),post.getTag(),post.getTag(),post.getExtended(),this.getUser(request).getId());
					if(post.getTag() == null)
						delicious.add(bookmark);
					else{
						for(BookmarkTag bTag : deliciousTags){
	                           if(bTag.getTagId().equals(post.getTag())){
	                               bTag.addBookmark(bookmark);
	                               break;
	                           }
	                       }
					}
										
				}			
		        request.getPortletSession().setAttribute("deliciousTags",deliciousTags, PortletSession.APPLICATION_SCOPE);
		        request.getPortletSession().setAttribute("delicious",delicious, PortletSession.APPLICATION_SCOPE);
			}else{
				request.setAttribute("notLogin",true);
			}
       }

		
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/delicious/deliciousPortletView.jsp").include(request,response);  			
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		 if(request.getAttribute("loginError") != null){
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/delicious/deliciousPortletEdit.jsp").include(request,response);
			 return;
		 }else if(request.getAttribute("firstTime") != null){
			 PortletPreferences portletPreferences = request.getPreferences();
			 String userName = portletPreferences.getValue("userName",null);
			 String password = portletPreferences.getValue("password",null);
			 if(userName != null){
				 Delicious d= new Delicious(userName,password);
				 try{
					 d.getAllPosts();
					 this.doView(request,response);
					 return;
				 }catch(Exception e){
					 request.setAttribute("userName", userName);
					 request.setAttribute("password", password);
					 request.setAttribute("loginError",true);
					 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/delicious/deliciousPortletEdit.jsp").include(request,response);
					 return;
				 }
			 }			
		 }else if(request.getAttribute("edit") != null){
			String url = request.getParameter("parameter");
			String desc="";
			String tagName="";	
			String name=null;
			List<BookmarkTag> deliciousTags=(List<BookmarkTag>)request.getPortletSession().getAttribute("deliciousTags",PortletSession.APPLICATION_SCOPE);
		    List<Bookmark> delicious = (List<Bookmark>)request.getPortletSession().getAttribute("delicious",PortletSession.APPLICATION_SCOPE);
		    for(BookmarkTag tag : deliciousTags){
				for(Bookmark bm : tag.getBookmarks()){
		            if(bm.getUrl().equals(url)){
		                name = bm.getName();
						desc = bm.getDesc();
						tagName = tag.getTagName();
		                break;
		            }
				}
	        }
			if(name == null){
				for(Bookmark bm : delicious){
		            if(bm.getUrl().equals(url)){
		                name = bm.getName();
						desc = bm.getDesc();
		                break;
		            }
				}
			}
			PortletPreferences portletPreferences = request.getPreferences();
			String userName = portletPreferences.getValue("userName",null);
			String password = portletPreferences.getValue("password",null);
			request.setAttribute("url", url);
			request.setAttribute("name", name);
			request.setAttribute("desc", desc);
			request.setAttribute("tag", tagName);
			request.setAttribute("userName", userName);
			request.setAttribute("password", password);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/delicious/deliciousPortletEdit.jsp").include(request,response);
		 }else if(request.getAttribute("doView") != null){
			 this.doView(request,response);
			 return;
		 }else{
			 PortletPreferences portletPreferences = request.getPreferences();
			 String userName = portletPreferences.getValue("userName",null);
			 String password = portletPreferences.getValue("password",null);
			 if(userName != null){				
				 request.setAttribute("userName", userName);
				 request.setAttribute("password", password);
			 }
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/delicious/deliciousPortletEdit.jsp").include(request,response);
		 }
	 }	
	 
}

