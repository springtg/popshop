/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.tags;

import static org.light.portal.util.Constants._PORTLET_SYNC_LOAD;

import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.PortletWindow;
import org.light.portal.portlet.factory.PortletContainerFactory;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class PortletsViewTag extends BaseTag {

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();		
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		try{
			String tabId = (String)request.getAttribute("tabId");
	    	if(tabId != null){
		    	List<PortletObject> portlets = this.getPortalService(request).getPortletsByTab(Integer.parseInt(tabId));               
		    	for(PortletObject po : portlets){
		    		if(po.getType() == _PORTLET_SYNC_LOAD){
			    		request.setAttribute("portletId",String.valueOf(po.getId()));
			    		request.setAttribute("portletObject",po);
			    		request.setAttribute("responseId","portletContent_"+po.getId());
		        		PortletMode mode = PortletMode.VIEW;	        		
		        		WindowState state = WindowState.NORMAL;
	        		    if(po.getWindowStatus() == 1) state = WindowState.MINIMIZED;   
	        		    if(po.getWindowStatus() == 2) state = WindowState.MAXIMIZED;      
		        		String suffix = ".view";
		        		if(WindowState.MAXIMIZED.equals(state))	suffix=".max"+suffix;
		        		String portletName = po.getPath();
		        		if(portletName.startsWith("/")) portletName = portletName.substring(1);
		        		if(portletName.indexOf(".") > 0) portletName = portletName.substring(0,portletName.indexOf("."));
			    		response.getWriter().print("<textarea id=portlet"+po.getId()+suffix+" style='display:none;'>"); 
			    		PortletWindow portletWindow = new PortletWindow(portletName, state, mode, po);
			    		PortletContainerFactory.getPortletContainer().renderPortlet(portletWindow, request, response);
			    		response.getWriter().print("</textarea>"); 
		    		}
		     	}
	    	}
		}catch(Exception e){
	    	throw new RuntimeException(e);
	    }
		
        return EVAL_PAGE;
    }
}



