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

import static org.light.portal.util.Constants.ACTION_RESPONSE;

import javax.portlet.ActionResponse;

import org.light.portal.portlet.core.impl.ActionResponseImpl;
import org.light.portal.portlet.core.impl.PortletWindow;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ActionResponseFactory {
	private static ActionResponseFactory instance = new ActionResponseFactory();
	public static ActionResponseFactory getInstance(){
		return instance;
}
	 public ActionResponse getActionResponse(PortletWindow portletWindow, 
			 								 javax.servlet.http.HttpServletRequest request,
			 								 javax.servlet.http.HttpServletResponse response){		
		 ActionResponse actionResponse =new ActionResponseImpl(portletWindow, request, response); 
		 request.setAttribute(ACTION_RESPONSE,actionResponse);
		 return actionResponse;
	 }
}
