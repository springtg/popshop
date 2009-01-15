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

import java.io.BufferedReader;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.HttpSession;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.InternalPortletConfig;
import org.light.portal.util.Enumerator;
import org.light.portal.util.StringUtils;

import static org.light.portal.util.Constants.*;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public abstract class PortletRequestImpl extends
javax.servlet.http.HttpServletRequestWrapper implements PortletRequest {
    
	private PortletWindow portletWindow;
	private PortletSession portletSession;
	private PortalContext portalContext;
	/**
	 * true if the HTTP-Body has been accessed
	 */
	private boolean bodyAccessed;

	
	public PortletRequestImpl(PortletWindow portletWindow,javax.servlet.http.HttpServletRequest servletRequest) {
		super(servletRequest);	
		
		this.portletWindow = portletWindow;		
	}
		
	public boolean isWindowStateAllowed(WindowState state) {
		if(state == null) return false;		
		Enumeration enume =getPortalContext().getSupportedWindowStates();
		while(enume.hasMoreElements()){
			WindowState ws=(WindowState)enume.nextElement();
			if(ws.equals(state)) return true;
		}
		return false;
	}

	public boolean isPortletModeAllowed(PortletMode mode) {
		if(mode == null) return false;		
		Enumeration enume =getPortalContext().getSupportedPortletModes();
		while(enume.hasMoreElements()){
			PortletMode pm=(PortletMode)enume.nextElement();
			if(pm.equals(mode)) return true;
		}
		return false;
	}

	public PortletMode getPortletMode() {
		return this.getPortletWindow().getPortletMode();
	}

	public WindowState getWindowState() {
		return this.getPortletWindow().getWindowState();
	}

	public abstract PortletPreferences getPreferences();

	public PortletSession getPortletSession() {
		return getPortletSession(true);
	}

	public PortletSession getPortletSession(boolean create) {
//		 check if the session was invalidated
		javax.servlet.http.HttpSession httpSession = this._getHttpServletRequest().getSession(false);

		if ((portletSession != null) && (httpSession == null)) {
			portletSession = null;
		} else if (httpSession != null) {
			create = true;
		}

		if (create && portletSession == null) {
			httpSession = this._getHttpServletRequest().getSession(create);
			PortletObject portletObject = (PortletObject)this._getHttpServletRequest().getAttribute("portletObject");
			if (httpSession != null) {
				portletSession = new PortletSessionImpl(portletObject, httpSession);
			}
		}

		return portletSession;

	}

	public String getProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getProperties(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getPropertyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public PortalContext getPortalContext() {
		if(portalContext == null){
			PortletConfig portletConfig = (PortletConfig)this.getAttribute(PORTLET_CONFIG);
			portalContext = new PortalContextImpl((InternalPortletConfig)(PortletConfigImpl)portletConfig);
		}
		return portalContext;
	}

	public String getAuthType() {
		return this._getHttpServletRequest().getAuthType();
	}

	public String getContextPath() {
		// TODO Auto-generated method stub
		return this._getHttpServletRequest().getContextPath();
	}

	public String getRemoteUser() {
		return this._getHttpServletRequest().getRemoteUser();
	}

	public java.security.Principal getUserPrincipal() {
		return this._getHttpServletRequest().getUserPrincipal();
	}

	public boolean isUserInRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getAttribute(String arg0) {
		return this._getHttpServletRequest().getAttribute(arg0);
	}

	public Enumeration getAttributeNames() {
		return this._getHttpServletRequest().getAttributeNames();
	}

	public String getParameter(String arg0) {
		return this._getHttpServletRequest().getParameter(arg0);
	}

	public Enumeration getParameterNames() {
		return this._getHttpServletRequest().getParameterNames();
	}

	public String[] getParameterValues(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Parameter name == null");
		}

		bodyAccessed = true;

		String[] values = (String[]) getParameterMap().get(name);
		if (values != null)
			values = StringUtils.copy(values);
		return values;
	}

	public Map getParameterMap() {
		bodyAccessed = true;
		Map result =
            StringUtils.copyParameters(
					this._getHttpServletRequest().getParameterMap()
            );
		return result;
	}

	public boolean isSecure() {
		return this._getHttpServletRequest().isSecure();
	}

	public void setAttribute(String arg0, Object arg1) {
		this._getHttpServletRequest().setAttribute(arg0,arg1);
	}

	public void removeAttribute(String arg0) {
		this._getHttpServletRequest().removeAttribute(arg0);

	}

	public String getRequestedSessionId() {
		return this._getHttpServletRequest().getRequestedSessionId();
	}

	public boolean isRequestedSessionIdValid() {
		return this._getHttpServletRequest().isRequestedSessionIdValid();
	}

	public String getResponseContentType()
    {
        return "text/xml;charset=UTF-8";
    }
	
	public Enumeration getResponseContentTypes() {
		HashSet responseMimeTypes = new HashSet(NumberOfKnownMimetypes);
        responseMimeTypes.add("text/xml;charset=UTF-8");

        return new Enumerator(responseMimeTypes.iterator());
	}
	
	public Locale getLocale() {
		return this._getHttpServletRequest().getLocale();
	}

	public Enumeration getLocales() {
		return this._getHttpServletRequest().getLocales();
	}

	public String getScheme() {
		return this._getHttpServletRequest().getScheme();
	}

	public String getServerName() {
		return this._getHttpServletRequest().getServerName();
	}

	public int getServerPort() {
		return this._getHttpServletRequest().getServerPort();
	}
    
	public java.lang.String getCharacterEncoding() {
		return this._getHttpServletRequest().getCharacterEncoding();
	}
	public java.lang.String getContentType() {
		return this._getHttpServletRequest().getContentType();
	}

	public int getContentLength() {
		return _getHttpServletRequest().getContentLength();
	}

	public BufferedReader getReader()
			throws java.io.UnsupportedEncodingException, java.io.IOException {
		BufferedReader reader = _getHttpServletRequest().getReader();
		return reader;
	}
	
	public void setCharacterEncoding(String env)
	throws java.io.UnsupportedEncodingException {
		this._getHttpServletRequest().setCharacterEncoding(env);
	}
	
	public javax.servlet.http.HttpServletRequest getHttpServletRequest() {
		return this._getHttpServletRequest();
	}

	public PortletWindow getPortletWindow() {
		return portletWindow;
	}
	
	private javax.servlet.http.HttpServletRequest _getHttpServletRequest() {
		return (javax.servlet.http.HttpServletRequest) super.getRequest();
	}
}
