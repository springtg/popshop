package org.light.portlets.popular;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PopularItem;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserPicture;
import org.light.portal.model.ViewedItem;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;

public class ViewedItemPortlet extends LightGenericPortlet {

    public void processAction (ActionRequest request, ActionResponse response)
       throws PortletException, java.io.IOException {
        String action = request.getParameter("action");
        if("config".equals(action)){
       	 String viewedBy = request.getParameter("viewedBy");
       	 PortletPreferences portletPreferences = request.getPreferences();		 
	 		 portletPreferences.setValue("viewedBy",viewedBy);

	    	 String items = request.getParameter("items");
	         PortletObject portlet =getPortlet(request);
	         if(portlet != null){
	             portlet.setShowNumber(Integer.parseInt(items));
	             this.getPortalService(request).save(portlet);
	         }
	         
	         String max = request.getParameter("maxItems");	         
	 		 portletPreferences.setValue("maxViewed",max);
	 		 portletPreferences.store();
	         //request.setAttribute("mode",PortletMode.VIEW.toString());
	         response.setPortletMode(PortletMode.VIEW);
      }
       else if("pop".equals(action)){
       	String id = request.getParameter("parameter");
       	if(id != null){
       		ViewedItem vItem = this.getPortalService(request).getViewedItemById(Integer.parseInt(id));
       		if(vItem != null){
	        		PopularItem item = this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),vItem.getLink());
	        		if(item != null){
		        		item.popIt();
	        		}else{
	        			item = new PopularItem(vItem.getLink(),vItem.getTitle(),vItem.getDesc(),vItem.getTag(),vItem.getLocale(),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
	        		}
		        	this.getPortalService(request).save(item);
		        	request.setAttribute("success", "You have voted this news successfully.");	        		
       		}
       	}
       }
       else if("forward".equals(action)){
       	String id = request.getParameter("parameter");
       	if(id != null){
       		ViewedItem item = this.getPortalService(request).getViewedItemById(Integer.parseInt(id));
       		if(item != null){
	        		User user = this.getUser(request);
	                if(user != null){
	                    List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
	                    for(Connection friend : userFriends){
	                        Message message = new Message(user.getDisplayName()+" send you a news link.",
	                                "<a href='"+item.getLink()+"' target='_blank'>"+item.getTitle()+"</a><br/><br/>"+item.getDesc(),friend.getBuddyUserId(),user.getId());
	                        this.getUserService(request).sendMessage(message);
	                    }
	                    request.setAttribute("success", "You have forwarded this news to your friends successfully.");
	                }
       		}
       	}
       }
	    else if("bookmark".equals(action)){
	     	String id = request.getParameter("parameter");
	     	if(id != null){
	     		ViewedItem item = this.getPortalService(request).getViewedItemById(Integer.parseInt(id));
	     		if(item != null){
	     			Bookmark bookmark = new Bookmark(item.getTitle(),item.getLink(),item.getTag(),item.getTag(),item.getDesc(),this.getUser(request).getId());
		            this.getPortalService(request).save(bookmark);
		            request.getPortletSession().removeAttribute("bookmarkTags", PortletSession.APPLICATION_SCOPE);					   
		            request.getPortletSession().removeAttribute("defaultBookmarks", PortletSession.APPLICATION_SCOPE);		            
		            request.setAttribute("success", "You have saved this news to your bookmarks successfully.");
	     		}
	     	}
	    }
	    else if("delete".equals(action)){
	     	String id = request.getParameter("parameter");
	     	if(id != null){
	     		ViewedItem item = this.getPortalService(request).getViewedItemById(Integer.parseInt(id));
	     		if(item != null){	     			
		            this.getPortalService(request).delete(item);
		            request.setAttribute("success", "You have deleted this viewed news.");
	     		}
	     	}
	    }
	    else if("picture".equals(action)){
	     	String id = request.getParameter("parameter");
	     	if(id != null){
	     		ViewedItem item = this.getPortalService(request).getViewedItemById(Integer.parseInt(id));
	     		if(item != null){
	     			User user = this.getUser(request);
	     			if(user != null){
		     			URL url = new URL(item.getLink());
		    			java.awt.image.BufferedImage image=javax.imageio.ImageIO.read(url);
		    			int width = 300;
		    			int height= 280;
		    			if(image != null){
		    				width = image.getWidth();
		    				height= image.getHeight();
		    			}
		    			
		    			int status = user.getDefaultPictureStatus();
		    			UserPicture picture = new UserPicture(user.getId(),item.getLink(),status,width,height);			
		    			this.getPortalService(request).save(picture);	
		    			List<UserPicture> userPictures = (List<UserPicture>)request.getPortletSession().getAttribute("myPictures",PortletSession.APPLICATION_SCOPE);
		    		    if(userPictures == null)
		    		    {
		    		    	userPictures= new ArrayList<UserPicture>();
		    		    }
		    			userPictures.add(picture);
		    			request.getPortletSession().setAttribute("myPictures", userPictures, PortletSession.APPLICATION_SCOPE);		     					     		
			            request.setAttribute("success", "You have saved this picture to your pictures list successfully.");
	     			}
	     		}
	     	}
	    }
     }

    protected void doView (RenderRequest request, RenderResponse response)
      throws PortletException, java.io.IOException
    {   
    	 PortletPreferences portletPreferences = request.getPreferences();	
		 int  viewedBy= Integer.parseInt(portletPreferences.getValue("viewedBy","0"));
		 long userId = 0;
		 if(viewedBy != 0){
			 userId = this.getUser(request).getId();
			 if(this.getVisitedUser(request) != null)
			   userId = this.getVisitedUser(request).getId();
		 }
		 String region = "en";
		 if(this.getUser(request) != null){
			 region = this.getUser(request).getRegion();
		 }
    	 String indx= request.getParameter("index");
		 if(indx != null){
			long id = Long.parseLong(indx);
			String previous = request.getParameter("previous");
			String next = request.getParameter("next");
			if(previous != null) id++;
			if(next != null) id--;
			ViewedItem item = this.getPortalService(request).getViewedItemNext(id, userId,region);
			if(item != null){
				request.setAttribute("item",item);
				request.setAttribute("readerHeight",300);
				request.setAttribute("readerMaxHeight",600);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/viewedItemReader.jsp").include(request,response);
				return;
			}
		 }
    	 PortletObject portlet = this.getPortlet(request);
		 int start = 1;
		 int page = 1;
		 int showNumber = 6;
		 if(portlet != null && portlet.getShowNumber() > 0){
			 showNumber = portlet.getShowNumber();
		 }
		 int total = this.getPortalService(request).getViewedItemTotal(region,userId);
		 if(request.getWindowState().equals(WindowState.MAXIMIZED)){		   
		   String pageParam = request.getParameter("page"); 
		   String  max= portletPreferences.getValue("maxViewed","10");		   
		   showNumber = Integer.parseInt(max);
		   if(pageParam != null) page = Integer.parseInt(pageParam);			   	
	       int pages  = total / showNumber;
		   if(total % showNumber != 0) pages++;
		   if(page > pages) page = pages;
		   start = (page - 1) *  showNumber + 1;
		   if(start < 1)start = 1;
		   int end = start + showNumber - 1;
		   if(end > total) end = total;
		   request.setAttribute("page",page);
		   request.setAttribute("start",start);		   
		   request.setAttribute("end",end);
		   request.setAttribute("total",total);
		   request.setAttribute("pages",pages);
		 }		
		 List<ViewedItem> list =this.getPortalService(request).getViewedItems(start - 1,showNumber,region,userId);		 
		 
		 request.setAttribute("lists",list);
		 if(total > showNumber){
			 request.setAttribute("showMore",true);
		 }
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/viewedItemPortletMaxView.jsp").include(request,response);
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/viewedItemPortletView.jsp").include(request,response);        
    }

    
    protected void doEdit (RenderRequest request, RenderResponse response)
    throws PortletException, java.io.IOException
  {

      PortletObject portlet = this.getPortlet(request);
      int showNumber = portlet.getShowNumber();
      if(showNumber <=0) showNumber = 6;
      request.setAttribute("showNumber",showNumber);
      PortletPreferences portletPreferences = request.getPreferences();		 
	  String  max= portletPreferences.getValue("maxViewed","10");
	  String  viewedBy= portletPreferences.getValue("viewedBy","0");
	  request.setAttribute("maxNumber",max);
	  request.setAttribute("viewedBy",viewedBy);
      this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/viewedItemPortletEdit.jsp").include(request,response);

  }
}

