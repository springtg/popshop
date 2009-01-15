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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class MediaTag extends BaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();		
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		String browserInfo = request.getHeader("User-Agent");
		if(browserInfo.indexOf("Opera Mobi") >= 0 
			|| browserInfo.indexOf("Opera Mini") >= 0 
			|| browserInfo.indexOf("OperaMini") >= 0 
			|| browserInfo.indexOf("iPhone") >= 0 
			|| browserInfo.indexOf("i-Phone") >= 0 
			|| browserInfo.indexOf("BlackBerry") >= 0 
			|| browserInfo.indexOf("Windows CE") >= 0 
			|| browserInfo.indexOf("IEMobile") >= 0 
			|| browserInfo.indexOf("MIDP") >= 0 
			){	
				try{
					response.sendRedirect("m.jsp");
				}catch(Exception e){
			    	throw new RuntimeException(e);
			    }
			}
		return SKIP_BODY;
	}	
}



