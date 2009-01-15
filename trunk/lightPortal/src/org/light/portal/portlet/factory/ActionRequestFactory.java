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

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.WindowState;

import org.light.portal.core.PortalCommandFactory;
import org.light.portal.portlet.core.impl.ActionRequestImpl;
import org.light.portal.portlet.core.impl.PortletWindow;
import org.light.portal.portlet.core.impl.RenderRequestImpl;

import static org.light.portal.util.Constants.SERVLET_REQUEST;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ActionRequestFactory {
	 private static ActionRequestFactory instance = new ActionRequestFactory();
	 
	 public static ActionRequestFactory getInstance(){
			return instance;
	}
	 public ActionRequest getActionRequest(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest request){		 		
		 ActionRequest actionRequest = new ActionRequestImpl(portletWindow, request);
		 actionRequest.setAttribute(SERVLET_REQUEST,request);
		 return actionRequest;		 
	 }
}
