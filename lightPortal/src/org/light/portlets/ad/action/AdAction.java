package org.light.portlets.ad.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.action.BaseAction;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.util.DateFormatter;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.ad.CategoryAd;
import org.light.portlets.ad.CategoryAdComment;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;

public class AdAction extends BaseAction{
	
	public Object getAdDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String content= null;
		 CategoryAd ad = this.getAdService(request).getAdById(id);
		 if(ad != null) content = ad.getContent();		 
		 if(content == null || content.equals("")) content="this Ad's content is unavaliable.";
		 //if(content.length() > 200) content = content.substring(0,200)+"......";
		 return content;	
	}
	
	public Object popAd(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		String strAdId = request.getParameter("adId");
		String responseId = request.getParameter("responseId");
		int id = Integer.parseInt(strAdId);
		CategoryAd ad = this.getAdService(request).getAdById(id);
		ad.setScore(ad.getScore() + 1);
		this.getPortalService(request).save(ad);
		return responseId;
	}
	public Object getAdComments(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String responseId = request.getParameter("responseId");
		 StringBuffer content= new StringBuffer();
		 List<CategoryAdComment> adComment = this.getAdService(request).getAdCommentsById(id);
		 if(adComment != null && adComment.size() > 0) {
			 content.append("<span title='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.close")+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideAdComments();'><img src='"+request.getContextPath()+"/light/images/close_on.gif' style='border: 0px;'/></a></span>")
			 		
			 		;
			 for(CategoryAdComment comment : adComment){
				 String displayName = comment.getDisplayName();
				 if(displayName == null)
					 displayName = PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.anonym");
				 content
				    .append("<table border='0' cellpadding='0' cellspacing='0' >")
				    .append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<span class=\"portlet-item\">")					
					.append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.commentedBy")+": ")
					;
				 if(comment.getUri() != null)
					 content.append("<a href='http://www."+OrganizationThreadLocal.getOrg().getSpace()+comment.getUri()+"' target='_blank'>"+displayName + "</a> ");
				 else
					 content.append(displayName+ " ");
				 content
				    .append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.date")+": "+comment.getFullDate())
					.append("</span>")					
					.append("<br/>")
					.append("<br/>")
					.append("</td>")
					.append("</tr>")
				    .append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<span>"+comment.getComment()+"</span>")
					.append("</td>")					
					.append("</tr>")
					.append("</table>")	
					.append("<br/>")
					.append("<br/>")
					.append("<hr/>")
					;
			 }
          			

		 }else
			 content.append("this ad has no comments.");
		 return content.toString();	
	}
	public Object saveAdComment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String comment = request.getParameter("comment");
		String strAdId = request.getParameter("adId");
		String responseId = request.getParameter("responseId");
		int adId = Integer.parseInt(strAdId);
		CategoryAdComment adComment = new CategoryAdComment(adId,this.getUser(request).getId(),comment);
		this.getPortalService(request).save(adComment);
		return responseId;
	}
	public Object forwardAdToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String index = request.getParameter("index");
        int id = Integer.parseInt(index);
        CategoryAd ad = this.getAdService(request).getAdById(id);
		if(ad != null){
			String desc = ad.getContent();
			if(desc == null) desc="";
			User user = this.getUser(request);
	           if(user != null){
	               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
	               for(Connection friend : userFriends){
	                   Message message = new Message(user.getDisplayName()+" send you a Ad link.",
	                		   "Location: "+ad.getLocation()+
	                		   "<br/>"+
	                		   "Effective Date: "+DateFormatter.format(ad.getEffDate())+"-"+DateFormatter.format(ad.getEndEffDate())+
	                		   "<br/>"+
	                		   "Ad Url: <a href='"+ad.getAdUrl()+"' target='_blank'>"+ad.getAdUrl()+"</a>"+
	                		   "<br/>"+
	                		   "Ad Detail:<br/>"+
	                		   desc,friend.getBuddyUserId(),user.getId());
	                   this.getUserService(request).sendMessage(message);
	               }
	           }
        }
        return request.getParameter("responseId");
   }
	public Object saveAdToBookmark(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
			String index = request.getParameter("index");
	        int id = Integer.parseInt(index);
	        String link = null;
	        String title = null;
	        String desc = null;
	        CategoryAd ad = this.getAdService(request).getAdById(id);
			if(ad != null){
	         link = ad.getAdUrl();
	         title = ad.getTitle();
	         desc= ad.getContent();
			}
	        if(desc == null) desc="ad description is unavaliable.";
	        if(title != null){
	           String tag = "portlet.tag.title.ad";
	           PortletObject po= this.getPortlet(request);
	           if(po != null)
	        	   tag = po.getLabel();
	           Bookmark bookmark = new Bookmark(title,link,tag,tag,desc,this.getUser(request).getId());
	           this.getPortalService(request).save(bookmark);
	           request.getSession().removeAttribute("bookmarkTags");
			   request.getSession().removeAttribute("defaultBookmarks");			   
	        }
	        return request.getParameter("responseId");
	   }
}
