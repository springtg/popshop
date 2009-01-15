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

import static org.light.portal.util.Constants.PORTLET_REQUEST;
import static org.light.portal.util.Constants.SERVLET_REQUEST;

import javax.portlet.RenderRequest;

import org.light.portal.portlet.core.impl.PortletWindow;
import org.light.portal.portlet.core.impl.RenderRequestImpl;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class RenderRequestFactory {
	private static RenderRequestFactory instance = new RenderRequestFactory();
	public static RenderRequestFactory getInstance(){
		return instance;
}
	 public RenderRequest getRenderRequest(PortletWindow portletWindow, javax.servlet.http.HttpServletRequest request){		 
		 RenderRequest renderRequest = new RenderRequestImpl(portletWindow, request);
		 renderRequest.setAttribute(SERVLET_REQUEST,request);
		 request.setAttribute(PORTLET_REQUEST,renderRequest);
		 return renderRequest;
	 }
}
