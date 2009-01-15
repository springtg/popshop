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

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public abstract class PortletResponseImpl extends HttpServletResponseWrapper
		implements PortletResponse {
	private PortletWindow portletWindow;
	private javax.servlet.http.HttpServletRequest httpServletRequest;
	private javax.servlet.http.HttpServletResponse httpServletResponse;
	private Map properties;
	
	public PortletResponseImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest,
            javax.servlet.http.HttpServletResponse servletResponse){
		super(servletResponse);
		this.portletWindow = portletWindow;
		this.httpServletRequest = servletRequest;
		this.httpServletResponse = servletResponse;
	}
	
	public java.lang.String getContentType() {
		return this.getHttpServletRequest().getContentType();
	}
		 
	public void addProperty(String key, String value) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Property key == null");
        }

        Map props = getProperties();
        
        String[] oldValues = (String[]) props.get(key);
        String[] newValues = null;
        if (oldValues == null)
        {
            newValues = new String[]{value}; 
        }
        else
        {
            int len = oldValues.length;
            newValues = new String[len+1];
            System.arraycopy(oldValues, 0, newValues, 0, len);
            newValues[len] = value;
        }
        props.put(key, newValues);

    }
    
    public void setProperty(String key, String value) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Property key == null");
        }

        Map props = getProperties();
        
        String[] newValues = new String[]{value}; 
        props.put(key, newValues);

    }
    
    public String encodeURL(String path)
    {        
        return this.getHttpServletResponse().encodeURL(path);
    }
    
	public javax.servlet.http.HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
	public javax.servlet.http.HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public PortletWindow getPortletWindow() {
		return portletWindow;
	}
	
	private Map getProperties() {
        if (properties == null)
            properties = new HashMap();
        return properties;
    }
}
