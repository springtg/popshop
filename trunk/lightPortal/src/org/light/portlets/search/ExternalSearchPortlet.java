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
package org.light.portlets.search;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.portlet.core.impl.PortletPreference;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ExternalSearchPortlet extends LightGenericPortlet {
	 	     
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {		
		String action = request.getParameter("action");
		if("add".equals(action)){
		   String name = request.getParameter("urlName");
		   if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);
		   String url = request.getParameter("url");	
		   if(url != null) url = URLDecoder.decode(url,_CHARSET_UTF);
		   PortletPreferences portletPreferences = request.getPreferences();
		   portletPreferences.setValue(name,url);		   
		   portletPreferences.store();
		}
		if("delete".equals(action)){
			String name = request.getParameter("engineName");						
			PortletPreferences portletPreferences = request.getPreferences();
			portletPreferences.reset(name);
			portletPreferences.store();
		}
	  }
 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		List<PortletPreference> searchEngine = new ArrayList<PortletPreference>();
		PortletPreferences portletPreferences = request.getPreferences();
		Enumeration enumerator= portletPreferences.getNames();
        while (enumerator.hasMoreElements()){
            String name = (String)enumerator.nextElement();
            searchEngine.add(new PortletPreference(name, portletPreferences.getValue(name,"")));
        }		
		request.setAttribute("searchEngine", searchEngine);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/search/searchPortletView.jsp").include(request,response);
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		
		List<PortletPreference> searchEngine = new ArrayList<PortletPreference>();
		PortletPreferences portletPreferences = request.getPreferences();
		Enumeration enumerator= portletPreferences.getNames();
        while (enumerator.hasMoreElements()){
            String name = (String)enumerator.nextElement();
            if(!portletPreferences.isReadOnly(name))
            	searchEngine.add(new PortletPreference(name, portletPreferences.getValue(name,"")));
        }			
		request.setAttribute("searchEngine", searchEngine);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/search/searchPortletEdit.jsp").include(request,response);
	 }	
	
}