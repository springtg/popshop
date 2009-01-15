/* Copyright (c) 2006 Jianmin Liu.
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

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.light.portal.model.PortalTab;
import org.light.portal.model.PortletObjectRef;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import static org.light.portal.util.Constants.*;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class ContentPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
		 if("addFeed".equals(action)){
			 String feed = request.getParameter("feed");			 
			 if(feed != null && !"".equals(feed)){
				feed = URLDecoder.decode(feed,_CHARSET_UTF);
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
				    String imageUrl="";
				    if(rss.getImage() != null && rss.getImage().getUrl() != null)
				    	imageUrl = rss.getImage().getUrl().toString();
					String title = rss.getTitle();
					if(title == null && rss.getDescription() != null){
						String desc = rss.getDescription();
						if(desc.indexOf("-")>0){
							title = desc.substring(0,desc.indexOf("-"));
							if(title.length() > 30)
								title = title.substring(0,30);
						}else if(desc.length() > 15)
							title = desc.substring(0,15);
						else
							title = desc;
					}
					if(title == null) title = rss.getLink();										
					String feedName = String.valueOf(System.currentTimeMillis());
					String language = _LANGUAGE_EN;
					if(this.getUser(request) != null) language = this.getUser(request).getLanguage();
				    PortletObjectRef ref = new PortletObjectRef(
				    							feedName
				    						   ,"/rssPortlet.lp"
				    						   ,title
				    						   ,imageUrl
											   ,rss.getLink()
											   ,null
				    						   ,_MY_FEED
				    						   ,language
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,this.getUser(request).getUserId());
				    this.getPortalService(request).save(ref);
					List<PortletObjectRef> myFeedLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("myFeedLists",PortletSession.APPLICATION_SCOPE);
					if(myFeedLists != null){
						myFeedLists.add(ref);
						request.getPortletSession().setAttribute("myFeedLists",myFeedLists,PortletSession.APPLICATION_SCOPE);
					}
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("addFeedError",e.getMessage());
				}
			}
		 }
		 else if("addFeaturedFeed".equals(action)){
			 String feed = request.getParameter("feed");			 
			 if(feed != null && !"".equals(feed)){				
				try{
					URL feedUrl = new URL(feed);
	                SyndFeedInput input = new SyndFeedInput();
	                SyndFeed rss = input.build(new XmlReader(feedUrl));
				    String imageUrl="";
				    if(rss.getImage() != null && rss.getImage().getUrl() != null)
				    	imageUrl = rss.getImage().getUrl().toString();
					String title = rss.getTitle();
					if(title == null && rss.getDescription() != null){
						String desc = rss.getDescription();
						if(desc.indexOf("-")>0){
							title = desc.substring(0,desc.indexOf("-"));
							if(title.length() > 30)
								title = title.substring(0,30);
						}else if(desc.length() > 15)
							title = desc.substring(0,15);
						else
							title = desc;
					}
					if(title == null) title = rss.getLink();					
					String feedName = String.valueOf(System.currentTimeMillis());					
				    PortletObjectRef ref = new PortletObjectRef(
				    							feedName
				    						   ,"/rssPortlet.lp"
				    						   ,title
				    						   ,imageUrl
											   ,rss.getLink()
											   ,null
				    						   ,_FEATURED
				    						   ,_LANGUAGE_ALL
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,_DEFAULT_ROLE
				    						   ,this.getUser(request).getUserId());
				    this.getPortalService(request).save(ref);
					List<PortletObjectRef> featuredLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("featuredLists",PortletSession.APPLICATION_SCOPE);
					if(featuredLists != null){
						featuredLists.add(ref);
						request.getPortletSession().setAttribute("featuredLists",featuredLists,PortletSession.APPLICATION_SCOPE);
					}
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("addFeedError",e.getMessage());
				}
			}
		 }
		 else if("addCategoryFeed".equals(action)){
			 String feed = request.getParameter("feed");			 
			 if(feed != null && !"".equals(feed)){				
				try{
					URL feedUrl = new URL(feed);
	                SyndFeedInput input = new SyndFeedInput();
	                SyndFeed rss = input.build(new XmlReader(feedUrl));
				    String imageUrl="";
				    if(rss.getImage() != null && rss.getImage().getUrl() != null)
				    	imageUrl = rss.getImage().getUrl().toString();
					String title = rss.getTitle();
					if(title == null && rss.getDescription() != null){
						String desc = rss.getDescription();
						if(desc.indexOf("-")>0){
							title = desc.substring(0,desc.indexOf("-"));
							if(title.length() > 30)
								title = title.substring(0,30);
						}else if(desc.length() > 15)
							title = desc.substring(0,15);
						else
							title = desc;
					}
					if(title == null) title = rss.getLink();
					String feedName = String.valueOf(System.currentTimeMillis());
					User user = this.getUser(request);
					String tag = request.getParameter("tag");
				    PortletObjectRef ref = new PortletObjectRef(
				    							feedName
				    						   ,"/rssPortlet.lp"
				    						   ,title
				    						   ,imageUrl
											   ,rss.getLink()
											   ,null
				    						   ,tag
				    						   ,user.getRegion()
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,_DEFAULT_ROLE
				    						   ,this.getUser(request).getUserId());
				    this.getPortalService(request).save(ref);
				    List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
					for(ContentCategory dic : categories){
						 if(dic.isShowed()){
							 if(dic.getFeedLists() != null)
								 dic.getFeedLists().add(ref);						 
							 break;
						 }					 							 						 
					}	
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("addFeedError",e.getMessage());
				}
			}
		 }
		 else if("addSubCategoryFeed".equals(action)){
			 String feed = request.getParameter("feed");			 
			 if(feed != null && !"".equals(feed)){				
				try{
					URL feedUrl = new URL(feed);
	                SyndFeedInput input = new SyndFeedInput();
	                SyndFeed rss = input.build(new XmlReader(feedUrl));
				    String imageUrl="";
				    if(rss.getImage() != null && rss.getImage().getUrl() != null)
				    	imageUrl = rss.getImage().getUrl().toString();
					String title = rss.getTitle();
					if(title == null && rss.getDescription() != null){
						String desc = rss.getDescription();
						if(desc.indexOf("-")>0){
							title = desc.substring(0,desc.indexOf("-"));
							if(title.length() > 30)
								title = title.substring(0,30);
						}else if(desc.length() > 15)
							title = desc.substring(0,15);
						else
							title = desc;
					}
					if(title == null) title = rss.getLink();
					String feedName = String.valueOf(System.currentTimeMillis());
					User user = this.getUser(request);
					String tag = request.getParameter("tag");
					String subtag = request.getParameter("subtag");
				    PortletObjectRef ref = new PortletObjectRef(
			    								feedName
				    						   ,"/rssPortlet.lp"
				    						   ,rss.getTitle()
				    						   ,imageUrl
											   ,rss.getLink()
											   ,subtag
				    						   ,tag
				    						   ,user.getRegion()
				    						   ,1
				    						   ,1
				    						   ,0
				    						   ,1
				    						   ,1
				    						   ,1
				    						   ,null
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,6
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,0
				    						   ,"feed="+feed
				    						   ,_DEFAULT_ROLE
				    						   ,this.getUser(request).getUserId());
				    this.getPortalService(request).save(ref);
				    List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
					for(ContentCategory dic : categories){
						 if(dic.isShowed()){
							 for(ContentSubCategory sub : dic.getSubCategories()){
								 if(sub.isShowed()){
									if(sub.getFeedLists() != null)
										sub.getFeedLists().add(ref);
									break;
								 }								 
							 }						 
							 break;
						 }					 							 						 
					}	
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("addFeedError",e.getMessage());
				}
			}
		 }
		 else if("delete".equals(action)){
			 String name = request.getParameter("parameter");
			 PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
			 if(ref != null){				 
				 List<PortletObjectRef> myFeedLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("myFeedLists",PortletSession.APPLICATION_SCOPE);
				 myFeedLists.remove(ref);	
				 this.getPortalService(request).delete(ref);
			 }
		 }
		 else if("deleteFeatured".equals(action)){
			 String name = request.getParameter("parameter");
			 PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
			 if(ref != null){				 
				 List<PortletObjectRef> featuredLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("featuredLists",PortletSession.APPLICATION_SCOPE);
				 featuredLists.remove(ref);	
				 this.getPortalService(request).delete(ref);
			 }
		 }
		 else if("deleteCategoryFeed".equals(action)){
			 String name = request.getParameter("parameter");
			 PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
			 if(ref != null){				 
				 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
				 for(ContentCategory dic : categories){
					 if(dic.isShowed()){
						 if(dic.getFeedLists() != null)
							 dic.getFeedLists().remove(ref);						 
						 break;
					 }					 							 						 
				 }	
				 this.getPortalService(request).delete(ref);
			 }
		 }
		 else if("deleteSubCategoryFeed".equals(action)){
			 String name = request.getParameter("parameter");
			 PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
			 if(ref != null){				 
				 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
				 for(ContentCategory dic : categories){
					 if(dic.isShowed()){						 
						 for(ContentSubCategory sub : dic.getSubCategories()){
							 if(sub.isShowed()){
								if(sub.getFeedLists() != null)
									sub.getFeedLists().remove(ref);
								break;
							 }								 
						 }
						 break;
					 }					 							 						 
				 }	
				 this.getPortalService(request).delete(ref);
			 }
		 }
		 else if("deleteSearched".equals(action)){
			 String name = request.getParameter("parameter");
			 PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
			 if(ref != null){				 
				 List<PortletObjectRef> list =(List<PortletObjectRef>)request.getPortletSession().getAttribute("searchLists",PortletSession.APPLICATION_SCOPE);
				 list.remove(ref);
				 this.getPortalService(request).delete(ref);
			 }
		 }
		 else if("showMyFeed".equals(action)){
			 request.getPortletSession().setAttribute("show","myFeed",PortletSession.APPLICATION_SCOPE);			 
		 }
		 else if("hideMyFeed".equals(action)){
			 request.getPortletSession().setAttribute("show","default",PortletSession.APPLICATION_SCOPE);
		 }
		 else if("showFeatured".equals(action)){
			 request.getPortletSession().setAttribute("show","featured",PortletSession.APPLICATION_SCOPE);
		 }
		 else if("hideFeatured".equals(action)){
			 request.getPortletSession().setAttribute("show","default",PortletSession.APPLICATION_SCOPE);
		 }
		 else if("showCategory".equals(action)){
			 request.getPortletSession().setAttribute("show","category",PortletSession.APPLICATION_SCOPE);			 
		 }
		 else if("hideCategory".equals(action)){
			 request.getPortletSession().setAttribute("show","default",PortletSession.APPLICATION_SCOPE);
		 }
		 else if("showSubCategory".equals(action)){
			 request.getPortletSession().setAttribute("show","category",PortletSession.APPLICATION_SCOPE);
			 String name = request.getParameter("name");
			 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
			 if(categories != null && name != null){
				 for(ContentCategory dic : categories){
					 if(dic.isShowed()){
						 for(ContentSubCategory sub : dic.getSubCategories()){
							 if(sub.getName().equals(name))
								 sub.setShowed(true);						
							 else
								 sub.setShowed(false);
						 }
					 }					 							 						 
				 }
			 }
		 }
		 else if("hideSubCategory".equals(action)){
			 request.getPortletSession().setAttribute("show","category",PortletSession.APPLICATION_SCOPE);
			 String name = request.getParameter("name");
			 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
			 if(categories != null && name != null){
				 for(ContentCategory dic : categories){
					 if(dic.isShowed()){
						 for(ContentSubCategory sub : dic.getSubCategories()){
							 if(sub.getName().equals(name))								
								 sub.setShowed(false);
						 }
					 }					 							 						 
				 }
			 }
		 }
		 else if("showCategoryContent".equals(action)){
			 String name = request.getParameter("name");
			 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
			 if(categories != null && name != null){
				 for(ContentCategory dic : categories){
					 if(dic.getName().equals(name))
						 dic.setShowed(true);						
					 else
						 dic.setShowed(false);		
					 
						 
				 }
			 }
		 }
		 else if("hideCategoryContent".equals(action)){
			 String name = request.getParameter("name");
			 List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
			 if(categories != null && name != null){
				 for(ContentCategory dic : categories){
					 if(dic.getName().equals(name)){
						 dic.setShowed(false);
						 break;
					 }
						 
				 }
			 }
		 }
//		 else {
//			 request.getPortletSession().setAttribute("show","default",PortletSession.APPLICATION_SCOPE);
//		 }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		PortalTab portalTab = getPortalTab(request);		
		String widths="300,300,300";
		int columns = 3;
				
		if(portalTab != null){			
			widths = portalTab.getWidths();	
			String[] widthArray = widths.split(",");
			columns = widthArray.length;
		}
		
		List<PortletObjectRef> defaultLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("defaultLists",PortletSession.APPLICATION_SCOPE);
		List<PortletObjectRef> myFeedLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("myFeedLists",PortletSession.APPLICATION_SCOPE);
		List<PortletObjectRef> featuredLists =(List<PortletObjectRef>)request.getPortletSession().getAttribute("featuredLists",PortletSession.APPLICATION_SCOPE);
		List<ContentCategory> categories =(List<ContentCategory>)request.getPortletSession().getAttribute("categories",PortletSession.APPLICATION_SCOPE);
		
		if(defaultLists == null){
			List<PortletObjectRef> list = this.getPortalService(request).getPortletRefsByUser(this.getUser(request).getUserId());
			defaultLists = new ArrayList<PortletObjectRef>();
			myFeedLists = new ArrayList<PortletObjectRef>();
			featuredLists = new ArrayList<PortletObjectRef>();
			categories = new ArrayList<ContentCategory>();
			for(PortletObjectRef ref : list){
				if(ref.getTag().equals(_DEFAULT)){
					defaultLists.add(ref);
				}else if(ref.getTag().equals(_MY_FEED)){
					myFeedLists.add(ref);
				}else if(ref.getTag().equals(_FEATURED)){
					featuredLists.add(ref);
				}else{
					if(ref.getSubTag() == null){
						ContentCategory fd = new ContentCategory(ref.getTag(),ref.getTagTitle());
						if(!categories.contains(fd)){
							fd.addFeed(ref);
							categories.add(fd);					
						}else{
							for(ContentCategory feedDictionary : categories){
								if(feedDictionary.equals(fd)){
									feedDictionary.addFeed(ref);
								    break;
							    }
							}
						}	
					}else{
						ContentCategory category = new ContentCategory(ref.getTag(),ref.getTagTitle());
						ContentSubCategory sub = new ContentSubCategory(ref.getSubTag(),ref.getSubTagTitle());
						if(!categories.contains(category)){							
							List<ContentSubCategory> subs = new ArrayList<ContentSubCategory>();
							sub.addFeed(ref);
							subs.add(sub);
							category.setSubCategories(subs);
							categories.add(category);					
						}else{
							for(ContentCategory categoryItem : categories){
								if(categoryItem.equals(category)){
									if(categoryItem.getSubCategories() == null){
										List<ContentSubCategory> subs = new ArrayList<ContentSubCategory>();
										sub.addFeed(ref);
										subs.add(sub);
										categoryItem.setSubCategories(subs);
									}else if(!categoryItem.getSubCategories().contains(sub)){
										sub.addFeed(ref);
										categoryItem.addSub(sub);
										break;
									}else{
										for(ContentSubCategory subCategory : categoryItem.getSubCategories()){
											if(subCategory.equals(sub)){
												subCategory.addFeed(ref);
											    break;
										    }
										}
									}
							    }
							}
						}	
					}
				}
			}
			request.getPortletSession().setAttribute("defaultLists",defaultLists,PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("myFeedLists",myFeedLists,PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("featuredLists",featuredLists,PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("categories",categories,PortletSession.APPLICATION_SCOPE);
		}
		
		String show = (String) request.getPortletSession().getAttribute("show",PortletSession.APPLICATION_SCOPE);
		if(show == null) show ="default";
		request.setAttribute("show", show);
		request.setAttribute("columns", columns);
		request.setAttribute("defaultLists", defaultLists);
		request.setAttribute("myFeedLists", myFeedLists);
		request.setAttribute("featuredLists", featuredLists);
		request.setAttribute("categories", categories);
		
		String keyword = request.getParameter("keyword");
		if(keyword != null){
			List<PortletObjectRef> list = this.getPortalService(request).getPortletRefsByUserAndKeyword(this.getUser(request).getUserId(),keyword);			
			request.getPortletSession().setAttribute("searchLists", list,PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("keyword", keyword,PortletSession.APPLICATION_SCOPE);
		}else{
			request.getPortletSession().removeAttribute("searchLists", PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().removeAttribute("keyword", PortletSession.APPLICATION_SCOPE);
		}
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/addContent.jsp").include(request,response);		  
	 }	

}
