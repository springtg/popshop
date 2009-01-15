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
package org.light.portal.portlet.factory;

import static org.light.portal.util.Constants.PORTLET_RESPONSE;
import static org.light.portal.util.Constants.SERVLET_RESPONSE;

import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.PortletWindow;
import org.light.portal.portlet.core.impl.RenderResponseImpl;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class RenderResponseFactory {
	private static RenderResponseFactory instance = new RenderResponseFactory();
	public static RenderResponseFactory getInstance(){
		return instance;
}
	 public RenderResponse getRenderResponse(PortletWindow portletWindow,
			 								 javax.servlet.http.HttpServletRequest request,
			 								 javax.servlet.http.HttpServletResponse response){		
		 RenderResponse renderResponse = new RenderResponseImpl(portletWindow, request, response);
		 request.setAttribute(SERVLET_RESPONSE,response);
		 request.setAttribute(PORTLET_RESPONSE,renderResponse);
		 return renderResponse;
		 
	 }
}
