package org.light.struts;

import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._USER;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.light.portal.core.service.PortalService;
import org.light.portal.model.User;
import org.light.portal.user.service.UserService;
import org.light.portlets.ad.service.AdService;
import org.light.portlets.blog.service.BlogService;
import org.light.portlets.chat.service.ChatService;
import org.light.portlets.forum.service.ForumService;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class BaseAction extends Action {


    // --------------------------------------------------------- Public Methods


    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {
    	
    	return (mapping.findForward("success"));


    }
    
    protected Locale getLocale(HttpServletRequest request){
    	Locale currentLocale = (Locale) Config.get(request.getSession(),Config.FMT_LOCALE);
		if(currentLocale == null){
	    	String locale = _DEFAULT_LOCALE;
	    	if(request.getSession().getAttribute("currentLocale") != null)
	    		locale = (String)request.getSession().getAttribute("currentLocale");
	    	
	    	String[] localeParams = locale.split("_");
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
		}
		return currentLocale;
    }
    protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}  
    protected PortalService getPortalService(HttpServletRequest request) {			
		return (PortalService)getService(request, "portalService");
	}
	
	protected UserService getUserService(HttpServletRequest request) {			
		return (UserService)getService(request, "userService");
	}
	
	protected ChatService getChatService(HttpServletRequest request) {			
		return (ChatService)getService(request, "chatService");
	}
	
    protected ForumService getForumService(HttpServletRequest request) {			
		return (ForumService)getService(request, "forumService");
	}
	
	protected BlogService getBlogService(HttpServletRequest request) {			
		return (BlogService)getService(request, "blogService");
	}	

	protected GroupService getGroupService(HttpServletRequest request) {			
		return (GroupService)getService(request, "groupService");
	}
	
	protected AdService getAdService(HttpServletRequest request) {			
		return (AdService)getService(request, "adService");
	}

	private Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}	
}
