package org.light.portal;

import static org.light.portal.util.Constants._ORGANIZATION;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_USER;
import static org.light.portal.util.Constants._DEFAULT_USER_MALE_PORTRAIT;
import static org.light.portal.util.Constants._DEFAULT_USER_FEMALE_PORTRAIT;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.light.portal.model.Organization;
import org.light.portal.model.User;
import org.light.portal.user.service.UserService;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.PropUtil;
import org.light.portlets.group.Group;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class VirtualHostFilter implements Filter {
	   
	   public void init(FilterConfig config) throws ServletException {

	   }

	   public void destroy() {
		   
	   }

	   public void doFilter(ServletRequest request, 
	      ServletResponse response, FilterChain chain) 
	      throws IOException, ServletException {
		   if (!(request instanceof HttpServletRequest)) {
	         chain.doFilter(request, response);
	         return;
	       }		   
	       HttpServletRequest httpRequest = (HttpServletRequest) request;	    
	       Organization org = (Organization)httpRequest.getSession().getAttribute(_ORGANIZATION);
	       String host = getHost(httpRequest);
	       if(org == null || (org != null && !host.equalsIgnoreCase(org.getVirtualHost()))){
	    	   org = getOrganization(httpRequest);	
	    	   if(org != null){
	    		   org.setDefaultMalePortrait(PropUtil.getString(_DEFAULT_USER_MALE_PORTRAIT,org.getWebId()));
	    		   org.setDefaultFemalePortrait(PropUtil.getString(_DEFAULT_USER_FEMALE_PORTRAIT,org.getWebId()));
	    		   httpRequest.getSession().setAttribute(_ORGANIZATION,org);
			   }
	       }
	       OrganizationThreadLocal.setOrganization(org);
	       
	       chain.doFilter(request, response);
	       return;
	   }
	   
	   private Organization getOrganization(HttpServletRequest request){
		   String host = getHost(request);
		   Organization org = this.getUserService(request).getOrgByVirtualHost(host);
		   if(org == null){
			   int index = host.indexOf(".");
			   String domain = host.substring(index + 1);
			   if(domain.indexOf(".") > 0)
				   org = this.getUserService(request).getOrgByVirtualHost(domain);
		   }			   
		   if(org == null)
			   org = this.getUserService(request).getOrganizations().get(0);		
		   return org;
	   }
	   
	   public String getHost(HttpServletRequest request) {
			String host = request.getHeader("Host");
			if (host != null) {
				host = host.trim().toLowerCase();
				int pos = host.indexOf(':');
				if (pos >= 0) {
					host = host.substring(0, pos);
				}
				if(host.startsWith("www.") || host.startsWith("WWW.")){
					host = host.substring(4);
				}
			}
			else {
				host = null;
			}			
			return host;
		}
	   	protected User getUser(HttpServletRequest request){
			return (User)request.getSession().getAttribute(_ORGANIZATION);
		}
	    protected User getVisitedUser(HttpServletRequest request){		
	    	return (User)request.getSession().getAttribute(_VISITED_USER);
		}	
		
		protected Group getVisitedGroup(HttpServletRequest request){		
			return (Group)request.getSession().getAttribute(_VISITED_GROUP);
		}
	    protected UserService getUserService(HttpServletRequest request) {			
			return (UserService)getService(request, "userService");
		}
	    
	    protected GroupService getGroupService(HttpServletRequest request) {			
			return (GroupService)getService(request, "groupService");
		}
				
		private Object getService(HttpServletRequest request, String serviceName) {
			ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
	        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
			return ctx.getBean(serviceName);
		}	
}


