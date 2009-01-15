package org.light.portlets.horoscope;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PopularItem;
import org.light.portal.model.PopularItemComments;
import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;

public class HoroscopePortlet extends LightGenericPortlet {

    public void processAction (ActionRequest request, ActionResponse response)
       throws PortletException, java.io.IOException {
        String action = request.getParameter("action");
        if("config".equals(action)){
           String items = request.getParameter("items");
           PortletObject portlet =getPortlet(request);
           if(portlet != null){
               portlet.setShowNumber(Integer.parseInt(items));
               this.getPortalService(request).save(portlet);
           }
           String max = request.getParameter("maxItems");
           PortletPreferences portletPreferences = request.getPreferences();		 
   		   portletPreferences.setValue("maxViewed",max);
   		   portletPreferences.store();
           //request.setAttribute("mode",PortletMode.VIEW.toString());
           response.setPortletMode(PortletMode.VIEW);
       }
        else if("pop".equals(action)){
        	String id = request.getParameter("parameter");
        	if(id != null){
        		PopularItem item = this.getPortalService(request).getPopularItemById(Integer.parseInt(id));
        		if(item != null){
	        		item.popIt();
	        		this.getPortalService(request).save(item);
	        		request.setAttribute("success", "You have voted this news successfully.");
        		}
        	}
        }
        else if("forward".equals(action)){
        	String id = request.getParameter("parameter");
        	if(id != null){
        		PopularItem item = this.getPortalService(request).getPopularItemById(Integer.parseInt(id));
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
	     		PopularItem item = this.getPortalService(request).getPopularItemById(Integer.parseInt(id));
	     		if(item != null){
	     			Bookmark bookmark = new Bookmark(item.getTitle(),item.getLink(),item.getTag(),item.getTag(),item.getDesc(),this.getUser(request).getId());
		            this.getPortalService(request).save(bookmark);
		            request.setAttribute("success", "You have saved this news to your bookmarks successfully.");
	     		}
	     	}
	    }
     }

    protected void doView (RenderRequest request, RenderResponse response)
      throws PortletException, java.io.IOException
    {	
    	User user = this.getUser(request);
    	if(this.getVisitedUser(request) != null){
    		user = this.getVisitedUser(request);
    	}
    	Portal portal = this.getPortal(request);
    	if(this.getVisitedPortal(request) != null)
    		portal = this.getVisitedPortal(request);
    	if(user != null){
    		String birthM = user.getBirthM();
    		String birthD = user.getBirthD();
    		if(birthM != null && birthD != null){
	    		int month=Integer.parseInt(birthM);
	    		int day = Integer.parseInt(birthD);
	
		    	if(request.getWindowState().equals(WindowState.MAXIMIZED)){
		    		List<Horoscope> horoscopes = this.getUserService(request).getHoroscopes();
		    		List<Connection> buddys = this.getChatService(request).getBuddysByUser(user.getId());
		    		for(Horoscope horoscope : horoscopes){	
		    			String desc = this.getUserService(request).getUserHoroscopeWeeklyInfo(horoscope.getId(),user.getLanguage());
				    	horoscope.setWeeklyInfo(desc);
	    				if((horoscope.getEndMonth() == month && horoscope.getEndDay() >= day) || (horoscope.getStartMonth() == month && horoscope.getStartDay() <= day))
	    					horoscope.setUser(user);	    			
		    			if(buddys != null && buddys.size() > 0){
			    			for(Connection buddy : buddys){
			    				int bm = Integer.parseInt(buddy.getBirthM());
				    			int bd = Integer.parseInt(buddy.getBirthD());
				    			if((horoscope.getEndMonth() == bm && horoscope.getEndDay() >= bd) || (horoscope.getStartMonth() == bm && horoscope.getStartDay() <= bd))			    				
				    				horoscope.addBuddy(buddy);
			    			}
		    			}
		    		}
		    		List<Horoscope> sortedHoroscopes = new ArrayList<Horoscope>();
		    		int i=0;
		    		int found = -1;
		    		for(Horoscope horoscope : horoscopes){
		    			if((horoscope.getEndMonth() == month && horoscope.getEndDay() >= day) || (horoscope.getStartMonth() == month && horoscope.getStartDay() <= day)){
		    				sortedHoroscopes.add(0,horoscope);
		    				found = i;
		    			}else if(found > 0){
		    				sortedHoroscopes.add(i - found,horoscope);
		    			}else{
		    				sortedHoroscopes.add(horoscope);
		    			}
			    		i++;	
		    		}
		    		request.setAttribute("horoscopes",sortedHoroscopes);
		    		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/horoscope/horoscopePortletMaxView.jsp").include(request,response);
		    	}else{		    	
			    	Horoscope horoscope = this.getUserService(request).getUserHoroscope(month,day);
			    	if(horoscope != null){
			    		String desc = this.getUserService(request).getUserHoroscopeWeeklyInfo(horoscope.getId(),user.getLanguage());
			    		horoscope.setWeeklyInfo(desc);
				    	request.setAttribute("horoscope",horoscope);
			    	}			 
					this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/horoscope/horoscopePortletView.jsp").include(request,response);
		    	}
    		}
    	}
    }

    protected void doEdit (RenderRequest request, RenderResponse response)
      throws PortletException, java.io.IOException
    {       		
        this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/horoscope/horoscopePortletEdit.jsp").include(request,response);

    }

}


