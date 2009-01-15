package org.light.struts.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.light.portal.util.MessageUtil;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumCategory;
import org.light.struts.BaseAction;

public class ViewCategoryAction extends BaseAction {


    // --------------------------------------------------------- Public Methods


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
    	String categoryId = request.getParameter("id");
    	if(categoryId != null){
    		ForumCategory category = this.getForumService(request).getForumCategoryById(Integer.parseInt(categoryId));
			 if(category != null){				
				request.setAttribute("id",categoryId);
				request.setAttribute("categoryName",MessageUtil.getMessage(category.getName(),getLocale(request)));
			  	List<Forum> list = this.getForumService(request).getForumByCategory(category.getId());
			  	
		    	for(Forum forum : list){
		    		forum.setName(MessageUtil.getMessage(forum.getName(),getLocale(request)));
		    	}
			  	 request.setAttribute("forumLists",list);
				 return (mapping.findForward("success"));
			 }
    	}
    	return (mapping.findForward("forum"));
    }
}
