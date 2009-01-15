package org.light.portal;

import static org.light.portal.util.Constants._USER;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.light.portal.model.User;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.ChatStatusRef;
import org.light.portlets.chat.service.ChatService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent event) {
		User user = this.getUser(event.getSession());
		if(user != null){
			 Chat chat = this.getChatService(event.getSession()).getChatByUser(user.getId());
			 if(chat != null){
				 chat.setCurrentStatus(ChatStatusRef.OFFLINE);
				 this.getChatService(event.getSession()).save(chat);
			 }
			 this.getChatService(event.getSession()).deleteChattingByUser(user.getId());
		}
	}
	protected User getUser(HttpSession session){
			return (User)session.getAttribute(_USER);
	}
	
	protected ChatService getChatService(HttpSession session) {			
		return (ChatService)getService(session, "chatService");
	}
	
	private Object getService(HttpSession session, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) session.getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}	

}
