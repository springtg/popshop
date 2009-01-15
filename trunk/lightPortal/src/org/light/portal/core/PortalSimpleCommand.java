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

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class PortalSimpleCommand implements PortalCommand{
	private String className;
	private String method;
	
	public PortalSimpleCommand(String className){
		this.className = className;		
	}
	
	public PortalSimpleCommand(String className, String method){
		this.className = className;
		this.method = method;
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{		

		Object action = Class.forName(this.getClassName()).newInstance();
		Object result;
		if(action instanceof PortalAction){
			PortalAction portalAction = (PortalAction)action;
			result = portalAction.execute(request,response);
		}else{
			Class partypes[] = new Class[2];
			partypes[0] = HttpServletRequest.class;
			partypes[1] = HttpServletResponse.class;
			Object arglist[] = new Object[2];
			arglist[0] = request;
			arglist[1] = response;
	    	Method method= Class.forName(this.getClassName()).getMethod(this.getMethod(),partypes);					
	    	result = method.invoke(Class.forName(this.getClassName()).newInstance(),arglist);	
		}
	    
		response.getWriter().print(result);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}

