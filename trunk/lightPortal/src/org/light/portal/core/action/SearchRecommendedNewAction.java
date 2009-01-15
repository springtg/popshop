package org.light.portal.core.action;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.RecommendedItem;
import org.light.portal.model.User;
import org.light.portal.model.UserKeyword;
import org.light.portal.model.ViewedItem;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class SearchRecommendedNewAction extends Thread {
	
	private User user;
	private PortalService portalService;
	public SearchRecommendedNewAction(User user, PortalService portalService){
		this.user = user;
		this.portalService = portalService;
		
	}
	
	public void run() {
		List<UserKeyword> keywords = this.portalService.getUserKeywords(user.getId());
		if(keywords != null && keywords.size() > 0){
			List<String> lists = this.portalService.getFeedsByLanguage(user.getLanguage());
			for(String param : lists){		
				int index = param.indexOf("feed=");
				String feed = param.substring(index+5).trim();
				try{
		            URL feedUrl = new URL(feed);
		            SyndFeedInput input = new SyndFeedInput();
		            SyndFeed rss = input.build(new XmlReader(feedUrl));
		            Collection items = rss.getEntries();
		            if(items != null && !items.isEmpty()){
		                for(Iterator i = items.iterator(); i.hasNext(); ){
		                    SyndEntry item = (SyndEntry)i.next();	                        
	                        String title = item.getTitle();
	                        if(title != null){
	                        	for(UserKeyword keyword : keywords){
	                        		if(title.toLowerCase().indexOf(keyword.getKeyword().toLowerCase()) > 0){
	                        			String link =item.getLink();
	                        			RecommendedItem news = this.portalService.getRecommendedItemByLink(link);
	                        			ViewedItem viewed = this.portalService.getViewedItemByLink(link);
	                        			if(news == null){
	                        				//don't recommend to user if user already read the news
	                        				if(viewed == null){
		                        				String desc = item.getDescription().getValue();
		                        				news = new RecommendedItem(link,title,desc,"portlet.title.recommendedItem",user.getLanguage(),user.getId());
		                        				this.portalService.save(news);
	                        				}
	                        			}else if(news.getRead() == 0){
	                        				news.weighIt();
	                        				this.portalService.save(news);
	                        			}	                        				     		                        
	                        		}
	                        	}
		                       
	                        }
		                }
		            }
		         }catch(Exception e){
		             
		         }
			}
		}
	}
}
