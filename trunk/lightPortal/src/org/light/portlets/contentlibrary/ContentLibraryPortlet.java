package org.light.portlets.contentlibrary;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.io.DataInputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.contentlibrary.entity.CLFile;
import org.light.portal.portlet.contentlibrary.entity.CLFolder;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.portlet.core.impl.PortletRequestImpl;
import org.light.portal.util.OrganizationThreadLocal;




/**
 * 
 * @author stanley
 * @since 2008-11-7
 */
public class ContentLibraryPortlet extends LightGenericPortlet {
	// call ContentLibrary to interact with the CMS
	
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String id = request.getParameter("id");
		   String group = request.getParameter("group");
		   String groups = request.getParameter("groups");
		   
		   if(group != null){
			   group = URLDecoder.decode(group,_CHARSET_UTF);		   	
		   }else{
			   group = URLDecoder.decode(groups,_CHARSET_UTF);
		   }
		   
		   try {
			   uploadFile(request, response);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   
		}
		 
		 
		
	  }
	 
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 long nodeId = -1;
		 String nodeIdStr = request.getParameter("nodeId");
		 if (nodeIdStr != null) {
			 nodeId = Long.parseLong(nodeIdStr);
		 }
		 
		 //int nodeType = Integer.parseInt(request.getParameter("nodeType"));
		 long orgId = OrganizationThreadLocal.getOrganizationId();
		 User user = this.getUser(request);
		 long userId = user.getId();
		 
		 List<CLFolder> folders = this.getContentLibraryService(request).getSubFoldersByParentId(orgId, userId, nodeId, -1, -1);

//				 request.setAttribute("contact",contact);
		
	     if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/contentlibrary/contentLibraryMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/contentlibrary/contentLibraryView.jsp").include(request,response); 			
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		 
		 if(request.getParameter("add") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/contentlibrary/contentLibraryEdit.jsp").include(request,response);  		 
		 else if(request.getAttribute("file") != null)
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/contentlibrary/contentLibraryEdit.jsp").include(request,response);
		 else{
			 PortletObject portlet = this.getPortlet(request);
			 int showNumber = 0;
			 if(portlet != null)
			    showNumber = portlet.getShowNumber();
			 if(showNumber <=0) showNumber = 6;
			 request.setAttribute("showNumber",showNumber);
			 String defaultPicStatus = "0";
			 User user = this.getUser(request);
			 if(user != null) defaultPicStatus = String.valueOf(user.getDefaultPictureStatus());
			 request.setAttribute("defaultPicStatus",Integer.parseInt(defaultPicStatus));
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myFilePortletConfig.jsp").include(request,response);
		 }	
	 }	
	 
	 public Object uploadFile(ActionRequest request, ActionResponse response) throws Exception{		
			boolean upload = true;
			DataInputStream in = null;
			
			try{   
				in = new DataInputStream( ((PortletRequestImpl) request).getInputStream());
				User user = this.getUser(request);
				
				CLFile clFile = new CLFile();
				clFile.setCreatedByUserId(user.getId());
				//clFile.setDescription(description);
				clFile.setLastUpdatedByUserId(user.getId());
				//clFile.setMimeType(mimeType)
				//clFile.setTitle(title)
				clFile.setInputStream(in);
				
				this.getContentLibraryService(request).addFile(OrganizationThreadLocal.getOrganizationId(), user.getId(), clFile);
				
			}catch (Exception e){
				e.printStackTrace();
				upload = false;
			}
			finally {
				if (in != null) {
					in.close();
					in = null;
				}
			}
			return upload;
			
		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static void main(String[] args) throws Exception {

	 }

	 

}
