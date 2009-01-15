package org.light.portlets.business;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.group.Group;

public class BusinessPortlet extends LightGenericPortlet {
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		 if(this.getVisitedGroup(request) != null){
			Group group = this.getVisitedGroup(request);
	    	long groupId = group.getId();
	    	String uri = group.getUri();
			String dirName = "/grp/"+uri+"/files/";
			if(uri != null && uri.length() >0){
				String firstLetter = uri.substring(0,1);			
				dirName = "/grp/"+firstLetter+"/"+firstLetter+"/"+uri+"/files/";
			}
			if(uri != null && uri.length() >1){
				String firstLetter = uri.substring(0,1);
				String secondLetter = uri.substring(1,2);
				dirName = "/grp/"+firstLetter+"/"+secondLetter+"/"+uri+"/files/";			
			}
			String viewJSP = "/WEB-INF"+dirName+"biz_"+groupId+".html";				
			this.getPortletContext().getRequestDispatcher(viewJSP).include(request,response);  
		 }		
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		
	 }	
	 
}

