package org.light.portlets.group;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.connection.Connection;

public class GroupEditPortlet  extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");		
		if("modify".equals(action)){
		   response.setRenderParameter("type","edit");
		   String displayName = request.getParameter("displayName");
		   String uri = request.getParameter("uri");
		   if(displayName == null || displayName.length() <= 0 || uri == null || uri.length() <= 0){
			   request.setAttribute("error","Group's display name and uri are required field.");			   
			   return;
		   }
		   int groupId = Integer.parseInt(request.getParameter("groupId"));
		   Group checkGroup = this.getGroupService(request).getGroupByUri(uri,OrganizationThreadLocal.getOrganizationId());
		   if(checkGroup != null && checkGroup.getId() != groupId){			
			   request.setAttribute("error","This Group URI is not available, please try a new URI.");				   
			   return;		 
		   }			   
		   Group group = this.getGroupService(request).getGroupById(groupId);
		   if(group != null){
			   int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			   int openJoin = Integer.parseInt(request.getParameter("openJoin"));
			   int hiddenGroup = Integer.parseInt(request.getParameter("hiddenGroup"));
			   int memberInvite = Integer.parseInt(request.getParameter("memberInvite"));
			   int publicForum = Integer.parseInt(request.getParameter("publicForum"));
			   int memberBulletin = Integer.parseInt(request.getParameter("memberBulletin"));
			   int memberImage = Integer.parseInt(request.getParameter("memberImage"));
			   int matureContent = Integer.parseInt(request.getParameter("matureContent"));
			   String country = request.getParameter("country");
			   String province = request.getParameter("province");
			   String city = request.getParameter("city");
			   String postalCode = request.getParameter("postalCode");
			   String shortDesc = request.getParameter("shortDesc");
			   String desc = request.getParameter("desc");		  
			   if(displayName != null) displayName = URLDecoder.decode(displayName,_CHARSET_UTF).replaceAll("\n","").trim();
			   if(shortDesc != null) shortDesc = URLDecoder.decode(shortDesc,_CHARSET_UTF).replaceAll("\n","").trim();
			   if(desc != null) desc = URLDecoder.decode(desc,_CHARSET_UTF).replaceAll("\n","").trim();
				
			   group.setDisplayName(displayName);
			   group.setCategoryId(categoryId);
			   group.setOpenJoin(openJoin);
			   group.setHiddenGroup(hiddenGroup);
			   group.setMemberInvite(memberInvite);
			   group.setPublicForum(publicForum);				   
			   group.setMemberBulletin(memberBulletin);
			   group.setMemberImage(memberImage);
			   group.setMatureContent(matureContent);
			   group.setUri(uri);
			   group.setCountry(country);
			   group.setProvince(province);
			   group.setCity(city);
			   group.setPostalCode(postalCode);
			   group.setShortDesc(shortDesc);
			   group.setDesc(desc);
			   this.getPortalService(request).save(group);
			   request.setAttribute("success","You have modified this Group successfully.");
		   }else{
			   request.setAttribute("error","System cannot find this Group, try later.");
		   }
		   //request.setAttribute("mode",PortletMode.VIEW.toString());
		   response.setPortletMode(PortletMode.VIEW);	   
		}
		
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		List<GroupCategory> groupCategories = this.getGroupService(request).getGroupCategories(OrganizationThreadLocal.getOrganizationId());
		request.setAttribute("groupCategories", groupCategories);
		String groupId= request.getParameter("groupId");
		Group group = this.getGroupService(request).getGroupById(Integer.parseInt(groupId));
		request.setAttribute("group", group);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletEdit.jsp").include(request,response);
	}	
	 
}

