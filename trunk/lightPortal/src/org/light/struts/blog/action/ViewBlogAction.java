package org.light.struts.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;
import org.light.struts.BaseAction;

public class ViewBlogAction extends BaseAction {


    // --------------------------------------------------------- Public Methods


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
    	String id = request.getParameter("id");
		if(id != null){
			long blogId = Long.parseLong(id);			
    		Blog blog = this.getBlogService(request).getBlogById(blogId);
			 if(blog != null){				 
				 request.setAttribute("blog",blog);	
				 List<BlogComment> comments = this.getBlogService(request).getBlogCommentsById(blog.getId());
				 request.setAttribute("comments",comments);
				 return (mapping.findForward("success"));
			 }
    	}
    	return (mapping.findForward("error"));
    }

}
