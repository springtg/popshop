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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.WindowState;

import static org.light.portal.util.Constants.*;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ActionRequestImpl extends PortletRequestImpl implements
		ActionRequest {
	
	private PortletPreferences portletPreferences;
	public ActionRequestImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest) {
		super(portletWindow, servletRequest);	
	}
	
	public PortletPreferences getPreferences() {	
		//if(this.portletPreferences == null)
			this.portletPreferences = new PortletPreferencesImpl(METHOD_ACTION, this, this.getPortletWindow());
		return portletPreferences;
	}
	
	public InputStream getPortletInputStream() throws IOException {
		javax.servlet.http.HttpServletRequest servletRequest = (javax.servlet.http.HttpServletRequest) super.getRequest();

        if (servletRequest.getMethod().equals("POST"))
        {
            String contentType=servletRequest.getContentType();
            if (contentType==null||contentType.equals("application/x-www-form-urlencoded"))
            {
                throw new java.lang.IllegalStateException(
                                                         "User request HTTP POST data is of type application/x-www-form-urlencoded. This data has been already processed by the portal/portlet-container and is available as request parameters."
                                                         );
            }
        }
        return servletRequest.getInputStream();
	}

}
