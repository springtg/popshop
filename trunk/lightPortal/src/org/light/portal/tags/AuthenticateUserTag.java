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

import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.light.portal.model.User;
import org.light.portal.util.OrganizationThreadLocal;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Sep 24, 2006
 **/
public class AuthenticateUserTag extends TagSupport {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	//private String user;
	
	public int doStartTag() throws JspException {
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		User visitedProfile = (User)pageContext.getSession().getAttribute(_VISITED_USER);
		if(user != null && user.getId()!=OrganizationThreadLocal.getOrg().getUserId() && (visitedProfile == null || (visitedProfile != null && user.getId() == visitedProfile.getId())))
	       return EVAL_BODY_INCLUDE;
		else
		   return SKIP_BODY;
	}
	
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}

	
}