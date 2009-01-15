package org.light.portlets.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.action.BaseAction;
import org.light.portal.model.User;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;

public class BlogAction extends BaseAction{
	
	public Object getBlogDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String id = request.getParameter("index");		 
		 String desc= null;
		 Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(id));
		 if(blog != null){
			 desc = blog.getSummary();
			 if(desc == null || desc.trim().length() <= 0){
				 desc = blog.getContent();		
				 if(desc != null && desc.length() > 200) 
					 desc = desc.substring(0,200)+"......";
			 }
		 }
		 if(desc == null || desc.equals("")) desc="this blog's summary is unavaliable.";		 
		 return desc;	
	}
	
	public Object getBlogDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String id = request.getParameter("index");
		 String responseId = request.getParameter("responseId");
		 StringBuffer content= new StringBuffer();
		 Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(id));
		 if(blog != null) {
			 content.append("<span title='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.close")+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideBlogDetail();'><img src='"+request.getContextPath()+"/light/images/close_on.gif' style='border: 0px;'/></a></span>")
			 		.append("<table border='0' cellpadding='0' cellspacing='0' >")
		 			.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<b>"+blog.getTitle()+"</b>")
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<span class=\"portlet-rss\">")					
					.append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.postedBy")+": <a href='http://www."+OrganizationThreadLocal.getOrg().getSpace()+blog.getUri()+"' target='_blank'>"+blog.getDisplayName() + "</a> "+PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.date")+": "+blog.getFullDate())
					.append("<br/>")
					.append("<br/>")
					.append("</span>")
					.append("</td>")					
					.append("</tr>")
					.append("<tr>")
						.append("<td class='portlet-table-td-right'>")
						.append("<span class=\"portlet-link\">")	
						.append("<a href='javascript:void(0);' onclick='javascript:showBlogComment(event,\""+blog.getId()+"\");'>"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.total")+" "+blog.getCommentCount()+" "+PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.comments")+"</a>")
						.append("</span>")
						.append("</td>")
						.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<span>"+blog.getContent()+"</span>")
					.append("</td>")
					.append("</tr>")
					;
			if(blog.getCommentCount() > 0){
				 content.append("<tr>")
						.append("<td class='portlet-table-td-right'>")
						.append("<span class=\"portlet-link\">")	
						.append("<a href='javascript:void(0);' onclick='javascript:showBlogComment(event,\""+blog.getId()+"\");'>"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.total")+" "+blog.getCommentCount()+" "+PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.comments")+"</a>")
						.append("</span>")
						.append("</td>")
						.append("</tr>")
						;
			 }
			 content.append("<tr>")
					.append("<td class='portlet-table-td-right'>")
					;
			 User blogOwner = this.getUserService(request).getUserById(blog.getUserId());
			 if(blogOwner.getBlogCommentFriendOnly() == 0 ||
				blog.getUserId()== this.getUser(request).getId() ||
			    this.getChatService(request).getChatBuddy(blog.getId(),this.getUser(request).getId()) != null){
				 content.append("<input type='button' value='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.addComment")+"'")
						.append(" onclick='javascript:addBlogComment(event,\""+blog.getId()+"\",\""+responseId+"\");' class='portlet-form-button'/>")
						;
			 }
			 content.append("<input type='button' value='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.popIt")+"'")
					.append(" onclick='javascript:popBlog(\""+blog.getId()+"\",\""+responseId+"\");' class='portlet-form-button'/>")
					.append("</td>")
					.append("</tr>")			  
					.append("</table>")
					; 					

		 }else
			 content.append("this blog's content is unavaliable.");
		 return content.toString();	
	}
	
	public Object popBlog(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		String blogId = request.getParameter("blogId");
		String responseId = request.getParameter("responseId");
		if(blogId != null){
			Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
			blog.setScore(blog.getScore() + 1);
			this.getPortalService(request).save(blog);
		}
		return responseId;
	}
	public Object getBlogComments(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String responseId = request.getParameter("responseId");
		 StringBuffer content= new StringBuffer();
		 List<BlogComment> blogComment = this.getBlogService(request).getBlogCommentsById(id);
		 if(blogComment != null && blogComment.size() > 0) {
			 content.append("<span title='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.close")+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideBlogComments();'><img src='"+request.getContextPath()+"/light/images/close_on.gif' style='border: 0px;'/></a></span>")
			 		
			 		;
			 for(BlogComment comment : blogComment){
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
			 content.append("this blog has no comments.");
		 return content.toString();	
	}
	public Object saveBlogComment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String comment = request.getParameter("comment");
		String strBlogId = request.getParameter("blogId");
		String responseId = request.getParameter("responseId");
		long blogId = Long.parseLong(strBlogId);
		BlogComment blogComment = new BlogComment(blogId,this.getUser(request).getId(),comment);
		this.getPortalService(request).save(blogComment);
		return responseId;
	}
}
