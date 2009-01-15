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
package org.light.portal.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.light.portal.model.PortalUserRole;
import org.light.portal.model.User;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Sep 24, 2006
 **/
public class AuthorizeTag extends BaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	private String role;
	
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		if(user == null) return SKIP_BODY;
		List<PortalUserRole> userRoles = this.getPortalService(request).getUserRole(user.getId(),role);
		if(userRoles == null || userRoles.size() == 0)
	       return SKIP_BODY;
		else
		   return EVAL_BODY_INCLUDE;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}