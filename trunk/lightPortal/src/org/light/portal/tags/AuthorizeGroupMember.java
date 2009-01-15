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

import static org.light.portal.util.Constants._VISITED_GROUP;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.light.portal.model.User;
import org.light.portlets.group.Group;
import org.light.portlets.group.UserGroup;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Sep 24, 2006
 **/
public class AuthorizeGroupMember extends BaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	private String type; //"yes" check is a member  "no" check is not a member "leader" check is a leader
	
	public int doStartTag() throws JspException {
		Group group = getVisitedGroup((HttpServletRequest)pageContext.getRequest());	
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		if(group == null )
			return SKIP_BODY;
		List<UserGroup> userGroup = this.getGroupService(pageContext.getSession().getServletContext()).getUserGroup(user.getId(),group.getId());
		if("no".equals(type) && (userGroup == null || userGroup.size() == 0) )
			return EVAL_BODY_INCLUDE;
		else if("yes".equals(type) && (userGroup != null && userGroup.size() > 0) )
			return EVAL_BODY_INCLUDE;
		else if("leader".equals(type) && (userGroup != null && userGroup.size() > 0) && group.getLeaderId() == user.getId())
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}
	
	private GroupService getGroupService(ServletContext context) {			
		return (GroupService)getService(context, "groupService");
	}
	
	private Object getService(ServletContext context, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) context		
     							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
	
	protected Group getVisitedGroup(HttpServletRequest request){				
		return (Group)request.getSession().getAttribute(_VISITED_GROUP);
	}
	
	public String getType() {
		return type;
	}
	

	public void setType(String type) {
		this.type = type;
	}
	

}