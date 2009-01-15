package org.light.portal;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._FILE_PATH;
import static org.light.portal.util.Constants._LIGHT_PORTAL_USER_ID;
import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_USER;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.PortletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.model.User;
import org.light.portal.user.service.UserService;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.group.Group;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class FileDispatcherServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	process(request,response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
    }
	
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String uri = request.getRequestURI();
	   Calendar current = Calendar.getInstance();
	   current.add(Calendar.YEAR,10);
	   response.setDateHeader("Expires",current.getTime().getTime());
	   if(uri.indexOf("/user/") >= 0 && uri.indexOf(".lp") < 0){
		   int index = uri.indexOf("/user/");
		   String path = uri.substring(index);
		   if(path != null) path = URLDecoder.decode(path,_CHARSET_UTF);
		   String path2 = path.substring(6);
		   index = path2.indexOf("/");
		   String userId = path2.substring(0,index);
		   long id = 0L;
		   try{
			   id = Long.parseLong(userId);
		   }catch(Exception e){}
		   User user = this.getUserService(request).getUserById(id);
		   if(user != null){
			   if(user.getNoPicForward() == 1 && this.getUser(request) == null && this.getVisitedUser(request) == null){					   
				   response.sendRedirect(request.getContextPath()+"/index.jsp");
				   return;
			   }else{	
				   File file = new File(getPath(OrganizationThreadLocal.getOrganizationId())+path);
			   	   //Set content type
				   String mime;
				   if(path.indexOf("images") > 0)
					  mime = "image/gif";
				   else if(path.indexOf("musics") > 0)
					  mime = "audio";
				   else
					   mime = new MimetypesFileTypeMap().getContentType(file); 
				   response.setContentType(mime);
			    
			        // Set content size			        
			        response.setContentLength((int)file.length());
			    
			        // Open the file and output streams
			        FileInputStream in = new FileInputStream(file);
			        OutputStream out = response.getOutputStream();
			    
			        // Copy the contents of the file to the output stream
			        byte[] buf = new byte[1024];
			        int count = 0;
			        while ((count = in.read(buf)) >= 0) {
			            out.write(buf, 0, count);
			        }
			        in.close();
			        out.close();
				    return;
			   }
				   
		   }			
		}			
	   if(uri.indexOf("/grp/") >= 0 && uri.indexOf(".lp") < 0){
		   int index = uri.indexOf("/grp/");
		   String path = uri.substring(index);
		   if(path != null) path = URLDecoder.decode(path,_CHARSET_UTF);
		   String path2 = path.substring(9);
		   index = path2.indexOf("/");
		   String userUri = path2.substring(0,index);
		   Group group = this.getGroupService(request).getGroupByUri(userUri,OrganizationThreadLocal.getOrganizationId());
		   if(group != null){
			   if(group.getNoPicForward() == 1 && this.getUser(request) == null && this.getVisitedGroup(request) == null){
				   response.sendRedirect(request.getContextPath()+"/index.jsp");
				   return;
			   }else{					   
				   File file = new File(_FILE_PATH+path);
				   // Set content type
				   String mime;
				   if(path.indexOf("images") > 0)
					  mime = "Image";
				   else if(path.indexOf("musics") > 0)
					  mime = "Audio";
				   else
					   mime = new MimetypesFileTypeMap().getContentType(file); 
				   response.setContentType(mime);
			    
			        // Set content size			        
			        response.setContentLength((int)file.length());
			    
			        // Open the file and output streams
			        FileInputStream in = new FileInputStream(file);
			        OutputStream out = response.getOutputStream();
			    
			        // Copy the contents of the file to the output stream
			        byte[] buf = new byte[1024];
			        int count = 0;
			        while ((count = in.read(buf)) >= 0) {
			            out.write(buf, 0, count);
			        }
			        in.close();
			        out.close();			
				   return;
			   }
				   
		   }			
		}			
        return;
	    }
	    private String getPath(long userId){
			String separator = System.getProperty("file.separator");
			return _FILE_PATH+OrganizationThreadLocal.getOrganizationId();//+"user"+separator+userId+separator+prefix+separator;
		}
	    protected User getUser(HttpServletRequest request){
			return (User)request.getSession().getAttribute(_USER);
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
