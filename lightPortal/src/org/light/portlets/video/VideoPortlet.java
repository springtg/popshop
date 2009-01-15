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
package org.light.portlets.video;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.rss.RssBean;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
/**
* 
* @author Jianmin Liu
* @version 0.9.0
* Creation date: April 14, 2006
**/
public class VideoPortlet extends LightGenericPortlet {
	
	public void processAction (ActionRequest request, ActionResponse response) 
   throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("edit".equals(action)){
			String feed = request.getParameter("feed");
			String title = request.getParameter("title");
			String icon = request.getParameter("icon");
			String url = request.getParameter("url");						
			PortletObject rssPortlet =getPortlet(request);		
			if(rssPortlet != null){
				rssPortlet.setLabel(title);
				rssPortlet.setIcon(icon);
				rssPortlet.setUrl(url);				
				rssPortlet.setParameter("feed="+feed);
				this.getPortalService(request).save(rssPortlet);
			}
		}
		
	  }

	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		
		StringBuffer resultBuffer = new StringBuffer();
		String feed = request.getParameter("feed");
		if(feed != null && !"".equals(feed)){
			HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");
			String proxySet = httpServletRequest.getSession().getServletContext().getInitParameter("proxySet");
			if("true".equals(proxySet)){
				String proxyHost = httpServletRequest.getSession().getServletContext().getInitParameter("proxyHost");
				String proxyPort = httpServletRequest.getSession().getServletContext().getInitParameter("proxyPort");
				System.getProperties().put( "proxySet", proxySet );
				System.getProperties().put( "proxyHost", proxyHost );
				System.getProperties().put( "proxyPort", proxyPort );
			}
			try{
			URL feedUrl = new URL(feed);
           SyndFeedInput input = new SyndFeedInput();
           SyndFeed rss = input.build(new XmlReader(feedUrl));
		    Collection items = rss.getEntries();
	        if(items != null && !items.isEmpty())
	        {  
	        	String num = request.getParameter("number");
	        	int number = 0;
	        	if(num != null)
	        		number = Integer.parseInt(num);
	        	if(number >= items.size()) number = 0;
	        	if(number < 0 ) number = items.size() - 1;
	        	int i=0;
	        	SyndEntry item = null;
	        	List<RssBean> lists = new ArrayList<RssBean>();
	        	for(Iterator it = items.iterator(); it.hasNext(); )
	            {		        		
	        		SyndEntry temp = (SyndEntry)it.next();
	        		String link = temp.getLink();							
					String title = temp.getTitle();
					String author = temp.getAuthor();
					Date date=temp.getPublishedDate();
					String desc = temp.getDescription().getValue();												
					boolean addLink = true;
	        		lists.add(new RssBean(i,link,title,desc,author,date,addLink));
	        		if(number == i){
	        			item = temp;	        			
	        		}
	        		i++;
	            }
				request.setAttribute("currentNumber",number);
				String link = item.getLink();
				int index = link.indexOf('?');
				String newLink = link.substring(0,index)+link.substring(index + 1);
				newLink = newLink.replace('=','/');
				request.setAttribute("currentLink",newLink);
				request.setAttribute("currentTitle",item.getTitle());
				request.getPortletSession().setAttribute(feed,lists,PortletSession.APPLICATION_SCOPE);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/video/videoPortletView.jsp").include(request,response);
	        }	
			}catch(Exception e){
				resultBuffer.append(e.getMessage());
				response.getWriter().print(resultBuffer.toString());
			}
		}			
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){
			String feed = portlet.getParameter().substring(5,portlet.getParameter().length());
			request.setAttribute("feed",feed);
			request.setAttribute("portlet",portlet);
			
		}
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/video/videoPortletEdit.jsp").include(request,response);
	 }	
	 	
}
