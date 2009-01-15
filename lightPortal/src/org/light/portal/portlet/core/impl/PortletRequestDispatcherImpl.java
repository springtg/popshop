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
package org.light.portal.portlet.core.impl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletRequestDispatcherImpl implements PortletRequestDispatcher
{

    private RequestDispatcher requestDispatcher;

    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher)
    {
        this.requestDispatcher = requestDispatcher;
    }


    // javax.portlet.PortletRequestDispatcher implementation --------------------------------------
    public void include(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException
    {
        
        try{        	
            this.requestDispatcher.include(getServletRequest(request),getServletResponse(request));
        }catch (java.io.IOException e){
            throw e;
        }catch (javax.servlet.ServletException e){
            if (e.getRootCause()!=null){
                throw new PortletException(e.getRootCause());
            }else{
                throw new PortletException(e);
            }
        } finally {
            
        }
    }
    // --------------------------------------------------------------------------------------------

    protected HttpServletRequest getServletRequest(PortletRequest request){
		HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");		
		return httpServletRequest;
	}
	protected HttpServletResponse getServletResponse(PortletRequest request){
		HttpServletResponse httpServletResponse = (HttpServletResponse)request.getAttribute("httpServletResponse");		
		return httpServletResponse;
	}
}
