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

import static org.light.portal.util.Constants.PORTLET_CONFIG;
import static org.light.portal.util.Constants._APPLICATION_CONFIG;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exolab.castor.xml.Unmarshaller;
import org.light.portal.core.service.PortalService;
import org.light.portal.layout.config.PortalLayout;
import org.light.portal.portlet.config.Portlets;
import org.light.portal.portlet.core.PortletContainer;
import org.light.portal.portlet.definition.PortletApp;
import org.light.portal.portlet.factory.ActionRequestFactory;
import org.light.portal.portlet.factory.ActionResponseFactory;
import org.light.portal.portlet.factory.RenderRequestFactory;
import org.light.portal.portlet.factory.RenderResponseFactory;
import org.light.portal.security.config.PortalSecurity;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 14, 2006
 **/

public class PortletContainerImpl implements PortletContainer {
	
	private HashMap<String, Portlet> portlets = new HashMap<String, Portlet>();	
	private ServletConfig servletConfig;
	private Map<String,PortletConfig> portletConfigs = new HashMap<String,PortletConfig>();
	private PortletApp portletApp;
	private HashMap<String, org.light.portal.portlet.definition.Portlet> portletDefinitions = new HashMap<String, org.light.portal.portlet.definition.Portlet>();
	
	public void init(ServletConfig servletConfig) throws PortletException {
		try{
			InputStream stream = servletConfig.getServletContext().getResourceAsStream("/WEB-INF/portlet.xml");
		    InputStreamReader rdr = new InputStreamReader( stream );
			PortletApp portletApp = (PortletApp)Unmarshaller.unmarshal(PortletApp.class, rdr);
			if(portletApp == null)
				throw new RuntimeException("Portal.xml configure error: null object.");
			
			InputStream stream2 = servletConfig.getServletContext().getResourceAsStream("/WEB-INF/portlet-config.xml");
		    InputStreamReader rdr2 = new InputStreamReader( stream2 );
			Portlets portlets = (Portlets)Unmarshaller.unmarshal(Portlets.class, rdr2);	
			if(portlets == null)
				throw new RuntimeException("Portal-config.xml configure error: null object.");
			
			InputStream stream3 = servletConfig.getServletContext().getResourceAsStream("/WEB-INF/portal-layout.xml");
		    InputStreamReader rdr3 = new InputStreamReader( stream3 );
			PortalLayout portalLayout = (PortalLayout)Unmarshaller.unmarshal(PortalLayout.class, rdr3);	
			if(portalLayout == null)
				throw new RuntimeException("Portal-layout.xml configure error: null object.");
			
			InputStream stream4 = servletConfig.getServletContext().getResourceAsStream("/WEB-INF/portal-security.xml");
		    InputStreamReader rdr4 = new InputStreamReader( stream4 );
		    PortalSecurity portalSecurity = (PortalSecurity)Unmarshaller.unmarshal(PortalSecurity.class, rdr4);
			if(portalSecurity == null)
				throw new RuntimeException("Portal-security.xml configure error: null object.");
			servletConfig.getServletContext().setAttribute(_APPLICATION_CONFIG,portalSecurity.getApplication());
			this.getPortalService(servletConfig.getServletContext()).init(portlets,portalLayout, portalSecurity);
			this.init(servletConfig,portletApp);
		}catch(Exception e){
			throw new PortletException(e);
		}
	}
	
	private void init(ServletConfig servletConfig,PortletApp portletApp) throws PortletException{		
		this.servletConfig = servletConfig;
		this.portletApp = portletApp;
		org.light.portal.portlet.definition.Portlet[] portletDefinitionArrays = portletApp.getPortlet();
		if(portletDefinitions != null){
			if(portletDefinitionArrays.length > 0){
				for (int i=0;i<portletDefinitionArrays.length;i++ ) {		            	            		          
		            try{
		            	Portlet portlet = (Portlet)Class.forName(portletDefinitionArrays[i].getPortletClass()).newInstance();
		            	PortletConfig portletConfig = new PortletConfigImpl(
			        						servletConfig
			         					   ,new PortletContextImpl(servletConfig.getServletContext())
			         					   ,portletDefinitionArrays[i]);
						portletConfigs.put(portletDefinitionArrays[i].getPortletName().getContent(),portletConfig);
						portlet.init(portletConfig);
		            	portlets.put(portletDefinitionArrays[i].getPortletName().getContent(),portlet);
		            	portletDefinitions.put(portletDefinitionArrays[i].getPortletName().getContent(),portletDefinitionArrays[i]);
		            }catch(Exception e){
						throw new PortletException(e);
					}
					
		        }
			}
		}
	}
	
	public boolean isInitialized() {		
		return (servletConfig == null)? false:true;
	}
	
	public org.light.portal.portlet.definition.Portlet getPortletDefinitionByName(String name){
		return this.portletDefinitions.get(name);
	}
	public void portletLoad(PortletWindow portletWindow,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws PortletException {
	}

	public void processPortletAction(PortletWindow portletWindow,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws PortletException, IOException {
		String name = (String)servletRequest.getAttribute("portletName"); 
		Portlet portlet = this.getPortlet(name);
		if(portlet != null){
			portlet.processAction(ActionRequestFactory.getInstance().getActionRequest(portletWindow, servletRequest)
							 ,ActionResponseFactory.getInstance().getActionResponse(portletWindow,servletRequest,servletResponse));
		}
	}

	public void renderPortlet(PortletWindow portletWindow,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws PortletException, IOException {
		String name = portletWindow.getName();
		PortletConfig portletConfig = portletConfigs.get(name);
		servletRequest.setAttribute(PORTLET_CONFIG,portletConfig);
		
		Portlet portlet = this.getPortlet(name);		
		if(portlet != null){			
			portlet.render(RenderRequestFactory.getInstance().getRenderRequest(portletWindow, servletRequest)
						  ,RenderResponseFactory.getInstance().getRenderResponse(portletWindow, servletRequest,servletResponse));
		}
		
	}

	public void shutdown() throws PortletException {
		
	}
    
	protected Portlet getPortlet(String name){
		Portlet portlet = portlets.get(name);		
		if(portlet == null){
			try{
				org.light.portal.portlet.definition.Portlet portletDefinition = portletDefinitions.get(name);				
				if(portletDefinition != null){
					portlet = (Portlet)Class.forName(portletDefinition.getPortletName().getContent()).newInstance();
					PortletConfig portletConfig = portletConfigs.get(name);
					if(portletConfig == null){
						portletConfig = new PortletConfigImpl(
			    						servletConfig
			     					   ,new PortletContextImpl(servletConfig.getServletContext())
			     					   ,portletDefinition);
						portletConfigs.put(name,portletConfig);
					}
					portlet.init(portletConfig);
					portlets.put(name,portlet);
				}				            	
			}catch(Exception e){
				
			}
		}
		return portlet;
	}
	
	protected PortalService getPortalService(ServletContext context) {			
		return (PortalService)getService(context, "portalService");
	}
	
	private Object getService(ServletContext context, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) context		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
}
