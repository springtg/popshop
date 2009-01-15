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

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.light.portal.util.StringUtils;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletURLImpl implements PortletURL {    
    protected PortletMode mode;

    protected Map parameters = new HashMap();

    protected PortletWindow portletWindow;

    protected boolean secure;
    protected javax.servlet.http.HttpServletRequest servletRequest;
    protected javax.servlet.http.HttpServletResponse servletResponse;
    protected WindowState state;
    protected boolean isAction;

    public PortletURLImpl(PortletWindow portletWindow,
                          javax.servlet.http.HttpServletRequest servletRequest,
                          javax.servlet.http.HttpServletResponse servletResponse,
                          boolean isAction)
    {
        this.portletWindow = portletWindow;
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
        secure = servletRequest.isSecure();
        this.isAction = isAction;
    }

    // javax.portlet.PortletURL -------------------------------------------------------------------
    public void setWindowState(WindowState windowState) throws WindowStateException
    {
        if (windowState != null)
        {
            state = windowState;                        
            return;             
        }
 
        throw new WindowStateException("unsupported Window State used: " + windowState,windowState);
    }

    public void setPortletMode (PortletMode portletMode) throws PortletModeException
    {
  		if (portletMode != null)
        {
            if (isPortletModeSupported(portletMode, portletWindow))
            {
                mode = portletMode;
                return;             
            }
        }
        throw new PortletModeException("unsupported Portlet Mode used: " + portletMode,portletMode);
    }

    public void setParameter(String name, String value)
    {
        if (name == null || value == null) {
            throw new IllegalArgumentException("name and value must not be null");
        }

        parameters.put( name, new String[]{value});
    }

    public void setParameter (String name, String[] values)
    {
        if (name == null || values == null || values.length == 0) {
            throw new IllegalArgumentException("name and values must not be null or values be an empty array");
        }

        parameters.put(name, StringUtils.copy(values));
    }
    
    /* (non-Javadoc)
     * @see javax.portlet.PortletURL#setParameters(Map)
     */
    public void setParameters(Map parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
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

        this.parameters = StringUtils.copyParameters(parameters);
    }

    public void setSecure (boolean secure) throws PortletSecurityException
    {
        this.secure = secure;
    }
    
    public String toString()
    {	
		String strMode="";
		if(this.portletWindow.getPortletMode() != null) strMode = this.portletWindow.getPortletMode().toString();
		if(this.mode != null) strMode = this.mode.toString();
		String strState = "";
		if(this.state != null) strState = this.state.toString();
		
        StringBuffer url = new StringBuffer(200);                                                                                  
        String responseId = (String)servletRequest.getAttribute("responseId");
		String param="";
		Iterator i= parameters.keySet().iterator();
		while(i.hasNext()){
			String key = (String)i.next();
			String value = this.getParameter(key);
			param=param+key+"="+value+";";
		}
		if(this.isAction){
	        url.append("javascript:Light.executeAction('")
	           .append(responseId)
	           .append("',document.currentForm,document.pressed,document.pressedName,document.parameter,'")
	           .append(strMode)
	           .append("','")
			   .append(strState)
			   .append("','")
			   .append(param)
			   .append("'")
	           .append(");")
	           ;
		}else{
			 url.append("javascript:Light.executeRender('")
	           .append(responseId)
	           .append("','")
	           .append(strMode)
	           .append("','")
			   .append(strState)
			   .append("','")
			   .append(param)
			   .append("'")
	           .append(",document.parameter);")
	           ;
		}
		
        return url.toString();
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private boolean isPortletModeSupported(PortletMode requestedPortletMode,PortletWindow referencedPortletWindow) 
    {        
        return true;
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    public String getParameter(String name)
    {
        String[] values = (String[])parameters.get(name);
		String value = null;
		if(values != null && values.length > 0) value = values[0];
		return value;
    }

    public String[] getParameters(String name)
    {
        return(String[])parameters.get(name);
    }

    public PortletMode getPortletMode ()
    {
        return mode;
    }

    public WindowState getWindowState ()
    {
        return state;
    }
    // --------------------------------------------------------------------------------------------
}
