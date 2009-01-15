package org.light.struts.forum.action;

import static org.light.portal.util.Constants._MAX_ROW_PER_PAGE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.light.portal.util.MessageUtil;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumPost;
import org.light.struts.BaseAction;

public class ViewForumAction extends BaseAction {


    // --------------------------------------------------------- Public Methods


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
    	String id = request.getParameter("id");
		if(id.indexOf("p") > 0){
			String[] ids= id.split("p");
			int forumId = Integer.parseInt(ids[0]);
			int pageId = Integer.parseInt(ids[1]);	
			String strPages = request.getParameter("pages");
			int pages=1;
			if(strPages == null){
			    int count = this.getForumService(request).getTopicsCountByForum(forumId);				    			   
			    int newPages = count / _MAX_ROW_PER_PAGE;
			    if( count % _MAX_ROW_PER_PAGE != 0)
			    	newPages++;
			    pages = newPages;
			}else{
				try{
					pages = Integer.parseInt(strPages);
				}catch(Exception e){}
			}						 
    		Forum forum = this.getForumService(request).getForumById(forumId);
			 if(forum != null){				
				 request.setAttribute("categoryId",forum.getCategory().getId());
				 request.setAttribute("id",forumId);
				 request.setAttribute("categoryName",MessageUtil.getMessage(forum.getCategory().getName(),this.getLocale(request)));
				 request.setAttribute("forumName",MessageUtil.getMessage(forum.getName(),this.getLocale(request)));
			  	 List<ForumPost> list = this.getForumService(request).getTopicsByForum(forumId,pageId - 1,_MAX_ROW_PER_PAGE);
				 request.setAttribute("topicLists",list);
				 request.setAttribute("pageId",pageId);
				 request.setAttribute("pages",pages);
				 return (mapping.findForward("success"));
			 }
	    	}
	    	return (mapping.findForward("forum"));
    }
}
