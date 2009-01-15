package org.light.portlets.addressbook;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class AddressBookPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String id = request.getParameter("id");
		   String group = request.getParameter("group");
		   String groups = request.getParameter("groups");
		   String fullName = request.getParameter("fullName");
		   String homePhone = request.getParameter("homePhone");
		   String workPhone = request.getParameter("workPhone");
		   String mobilePhone = request.getParameter("mobilePhone");
		   int primaryPhone = Integer.parseInt(request.getParameter("primaryPhone"));
		   String workEmail = request.getParameter("workEmail");
		   String personalEmail = request.getParameter("personalEmail");
		   int primaryEmail = Integer.parseInt(request.getParameter("primaryEmail"));
		   String homePage = request.getParameter("homePage");
		   String address = request.getParameter("address");
		   String city = request.getParameter("city");
		   String province = request.getParameter("province");
		   String country = request.getParameter("country");
		   String postalCode = request.getParameter("postalCode");
		   if(group != null){
			   group = URLDecoder.decode(group,_CHARSET_UTF);		   	
		   }else{
			   group = URLDecoder.decode(groups,_CHARSET_UTF);
		   }
		   if(fullName != null) fullName = URLDecoder.decode(fullName,_CHARSET_UTF);
		   if(workEmail != null) workEmail = URLDecoder.decode(workEmail,_CHARSET_UTF);		   	
		   if(personalEmail != null) personalEmail = URLDecoder.decode(personalEmail,_CHARSET_UTF);
		   if(homePage != null) homePage = URLDecoder.decode(homePage,_CHARSET_UTF);		   	
		   if(address != null) address = URLDecoder.decode(address,_CHARSET_UTF);
		   if(city != null) city = URLDecoder.decode(city,_CHARSET_UTF);		   	
		   if(province != null) province = URLDecoder.decode(province,_CHARSET_UTF);
		   if(country != null) country = URLDecoder.decode(country,_CHARSET_UTF);
		   if(postalCode != null) postalCode = URLDecoder.decode(postalCode,_CHARSET_UTF);
		   AddressBook contact = null;
		   int contactId = Integer.parseInt(id);
		   if(contactId != 0){
			 contact = this.getUserService(request).getAddressBookById(contactId);					 
		   }else{
			 contact = new AddressBook(); 
			 contact.setUserId(this.getUser(request).getId());
		   }
		   contact.setGroup(group);
		   contact.setFullName(fullName);
		   contact.setHomePhone(homePhone);
		   contact.setWorkPhone(workPhone);
		   contact.setMobilePhone(mobilePhone);
		   contact.setPrimaryPhone(primaryPhone);
		   contact.setWorkEmail(workEmail);
		   contact.setPersonalEmail(personalEmail);
		   contact.setPrimaryEmail(primaryEmail);
		   contact.setHomePage(homePage);
		   contact.setAddress(address);
		   contact.setCity(city);
		   contact.setProvince(province);
		   contact.setCountry(country);
		   contact.setPostalCode(postalCode);			 
		   this.getPortalService(request).save(contact);
		}	
		else if("delete".equals(action)){
			String id = request.getParameter("parameter");
			AddressBook contact = this.getUserService(request).getAddressBookById(Integer.parseInt(id));
			if(contact != null){
				this.getPortalService(request).delete(contact);	
			}
		}
		
	  }
	 
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String contactId = request.getParameter("contactId");
		 if(contactId != null){
			 AddressBook contact = this.getUserService(request).getAddressBookById(Integer.parseInt(contactId));
			 request.setAttribute("contact",contact);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/addressbook/addressbookPortletDetailView.jsp").include(request,response);
			 return;
		 }
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) == null){	    	 
	    	 String group = request.getParameter("group");
	    	 List<AddressBook> contacts = null;
	    	 if(group == null)
	    		 contacts = this.getUserService(request).getAddressBooksByUser(user.getId());
	    	 else
	    		 contacts = this.getUserService(request).getAddressBooksByUser(user.getId(),group);
			 request.setAttribute("contacts",contacts);		
			 List<String> groups =this.getUserService(request).getAddressBookGroupByUser(user.getId());
			 request.setAttribute("groups",groups);
			 if(groups != null && groups.size() > 0)
				 request.setAttribute("groupCount",groups.size());
	     }
		 if(request.getWindowState().equals(WindowState.MAXIMIZED))
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/addressbook/addressbookPortletMaxView.jsp").include(request,response);  
		 else
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/addressbook/addressbookPortletView.jsp").include(request,response); 			
	 }	

	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	 
		 String contactId = request.getParameter("contactId");
		 AddressBook contact = null;
		 if(contactId != null){
			 contact = this.getUserService(request).getAddressBookById(Integer.parseInt(contactId));			 		
		 }else{
			 contact = new AddressBook(); 
		 }
		 List<String> groups =this.getUserService(request).getAddressBookGroupByUser(this.getUser(request).getId());
		 request.setAttribute("groups",groups);
		 request.setAttribute("contact",contact);	
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/addressbook/addressbookPortletEdit.jsp").include(request,response);
	 }
}

