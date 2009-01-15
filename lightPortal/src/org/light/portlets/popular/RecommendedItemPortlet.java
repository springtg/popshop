package org.light.portlets.popular;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

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
import org.light.portal.model.PopularItemComments;
import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.RecommendedItem;
import org.light.portal.model.User;
import org.light.portal.model.UserKeyword;
import org.light.portal.model.ViewedItem;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;
import org.light.portlets.rss.RssBean;

public class RecommendedItemPortlet  extends LightGenericPortlet {

    public void processAction (ActionRequest request, ActionResponse response)
       throws PortletException, java.io.IOException {
        String action = request.getParameter("action");
        if("config".equals(action)){
           String items = request.getParameter("items"); 
           String max = request.getParameter("maxItems");
           PortletObject portlet =getPortlet(request);
           if(portlet != null){
               portlet.setShowNumber(Integer.parseInt(items));
               this.getPortalService(request).save(portlet);
           	           
	           PortletPreferences portletPreferences = request.getPreferences();		 
	   		   portletPreferences.setValue("maxViewed",max);
	   		   portletPreferences.store();
           }
   		   String growKeyword = request.getParameter("growKeyword");   		   
		   User user = this.getUser(request);
		   if(user != null){
			   if(growKeyword != null){
				   user.setGrowKeyword(1);
			   }else{
				   user.setGrowKeyword(0);
			   }
			   this.getUserService(request).saveUser(user);
   		   }
		   request.getPortletSession().setAttribute("showNumber",items,PortletSession.APPLICATION_SCOPE);
		   request.getPortletSession().setAttribute("maxViewed",max,PortletSession.APPLICATION_SCOPE);
           //request.setAttribute("mode",PortletMode.VIEW.toString());
           response.setPortletMode(PortletMode.VIEW);
       }      
        else if("pop".equals(action)){
        	String id = request.getParameter("parameter");
        	if(id != null){
        		RecommendedItem vItem = this.getPortalService(request).getRecommendedItemById(Integer.parseInt(id));
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
        		RecommendedItem item = this.getPortalService(request).getRecommendedItemById(Integer.parseInt(id));
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
	     		RecommendedItem item = this.getPortalService(request).getRecommendedItemById(Integer.parseInt(id));
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
	     		RecommendedItem item = this.getPortalService(request).getRecommendedItemById(Integer.parseInt(id));
	     		if(item != null){	     			
		            this.getPortalService(request).delete(item);
		            request.setAttribute("success", "You have deleted this recommended news.");
	     		}
	     	}
	    }
	    else if("deleteAll".equals(action)){	     	
	     	if(this.getUser(request) != null){
	     		this.getPortalService(request).deleteRecommendedItems(this.getUser(request).getId());
	     		request.setAttribute("success", "You have deleted all recommended news.");	     		
	     	}
	    }
     }

    protected void doView (RenderRequest request, RenderResponse response)
      throws PortletException, java.io.IOException
    {	 
    	 long userId = this.getUser(request).getId();
		 if(this.getVisitedUser(request) != null)
			   userId = this.getVisitedUser(request).getId();
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
			RecommendedItem item = this.getPortalService(request).getRecommendedItemNext(id, userId,region);
			if(item != null){
				request.setAttribute("item",item);
				request.setAttribute("readerHeight",300);
				request.setAttribute("readerMaxHeight",600);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/recommendedItemReader.jsp").include(request,response);
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
		 if(request.getPortletSession().getAttribute("showNumber",PortletSession.APPLICATION_SCOPE) != null)
			 showNumber = Integer.parseInt((String)request.getPortletSession().getAttribute("showNumber",PortletSession.APPLICATION_SCOPE));		  
		 PortletPreferences portletPreferences = request.getPreferences();	

		 if(request.getWindowState().equals(WindowState.MAXIMIZED)){		   
		   String  max= portletPreferences.getValue("maxViewed","10");
		   if(request.getPortletSession().getAttribute("maxViewed",PortletSession.APPLICATION_SCOPE) != null)
			   max= (String)request.getPortletSession().getAttribute("maxViewed",PortletSession.APPLICATION_SCOPE);
		   showNumber = Integer.parseInt(max);
		 }
		 String pageParam = request.getParameter("page"); 
		 if(pageParam != null) page = Integer.parseInt(pageParam);			   	
		 int total = this.getPortalService(request).getRecommendedItemTotal(userId);
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
		
		 List<RecommendedItem> list =this.getPortalService(request).getRecommendedItems(start - 1,showNumber,userId);		 
		 request.setAttribute("lists",list);
		 //if(list != null && list.size() > showNumber)
		 request.setAttribute("showMore",true);
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/recommendedItemPortletMaxView.jsp").include(request,response);
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/recommendedItemPortletView.jsp").include(request,response);        
	}
	
	
	protected void doEdit (RenderRequest request, RenderResponse response)
	throws PortletException, java.io.IOException
	{
	
	  PortletObject portlet = this.getPortlet(request);
	  int showNumber = 0;
	  if(portlet != null) showNumber = portlet.getShowNumber();
	  if(request.getPortletSession().getAttribute("showNumber",PortletSession.APPLICATION_SCOPE) != null)
		 showNumber = Integer.parseInt((String)request.getPortletSession().getAttribute("showNumber",PortletSession.APPLICATION_SCOPE));		  		 
	  if(showNumber <=0) showNumber = 6;
	  request.setAttribute("showNumber",showNumber);
	  PortletPreferences portletPreferences = request.getPreferences();		 
	  String  max= portletPreferences.getValue("maxViewed","10");
	  if(request.getPortletSession().getAttribute("maxViewed",PortletSession.APPLICATION_SCOPE) != null)
		 max= (String)request.getPortletSession().getAttribute("maxViewed",PortletSession.APPLICATION_SCOPE);
	  request.setAttribute("maxNumber",max);
	  if(this.getUser(request) != null && this.getVisitedUser(request) == null){
		  List<UserKeyword> keywords = this.getPortalService(request).getUserKeywords(this.getUser(request).getId());
		  request.setAttribute("keywords",keywords);		  
		  request.setAttribute("growKeyword",this.getUser(request).getGrowKeyword());
	  }	 
	  
	  this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/popular/recommendedItemPortletEdit.jsp").include(request,response);
	
	}		
}


