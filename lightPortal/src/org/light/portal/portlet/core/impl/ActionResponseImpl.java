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
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.light.portal.portlet.core.InternalActionResponse;
import org.light.portal.util.StringUtils;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ActionResponseImpl extends PortletResponseImpl implements
		ActionResponse, InternalActionResponse {
    
	private Map renderParameters = new HashMap();
	
	public ActionResponseImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest,
             javax.servlet.http.HttpServletResponse servletResponse)
	{
		 super(portletWindow, servletRequest, servletResponse);
	}
	
	public void setWindowState(WindowState state) throws WindowStateException {
		this.getPortletWindow().setWindowState(state);

	}

	public void setPortletMode(PortletMode mode) throws PortletModeException {
		this.getPortletWindow().setPortletMode(mode);
	}

	public void setRenderParameters(Map parameters)
    {        
        if (parameters == null) {
            throw new IllegalArgumentException("Render parameters must not be null.");
        }
        for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry)iter.next();
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Key must not be null and of type java.lang.String.");
            }
            if (!(entry.getValue() instanceof String[])) {
                throw new IllegalArgumentException("Value must not be null and of type java.lang.String[].");
            }
        }

        renderParameters = StringUtils.copyParameters(parameters);

    }
    
	public Map getRenderParameters(){
		return renderParameters;
	}
	
	public String getRenderParameter(String key){
		String value = null;
		String[] values =(String[] )renderParameters.get(key);
		if(values != null && values.length > 0)
			value= values[0];
		return value;
	}
    public void setRenderParameter(String key, String value)
    {     
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Render parameter key or value must not be null.");
        }

        renderParameters.put(key, new String[] {value});
    }
    
    public void setRenderParameter(String key, String[] values)
    {
        if (key == null || values == null || values.length == 0) {
            throw new IllegalArgumentException("Render parameter key or value must not be null or values be an empty array.");
        }

        renderParameters.put(key, StringUtils.copy(values));

    }

}
