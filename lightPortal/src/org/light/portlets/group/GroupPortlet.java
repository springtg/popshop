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

import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.chat.Chat;
import org.light.portlets.connection.Connection;

public class GroupPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");		
		if("create".equals(action)){
		   response.setRenderParameter("type","create");
		   String displayName = request.getParameter("displayName");
		   String uri = request.getParameter("uri");
		   if(displayName == null || displayName.length() <= 0 || uri == null || uri.length() <= 0){
			   request.setAttribute("error","Group's display name and URI are required field.");
			   response.setPortletMode(PortletMode.EDIT);				   
			   return;
		   }
		   Group checkGroup = this.getGroupService(request).getGroupByUri(uri,OrganizationThreadLocal.getOrganizationId());
		   if(checkGroup != null){			
			   request.setAttribute("error","This Group URI is not available, please try a new URI.");
			   response.setPortletMode(PortletMode.EDIT);				   
			   return;		 
		   }	
		   int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		   int openJoin = Integer.parseInt(request.getParameter("openJoin"));
		   int hiddenGroup = Integer.parseInt(request.getParameter("hiddenGroup"));
		   int memberInvite = Integer.parseInt(request.getParameter("memberInvite"));
		   int publicForum = Integer.parseInt(request.getParameter("publicForum"));
		   int memberBulletin = Integer.parseInt(request.getParameter("memberBulletin"));
		   int memberImage = Integer.parseInt(request.getParameter("memberImage"));
		   int noPicForward = Integer.parseInt(request.getParameter("noPicForward"));
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
			 
		   Group group = new Group(displayName,categoryId,openJoin,hiddenGroup,memberInvite,publicForum,memberBulletin,memberImage,noPicForward,matureContent,country,province,city,postalCode,shortDesc,desc,uri,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
		   this.getPortalService(request).save(group);
		   UserGroup userGroup = new UserGroup(this.getUser(request).getId(),group.getId());
		   this.getPortalService(request).save(userGroup);
		   request.setAttribute("success","You have created a new Group successfully.");
		   //request.setAttribute("mode",PortletMode.VIEW.toString());
		   response.setPortletMode(PortletMode.VIEW);
			   
		}
		if("invite".equals(action)){
			   response.setRenderParameter("type","invite");
		}
		if("edit".equals(action)){
			   response.setRenderParameter("type","edit");
		}
		if("modify".equals(action)){
			   response.setRenderParameter("type","edit");
			   String displayName = request.getParameter("displayName");
			   String uri = request.getParameter("uri");
			   if(displayName == null || displayName.length() <= 0 || uri == null || uri.length() <= 0){
				   request.setAttribute("error","Group's display name and uri are required field.");
				   response.setPortletMode(PortletMode.EDIT);				   
				   return;
			   }
			   Group checkGroup = this.getGroupService(request).getGroupByUri(uri,OrganizationThreadLocal.getOrganizationId());
			   if(checkGroup != null){			
				   request.setAttribute("error","This Group URI is not available, please try a new URI.");
				   response.setPortletMode(PortletMode.EDIT);				   
				   return;		 
			   }	
			   int groupId = Integer.parseInt(request.getParameter("groupId"));
			   Group group = this.getGroupService(request).getGroupById(groupId);
			   if(group != null){
				   int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				   int openJoin = Integer.parseInt(request.getParameter("openJoin"));
				   int hiddenGroup = Integer.parseInt(request.getParameter("hiddenGroup"));
				   int memberInvite = Integer.parseInt(request.getParameter("memberInvite"));
				   int publicForum = Integer.parseInt(request.getParameter("publicForum"));
				   int memberBulletin = Integer.parseInt(request.getParameter("memberBulletin"));
				   int memberImage = Integer.parseInt(request.getParameter("memberImage"));
				   int noPicForward = Integer.parseInt(request.getParameter("noPicForward"));
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
				   group.setNoPicForward(noPicForward);
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
		if("search".equals(action)){
			   response.setRenderParameter("type","search");			   			   
			   String country = request.getParameter("country");
			   String province = request.getParameter("province");
			   String city = request.getParameter("city");
			   Group group = new Group();
			   group.setDisplayName(request.getParameter("displayName"));
			   group.setUri(request.getParameter("uri"));
			   group.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			   group.setCountry(request.getParameter("country"));
			   group.setProvince(request.getParameter("province"));
			   group.setCity(request.getParameter("city"));
			   List<Group> searchGroups = this.getGroupService(request).searchGroups(group);
			   int searchCount = 0;
			   if(searchGroups != null) searchCount = searchGroups.size();
			   request.setAttribute("searchCount",searchCount);
			   request.setAttribute("searchGroups",searchGroups);
				   
			}		
		if("delete".equals(action)){
			int groupId = Integer.parseInt(request.getParameter("parameter"));
			List<UserGroup> userGroups =this.getGroupService(request).getUsersByGroup(groupId);
			if(userGroups != null && userGroups.size() > 1){
				request.setAttribute("error","This Group contains "+userGroups.size()+" members, you can not delete it.");
			}else{
				 Group group = this.getGroupService(request).getGroupById(groupId);
				 if(group != null) this.getPortalService(request).delete(group);
				 for(UserGroup ug : userGroups){
					 this.getPortalService(request).delete(ug);
				 }
				 request.setAttribute("success","You have deleted this Group successfully.");
			}
		}
		if("cancel".equals(action)){
			//request.setAttribute("mode",PortletMode.VIEW.toString());
			response.setPortletMode(PortletMode.VIEW);
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String action = request.getParameter("action");		
		if("members".equals(action)){
			String groupId= request.getParameter("parameter");
			List<UserGroup> groupMembers = this.getGroupService(request).getUsersByGroup(Integer.parseInt(groupId));
			int memberCount = 0;
			if(groupMembers != null) memberCount = groupMembers.size();
			request.setAttribute("memberCount", memberCount);
			request.setAttribute("groupMembers", groupMembers);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletMembers.jsp").include(request,response);
		}else{
			User user = this.getUser(request);
		    if(this.getVisitedUser(request) != null)
		    	 user = this.getVisitedUser(request);	
		    if(user != null){
				List<UserGroup> userGroups = this.getGroupService(request).getGroupsByUser(user.getId());
				int groupCount =0;
				if(userGroups != null) groupCount=userGroups.size();
				request.setAttribute("userGroups",userGroups);
				request.setAttribute("groupCount", groupCount);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletView.jsp").include(request,response);
		    }
		}
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {			
		List<GroupCategory> groupCategories = this.getGroupService(request).getGroupCategories(OrganizationThreadLocal.getOrganizationId());
		request.setAttribute("groupCategories", groupCategories);
		String type= request.getParameter("type");
		if("create".equals(type)){
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletCreate.jsp").include(request,response);
		}else if("edit".equals(type)){
			String groupId= request.getParameter("parameter");
			Group group = this.getGroupService(request).getGroupById(Integer.parseInt(groupId));
			request.setAttribute("group", group);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletEdit.jsp").include(request,response);
		}else if("search".equals(type)){			
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletSearch.jsp").include(request,response);
		}else if("invite".equals(type)){			
			List<Connection> myFriends = this.getChatService(request).getBuddysByUser(this.getUser(request).getId());
			String groupId= request.getParameter("parameter");
			request.setAttribute("groupId",groupId);
			request.setAttribute("myFriends",myFriends);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletInvite.jsp").include(request,response);
		}else if("joinDetail".equals(type)){
			String categoryId = request.getParameter("parameter");
			if(categoryId != null){
				List<Group> groups = this.getGroupService(request).getGroupsByCategory(Integer.parseInt(categoryId),OrganizationThreadLocal.getOrganizationId());
				int groupCount = 0;
				if(groups != null) groupCount = groups.size();
				request.setAttribute("groups", groups);
				request.setAttribute("groupCount", groupCount);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletDetail.jsp").include(request,response);
			}
		}else{
			groupCategories = this.getGroupService(request).getGroupCategories(OrganizationThreadLocal.getOrganizationId());
			request.setAttribute("groupCategories", groupCategories);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletJoin.jsp").include(request,response);
		}
		
	 }	
	 
	 protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletHelp.jsp").include(request,response);
	 }
}

