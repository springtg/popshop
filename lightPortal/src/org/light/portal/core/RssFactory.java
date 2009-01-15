package org.light.portal.core;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.light.portal.model.PortletObjectRef;
import org.light.portal.util.DateFormatter;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.blog.Blog;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.group.GroupForum;

import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedOutput;

public class RssFactory {
	
	private static RssFactory instance = new RssFactory();	
	private static final DateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd");
	private static String feedType = "rss_2.0";
	private static String fileName = null;
	private RssFactory(){		
	}
	
	public static RssFactory getInstance(){
		return instance;
	}
	public String getOpml(List<PortletObjectRef> list,String xml){
		try {			            
			StringBuffer buffer = new StringBuffer();
			buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
				  .append("\n")
				  .append("<opml version=\"1.1\">")
				  .append("<head><title>")
				  .append(OrganizationThreadLocal.getWebId())
				  .append(" Exported my feeds</title><dateCreated>")
				  .append(DateFormatter.format(new Date(System.currentTimeMillis()),"EEE, MMMM dd, yyyy HH:mm aaa"))
				  .append("</dateCreated></head>")
				  .append("\n")
				  .append("<body><outline text=\"")
				  .append(OrganizationThreadLocal.getWebId())
				  .append(" Exported my feeds\">")
				  .append("\n")
				  ;
			for(PortletObjectRef myfeed : list){
				if(myfeed.getParameter() != null && myfeed.getParameter().indexOf("feed") >= 0){
					String feed = myfeed.getParameter().substring(myfeed.getParameter().indexOf("=") + 1).trim();
					String title = myfeed.getLabel();
					if(title.indexOf("&") > 0) 
						title=title.replaceAll("&","&amp;").trim();				
					if(feed.indexOf("&") > 0) 
						feed=feed.replaceAll("&","&amp;");
					
					buffer.append("<outline text=\"")
						  .append(title)
						  .append("\" ")
						  .append("title=\" ")
						  .append(title)
						  .append("\" type=\"rss\" xmlUrl=\"")
						  .append(feed)
						  .append("\" />")
						  .append("\n")
						  ;
				}
			}
			buffer.append("</outline></body></opml>");
            //final Writer writer = new FileWriter(xml);
            FileOutputStream fileoutstream = new FileOutputStream(xml);
            Writer writer = new OutputStreamWriter(fileoutstream, "UTF-8");
            writer.write(buffer.toString());
            writer.close();
        }			
        catch (Exception ex) {
            ex.printStackTrace();               
     }
		return null;
	}
	public String getAllOpml(List<PortletObjectRef> list,String xml){
		try {			            
			StringBuffer buffer = new StringBuffer();
			buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
				  .append("\n")
				  .append("<opml version=\"1.1\">")
				  .append("<head><title>")
				  .append(OrganizationThreadLocal.getWebId())
				  .append(" Exported my feeds</title><dateCreated>")
				  .append(DateFormatter.format(new Date(System.currentTimeMillis()),"EEE, MMMM dd, yyyy HH:mm aaa"))
				  .append("</dateCreated></head>")
				  .append("\n")
				  .append("<body><outline text=\"")
				  .append(OrganizationThreadLocal.getWebId())
				  .append(" Exported my feeds\">")
				  .append("\n")
				  ;
			for(PortletObjectRef feed : list){
				if(feed.getParameter() != null && feed.getParameter().indexOf("feed") >= 0){
					String url = feed.getParameter().substring(feed.getParameter().indexOf("=") + 1).trim();
					String title = feed.getLabel();
					if(title.indexOf("&") > 0) 
						title=title.replaceAll("&","&amp;").trim();				
					if(url.indexOf("&") > 0) 
						url=url.replaceAll("&","&amp;");
					
					buffer.append("<outline ")
						  .append("text=\"")
						  .append(title)
						  .append("\" ")
						  .append("title=\" ")
						  .append(title)
						  .append("\" ")
						  .append("type=\"rss\" ")
						  .append("xmlUrl=\"")
						  .append(url)
						  .append("\" ")
						  .append("name=\"")
						  .append(feed.getName())
						  .append("\" ")
						  .append("userId=\"")
						  .append(feed.getUserId())
						  .append("\" ")
						  .append("tag=\"")
						  .append(feed.getTag())
						  .append("\" ")
						  .append("subTag=\"")
						  .append(feed.getSubTag())
						  .append("\" ")
						  .append("language=\"")
						  .append(feed.getLanguage())
						  .append("\" ")
						  .append("/>")
						  .append("\n")
						  ;
				}
			}
			buffer.append("</outline></body></opml>");
            //final Writer writer = new FileWriter(xml);
            FileOutputStream fileoutstream = new FileOutputStream(xml);
            Writer writer = new OutputStreamWriter(fileoutstream, "UTF-8");
            writer.write(buffer.toString());
            writer.close();
        }			
        catch (Exception ex) {
            ex.printStackTrace();               
     }
		return null;
	}
	public String getForumRss(String category,String categoryDesc,String id,String xml,List<ForumPost> topics){
		List entries = new ArrayList();
		for(ForumPost topic : topics){
			SyndEntryImpl entry = new SyndEntryImpl();
		    entry.setAuthor(topic.getDisplayName());
	        entry.setTitle(topic.getTopic() + ((topic.getPosts() > 0) ? "("+topic.getPosts()+" posts)" : ""));
	        entry.setLink(getLink()+"/viewtopic.do?id="+topic.getId()+"p1");
	        entry.setPublishedDate(topic.getCreateDate());
	        SyndContentImpl description = new SyndContentImpl();
	        description.setType("text/plain");
	        description.setValue(topic.getContent());
	        entry.setDescription(description);
	       
			entries.add(entry);
		}
		doSyndication(category,getLink(),categoryDesc,xml,entries);
		return null;
	}
	
	public String getForumTopicRss(String category,String categoryDesc,String id,String xml,List<ForumPost> posts){
		List entries = new ArrayList();
		for(ForumPost post : posts){
			SyndEntryImpl entry = new SyndEntryImpl();
		    entry.setAuthor(post.getDisplayName());
		    if(post.getTopId() == 0)
		    	entry.setTitle(post.getTopic());
		    else{
		    	if(post.getContent().length() > 30)
		    		entry.setTitle(post.getContent().substring(0,30));
		    	else
		    		entry.setTitle(post.getContent());
		    }
	        entry.setLink(getLink()+"/viewtopic.do?id="+id);
	        entry.setPublishedDate(post.getCreateDate());
	        SyndContentImpl description = new SyndContentImpl();
	        description.setType("text/plain");
	        description.setValue(post.getContent());
	        entry.setDescription(description);
	       
			entries.add(entry);
		}
		doSyndication(category,getLink(),categoryDesc,xml,entries);
		return null;
	}
	
	public String getGroupForumRss(String category,String categoryDesc,String id,String xml,List<GroupForum> topics){
		List entries = new ArrayList();
		for(GroupForum topic : topics){
			SyndEntryImpl entry = new SyndEntryImpl();
		    entry.setAuthor(topic.getDisplayName());
	        entry.setTitle(topic.getTopic() + ((topic.getPosts() > 0) ? "("+topic.getPosts()+" posts)" : ""));
	        entry.setLink(getLink()+"/grouptopic.do?id="+id);
	        entry.setPublishedDate(topic.getCreateDate());
	        SyndContentImpl description = new SyndContentImpl();
	        description.setType("text/plain");
	        description.setValue(topic.getContent());
	        entry.setDescription(description);
	       
			entries.add(entry);
		}
		doSyndication(category,getLink(),categoryDesc,xml,entries);
		return null;
	}
	
	public String getGroupForumTopicRss(String category,String categoryDesc,String id,String xml,List<GroupForum> posts){
		List entries = new ArrayList();
		for(GroupForum post : posts){
			SyndEntryImpl entry = new SyndEntryImpl();
		    entry.setAuthor(post.getDisplayName());
		    if(post.getTopId() == 0)
		    	entry.setTitle(post.getTopic());
		    else{
		    	if(post.getContent().length() > 30)
		    		entry.setTitle(post.getContent().substring(0,30));
		    	else
		    		entry.setTitle(post.getContent());
		    }
	        entry.setLink(getLink()+"/grouptopic.do?id="+id);
	        entry.setPublishedDate(post.getCreateDate());
	        SyndContentImpl description = new SyndContentImpl();
	        description.setType("text/plain");
	        description.setValue(post.getContent());
	        entry.setDescription(description);
	       
			entries.add(entry);
		}
		doSyndication(category,getLink(),categoryDesc,xml,entries);
		return null;
	}
	
	public String getBlogRss(String title,String titleDesc,String xml,List<Blog> blogs){
		List entries = new ArrayList();
		for(Blog blog : blogs){
			SyndEntryImpl entry = new SyndEntryImpl();
		    entry.setAuthor(blog.getDisplayName());
	        entry.setTitle(blog.getTitle() + ((blog.getCommentCount() > 0) ? "("+blog.getCommentCount()+" comments)" : ""));
	        entry.setLink(getLink()+"/viewblog.do?id="+blog.getId());
	        entry.setPublishedDate(blog.getCreateDate());
	        SyndContentImpl description = new SyndContentImpl();
	        description.setType("text/plain");
	        description.setValue(blog.getSummary());
	        entry.setDescription(description);	       
			entries.add(entry);
		}
		doSyndication(title,getLink(),titleDesc,xml,entries);
		return null;
	}
	
	private String getLink(){
		return "http://www."+OrganizationThreadLocal.getWebId();
	}
	/**
	 * This method is called last after you have added all your entries and have specified your
	 * feed type and filename. This actually does the work
	 * <p>
	 * NOTE: This has static content entered in to the fields! You must have access to the source
	 * code edit this method or else you will be publishing content as the Post Modern Banter Blog
	 * Yes, I should change this immediately. Ideally, it would take values from the web.xml file itself.
	 * <p>
	 * @throws Exception
	 */
	private void doSyndication(String title, String link, String description_loc ,String xml, List entries ) {		 
		
            try {
 
                final SyndFeed feed = new SyndFeedImpl();
                feed.setFeedType(feedType);
 
                feed.setTitle(title);
                feed.setLink(link);
                feed.setDescription(description_loc);
                String copyright = "Copyright (c) "+DateFormatter.format(new Date(),"yyyy")+" "+OrganizationThreadLocal.getWebId()+". All rights reserved.";
			    feed.setCopyright(copyright);
				
                feed.setEntries(entries);
			   
                final Writer writer = new FileWriter(xml);
                final SyndFeedOutput output = new SyndFeedOutput();
                output.output(feed,writer);
                writer.close();
            }			
            catch (Exception ex) {
                ex.printStackTrace();               
         }

	}
}
