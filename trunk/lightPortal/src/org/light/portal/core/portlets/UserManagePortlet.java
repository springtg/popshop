package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.ChannelRef;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.CalendarUtil;
import org.light.portal.util.LocaleUtil;
import org.light.portal.util.OrganizationThreadLocal;

public class UserManagePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {	
		 String action = request.getParameter("action");
		 if("search".equals(action)){
			 String userId = request.getParameter("email");
			 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);		   				  
			 if( userId != null ){
				  User user = this.getUserService(request).getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
				  if(user != null){
					  request.setAttribute("searchedUser",user);
				  }
			 }
			 
		 }else if("save".equals(action)){
			 String userId = request.getParameter("id");
			 long id=0L;
			 if(userId != null) id = Long.parseLong(userId);
			 User user = this.getUserService(request).getUserById(id);
			 if(user != null){
				 String password = request.getParameter("password");
				 String cpassword = request.getParameter("confirmPassword");
				 String displayName = request.getParameter("displayName");
				 String disabled = request.getParameter("disabeld");
				 String locked = request.getParameter("locked");
				 String language = request.getParameter("language");
				 String region = language;
				 String timeZone=  request.getParameter("timeZone");
				 String birth = request.getParameter("birthY")+"/"+request.getParameter("birthM")+"/"+request.getParameter("birthD");
				 String gender = request.getParameter("gender");
				 String country = request.getParameter("country");
				 String province = request.getParameter("province");
				 String city = request.getParameter("city");
				 String postalCode = request.getParameter("postalCode");
				 
				 if(displayName != null) displayName = URLDecoder.decode(displayName,_CHARSET_UTF);
				 if(country != null) country = URLDecoder.decode(country,_CHARSET_UTF);
				 if(province != null) province = URLDecoder.decode(province,_CHARSET_UTF);
				 if(city != null) city = URLDecoder.decode(city,_CHARSET_UTF);
				 if(postalCode != null) postalCode = URLDecoder.decode(postalCode,_CHARSET_UTF);
				 
				 if(password.equals(cpassword)) user.setPassword(password);
				 user.setDisplayName(displayName);
				 user.setBirth(birth);
				 user.setCountry(country);
				 user.setLanguage(language);
				 user.setRegion(region);
				 user.setProvince(province);
				 user.setCity(city);
				 user.setPostalCode(postalCode);
				 user.setTimeZone(timeZone);
				 user.setGender(gender);				 
				 if(disabled != null) user.setDisabled(1);
				 if(locked != null) user.setLocked(1);
				 this.getUserService(request).saveUser(user);
			 }
		 }else if("delete".equals(action)){
			 String userId = request.getParameter("userId");
			 if(userId != null) userId = URLDecoder.decode(userId,_CHARSET_UTF);
			 User user = this.getUserService(request).getUserByUserId(userId,OrganizationThreadLocal.getOrganizationId());
			 this.getPortalService(request).deletePortal(userId);
			 this.getUserService(request).deleteUser(user.getId());
			 
		 }
	 }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 if(request.getAttribute("searchedUser") != null){
			request.setAttribute("months", CalendarUtil.getMonths());
			request.setAttribute("days", CalendarUtil.getDays());
			request.setAttribute("years", CalendarUtil.getYears());		
			request.setAttribute("languages", LocaleUtil.getSupportedLanguages());
			request.setAttribute("countries", LocaleUtil.getSupportedCountry());
			//request.setAttribute("provinces", LocaleUtils.getSupportedProvince());
			request.setAttribute("timeZones", LocaleUtil.getSupportedTimeZone());
		 }
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/userManage.jsp").include(request,response);
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		request.setAttribute("months", CalendarUtil.getMonths());
		request.setAttribute("days", CalendarUtil.getDays());
		request.setAttribute("years", CalendarUtil.getYears());
	
        List<ChannelRef> channels = this.getPortalService(request).getChannelRef();		 
		request.setAttribute("channels", channels);
		request.setAttribute("languages", LocaleUtil.getSupportedLanguages());
		request.setAttribute("countries", LocaleUtil.getSupportedCountry());
		//request.setAttribute("provinces", LocaleUtils.getSupportedProvince());
		request.setAttribute("timeZones", LocaleUtil.getSupportedTimeZone());
				
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/register.jsp").include(request,response);  

	 }

}
