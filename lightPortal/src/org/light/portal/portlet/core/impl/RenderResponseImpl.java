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

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.factory.PortletURLFactory;

/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class RenderResponseImpl extends PortletResponseImpl implements
		RenderResponse {

	 public RenderResponseImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest,
             javax.servlet.http.HttpServletResponse servletResponse)
	{
		 super(portletWindow, servletRequest, servletResponse);
		 servletRequest.setAttribute("javax.portlet.response",this);
	}
	 
	 public PortletURL createRenderURL(){
        PortletURL url = createURL(false);
        return url;
    }

    public PortletURL createActionURL(){
        PortletURL url = createURL(true);
        return url;
    }

	public String getNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTitle(String arg0) {
		// TODO Auto-generated method stub

	}

	public OutputStream getPortletOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;//getHttpServletResponse().getOutputStream();
	}
	
	private PortletURL createURL(boolean isAction)
    {
        return PortletURLFactory.getInstance().getPortletURL(getPortletWindow(),
                                                 getHttpServletRequest(),
                                                 getHttpServletResponse(),
                                                 isAction);
    }
}
