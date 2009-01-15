package org.light.struts.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.light.portal.util.MessageUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.forum.ForumCategory;
import org.light.struts.BaseAction;

public class ViewCategoriesAction extends BaseAction {


    // --------------------------------------------------------- Public Methods


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
    	List<ForumCategory> listCategory = this.getForumService(request).getForumCategories((String)request.getSession().getAttribute("currentLocale"),OrganizationThreadLocal.getOrganizationId());    	    	
    	for(ForumCategory category : listCategory){
    		category.setName(MessageUtil.getMessage(category.getName(),getLocale(request)));
    	}
    	request.setAttribute("forumCategories",listCategory);
		return (mapping.findForward("success"));
    }
}
