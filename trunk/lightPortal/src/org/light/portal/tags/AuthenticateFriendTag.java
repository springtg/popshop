package org.light.portal.tags;

import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.light.portal.model.User;
import org.light.portlets.chat.service.ChatService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class AuthenticateFriendTag extends TagSupport {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	//private String user;
	
	public int doStartTag() throws JspException {
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		User visitedProfile = (User)pageContext.getSession().getAttribute(_VISITED_USER);
		if(user != null && visitedProfile != null && 
		   this.getChatService((HttpServletRequest)pageContext.getRequest()).getChatBuddy(user.getId(),visitedProfile.getId()) != null)
		   return EVAL_BODY_INCLUDE;		    
		else
		   return SKIP_BODY;
	}
	
	private ChatService getChatService(HttpServletRequest request) {			
		return (ChatService)getService(request, "chatService");
	}
	
	private Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}	
	
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}

	
}
