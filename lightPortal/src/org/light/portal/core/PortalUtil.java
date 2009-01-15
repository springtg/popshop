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
package org.light.portal.core;

import static org.light.portal.util.Constants._LIGHT_PORTAL_USER_ID;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Sep 12, 2006
 **/
public class PortalUtil {
	
	public static void setUser(HttpServletRequest request,String userId){
		Map<String,String> userData = new HashMap<String,String>();
		userData.put(_LIGHT_PORTAL_USER_ID,userId);
		request.getSession().setAttribute(PortletRequest.USER_INFO,userData);
	}
}
