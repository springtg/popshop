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
package org.light.portlets.photo;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
import org.light.portlets.rss.RssCacheFactory;

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
public class PhotoPortlet extends LightGenericPortlet {
	
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
		PortletObject portlet = this.getPortlet(request);
		String parameter = portlet.getParameter();
		int ind = parameter.indexOf("=");
		String feed = parameter.substring(ind + 1);
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
				List<RssBean> lists = RssCacheFactory.getInstance().getRss(feed);
				String num = request.getParameter("number");
	        	int number = 0;
	        	if(num != null)
	        		number = Integer.parseInt(num);
	        	if(number >= lists.size()) number = 0;
	        	if(number < 0 ) number = lists.size() - 1;

	        	if(lists.get(number) != null){
		        	String img=lists.get(number).getDesc().toString();
		        	int index = img.indexOf("<a");
		        	String a = img.substring(index + 2);
		        	index = a.indexOf("<a");
		        	a = a.substring(index);
		        	index = a.indexOf(">");
		        	a = a.substring(0,index);
		        	index = img.indexOf("<img");
		        	img = img.substring(index);
		        	index = img.indexOf("/>");
		        	img = img.substring(0,index+2);
		        	request.setAttribute("currentNumber",number);
		        	request.setAttribute("currentTitle",lists.get(number).getTitle());
		        	request.setAttribute("currentImage",img);
		        	request.setAttribute("currentImageLink",lists.get(number).getLink());
		        	request.getPortletSession().setAttribute(feed,lists,PortletSession.APPLICATION_SCOPE);
		        	this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/photo/photoPortletView.jsp").include(request,response);
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
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/photo/photoPortletEdit.jsp").include(request,response);
	 }	
	 
}
