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
package org.light.portlets.rss;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PopularItem;
import org.light.portal.model.PortletObject;
import org.light.portal.model.PortletObjectRef;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.StringUtils;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class RssPortlet extends LightGenericPortlet {
	
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("edit".equals(action)){
			String feed = request.getParameter("feed");
			if(feed != null) feed = URLDecoder.decode(feed,_CHARSET_UTF);
			String title = request.getParameter("title");
			String icon = request.getParameter("icon");
			String url = request.getParameter("url");
			String autoRefresh = request.getParameter("autoRefresh");
			String minute = request.getParameter("minute");
			String items = request.getParameter("items");
			String showType = request.getParameter("showType");
			PortletObject rssPortlet =getPortlet(request);		
			if(rssPortlet != null){
				rssPortlet.setLabel(title);
				rssPortlet.setIcon(icon);
				rssPortlet.setUrl(url);
				rssPortlet.setAutoRefreshed(Integer.parseInt(autoRefresh));
				rssPortlet.setPeriodTime(Integer.parseInt(minute) * 60000);
				rssPortlet.setShowNumber(Integer.parseInt(items));
				rssPortlet.setShowType(Integer.parseInt(showType));
				rssPortlet.setParameter("feed="+feed);
				this.getPortalService(request).save(rssPortlet);
			}
			response.setPortletMode(PortletMode.VIEW);
		}
		else if("pop".equals(action)){
	       	String id = request.getParameter("parameter");
	       	if(id != null){
	       		int indx = Integer.parseInt(id);
	            String feed = request.getParameter("feed");
	            String link = feed;
	            String title = null;
	            String desc= null;
	            PortletObject po= this.getPortlet(request);
	            if(po != null){ 	        	  
	            	 String parameter = po.getParameter();
	            	 int ind = parameter.indexOf("=");
	         		 feed = parameter.substring(ind + 1);
	            }
	            List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	            for(RssBean rss : lists){         
	    	         if(rss.getIndex() == indx){
	    	        	 title = rss.getTitle();
	    	        	 desc = rss.getDesc();
	    	        	 if(rss.getLink() != null) link = rss.getLink();
	    	        	 break;
	    	         }    
	           }
	           if(title != null){
                PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),link);
                if(item == null){
                   String tag = "portlet.tag.title.news";
                   String locale = "en"; 	          
     	           if(po != null){ 	        	  
     	        	  PortletObjectRef ref=this.getPortalService(request).getPortletRefByName(po.getName());
     	        	  tag = ref.getTag();
     	        	  locale = ref.getLanguage();
     	           }
                   item = new PopularItem(link,title,desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
                }else
                    item.popIt();
                this.getPortalService(request).save(item);
                request.setAttribute("success", "You have voted this news successfully.");
	          }
	       	}
	       }
	       else if("forward".equals(action)){
	       	String id = request.getParameter("parameter");
	       	if(id != null){
	       		int indx = Integer.parseInt(id);
	       		String feed = request.getParameter("feed");
	            String link = feed;
	            String title = null;
	            String desc= null;
	            PortletObject po= this.getPortlet(request);
	            if(po != null){ 	        	  
	            	 String parameter = po.getParameter();
	            	 int ind = parameter.indexOf("=");
	         		 feed = parameter.substring(ind + 1);
	            }
	            List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
	            for(RssBean rss : lists){         
	    	         if(rss.getIndex() == indx){
	    	        	 title = rss.getTitle();
	    	        	 desc = rss.getDesc();
	    	        	 if(rss.getLink() != null) link = rss.getLink();
	    	        	 break;
	    	         }    
	           }
               if(title != null){
                User user = this.getUser(request);
                if(user != null){
                    List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
                    for(Connection friend : userFriends){
                        Message message = new Message(user.getDisplayName()+" send you a news link.",
                                "<a href='"+link+"' target='_blank'>"+title+"</a><br/><br/>"+desc,friend.getBuddyUserId(),user.getId());
                        this.getUserService(request).sendMessage(message);
                    }
                }
                request.setAttribute("success", "You have forwarded this news to your friends successfully.");
               }               
	       	}
	       }
		   else if("bookmark".equals(action)){
	     	String id = request.getParameter("parameter");
	     	if(id != null){
	     		int indx = Integer.parseInt(id);
		        String feed = request.getParameter("feed");
		        String link = feed;
		        String title = null;
		        String desc= null;
		        PortletObject po= this.getPortlet(request);
		        if(po != null){ 	        	  
		        	 String parameter = po.getParameter();
		        	 int ind = parameter.indexOf("=");
		     		 feed = parameter.substring(ind + 1);
		        }
		        List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
		        for(RssBean rss : lists){         
			         if(rss.getIndex() == indx){
			        	 title = rss.getTitle();
			        	 desc = rss.getDesc();
			        	 if(rss.getLink() != null) link = rss.getLink();
			        	 break;
			         }    
		        }
		        if(desc == null) desc="news description is unavaliable.";
		        if(title != null){
		           String tag = "portlet.tag.title.news";	           
		           if(po != null)
		        	   tag = po.getLabel();
		           Bookmark bookmark = new Bookmark(title,link,tag,tag,desc,this.getUser(request).getId());
		           this.getPortalService(request).save(bookmark);
		           request.getPortletSession().removeAttribute("bookmarkTags",PortletSession.APPLICATION_SCOPE);
				   request.getPortletSession().removeAttribute("defaultBookmarks",PortletSession.APPLICATION_SCOPE);	
				   request.setAttribute("success", "You have saved this news to your bookmarks successfully.");
		        }
	     	}
	    }
	    else if("delete".equals(action)){
			
		}
	  }
 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		PortletObject portlet = this.getPortlet(request);
		String parameter = portlet.getParameter();
		int ind = parameter.indexOf("=");
		String feed = parameter.substring(ind + 1);
		if(StringUtils.isEmpty(feed)){
			return;
		}
		List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
				
		String indx= request.getParameter("index");
		if(indx != null){
			int index = Integer.parseInt(indx);
			String previous = request.getParameter("previous");
			String next = request.getParameter("next");
			if(previous != null) index--;
			if(next != null) index++;
			if(index < 0) index = lists.size() - 1;
			if(index >= lists.size()) index = 0;
			RssBean item = null;
			for(RssBean rss : lists){
				if(rss.getIndex() == index){
					item = rss;
					break;
				}
			}
			request.setAttribute("item",item);
			request.setAttribute("readerHeight",300);
			request.setAttribute("readerMaxHeight",600);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/rss/rssReader.jsp").include(request,response);
			return;
		}
		
		int showNumber = 6;
		if(portlet != null) showNumber = portlet.getShowNumber();
		if(lists != null){		
			String previousPage=request.getParameter("previousPage");
			String nextPage = request.getParameter("nextPage");
			String pageNumber = request.getParameter("page");
			int page = 1;
			int totalPages = (lists.size() % showNumber == 0) ? lists.size() / showNumber : lists.size() / showNumber + 1;
			if(pageNumber != null) page = Integer.parseInt(pageNumber);
			if(previousPage != null) page--;
			if(nextPage != null) page++;
			if(page < 1) page = totalPages;
			if(page > totalPages) page = 1;
			request.setAttribute("page",page);
			request.setAttribute("pages",totalPages);
			if(request.getWindowState().equals(WindowState.NORMAL)){
				List<RssBean> showlists = new ArrayList<RssBean>();
				for(RssBean rss : lists )
			    {
					if(rss.getIndex() >= showNumber * (page - 1) 
						   && rss.getIndex() < showNumber * page)										
						showlists.add(rss);
			    }	
				request.setAttribute("rssLists",showlists);
			}else{
				request.setAttribute("rssLists",lists);
			}
		}
		request.setAttribute("portlet",portlet);
		if(portlet != null && lists != null && portlet.getShowNumber() > 0 && portlet.getShowNumber() < lists.size())
			request.setAttribute("showMore",true);			
		

		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/rss/rssPortletView.jsp").include(request,response);
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		PortletObject rssPortlet =getPortlet(request);		
		if(rssPortlet != null){
			String feed = rssPortlet.getParameter().substring(5,rssPortlet.getParameter().length());
			request.setAttribute("feed",feed);
			request.setAttribute("portlet",rssPortlet);
			request.setAttribute("minute",rssPortlet.getPeriodTime() / 60000);
		}
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/rss/rssPortletEdit.jsp").include(request,response);
	 }	
	 	 
}
