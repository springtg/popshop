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
package org.light.portlets.youtube;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.portlet.core.impl.PortletPreference;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class YouTubePortlet extends LightGenericPortlet {
	 	     
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {		
		String action = request.getParameter("action");
		if("search".equals(action)){
		   String tag = request.getParameter("tag");
		   if(tag != null && tag.trim().length() > 0 ){
			   String url ="http://www.youtube.com/api2_rest?method=youtube.videos.list_by_tag&dev_id=4adPqGmch9M&tag="+tag;		   		
			   HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");			
			   try{
				   URL youTubeUrl = new URL(url);
				   URLConnection con = youTubeUrl.openConnection();
	               InputStream in = con.getInputStream();
//	               StringBuffer buffer = new  StringBuffer();
//	   			    int i;
//		   			while ((i = in.read()) != -1){
//		   					buffer.append((char) i);
//		   			}
//		   			String text = buffer.toString();	   			
//		   			Document document = DocumentHelper.parseText(text);
	                Document document = new SAXReader().read(in);
		   			List list1 = document.selectNodes( "//ut_response/video_list/video" );
		   			List<VideoBean> videos = new ArrayList<VideoBean>();
		   			for (Iterator iter = list1.iterator(); iter.hasNext(); ) {
						Node node = (Node) iter.next();
						String author = node.selectSingleNode("author").getStringValue();
						String id = node.selectSingleNode("id").getStringValue();
						String title = node.selectSingleNode("title").getStringValue();
			            String desc = node.selectSingleNode("description").getStringValue();
			            String picUrl = node.selectSingleNode("thumbnail_url").getStringValue();
			            String videoUrl = node.selectSingleNode("url").getStringValue();
			            String seconds = node.selectSingleNode("length_seconds").getStringValue();
			            String ratingAvg = node.selectSingleNode("rating_avg").getStringValue();
			            String ratingCount = node.selectSingleNode("rating_count").getStringValue();
			            String viewCount = node.selectSingleNode("view_count").getStringValue();
			            String commentCount = node.selectSingleNode("comment_count").getStringValue();
			            String tags = node.selectSingleNode("tags").getStringValue();	
			            VideoBean video = new VideoBean(author,id,title,desc,picUrl,videoUrl,seconds,ratingAvg,ratingCount,viewCount,commentCount,tags);
			            videos.add(video);
					}
		   			request.getPortletSession().setAttribute("youTubes",videos,PortletSession.APPLICATION_SCOPE);		   			
			   }catch(Exception e){ }
		   }else{
			   request.getPortletSession().setAttribute("youTubes",null,PortletSession.APPLICATION_SCOPE);
		   }
		}
		if("author".equals(action)){
			   String searchAuthor = request.getParameter("author");
			   String url ="http://www.youtube.com/api2_rest?method=youtube.videos.list_by_user&dev_id=4adPqGmch9M&user="+searchAuthor;		   		
			   HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");			
			   try{
				   URL youTubeUrl = new URL(url);
				   URLConnection con = youTubeUrl.openConnection();
	               InputStream in = con.getInputStream();
	               Document document = new SAXReader().read(in);
		   			List list1 = document.selectNodes( "//ut_response/video_list/video" );
		   			List<VideoBean> videos = new ArrayList<VideoBean>();
		   			for (Iterator iter = list1.iterator(); iter.hasNext(); ) {
						Node node = (Node) iter.next();
						String author = node.selectSingleNode("author").getStringValue();
						String id = node.selectSingleNode("id").getStringValue();
						String title = node.selectSingleNode("title").getStringValue();
			            String desc = node.selectSingleNode("description").getStringValue();
			            String picUrl = node.selectSingleNode("thumbnail_url").getStringValue();
			            String videoUrl = node.selectSingleNode("url").getStringValue();
			            String seconds = node.selectSingleNode("length_seconds").getStringValue();
			            String ratingAvg = node.selectSingleNode("rating_avg").getStringValue();
			            String ratingCount = node.selectSingleNode("rating_count").getStringValue();
			            String viewCount = node.selectSingleNode("view_count").getStringValue();
			            String commentCount = node.selectSingleNode("comment_count").getStringValue();
			            String tags = node.selectSingleNode("tags").getStringValue();
			            VideoBean video = new VideoBean(author,id,title,desc,picUrl,videoUrl,seconds,ratingAvg,ratingCount,viewCount,commentCount,tags);
			            videos.add(video);
					}
		   			request.getPortletSession().setAttribute("youTubes",videos,PortletSession.APPLICATION_SCOPE);
			   }catch(Exception e){ }
		}		
		if("featured".equals(action)){			   
			   String url ="http://www.youtube.com/api2_rest?method=youtube.videos.list_featured&dev_id=4adPqGmch9M";		   		
			   HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");			
			   try{
				   URL youTubeUrl = new URL(url);
				   URLConnection con = youTubeUrl.openConnection();
	               InputStream in = con.getInputStream();
	               Document document = new SAXReader().read(in);
		   			List list1 = document.selectNodes( "//ut_response/video_list/video" );
		   			List<VideoBean> videos = new ArrayList<VideoBean>();
		   			for (Iterator iter = list1.iterator(); iter.hasNext(); ) {
						Node node = (Node) iter.next();
						String author = node.selectSingleNode("author").getStringValue();
						String id = node.selectSingleNode("id").getStringValue();
						String title = node.selectSingleNode("title").getStringValue();
			            String desc = node.selectSingleNode("description").getStringValue();
			            String picUrl = node.selectSingleNode("thumbnail_url").getStringValue();
			            String videoUrl = node.selectSingleNode("url").getStringValue();
			            String seconds = node.selectSingleNode("length_seconds").getStringValue();
			            String ratingAvg = node.selectSingleNode("rating_avg").getStringValue();
			            String ratingCount = node.selectSingleNode("rating_count").getStringValue();
			            String viewCount = node.selectSingleNode("view_count").getStringValue();
			            String commentCount = node.selectSingleNode("comment_count").getStringValue();
			            String tags = node.selectSingleNode("tags").getStringValue();
			            VideoBean video = new VideoBean(author,id,title,desc,picUrl,videoUrl,seconds,ratingAvg,ratingCount,viewCount,commentCount,tags);
			            videos.add(video);
					}
		   			request.getPortletSession().setAttribute("youTubes",videos,PortletSession.APPLICATION_SCOPE);
			   }catch(Exception e){ }
			}
		if("clear".equals(action)){
			request.getPortletSession().setAttribute("youTubes",null,PortletSession.APPLICATION_SCOPE);
		}
	  }
 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		 List<VideoBean> videos = (List<VideoBean>) request.getPortletSession().getAttribute("youTubes",PortletSession.APPLICATION_SCOPE);		   			
		 int videoCount = 0;
		 if(videos != null)
			 videoCount = videos.size();
		 request.setAttribute("videosCount",videoCount);
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/youTube/youTubePortletMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/youTube/youTubePortletView.jsp").include(request,response);
	 }	
	
}