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
package org.light.portal.portlet.core.impl;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.InternalActionResponse;
import org.light.portal.util.StringUtils;

import static org.light.portal.util.Constants.*;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class RenderRequestImpl extends PortletRequestImpl implements
		RenderRequest {
	
	private PortletPreferences portletPreferences;
	public RenderRequestImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest)
	{
		super( portletWindow, servletRequest);
		servletRequest.setAttribute("javax.portlet.request",this);
	}
	
	public PortletPreferences getPreferences() {	
		//if(this.portletPreferences == null)
			this.portletPreferences = new PortletPreferencesImpl(METHOD_RENDER, this, this.getPortletWindow());
		return portletPreferences;
	}
	public String getParameter(String name) {
		InternalActionResponse actionResponse = (InternalActionResponse)this.getAttribute(ACTION_RESPONSE);
		String value = null;
		if(actionResponse != null)
			value = actionResponse.getRenderParameter(name);
		if(value == null)
			value = this.getHttpServletRequest().getParameter(name);
		return value;
	}

	public Enumeration getParameterNames() {		
		return new java.util.Enumeration()
	      {   
			
	          private int curr = 0;
	  		  private int end = getParameterMap().size();

	          public boolean hasMoreElements()
	          {  
	              return (curr < end);
	          }

	          public Object nextElement()
	          {        	 
	              if (hasMoreElements())
	              {
	            	  return getParameterMap().keySet().toArray()[curr++];
	              }
	              else
	              {
	                  return null;
	              }
	          }
	      };      
	}

	public String[] getParameterValues(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Parameter name == null");
		}

		String[] values = (String[]) getParameterMap().get(name);
		if (values != null)
			values = StringUtils.copy(values);
		return values;
	}

	public Map getParameterMap() {
		Map requestParameters = this.getHttpServletRequest().getParameterMap();
		Map result = StringUtils.copyParameters(requestParameters);
		InternalActionResponse actionResponse = (InternalActionResponse)this.getAttribute(ACTION_RESPONSE);
		if(actionResponse != null){
			Map renderParameters = actionResponse.getRenderParameters();		
			result.putAll(renderParameters);
		}
		return result;
	}
}
